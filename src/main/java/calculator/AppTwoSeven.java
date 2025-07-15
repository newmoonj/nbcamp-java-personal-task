package calculator;

// 🧮 Level 2-7
// 반지름을 매개변수로 전달받아 원의 넓이를 계산
// 사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력

import java.util.Scanner;

public class AppTwoSeven {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); // Calculator 인스턴스 생성
        boolean running = true; // 반복 제어 플래그

        while (running) {
            System.out.println("■□ 계산기 프로그램을 시작합니다.□■");
            System.out.println("a. 사칙 연산/b. 원의 넓이 계산");
            System.out.print("원하는 기능을 입력하세요 (a or b)");
            String option = sc.next();

            // a. 사칙연산 수행
            if (option.equals("a")) {
                boolean validOperation = false; // 연산자 확인 플래그
                int result = 0;

                while (!validOperation) {

                    // 숫자 입력
                    int num1 = getInputNumber(sc, "첫 번째 숫자를 입력하세요: ");
                    int num2 = getInputNumber(sc, "두 번째 숫자를 입력하세요: ");

                    // 연산자 입력 및 계산 수행
                    System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                    char operator = sc.next().charAt(0);

                    try {
                        result = calculator.calculate(num1, num2, operator);
                        calculator.setResults(result); // Setter 활용
                        validOperation = true;
                    } catch (ArithmeticException | IllegalArgumentException e) {
                        // 나눗셈 분모 0 또는 잘못된 연산 기호
                        System.out.println(e.getMessage());
                    }
                }

                // 결과 출력
                System.out.println("결과: " + result); // 결과 출력

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
                        calculator.inquiryResults();
                    } else if (commandInput.equals("continue") || commandInput.equals("c")) {
                        break;
                    } else if (commandInput.equals("exit") || commandInput.equals("e")) {
                        running = false;
                        break;
                    } else {
                        System.out.println("※ 잘못된 명령어입니다. 다시 입력해주세요.");
                    }
                }


                // b. 원의 넓이 계산
            } else if (option.equals("b")) {
                double radius = getInputDouble(sc, "원의 반지름을 입력하세요: ");
                double area = calculator.calculateCircleArea(radius);
                System.out.println("원의 넓이: " + area);
                calculator.setCircleAreas(area);
                calculator.inquiryCircleAreas();


            } else {
                System.out.println("※ a 또는 b를 입력해주세요.");
                continue;
            }

            System.out.println("프로그램을 종료합니다.");

            // ===========

        }



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

// 숫자 입력 루프
private static double getInputDouble(Scanner sc, String prompt) {
    while (true) {
        try {
            System.out.print(prompt);
            return sc.nextDouble();
        } catch (Exception e) {
            System.out.println("※ 잘못된 입력입니다. 숫자를 다시 입력해주세요.");
            sc.next();
        }
    }

}

}

