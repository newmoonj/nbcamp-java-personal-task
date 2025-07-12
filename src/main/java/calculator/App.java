package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
        // 🧮 Level 1-1
        // Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); // 적합한 타입으로 선언한 변수에 저장
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        // 저장된 값 출력
        // System.out.println("num1 = " + num1 + ", " +  "num2 = " + num2);
*/
/*
        // 🧮 Level 1-2
        // Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.

        System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
        char operator = sc.next().charAt(0);

         //  sc.next() : sc를 이용해 문자열 하나를 입력받음
         // charAt(idx) : 매개변수로 char 타입으로 반환하고자하는 문자열의 위치(index)를 받는다.
         //  charAt(0) : 입력한 문자열 중 첫번째 문자를 가져옴


        // System.out.println("operator = " + operator);
*/
/*
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
*/
/*
        // 🧮 Level 1-4
        // “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행합니다.

        boolean running = true; // 반복 제어 플래그

        while (running) {
            // 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt(); // 적합한 타입으로 선언한 변수에 저장
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 연산자 입력
            System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
            char operator = sc.next().charAt(0);

            // 계산 수행
            int result = 0;
            boolean validOperation = true; // 연산자 확인 플래그

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
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("지원하지 않는 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
                    validOperation = false;
            }

            // 연산이 정상적으로 됐을 때만 결과 출력
            if (validOperation) {
                System.out.println("결과: " + result);
            }

            // 반복 여부 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitInput = sc.next();
            if (exitInput.equals("exit")) {
                running = false;
            }
        }

        System.out.println("종료");
*/

        // 🧮 Level 1-5
        // 연산 결과 10개를 저장할 수 있는 배열 추가
        // 숫자 아닌 입력값 예외처리 추가
// max
        int maxResults = 3; // 최대 결과 저장 개수(10개)
        int[] results = new int[maxResults];
        int resultCnt = 0; // 저장된 결과 count(index)

        boolean running = true; // 반복 제어 플래그

        while (running) {
            int num1;
            int num2;

            // 첫번째 숫자 입력
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt(); // 적합한 타입으로 선언한 변수에 저장
                    break;
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다. 숫자를 다시 입력해주세요.");
                    sc.next();
                }
            }

            // 두번째 숫자 입력
            while (true) {
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다. 숫자를 다시 입력해주세요.");
                    sc.next();
                }
            }

            // 연산자 입력 및 계산 수행
            char operator;
            boolean validOperation; // 연산자 확인 플래그
            boolean saveResult = true; // 결과 저장 여부
            int result = 0;

            do {
                validOperation = true;
                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                operator = sc.next().charAt(0);

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
                            saveResult = false;
                        }
                        break;
                    default:
                        System.out.println("지원하지 않는 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
                        validOperation = false;

                }
            } while (validOperation == false) ;


                // 연산이 정상적으로 됐을 때만 결과 출력
                // 배열에 저장(최대 10개)
                if (saveResult) {
                    System.out.println("결과: " + result);

                    if (resultCnt < maxResults) {
                        results[resultCnt] = result; // 배열에 저장
                        resultCnt++;

                    } else {
                        System.out.printf("저장 공간이 가득 찼습니다. 저장한도: %d\n", maxResults);
                    }
                }
                // 저장된 결과, 개수 출력
                System.out.printf("[RESULT HISTORY(%d/%d)]\n", resultCnt, maxResults);

                for (int i = 0; i < resultCnt; i++) {
                    System.out.print(results[i] + " ");
                }

                System.out.println();

                // 반복 여부 확인
                System.out.println("-".repeat(50));
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String exitInput = sc.next();
                if (exitInput.equals("exit")) {
                    running = false;
                }

            }
            System.out.println("프로그램을 종료합니다.");


            // ===========

    }
}
