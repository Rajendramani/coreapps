import java.util.NoSuchElementException;


public class BestDataContainer<T> 
{
	Object[] data;	//data structure
	int countItems; //number of valid items
	
	/**
	 * Default Constructor.
	 */
	public BestDataContainer()
	{
		//do nothing
		this(10);
	}
	
	/**
	 * Explicit Constructor.
	 * @param capacity maximum size of data structure
	 */
	public BestDataContainer(int capacity)
	{
		data = new Object[capacity];
		countItems = 0;
	}
	
	/**
	 * Get the current size (not the length!)
	 * @return count of items in the Container
	 */
	public int size()
	{
		return countItems;
	}
	
	/**
	 * Add an item to the container.
	 * Can't add null, can't add past capacity, can't add duplicates
	 * @param item to add
	 * @return true if added, else false
	 */
	public boolean add(T item)
	{
		//can't add if item is null
		if (item == null)
		{
			return false;
		}
		
		//can't add if at capacity
		if (countItems == data.length)
		{
			return false;
		}
		
		//don't add duplicate
		int itemIndex = findItem(item);
		if (itemIndex > 0)
		{
			return false;
		}
		
		//add to next item
		data[countItems++] = item;
		return true;
	}
	
	/**
	 * Remove an item if it exists by index.
	 * @param index the index to remove from the container.
	 * @return true if item is removed, else false.
	 * @throws NoSuchElementException if index is not valid
	 */
	public boolean remove(int index)
	{
		validateIndex(index);
		int i = index;
        int j = i + 1;
        //remove it:
        while (j < countItems)
        {
            data[j-1] = data[j];
            j++;
        }
        countItems--;
        return true;
	}
	
	/**
	 * Remove an item that is equal to the passed in item.
	 * 	can't remove a null item, can't remove an item if it is not in the container.
	 * @param item the item to remove.
	 * @return true if the item is removed, else false. 
	 */
	public boolean remove(T item)
	{
		if (item == null) return false;
		int index = findItem(item);
		if (index < 0) return false;
		return remove(index);
	}
	
	/**
	 * Find an item by the item itself
	 * 	relies on valid equality being implemented in type T
	 * @param item the item for which to find the index
	 * @return the index of the item if found, -1 if not in the container.
	 */
	public int findItem(T item)
	{
		for (int i = 0; i < countItems; i++)
		{
			if (data[i].equals(item)) return i;
		}
		return -1;
	}

	/**
	 * Get an item at an index.
	 * @param index the index to get an item from.
	 * @return the item at the given index.
	 * @throws NoSuchElementException if the index is invalid.
	 */
	public T get(int index)
	{
		validateIndex(index);
		//unsafe cast here...
		return (T)data[index];
	}
	
	/**
	 * Validate the index.
	 * @param index the index to validate.
	 * @throws NoSuchElementException if the index is invalid.
	 */
	private void validateIndex(int index)
	{
		if (index < 0 || index >= countItems)
		{
			throw new NoSuchElementException("Invalid Index");
		}
	}

	/**
	 * Print out all the items in the container.
	 * 	relies on toString() being implemented in the type T
	 * @return String representing all items in the container.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < countItems; i++)
		{
			sb.append("Next Item: " + data[i] + "\n");
		}
		return sb.toString();
	}
	
}

