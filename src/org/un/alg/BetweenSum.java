package org.un.alg;

import java.util.Arrays;

public class BetweenSum {
    public long solution1(int a, int b) {
        long start = System.currentTimeMillis();
        long answer = 0;
        int[] nums = {a, b};
        Arrays.sort(nums);

        for(int i = nums[0]; i <= nums[1]; i++) {
            answer += i;
        }

        long end = System.currentTimeMillis() - start;

        System.out.println("end = " + end);
        return answer;
    }


    public long solution2_1(int a, int b) {
        long start = System.currentTimeMillis();
        long result = sumAtoB(Math.min(a, b), Math.max(b, a));
        long end = System.currentTimeMillis() - start;

        System.out.println("end = " + end);

        return result;
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

    public static void main(String[] args) {
        BetweenSum bs = new BetweenSum();
        System.out.println(bs.solution2_1(-10000000, 1000000000));

    }
}
