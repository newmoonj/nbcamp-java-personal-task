package calculator;

// 🧮 Level 1-6
// 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장
// 힌트에 따라 작성함
// Hint : 결과 값들이 한칸씩 앞으로 이동되면 되지 않을까?

import java.util.Scanner;

public class AppOneSix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int maxResults = 10; // 최대 결과 저장 개수(10개)
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
            // 10개 초과시 맨 앞 결과 삭제 후 한칸씩 앞으로 당겨 맨 뒤에 저장
            if (saveResult) {
                System.out.println("결과: " + result);

                if (resultCnt < maxResults-1 ) {
                    results[resultCnt] = result; // 배열에 저장
                    resultCnt++;

                } else if (resultCnt == maxResults-1) { // 저장공간 차면 경고 메시지
                    results[resultCnt] = result;
                    resultCnt++;
                    System.out.printf("저장 공간이 가득 찼습니다. 저장한도: %d\n", maxResults);
                    System.out.println("다음 연산부터 가장 오래된 결과를 삭제하고 새로운 결과를 저장합니다.");

                } else { // results[0]에 results[1]을 저장 -> 반복
                    // i가 9일때 results[8]에 results[9](10번째 값) 저장
                    for (int i = 0; i < maxResults-1 ; i++) {
                        results[i] = results[i+1];
                    }
                    // results[9](10번째 결과)에 새 결과 저장
                    results[maxResults-1] = result;
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
