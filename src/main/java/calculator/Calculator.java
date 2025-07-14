package calculator;
// 🧮 Level 2-7
// 반지름을 매개변수로 전달받아 원의 넓이를 계산
// 사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 속성
    private List<Integer> results; // 사칙 연산 결과를 저장
    private List<Double> circleAreas; // 원 넓이 결과 저장 (캡슐화를 위해 private 사용)
    private static final double PI = 3.14; // 상수 PI 값


    // 생성자
    public Calculator() {
        results = new ArrayList<>();
        circleAreas = new ArrayList<>(); // 연산 결과를 저장하는 ArrayList가 생성자를 통해 초기화
    }

    // 기능
    // 1-1 calculate (첫번째 숫자, 두번째 숫자, 사칙연산 기호(+, -, *, /))
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

//        results.add(result); // 연산 결과를 저장
        return result;
    }

    // 1-2 원의 넓이 계산
    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;
        return area;
    }


    // 2-1 사칙 연산 결과 getter/setter(add 역할)
    public List<Integer> getResults() {
        return results;
    }

    public void setResults(int result) {
        results.add(result);
    }

    // 2-2 원 넓이 결과 getter/setter(add)
    public List<Double> getCircleAreas() {
        return circleAreas;
    }

    public void setCircleAreas(double area) {
        circleAreas.add(area);

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

    // 4-1 사칙연산 결과 출력
    public void inquiryResults() {
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


    // 4-2 원넓이 결과 출력
    public void inquiryCircleAreas() {
        System.out.println("[CIRCLE AREA RESULT HISTORY]");
        int index = 1;
        for (double value : circleAreas) {
            System.out.print(index + ": " + value);
            if (index != circleAreas.size()) {
                System.out.print(", ");
            }
            index++;
        }
        System.out.println();
    }
}

