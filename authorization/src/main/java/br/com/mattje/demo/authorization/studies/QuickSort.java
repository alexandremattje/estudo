package br.com.mattje.demo.authorization.studies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class QuickSort {

    static int[] sort(List<Integer> list) {
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        // Big O(n log n)
        if (start < end) {
            int pivot = part(arr, start, end);
            quickSort(arr, start, pivot);
            quickSort(arr, pivot + 1, end);
        }

    }

    static int part(int[] arr, int start, int end) {
        int pivotPosition = (start + end) / 2;
        int pivot = arr[pivotPosition];
        int i = start - 1;
        int j = end + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            int aux = arr[i];
            arr[i] = arr[j];
            arr[j] = aux;
        }
    }

    public static List<Integer> generateArray(int size) {
        List<Integer> array = new ArrayList<>();
        IntStream.range(0, size).forEach(it -> array.add(Random.from(RandomGenerator.getDefault()).nextInt(size)));

        return array;
    }


    public static void main(String[] args) {
        List<Integer> list = generateArray(20);
        int[] arr = sort(list);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
