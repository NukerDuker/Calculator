import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.apache.logging.log4j.*;

public class CalculatorTest {
    Logger LOG = LogManager.getLogger(CalculatorTest.class);
    private Calculator test = new Calculator();

    @Test
    public void test() {
        LOG.info("Начало тестирование");
        org.junit.Assert.assertTrue((test.calculate(1,2,'*')) == 2);
        org.junit.Assert.assertTrue((test.calculate(1,2,'+')) == 3);
        LOG.info("Тестируем неизвестную операцию");
        test.calculate(1,2,'Ы');

    }

    @Test(expected = ArithmeticException.class)
    public void divTest() {
        LOG.info("Начинаем тест деления на ноль");
        test.calculate(15, 0, '/');
    }
    @After
    public void afterTest() {
        LOG.info("Тестирование заврешено");
    }
}
