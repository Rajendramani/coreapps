import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple look at a basic linking list structure
 * @author Brian
 * This code is NOT intended for use.  Here, I simply want to 
 *   examine what a linking structure MIGHT look like under the 
 *   covers.  This is so we can get a better understanding of
 *   why certain data structures might work better in 
 *   some circumstances
 */
public class SimpleSingleLinkedList<E> implements Iterable
{
	private DataLink<E> header = null;
	private int size;
	
	/**
	 * Create a new SimpleSingleLinkedList
	 */
	public SimpleSingleLinkedList()
	{
		//create the head with a null data
		header = new DataLink<E>(null);
		size = 0; //the header doesn't count
	}
	
	/**
	 * Add a data to the end of the list
	 * @param data the data to store
	 */
	public void add(E data)
	{
		DataLink<E> prevLink = null;
		//create a new link and append it to the end of the chain
		if (size == 0)
		{
			prevLink = header;
		}
		else
		{
			//find the last link
			prevLink = findLink(size-1);
		}
		DataLink<E> newLink = new DataLink<E>(data, prevLink);
		//increment the size
		size++;
	}
	
	/**
	 * 
	 * @param index
	 * @param data
	 */
	public void addAtIndex(int index, E data)
	{
		//can actually add at size since it would be the
		//tail DataLink
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		DataLink<E> prevLink = null;
		//create a new link and append it to the end of the chain
		if (size == 0)
		{
			prevLink = header;
		}
		else
		{
			//find the link at index and it's next link
			//to insert in the middle
			prevLink = findLink(index - 1);
		}
		DataLink<E> newLink = new DataLink<E>(data, prevLink);
		
		//increment the size
		size++;
	}
	
	/**
	 * Remove data from the chain
	 * @param data the data to remove
	 */
	public void remove(E data)
	{
		DataLink<E> theLink = header.nextDataLink;
		DataLink<E> prevLink = header;
		
		if (theLink.data.equals(data))
		{
			//remove the first link
			header.nextDataLink = theLink.nextDataLink;
			theLink = null;
			size--;
		}
		else
		{
			boolean modified = false;
			for (int i = 1; (i <= size && !modified); i++)
			{
				//move to the link to get
				prevLink = theLink;
				theLink = theLink.nextDataLink;
				if (theLink.data.equals(data))
				{
					prevLink.nextDataLink = theLink.nextDataLink;
					theLink = null;
					size--;
					modified = true;
				}
			}
		}
		return;
	}

	/**
	 * Remove link from chain by index
	 * @param index the index to remove
	 */
	public void remove(int index)
	{
		CheckValidIndex(index);
		DataLink<E> prevLink = header;
		boolean modified = false;
		for (int i = 0; (i < size && !modified); i++)
		{
			DataLink<E> nextLink = prevLink.nextDataLink;
			if (i == index)
			{
				//this is the link to remove
				prevLink.nextDataLink = nextLink.nextDataLink;
				nextLink = null;
				size--;
				modified = true;
			}
			prevLink = nextLink;
		}
	}
	
	/**
	 * Get the data from the list at index
	 * @param index the index to return the data from
	 * @return the data from the node at index
	 */
	public E get(int index)
	{
		//make sure the index is valid
		CheckValidIndex(index);
		DataLink<E> theLink = findLink(index);
		if (theLink != null)
		{
			return theLink.data;
		}
		return null;
	}
	
	/**
	 * Find the index of the first matching link
	 * @param data the data to find
	 * @return index of the matching data, -1 if not found
	 */
	public int findIndex(E data)
	{
		if (size == 0) return -1;
		DataLink<E> theLink = header.nextDataLink;
		if (theLink.data.equals(data)) return 0;
		for (int i = 1; i < size; i++)
		{
			theLink = theLink.nextDataLink;
			//determine if the next link is the one to remove
			if (theLink.data.equals(data))
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Get the size
	 * @return the size of the List
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Get a link from the chain by index.
	 * @param index the index to get (0 is the first link [header not included]
	 * @return the link at index.
	 */
	private DataLink<E> findLink(int index)
	{
		CheckValidIndex(index);
		if (size <= 0) return null;
		
		DataLink<E> theLink = header.nextDataLink;
		if (index == 0)
		{
			return theLink;
		}
		else
		{
			for (int i = 1; i <= index; i++)
			{
				//move to the link to get
				theLink = theLink.nextDataLink;
			}
			//we are now at the link
			return theLink;
		}
	}
	
	/**
	 * Make sure an index is valid
	 * @param index
	 */
	private void CheckValidIndex(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException(
                    Integer.toString(index));
		}
	}
	
	/**
	 * DataLink Stores data and links to the next DataLink.
	 * @author Brian
	 * @param <E> the data type to store
	 */
	private class DataLink<E>
	{
		private E data;				  		//the data
		private DataLink<E> nextDataLink;   //the next link in the chain
		
		/**
		 * Create a single data link.
		 * @param theData the data to store in the link
		 */
		public DataLink(E theData)
		{
			data = theData;
			nextDataLink = null;
		}
		
		/**
		 * Create a new link and point to a next link.
		 * @param theData 
		 * @param nextLink
		 */
		public DataLink(E theData, DataLink<E> previousLink)
		{
			data = theData;
			nextDataLink = previousLink.nextDataLink;
			previousLink.nextDataLink = this;	
		}
	}

	
	@Override
	public Iterator iterator() {
		return new SimpleSingleLinkedListIterator();
	}
	
	public Iterator iterator(int index)
	{
		return new SimpleSingleLinkedListIterator(index);
	}
	
	/**
	 * Provide iteration for the SimpleSingleLinkedList
	 * @author Riker
	 *
	 * @param <E>
	 */
	private class SimpleSingleLinkedListIterator<E> implements Iterator
	{
		private DataLink<E> currentLink;
		private DataLink<E> previousLink;
		private int currentIndex;
		private int prevIndex;
		private final int BAD_INDEX = -1;
		
		public SimpleSingleLinkedListIterator()
		{
			this(0);
		}
		
		public SimpleSingleLinkedListIterator(int index)
		{
			CheckValidIndex(index);
			currentLink = (DataLink<E>)SimpleSingleLinkedList.this.header.nextDataLink;
			//set the current Index and prevIndex and currentLink
			if (index > 0)
			{
				//move to index
				for (int i = 1; i <= index; i++)
				{
					currentLink = currentLink.nextDataLink;
				}
			}
			currentIndex = index;
			prevIndex = BAD_INDEX;
		}

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			this.prevIndex = currentIndex;
			currentIndex++;
			previousLink = currentLink;
			currentLink = currentLink.nextDataLink;
			return previousLink.data;
		}
		
		@Override
		public void remove() 
		{
			CheckValidState();
			//need to remove the link we just passed over
			SimpleSingleLinkedList.this.remove(prevIndex);
			previousLink = null;
			currentIndex--;
			prevIndex = BAD_INDEX;
		}
		
		private void CheckValidState()
		{
			if (prevIndex == BAD_INDEX)
			{
				throw new IllegalStateException("Must move next before calling remove");
			}
		}
	}
}
