package calculator;

// 🧮 Level 2-1
// Calculator 클래스를 생성
// 나눗셈 분모에 0, 연산자 기호 잘못 -> Exception throw

// 🧮 Level 2-2
// App 클래스의 main 메서드에 Calculator 클래스 활용
// 연산 수행 역할은 Calculator 클래스가 담당(calculate)
// 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장

import java.util.ArrayList;
import java.util.Scanner;

public class AppTwoOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean running = true; // 반복 제어 플래그

        while (running) {

            boolean validOperation = false; // 연산자 확인 플래그
            int result = 0;
            while(validOperation == false) {

                // 첫번째 숫자 입력
                int num1 = getInputNumber(sc, "첫 번째 숫자를 입력하세요: ");

                // 두번째 숫자 입력
                int num2 = getInputNumber(sc, "두 번째 숫자를 입력하세요: ");


                // 연산자 입력 및 계산 수행
                // 결과 저장 포함
                char operator;




                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                operator = sc.next().charAt(0);

                try { // 결과 저장
                    result = calculator.calculate(num1, num2, operator);
                    validOperation = true;
                } catch (ArithmeticException | IllegalArgumentException e) {
                    // 나눗셈 분모 0 또는 잘못된 연산 기호
                    System.out.println(e.getMessage());
                }

            }
            // 결과 출력
            System.out.println("결과: " + result); // 결과 출력
            calculator.printResults();

            // 명령 루프
            // 삭제 여부 확인, inquiry로 결과 출력, 프로그램 종료 여부, continue 여부

            while (true) {
                System.out.println("명령어를 입력하세요: ");
                System.out.println("-(r)remove: 가장 먼저 저장된 결과 삭제");
                System.out.println("-(i)inquiry: RESULT HISTORY 보기");
                System.out.println("-(c)continue: 다음 계산 실행");
                System.out.println("-(e)exit: 프로그램 종료");

                String commandInput = sc.next();

                if (commandInput.equals("remove") || commandInput.equals("r")) {
                    calculator.removeFirstResult();
                } else if (commandInput.equals("inquiry") || commandInput.equals("i")) {
                    calculator.printResults();
                } else if (commandInput.equals("continue") || commandInput.equals("c")) {
                    break;
                } else if (commandInput.equals("exit") || commandInput.equals("e")) {
                    running = false;
                    break;
                } else {
                    System.out.println("※ 잘못된 명령어입니다. 다시 입력해주세요.");
                }
            }
        }


    System.out.println("프로그램을 종료합니다.");

    // ===========

}
// 숫자 입력 루프
    private static int getInputNumber(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("※ 잘못된 입력입니다. 숫자를 다시 입력해주세요.");
                sc.next();
            }
        }
    }

}

