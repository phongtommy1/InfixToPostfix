package infixxToPostfix;
//
//   Name: Tommy Phong
//   Project: #2
//   Due: 3/9/202
//   Course: cs-2400-02
//
//   Description:
//              This class is the implementation of the methods that are define 
//              in BagInterface.  
//
public final class ArrayBag<T> implements BagInterface<T> {
   private final T[] bag;
   public int numberOfEntries;
   private static final int DEFAULT_CAPACITY = 25;

   /** Checks whether the array has reached it's maximum capacity.
   @return True if the array is full, false if not. */
   private boolean isArrayFull() {
	   return numberOfEntries > bag.length;
   }
   
   /** Removes an entry using the index of the array. 
     @param anEntry
     @return The removed value from the array.  */
   private T removesEntry(int anEntry) {
	   T result = null;
	   
	   if( anEntry > -1 ) {
		   result = bag[anEntry];
		   bag[anEntry] = bag[numberOfEntries - 1];
		   bag[numberOfEntries - 1] = null;
		   numberOfEntries--;
			}
	   return result;	   
   }
   
   private int getIndexOf(T anEntry) {
	   boolean found = false;
	   int index = 0;
	   int where = -1;
	   
	   while(!found && (index < numberOfEntries)) {
		   if(anEntry.equals(bag[index])) {
			   found = true;
			   where = index;
		   }
		   else {
			   index++;
		   }
	   }
	   return where;
   }
   
   /** Creates an empty bag with the size of 25. */
   public ArrayBag() {
	   this(DEFAULT_CAPACITY);
   }
   
   /** Creates an empty bag with a given size by the user. 
       @param desiredCapacity. The size of the bag. */ 
   public ArrayBag(int desiredCapacity) {
	   /** Safe casting because of null entries in new array. */
	   @SuppressWarnings("unchecked")
	   T[] tempBag = (T[]) new Object[desiredCapacity];
	   bag = tempBag;
	   numberOfEntries = 0;	   
   }
   
   /** Adds a new entry into the bag.  	
       @param newEntry the object to be added. 
       @return True if the addition was successful, false otherwise. */   
   public boolean add(T newEntry) {
	   boolean result = false;
	   if(isArrayFull()) {
		   result = false;
	   }
	   else {
		   bag[numberOfEntries] = newEntry;
		   numberOfEntries++;
		   result = true;
	   }
	   return result;
   }

   /** Get the number of entries in this array.
       @return The integer value of the number of entries. */ 
   public int getCurrentSize() {
	   return numberOfEntries;
   }

   /** Checks if there are no entries in the bag.
       @return  True if bag is empty, false is not. */
   public boolean isEmpty() {
	   boolean result = false;
	   if(numberOfEntries == 0) {
		   result = true;
	   }
	   else {
		   result = false;
	   }
	   return result;
   }

   /** Removes an entries from the bag without any specification.
       @return The removed entry or null if didn't remove anything */
   public T remove() {
      T result = null;
      

    	  result = bag[numberOfEntries - 1];
    	  System.out.println(result);
    	  bag[numberOfEntries - 1] = null;
    	  numberOfEntries--;
   
      return result;
   }

   /** Removes a specific entry from the bag.
       @param anEntry. The entry the user selects.
       @return True if the removal was successful, false otherwise. */
   public boolean remove(T anEntry) {
       int index = getIndexOf(anEntry);
	   T result = removesEntry(index);
	   return anEntry.equals(result);
   }
   /** Clears all the entries from the bag. */
   public void clear() {
	  if(!isEmpty()) {
		  remove();
	  }
   }

   /** Gets the number of time the entry appears in the bag.
       @param anEntry. The value the user selects.
       @return The number of times that entry has appeared. */
   public int getFrequency(T anEntry) {
	   int counter = 0;
	   for(int index = 0; index < numberOfEntries; index++) {
		   if(anEntry.equals(bag[index])) {
			   counter++;
		   }
	   }
	   return counter;
   }

   /** Checks whether the chosen entry is in the bag.
       @param anEntry. The value the user selects to check.
       @return True if the value is in the bag, false if not. */
   public boolean contains(T anEntry) {
	   return getFrequency(anEntry) > 0;
   }

   /** Creates a new duplicate of the original array. 
       @return a new copied array with all entries in the bag. */
   public T[] toArray(){
	   
	   /** All entries in array are currently null */
	   @SuppressWarnings("unchecked")
	   T[] result = (T[]) new Object[numberOfEntries];
	   for(int index = 0; index < numberOfEntries; index++) {
		   result[index] = bag[index];
	   }
	   return result;
   }
}
