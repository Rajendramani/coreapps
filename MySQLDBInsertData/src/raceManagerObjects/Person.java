package raceManagerObjects;

/**
 * A Person.
 * 
 * @author  Brian 
 * @version 1.0
 */
public interface Person
{
    /**
     * Get the name of the person.
     * @return String representing person's name
     */
    String getName();
    
    /**
     * Set the name of the person.
     * @param name String value to set as person's name
     */
    void setName(String name);
    
    /**
     * Get the age of the person.
     * @return int representing age of the person.
     */
    int getAge();
    
    /**
     * Set the age of the person.
     * @param age int value to set as person's age
     */
    void setAge(int age);
}
