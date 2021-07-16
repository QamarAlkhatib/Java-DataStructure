// Using Array implementation

public class Queue {

    public int first,last;
    public int capacity = 10; // array size
    public int [] array = new int[capacity];
    public int size; // queue size

    public Queue() {
    first = last = -1;
    size = 0;
    }

    public boolean isEmpty(){
        return  (size ==0);
    }

    public boolean isFull(){
         return (size == capacity);
    }

    public void resize(){
        capacity = capacity *2;
        int [] newArray = new int [capacity];

        for (int i = 0 ; i < array.length; i++){
            newArray[i] = array[i];
            array = newArray;
        }
    }

    public void enQueue(int data){
        if(isFull())
            return;

        if(isEmpty()) {
            first = last = 0;
            array[last] = data;
            size++;
        return;
        }

        last ++;
        array[last] = data;
        size++;
    }

    public int deQueue() {
        if (isEmpty()) {
            return -1;
        }

        else
        {
            int temp = array[first];
            first++;
            size--;
            return temp;
        }
    }
}
