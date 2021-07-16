
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] FillArray(int array[]){
        Random rand = new Random();
        for (int i = 1; i < array.length; i++){
            array[i] = rand.nextInt(15) -0;
        }
        return array;
    }

    public static void main(String[] args) {

    Random random = new Random();
    System.out.println("Liner search");
	int array [] = new int[10];
	int x = random.nextInt(15) -0;
	System.out.println("The number that will be searching on is   " + x+"\n");
	FillArray(array);
	printArray(array);

	//Calling and checking LinerSearch
     int result = LinearSearch(array,x);
     if(result == -1){
         System.out.println("\nElement not exists");
     }
     else{
         System.out.println("\nElement is exists and in index = " + result);
     }

     System.out.println("\nBinary search");
     Arrays.sort(array);
     printArray(array);
        int result2 = BinarySearch(array,0, array.length -1,x);
        if(result2 == -1){
            System.out.println("\nElement not exists");
        }
        else{
            System.out.println("\nElement is exists and in index  = " + result2);
        }
    }

    public static void printArray(int[] valueOfArray){
        for (int value : valueOfArray){
            System.out.print(value + "   ");
        }
    }

    public static int LinearSearch(int arr[], int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    static int BinarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x){
                return mid;
            }

            if (arr[mid] > x) {
                return BinarySearch(arr, l, mid - 1, x);
            }
            return BinarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

}
