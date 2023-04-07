
/*В калькулятор добавьте возможность отменить последнюю операцию */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class prog3<T> {

    private static Logger logger = Logger.getLogger(prog3.class.getName());
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        Deque<Double> number_list = new LinkedList<>();
        System.out.println("результат операций");

        boolean first_input = true;
        boolean calc = true;
        double number1 = 0.0;
        String operation;

        logger.info("Это регистрация информации об уровне");
        logger.log(Level.WARNING, "Это регистрация предупреждений об уровне");
        logger.log(Level.SEVERE, "Это строгий уровень ведения журнала");
        System.out.println("Здравствуйте, Java Logging API.");

        while (calc) {
            if (first_input) {
                number1 = input_number(sc);
                first_input = false;
            }
            operation = input_operation(sc);
            if (operation.equals("отмена")) {
                if (!number_list.isEmpty()) {
                    reset_operation(number_list);
                    number1 = number_list.getLast();
                } else {
                    System.out.println("Текущий результат отсутствует. Давайте начнем сначала!");
                    number1 = input_number(sc);
                }
                operation = input_operation(sc);
            }
            double number2 = input_number(sc);
            double result = calculation(number1, number2, operation);
            number1 = result;
            add_element(number_list, result);
            System.out.println("Результат = " + result);
        }
    }

    public static double input_number(Scanner scanner) {
        System.out.println("введите число");
        double number = 0.0;
        try {
            number = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("допущена ошибка при вводе операции, попробуйте еще раз!");
            scanner.nextLine();
            input_number(scanner);
        }
        return number;
    }

    public static String input_operation(Scanner scanner) {
        System.out.println("Введите оператор действия (+, -, *, /) или 'Отмена'");
        String oper = scanner.next().toLowerCase();
        if ((!oper.equals("+")) & (!oper.equals("-")) & (!oper.equals("*")) & (!oper
                    .equals("/")) & (!oper.equals("отмена"))) {
                System.out.println("операция не распознана, повторите ввод!");
                oper = input_operation(scanner);
                scanner.nextLine();
        }
        return oper;
    }

    public static void reset_operation(Deque<Double> list) {
        if (!list.isEmpty()) {
            list.removeLast();
            System.out.println("Операция отменена");
            if (list.isEmpty()) {
                list.addLast(0.0);
            }
            System.out.println("Работаем с результатом " + list.getLast());
        }
    }

    public static double calculation(double num1, double num2, String oper) {
        double result = 0.0;
        switch (oper.toLowerCase()) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
    public static void add_element(Deque<Double> list, double element) {
        list.addLast(element);
    }
}