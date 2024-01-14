import java.util.*;

//*  1.  MERGE SORT
//*  2.  QUICK SORT
//*  3.  SORTED AND ROTATED ARRAY SEARCH

public class MergeQuickSorRotArrSearch {
    // Print Array Function
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // * Q 1
    public static void merge(int arr[], int si, int ei, int mid) {

    }

    public static void mergeSort(int arr[], int si, int ei) {

    }

    // * Q 2
    public static void quickSort(int arr[], int si, int ei) {
        // BC
        if (si >= ei) {
            return;
        }
        // last element for pivot
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp; 
        return i;
    }

    // * Q 3
    public static int Search(int arr[], int si, int ei, int tar) {
        if (si > ei) {
            return -1;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        // case found
        if (arr[mid] == tar) {
            return mid;
        }
        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case A : LEFT
            if (arr[si] <= tar && tar <= arr[mid]) {
                return Search(arr, si, mid - 1, tar);
            } else {
                // case B : RIGHT
                return Search(arr, mid + 1, ei, tar);
            }
        } // mid on L2
        else {
            // case C : LEFT
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return Search(arr, mid + 1, ei, tar);
            }
            // case D : RIGHT
            else {
                return Search(arr, si, mid - 1, tar);
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 0 };

        // quickSort(arr, 0, arr.length-1);
        // printArr(arr);

        System.out.println(Search(arr, 0, arr.length - 1, 0));
    }
}
