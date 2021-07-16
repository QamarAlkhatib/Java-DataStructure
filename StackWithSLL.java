//list implementation

public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}


public class SLL {
    public Node head;
    public Node tail;

    public SLL() {
        head = tail = null;
    }

    public void addNodeToHead(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addNodeToTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public void insertAt(int data, int position) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        }

        if (position == 1) {
            addNodeToHead(data);
        }

        Node current =  head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;

    }

    public void displayList() {

        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
        }
        while (current != null) {

            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public int getLength() {

        if (head == null)
            return 0;
        else {
            int count = 0;
            Node current = head;

            while (current != null) {

                current = current.next;
                count++;
            }

            return count;
        }
    }

    public boolean exists(int data) {

        if (head == null) {
            return false;
        } else {
            Node current = head;
            while (current != null) {
                if (current.value == data)
                    return true;
                current = current.next;
            }
        }
        return false;
    }

    public int existAt(int data) {

        if (head == null)
            return 0;

        if (head.value == data)
            return 1;

        Node current = head;
        int nodePosition = 1;

        while (current != null) {

            if (current.value == data)
                return nodePosition;

            current = current.next;
            nodePosition++;
        }
        return -1;
    }

    public void deleteFromHead() {

        if (head == null) {
            return;
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        }
    }

    public Node deleteFromTail() {

        if (tail == null)

            return null;

        else {

            if (head == tail) {

                head = null;

                tail = null;

            } else {

                Node current = head;

                while (current.next != tail)

                    current = current.next;

                tail = current;

                tail.next = null;

            }
        }
        return tail;
    }
    public Node reverseListIterative(){

        Node prevNode = null;
        Node currentNode = head;
        Node nextNode = null;

        while(currentNode != null){

            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public void insertInOrder(Node newNode) {


        if (head == null || head.value >= newNode.value)
        {
            addNodeToHead(newNode.value);
        }

        else if(tail == null || tail.value <= newNode.value)
        {
            addNodeToTail(newNode.value);
        }

        Node current = head;

        while (current.next != null && current.next.value < newNode.value)
        {
            current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}

public class StackList {

    SLL StackList = new SLL();
    Node top;

    public StackList() {
        top = null;
    }

    public boolean isEmpty() {

        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data){

        StackList.addNodeToTail(data);
        top = StackList.tail;
    }

    public int pop(){
        if(isEmpty())
        {
            return 1;
        }
        Node out = StackList.deleteFromTail();
        top = StackList.tail;
        return out.value;
    }
}