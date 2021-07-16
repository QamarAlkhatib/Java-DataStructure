
import java.util.Arrays;

public class Main {

    public static void mergeSort( int [] array, int first, int last) {

        if (first < last) {


            int mid = (first + last) / 2;

            mergeSort(array, first, mid);
            mergeSort(array, mid + 1, last);

            merge(array, first, mid, last);
        }
    }

    static void merge(int arr[], int first, int mid, int last)
    {
        int left = mid - first + 1;
        int right = last - mid;
        int LeftArray[] = new int [left];
        int RightArray[] = new int [right];

        for (int i = 0; i < left; ++i)
        {
            LeftArray[i] = arr[first + i];
        }

        for (int j = 0; j < right; ++j)
        {
            RightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = first;
        while (i < left && j < right)
        {
            if (LeftArray[i] <= RightArray[j])
            {
                arr[k] = LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < left)
        {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j < right)
        {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int arr[] = {90,12,30,11,84,1};
        System.out.println("Array elements");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length -1);

        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));

    }