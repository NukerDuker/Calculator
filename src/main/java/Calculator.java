

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private int result = 0;
    private int count = 0;
    private static final Logger LOG = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) {
        Calculator test = new Calculator();
        //Логирование
        LOG.info("Калькулятор запущен");
        test.runCalc();
    }

    private void runCalc() {
        Scanner input = new Scanner(System.in);
        while (true) {
            int a;
            //Если калькулятор уже вызывали, операнд берем из результата вызова.
            //Если это первый вход в калькулятор, предлагаем ввести операнд.
            if (count > 0) {
                a = result;
            } else {
                //Логирование
                LOG.trace("Вводим первый операнд");
                System.out.println("Введите первый операнд: ");
                a = input.nextInt();
            }
            System.out.println("Введите желаемую операцию: ");
            System.out.println("(для выхода - s, для сброса - с)");
            //Управление выходом и сбросом на калькуляторе происходит на этапе ввода знака операции
            //не нашел способ сделать это и на вводе чисел для переменных a и b.
            char operation = Character.toLowerCase(input.next().charAt(0));
            // На английской и русской раскладке C одинаково выглядит, но это разные буквы.
            //Добавлю условие на обе раскладки. Count сбрасываем, чтобы ввести операнд после.
            if (operation == 'c' || operation == 'с') {
                //Логирование
                LOG.info("Пользователь выбрал сброс данных");
                count = 0;
                continue;
            } else if (operation == 's') {
                //Логирование
                LOG.info("Пользователь нажал на выход");
                break;
            }
            System.out.println("Введите второй операнд: ");
            int b = input.nextInt();
            //Логирование
            LOG.info("Введен второй операнд");
            if(b == 0 && operation == '/') LOG.fatal("Деление на ноль!");
            //запускаем калькулятор с полученными данными, после этого увеличиваем счетчик.
            calculate(a, b, operation);
            count++;
        }
    }

    private void calculate(int a, int b, char operation) {
        switch (operation) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> result = a / b;
            default -> {
                //если попадаем сюда, первый операнд нужно будет ввести снова. Для этого сбрасываем счетчик.
                //Логирование
                LOG.warn("Неизвестная операция");
                System.out.println("Unknown operation. Allowed operations with \"+\", \"-\", \"*\", \"/\".");
                count = 0;
            }
        }
        System.out.println(result);
    }
}

