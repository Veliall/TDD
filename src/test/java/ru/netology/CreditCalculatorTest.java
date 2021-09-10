package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditCalculatorTest {
    CreditCalculator calculator = new CreditCalculator();

    @Test
    public void getTotalAmount() {
        final int months = 25;
        int countOfYears = months / 12; // <- обычно ведь процентная ставка не за месяц, а за год
        if (months % 12 != 0) countOfYears++;
        final int percent = 152; // <- не хочу связываться с double, подразумеваю 15,2%
        final long amount = 1_000_000L;

        final var expected = (amount + (percent * countOfYears * amount / 100)/ 10.0) ;
        final var actual = calculator.getTotalAmount(1_000_000L, 152, 25);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTotalAmount_WITH_INCORRECT_DATA_1() throws IllegalArgumentException {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.getTotalAmount(1_000_000L, 0, 24));

        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void getTotalAmount_WITH_INCORRECT_DATA_2() throws IllegalArgumentException {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.getTotalAmount(0, 200, 30));

        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void getTotalAmount_WITH_INCORRECT_DATA_3() throws IllegalArgumentException {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.getTotalAmount(10_000_000L, 100, 0));

        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void getTotalAmount_WITH_INCORRECT_DATA_4() throws IllegalArgumentException {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.getTotalAmount(1_000_000L, -20, 10));

        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void getOverpayment() {
        final int months = 25;
        int countOfYears = months / 12; // <- обычно ведь процентная ставка не за месяц, а за год
        if (months % 12 != 0) countOfYears++;
        final int percent = 152; // <- не хочу связываться с double, подразумеваю 15,2%
        final long amount = 1_000_000L;

        final var expected = (percent * countOfYears * amount / 100) / 10.0;
        final var actual = calculator.getOverpayment(1_000_000L, 152, 25);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getPaymentPerMonth() {
        final int months = 25;
        int countOfYears = months / 12; // <- обычно ведь процентная ставка не за месяц, а за год
        if (months % 12 != 0) countOfYears++;
        final int percent = 152; // <- не хочу связываться с double, подразумеваю 15,2%
        final long amount = 1_000_000L;

        final var expected = ((amount + (percent * countOfYears * amount / 100)/ 10.0) / months) ;
        final var actual = calculator.getPaymentPerMonth(1_000_000L, 152, 25);
        Assertions.assertEquals(expected, actual);
    }
}
