//array implementation

public class Stack {
    char [] arr = new char[100];
    int top;

    public Stack() {
        top = -1;
    }

    public boolean isEmpty(){

        if(top < 0){
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean push(char value){ //add elements to the stack

        if(top >= arr.length -1)
        {
            System.out.println("Stack is full");
            return false;
        }

        else // adding new item
        {
            ++top;
            arr[top] = value;
            return true;
        }
    }

    public int pop(){

        if(isEmpty())
        {
            return 'N';
        }
            char out = arr[top];
            top --;
            return out;
    }
}