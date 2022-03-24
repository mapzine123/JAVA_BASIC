package org.un.mapz;

import java.util.Vector;

/*
* isPrime : 소수일시 중지
* idx < primes.size() : 소수가 아닌 자연수는 소수로 나누어짐
* primes.get(idx) <= i/2 : 짝수 제외
*/

public class FindPrime {
    static int count = 0;
    
    public static Integer[] getPrimes(int end) {
        Vector<Integer> primes = new Vector<Integer>(); // 소수를 담을 벡터
        for (int i = 2; i <= end; i++) { // 2 ~ 지정된 마지막 숫자까지
            boolean isPrime = true;
            for(int idx = 0; isPrime && idx < primes.size() && primes.get(idx) <= i/2; idx++) { 
                if(i % primes.get(idx) == 0) { // 소수로 나누어질 시 소수가 아님
                    isPrime = false;
                }
                count++; // 시도 횟수 증가
            }
            if(isPrime) { // 소수라면 벡터에 추가
                primes.add(i);
            }
        }
        return primes.toArray(new Integer[0]); // 배열로 반환
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Integer[] nums = getPrimes(100);
        long end = System.currentTimeMillis() - start;
        for (int n : nums) {
            System.out.println("n = " + n);
        }
        System.out.println("count = " + count);
        System.out.println("end = " + end * 0.001 + "초");
    }
}
