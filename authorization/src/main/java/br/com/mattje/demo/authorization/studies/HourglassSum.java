package br.com.mattje.demo.authorization.studies;

import java.util.List;

public class HourglassSum {

    public static int hourGlassSum(List<List<Integer>> arr) {
        // Big O(n)
        int sum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int c = 0; c <= 3; c++) {
            for (int l = 0; l <= 3; l++) {
                tempSum += arr.get(l).get(c);
                tempSum += arr.get(l).get(c + 1);
                tempSum += arr.get(l).get(c + 2);
                tempSum += arr.get(l + 1).get(c + 1);
                tempSum += arr.get(l + 2).get(c);
                tempSum += arr.get(l + 2).get(c + 1);
                tempSum += arr.get(l + 2).get(c + 2);
                System.out.println(tempSum);
                if (tempSum > sum) {
                    sum = tempSum;
                }
                tempSum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hourGlassSum(List.of(
                List.of(1, 1, 1, 0, 0, 0),
                List.of(0, 1, 0, 0, 0, 0),
                List.of(1, 1, 1, 0, 0, 0),
                List.of(0, 0, 2, 4, 4, 0),
                List.of(0, 0, 0, 2, 0, 0),
                List.of(0, 0, 1, 2, 4, 0)
        )));
        System.out.println(hourGlassSum(List.of(
                List.of(1, 1, 1, 0, 0, 0),
                List.of(0, 1, 0, 0, 0, 0),
                List.of(1, 1, 1, 0, 0, 0),
                List.of(0, 9, 2, -4, -4, 0),
                List.of(0, 0, 0, -2, 0, 0),
                List.of(0, 0, -1, -2, -4, 0))));

        System.out.println(hourGlassSum(List.of(
                List.of(1, 1, 1 ,0, 0 ,0),
                List.of(0, 1, 0 ,0, 0 ,0),
                List.of(1, 1, 1, 0, 0 ,0),
                List.of(0, 0, 2, 4 ,4, 0),
                List.of(0, 0, 0, 2 ,0, 0),
                List.of(0, 0, 1, 2, 4, 0))));
    }

}
