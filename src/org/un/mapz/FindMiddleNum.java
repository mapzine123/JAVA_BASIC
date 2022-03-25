package org.un.mapz;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FindMiddleNum {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String input = stdIn.nextLine();
        int[] arr = new int[3];
        String[] nums = input.split(" ");
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(arr);
        System.out.printf("중간값 : %d", arr[1]);
    }
}
