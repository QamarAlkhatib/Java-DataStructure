public class dllNode {
    int value;
    dllNode next;
    dllNode prev;

    public dllNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}


public class DLL {

    dllNode head;
    dllNode tail;

    public DLL(){

        head = tail = null;
    }

    public void addNodeToTail(int data) {
        dllNode newNode = new dllNode(data);

        if (head == null) {
            head = tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void addNodeToHead(int data) {
        dllNode newNode = new dllNode(data);

        if (head == null)
        {
            head = tail = newNode;
        }

        newNode.next = head;
        newNode.prev = null;

        if(head != null){
            head.prev = newNode;
            head = newNode;
        }
    }
    public void insertAt(int data, int position) {

        dllNode newNode = new dllNode(data);

        if(head == null){
            System.out.println("List is empty");
        }

        else
        {
            if(position == 1){
                addNodeToHead(newNode.value);
            }
            dllNode current =  head;
            dllNode temp = null;

            for(int i = 1; i < position -1; i++){
                current = current.next;
            }
            temp = current.next;
            temp.prev = current;

            current.next = newNode;
            newNode.prev = current;
            newNode.next = temp;
            temp.prev = newNode;

        }
    }

    public boolean isPalindrome(){

        if (head == null) {
            return false;
        }
        if(head == tail) {
            return true;
        }
        dllNode low = head;
        dllNode high = head;

        while(high.next != null){
        high = high.next;
         }
        while (low != high){

            if(low.value != high.value)
                return false;

            low = low.next;
            high = high.prev;
        }
        return true;
    }

    public void deleteFromHead(){
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

    public void deleteFromTail(){
        if (tail == null)

            return;

        else {

            if (head == tail) {

                head = null;

                tail = null;

            } else {
                dllNode current = head;

                while (current.next != tail) {
                    current = current.next;
                }
                tail = current;
                tail.next = null;
            }
        }
    }

    public void displayList() {

        dllNode current = head;

        if (head == null) {
            System.out.println("List is empty");
        }

        while (current != null) {

            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public dllNode SortedMerge(dllNode A, dllNode B)
    {

        dllNode c = new dllNode(0);

        tail = c;
        while (true)
        {

            if(A == null){
                tail.next = B;
                break;
            }
            if(B == null){
                tail.next = A;
                break;
            }

            if(A.value <= B.value)
            {
                tail.next = A;
                A = A.next;
            }
            else
            {
                tail.next = B;
                B = B.next;
            }
            tail = tail.next;
        }
        return c;
    }

    public void sortList() {
        dllNode current = null, index = null;
        int temp;

        if(head == null)
        {
            return;
        }
        else
        {
            for(current = head; current.next != null; current = current.next)
            {
                for(index = current.next; index != null; index = index.next)
                {
                    if(current.value > index.value)
                    {
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }
                }
            }
        }
    }
}


public class Main {

    public static void main(String[] args) {

        System.out.println("List A");
        DLL A = new DLL();
        A.addNodeToTail(1);
        A.addNodeToTail(5);
        A.addNodeToTail(9);
        A.addNodeToTail(3);
        A.addNodeToTail(7);
        A.addNodeToTail(13);
        A.addNodeToTail(11);

        A.sortList();
        A.displayList();

        System.out.println("List B");
        DLL B = new DLL();

        B.addNodeToTail(0);
        B.addNodeToTail(6);
        B.addNodeToTail(4);
        B.addNodeToTail(2);
        B.addNodeToTail(10);
        B.addNodeToTail(8);
        B.addNodeToTail(12);

        B.sortList();
        B.displayList();

        A.SortedMerge(A.head,B.head);
        System.out.println("Final result");
        A.displayList();





        

//        System.out.printf("1. Doubly linked list is : "+"\n");
//        dList.displayList();
//
//        System.out.printf("2. Doubly linked list after deleting from head is : "+"\n");
//        dList.deleteFromHead();
//        dList.displayList();
//
//        System.out.printf("3. Doubly linked list after deleting from tail is : "+"\n");
//        dList.deleteFromTail();
//        dList.displayList();
//
//        System.out.printf("4. Doubly linked list after inserting data to a specific position is : " +"\n");
//        dList.insertAt(15,4);
//        dList.displayList();
//
//        System.out.printf("5. Doubly linked list after checking if it palindrome is : " +"\n");
//        System.out.println(dList.isPalindrome());
//        dList.displayList();

    }
}