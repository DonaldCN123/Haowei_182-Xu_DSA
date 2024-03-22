package oy.tol.tra;
public class QueueImplementation<E> implements QueueInterface<E> {
    private E [] itemArray = null;
    private int head = 0;
    private int tail = 0;
    private int capacity = 0;
    private static final int DEFAULT_QUEUE_SIZE = 10;
    private int number = 0;

    public QueueImplementation() throws QueueAllocationException {
        this.capacity = DEFAULT_QUEUE_SIZE;
        this.itemArray = (E [])new Object [capacity];
        this.head = this.tail = 0;
     }
    public QueueImplementation(int capacity) throws QueueAllocationException {
        if(capacity < 2)
           throw new QueueAllocationException(null);
        else{
           this.itemArray = (E [])new Object [capacity];
           this.capacity = capacity;
           this.head =0;
           this.tail = 0;
  
        }
  
    }

    @Override
   public int capacity(){
    return capacity;
   }
   
   private void resize(int max){
    E[] a ;
    a = (E[])new Object [max];
    int i = 0;
    while(!isEmpty()){
        a[i] = dequeue();
        i++;
    }
    itemArray = a;
    capacity = max;
    head = 0;
    tail = i;
    number = i;

   }

    @Override
   public void enqueue(E element) throws QueueAllocationException, NullPointerException{
    if (null == element)
        {
            throw new NullPointerException();
        }
    if(tail == head && (itemArray[head]!= null))
        {
            resize(10*capacity);
        }
    itemArray[tail] = element;
    number++;

    if(tail == (capacity - 1))
        {
            tail = 0;
        }
    else tail++;    
   }


   public E dequeue() throws QueueIsEmptyException{
    if (isEmpty())
        throw new QueueIsEmptyException(null);
    E item = itemArray[head];
    itemArray[head] = null;
    number--;
    if(head == (capacity - 1))
        head = 0;
    else head++;
    return item ;
   }


   public E element() throws QueueIsEmptyException{
    if (isEmpty())
    throw new QueueIsEmptyException(null);
    return itemArray[head];
   }


   public int size(){
    return this.number;
   }


   public boolean isEmpty(){
    return((this.head == this.tail) && (this.itemArray[head] == null));
   }

   public void clear(){
    this.itemArray = (E [])new Object [this.capacity];
    this.head = this.tail = 0;
    this.number = 0;
   }


   public String toString() {
    StringBuilder builder = new StringBuilder("[");

    int head = this.head;
    int tail = this.tail;
    if(isEmpty());
    else
    {
        do{
            builder.append(itemArray[head].toString());
            builder.append(", ");
            if((capacity - 1)== head)
            head = 0;
            else head++;
        }while(head!= tail);
        builder.deleteCharAt(builder.length()-1);
        builder.deleteCharAt(builder.length()-1);
        
    }

    builder.append("]");
    return builder.toString();
 }

}
