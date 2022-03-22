package org.un.mapz;

@FunctionalInterface
interface Car {
    String drive(int driveLevel);
}


public class LambdaEx {
    public static void main(String[] args) {
        new Thread(new Runnable() {
           public void run() {
               System.out.println("전통적 방식의 일회용 쓰레드 생성");
           }
        }).start();

        new Thread(() -> {
            System.out.println("람다 표현식을 이용한 일회용 쓰레드 생성");
        }).start();


        Car car = new Car() { // 일반적 방식의 내부클래스 구현
            @Override
            public String drive(int driveLevel) {
                return driveLevel == 0 ? "" : "자동차가" + driveLevel + " 의 속도로 이동합니다.";
            }
        };
        Car car1 = (i) -> i == 0 ? "" : "자동차가" + i + " 의 속도로 이동합니다."; // 람다 표현식을 이용한 내부클래스 구현
        System.out.println(car.drive(10));
        System.out.println(car1.drive(10));

    }



    public static void lambdaEx1(String str) {
        System.out.println("parameter is " + str);
    }
}
