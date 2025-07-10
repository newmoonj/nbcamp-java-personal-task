package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); // 적합한 타입으로 선언한 변수에 저장
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        // 저장된 값 출력
        System.out.println("num1 = " + num1 + ", " +  "num2 = " + num2);


    }
}