package Sortings;

public class QuickSort {

    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r){
        if(l >= r){
            return;
        }

        int p = partition(arr, l, r);

        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l;

        for(int j = l;j < r;j++){
            if(arr[j] < pivot){
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
}