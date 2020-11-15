package infixxToPostfix;

//
//   Name: Tommy Phong
//   Project: #2
//   Due: 3/9/202
//   Course: cs-2400-02
//
//   Description:
//               This interface define methods that must be implemented for the Bag.
//
public interface BagInterface<T> {
   /** Adds a new entry into the bag.  	
       @param newEntry the object to be added. 
	   @return True if the addition was successful, false otherwise. */   
   public boolean add(T newEntry);

   /** Get the number of entries in this array.
       @return The integer value of the number of entries. */ 
   public int getCurrentSize();

   /** Checks if there are no entries in the bag.
       @return  True if bag is empty, false is not. */
   public boolean isEmpty();

   /** Removes an entries from the bag without any specification.
       @return The removed entry or null if didn't remove anything */
   public T remove();
   
   /** Removes a specific entry from the bag.
       @param anEntry. The entry the user selects.
       @return True if the removal was successful, false otherwise. */
   public boolean remove(T anEntry);

   /** Clears all the entries from the bag. */
   public void clear();
   
   /** Gets the number of time the entry appears in the bag.
       @param anEntry. The value the user selects.
       @return The number of times that entry has appeared. */
   public int getFrequency(T anEntry);
   
   /** Checks whether the chosen entry is in the bag.
       @param anEntry. The value the user selects to check.
       @return True if the value is in the bag, false if not. */
   public boolean contains(T anEntry);
   
   /** Creates a new duplicate of the original array. 
       @return a new copied array with all entries in the bag. */
   public T[] toArray();      
}
