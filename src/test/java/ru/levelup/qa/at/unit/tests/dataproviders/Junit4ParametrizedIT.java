package ru.levelup.qa.at.unit.tests.dataproviders;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.levelup.qa.at.unit.tests.Calculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class Junit4ParametrizedIT {

    private int a;
    private int b;
    private double expected;

    public Junit4ParametrizedIT(int a, int b, double expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Test
    public void calculatorSumTest() {
        Calculator calculator = new Calculator();
        double actualSum = calculator.sum(a, b);
        assertEquals(actualSum, expected, 0.0001);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> calculatorDataProvider() {
        return Arrays.asList(new Object[][]{
                {2, 2, 4.0},
                {3, 3, 6.0},
                {-5, -5, -10.0}
        });
    }
}
