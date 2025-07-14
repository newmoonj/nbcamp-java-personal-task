package calculator;
// 🧮 Level 2-1
// Calculator 클래스를 생성
// 나눗셈 분모에 0, 연산자 기호 잘못 -> Exception throw

// 🧮 Level 2-2
// App 클래스의 main 메서드에 Calculator 클래스 활용
// 연산 수행 역할은 Calculator 클래스가 담당(calculate)
// 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 속성
    private List<Integer> results; // 연산 결과를 저장하는 list

    // 생성자
    public Calculator() {
        results = new ArrayList<>(); // 연산 결과를 저장하는 list
    }

    // 기능
    // 1. calculate (첫번째 숫자, 두번째 숫자, 사칙연산 기호(+, -, *, /))
    // 연산, 결과 저장(results.add(result))
    public int calculate(int num1, int num2, char operator) {

        int result;

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
                if (num2 == 0) {
                    throw new ArithmeticException("※ 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("※ 지원하지 않는 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
        }

        results.add(result); // 연산 결과를 저장
        return result;
    }

    // 2. 연산 결과 getter
    public List<Integer> getResults() {
        return results;
    }

    // 3. 가장 먼저 저장된 결과 삭제
    public void removeFirstResult() {
        if (results.isEmpty()) {
            System.out.println("※ 저장된 결과가 없습니다.");
        } else {
            results.remove(0);
            System.out.println("※ 첫 번째 결과가 삭제되었습니다.");
        }
    }

    // 4. 결과 출력
    public void printResults() {
        System.out.println("[RESULT HISTORY]");
        int index = 1;
        for (int value : results) {
            System.out.print(index + ": " + value);
            if (index != results.size()) {
                System.out.print(", ");
            }
            index++;
        }
        System.out.println();
    }
    }


