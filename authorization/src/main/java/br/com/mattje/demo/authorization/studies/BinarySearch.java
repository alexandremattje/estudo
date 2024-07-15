package br.com.mattje.demo.authorization.studies;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class BinarySearch {

    public static int binarySearch(List<Integer> arr, int searchValue) {
        // Big O(log n)
        int start = 0;
        int end = arr.size();
        int count = 0;
        System.out.println(LocalDateTime.now());
        while (start <= end) {
            int middle = (start + end) / 2;
            int value = arr.get(middle);
            count++;
            if (value == searchValue) {
                System.out.println(count);
                System.out.println(LocalDateTime.now());
                return middle;
            } else if (value > searchValue) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        System.out.println(count);
        System.out.println(LocalDateTime.now());
        return -1;
    }

    public static List<Integer> generateArray(int size) {
        List<Integer> array = new ArrayList<>();
        IntStream.range(0, size).forEach(array::add);

        return array;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(generateArray(100), Random.from(RandomGenerator.getDefault()).nextInt(100)));
        System.out.println(binarySearch(generateArray(1000), Random.from(RandomGenerator.getDefault()).nextInt(1000)));
        System.out.println(binarySearch(generateArray(10000), Random.from(RandomGenerator.getDefault()).nextInt(10000)));
        System.out.println(binarySearch(generateArray(100000), Random.from(RandomGenerator.getDefault()).nextInt(100000)));
        System.out.println(binarySearch(generateArray(1000000), Random.from(RandomGenerator.getDefault()).nextInt(1000000)));
        System.out.println(binarySearch(generateArray(10000000), Random.from(RandomGenerator.getDefault()).nextInt(10000000)));
        System.out.println(binarySearch(generateArray(100000000), Random.from(RandomGenerator.getDefault()).nextInt(100000000)));
    }

}
