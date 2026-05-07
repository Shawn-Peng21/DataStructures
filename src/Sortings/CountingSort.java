package Sortings;

public class CountingSort {

    /**
     * 基础版：适用于非负整数数组，假设最小值为0
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    /**
     * 优化版：支持包含负数的整数数组
     */
    public static void sortWithNegative(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int offset = -min;
        int[] count = new int[max - min + 1];

        for (int num : arr) {
            count[num + offset]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i - offset;
                count[i]--;
            }
        }
    }
}