package Tema6;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @Test
    public void testEvaluateExpression() {
    String expression = "10m + 5ft - 3km + 200cm";
    double result = DistanceCalculator.evaluateExpression(expression);
    assertEquals(907.05, result, 0.001);
}

    @Test
    public void testConvertToMeters() {
        assertEquals(1.0, DistanceCalculator.convertToMeters(1.0, "m"));
        assertEquals(0.01, DistanceCalculator.convertToMeters(1.0, "cm"));
        assertEquals(0.001, DistanceCalculator.convertToMeters(1.0, "mm"));
        assertEquals(1000.0, DistanceCalculator.convertToMeters(1.0, "km"));
        assertEquals(0.3048, DistanceCalculator.convertToMeters(1.0, "ft"));
        assertEquals(0.0254, DistanceCalculator.convertToMeters(1.0, "in"));
        assertEquals(1609.34, DistanceCalculator.convertToMeters(1.0, "mi"));

    }
}