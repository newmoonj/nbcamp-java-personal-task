package calculator;

// 🧮 Level 1-8
// “inquiry” 입력시 연산 결과 전부 출력
// 이미 for문으로 다 출력되게 하고있었지만
// Scanner로 입력받는 조건 추가, foreach(향상된 for문)로 수정

import java.util.ArrayList;
import java.util.Scanner;

public class AppOneEight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>();
        // LinkedList는 삭제 속도는 빠르지만 print 속도가 느리기때문에 ArrayList 채택

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
                    System.out.println("※ 잘못된 입력입니다. 숫자를 다시 입력해주세요.");
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
                    System.out.println("※ 잘못된 입력입니다. 숫자를 다시 입력해주세요.");
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
                            System.out.println("※ 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            saveResult = false;
                        }
                        break;
                    default:
                        System.out.println("※ 지원하지 않는 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
                        validOperation = false;

                }
            } while (validOperation == false) ;

            // 결과 출력

            // 연산이 정상적으로 됐을 때만 결과 출력
            // 배열에 저장(한도 없음)
            // remove 입력시 첫번째값 삭제(results.remove(0))

            if (saveResult) {
                System.out.println("결과: " + result); // 결과 출력
                results.add(result); // 배열에 저장

                // 저장된 결과, 개수 출력
                // 향상된 for문으로 수정
                int index = 1;
                System.out.println("[RESULT HISTORY]");
                for (int value : results) {
                    System.out.print((index) + ": " + value);
                    if (index != results.size()) {
                        System.out.print(", ");
                    }
                    index ++;
                }

                System.out.println();

                // 삭제 여부 확인
                // 루프 추가
                while (true) {
                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    String removeInput = sc.next();
                    if (removeInput.equals("remove")) {
                        results.remove(0);

                        if (results.size() == 0) {
                            System.out.println("저장된 결과가 없습니다.");
                            break; // 더 이상 삭제 불가하므로 탈출

                        } else {
                            // 저장된 결과, 개수 재출력
                            // 향상된 for문으로 수정
                            index = 1;
                            System.out.println("[RESULT HISTORY]");
                            for (int value : results) {
                                System.out.print((index) + ": " + value);
                                if (index != results.size()) {
                                    System.out.print(", ");
                                }
                                index ++;
                            }
                            System.out.println();
                        }
                    } else { // remove 외 입력시 루프 탈출
                        break;
                    }


                }
            }

            // 종료 여부 확인
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

