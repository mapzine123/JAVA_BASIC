package org.un.alg;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/*
    홀 + 홀 + 홀 : 홀
    홀 + 짝 + 짝 : 홀

 */
public class FindPrimes2 {
    public int solution(int[] nums) {
        int answer = 0;
        boolean flag = false;
        int maxNum = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        Integer[] prime = getPrimes(maxNum);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    System.out.println("isPrime(num, prime) = " + isPrime(num, prime));
                    System.out.println("num = " + num);
                    if(isPrime(num, prime)) {
                        answer++;
                    };
                }
            }
        }
        return answer;
    }

    private boolean isPrime(int num, Integer[] primes) {
        boolean flag = true;
        if(num % 2 == 0) {
            return false;
        }

        for (int idx = 0; flag && idx < primes.length; idx++) {
            if(num == primes[idx]) {
                return true;
            }

            if(num % primes[idx] == 0) {
                return false;
            }

        }
        return true;
    }

    public Integer[] getPrimes(int end) {
        Vector<Integer> primes = new Vector<Integer>(); // 소수를 담을 벡터
        for (int i = 2; i <= end; i++) { // 2 ~ 지정된 마지막 숫자까지
            boolean isPrime = true;
            for(int idx = 0; isPrime && idx < primes.size() && primes.get(idx) <= i/2; idx++) {
                if(i % primes.get(idx) == 0) { // 소수로 나누어질 시 소수가 아님
                    isPrime = false;
                }
            }
            if(isPrime) { // 소수라면 벡터에 추가
                primes.add(i);
            }
        }
        return primes.toArray(new Integer[0]); // 배열로 반환
    }

    public static void main(String[] args) {
        FindPrimes fp = new FindPrimes();
        int[] a = {1, 2, 3, 4};
        System.out.println(fp.solution(a));
    }
}