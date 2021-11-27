import java.util.Scanner;

public class Calculator {


    private int result = 0;
    private int count = 0;

    public static void main(String[] args) {
        Calculator test = new Calculator();
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
                count = 0;
                continue;
            } else if (operation == 's') {
                break;
            }
            System.out.println("Введите второй операнд: ");
            int b = input.nextInt();
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
                System.out.println("Unknown operation. Allowed operations with \"+\", \"-\", \"*\", \"/\".");
                count = 0;
            }
        }
        System.out.println(result);
    }
}

