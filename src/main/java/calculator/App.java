package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 🧮 Level 1-1
        // Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); // 적합한 타입으로 선언한 변수에 저장
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        // 저장된 값 출력
        // System.out.println("num1 = " + num1 + ", " +  "num2 = " + num2);

        // 🧮 Level 1-2
        // Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
        System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
        char operator = sc.next().charAt(0);
        /*
         *  sc.next() : sc를 이용해 문자열 하나를 입력받음
         *  charAt(idx) : 매개변수로 char 타입으로 반환하고자하는 문자열의 위치(index)를 받는다.
         *  charAt(0) : 입력한 문자열 중 첫번째 문자를 가져옴
        */

        // System.out.println("operator = " + operator);

        // 🧮 Level 1-3
        // 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
        int result = 0;
        boolean validOperation = true;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    validOperation=false;
                }
                break;
            default:
                System.out.println("지원하지 않는 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
                validOperation=false;
        }

        // 연산이 정상적으로 됐을 때만 결과 출력
        if (validOperation) {
            System.out.println("결과: " + result);
        }



    // ===========
        }
    }
