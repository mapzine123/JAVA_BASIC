package org.un.mapz;

import java.util.Vector;

/*
* isPrime : 소수일시 중지
* idx < primes.size() : 소수가 아닌 자연수는 소수로 나누어짐
* primes.get(idx) <= i/2 : 짝수 제외
*/

public class FindPrime {
    static int count1 = 0;
    static int count2 = 0;
    public static Integer[] getPrimes(int end) {
        Vector<Integer> primes = new Vector<Integer>(); // 소수를 담을 벡터
        for (int i = 2; i <= end; i++) { // 2 ~ 지정된 마지막 숫자까지
            boolean isPrime = true;
            for(int idx = 0; isPrime && idx < primes.size() && primes.get(idx) <= i/2; idx++) { 
                if(i % primes.get(idx) == 0) { // 소수로 나누어질 시 소수가 아님
                    isPrime = false;
                }
                count1++; // 시도 횟수 증가
            }
            if(isPrime) { // 소수라면 벡터에 추가
                primes.add(i);
            }
        }
        return primes.toArray(new Integer[0]); // 배열로 반환
    }

    public static int getPrimesPlus(int end) {
        Vector<Integer> vec = new Vector<Integer>();
//        vec.add(2);
        int result = 1;
        for (int i = 3; i <= end; i++) { // 2 ~ 지정된 마지막 숫자까지
            boolean isPrime = true;
            for(int j = 2; isPrime && j <= Math.sqrt(i); j++) {
                count2++;
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        Integer[] nums = getPrimes(1000000);
//        long end1 = System.currentTimeMillis() - start;

        long start2 = System.currentTimeMillis();
        int nums2 = getPrimesPlus(10000000);
        long end2 = System.currentTimeMillis() - start2;

//        System.out.println("count1 = " + count1);
//        System.out.println("end1 = " + end1 * 0.001 + "초");

        System.out.println("count2 = " + count2);
        System.out.println("end2 = " + end2 * 0.001 + "초");
    }
}
