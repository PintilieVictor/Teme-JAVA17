package Tema6;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ParamaterTest {
    private final String expression;
    private final double expected;

    public ParamaterTest(String expression, double expected) {
        this.expression = expression;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"10m + 5ft - 3km + 200cm", 907.05},
                {"1mi - 1000m", 402.336},
                {"100cm - 5ft", 47.0},
                {"0.5km + 1000mm - 2mi", -301.575}
        });
    }

    @Test
    public void testEvaluateExpression() {
        double result = DistanceCalculator.evaluateExpression(expression);
        assertEquals(expected, result, 0.001);
    }
}
