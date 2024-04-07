package oy.tol.tra;


public class StackImplementation<E> implements StackInterface<E> {

   private E [] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10;


   public StackImplementation() throws StackAllocationException {
      this.itemArray = (E [])new Object [capacity];
      this.capacity = DEFAULT_STACK_SIZE;
   }


   public StackImplementation(int capacity) throws StackAllocationException {
      if(capacity < 2)
         throw new StackAllocationException(null);
      else{
         this.itemArray = (E [])new Object [capacity];;
         this.capacity = capacity;

      }

   }

   @Override
   public int capacity() {

      return capacity;
   }

   private void resize(int max) {
      E [] a;
      a = (E []) new Object [max];
      for(int i = 0; i<= currentIndex; i++){
         a[i] = this.itemArray[i];
      }
      capacity = max;
      itemArray = a;
   }


   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {

      if (null == element)
         throw new NullPointerException();
      if(this.currentIndex == (this.capacity -1) )
         resize(10*capacity);
      itemArray[++currentIndex] = element;        
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if(isEmpty())
         throw new StackIsEmptyException(null);
      else{
         E item = itemArray[currentIndex];
         itemArray[currentIndex--] = null;
         return item;
      }

   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if(isEmpty())
         throw new StackIsEmptyException(null);
      else{
         E item = itemArray[currentIndex];
         return item;
      }
      
   }

   @Override
   public int size() {

      return currentIndex + 1;
   }

   @Override
   public void clear() {

      this.itemArray = (E [])new Object [capacity];
      this.currentIndex = 0 -1;
   }

   @Override
   public boolean isEmpty() {

      return (this.currentIndex == -1);
   }


   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}
