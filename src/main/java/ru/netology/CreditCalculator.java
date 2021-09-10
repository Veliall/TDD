package ru.netology;

public class CreditCalculator {

    public double getTotalAmount(final long amount, final int percent, final int months) {
        if (amount <= 0 || percent <= 0 || months <= 0) {
            throw new IllegalArgumentException("Incorrect data");
        }

        return (getOverpayment(amount, percent, months) + amount);
    }

    public double getOverpayment(final long amount, final int percent, final int months) {
        if (amount <= 0 || percent <= 0 || months <= 0) {
            throw new IllegalArgumentException("Incorrect data");
        }
        int countOfYears = months / 12;
        if (months % 12 != 0) countOfYears++;

        return (percent * countOfYears * amount / 100) / 10.0;
    }

    public double getPaymentPerMonth(final long amount, final int percent, final int months) {
        if (amount <= 0 || percent <= 0 || months <= 0) {
            throw new IllegalArgumentException("Incorrect data");
        }

        return getTotalAmount(amount, percent, months) / months;
    }
}
