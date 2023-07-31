package Tema6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceCalculator {
    public static double evaluateExpression(String expression) {
        double totalDistance = 0.0;


        Pattern pattern = Pattern.compile("(m|cm|mm|km|ft|in|mi)");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            double distance = Double.parseDouble(matcher.group(1));
            String unit = matcher.group(3);
            double convertedDistance = convertToMeters(distance, unit);
            totalDistance += convertedDistance;
        }

        return totalDistance;
    }

    public static double convertToMeters(double distance, String unit) {
        double convertedDistance = 0.0;

        switch (unit) {
            case "m":
                convertedDistance = distance;
                break;
            case "cm":
                convertedDistance = distance / 100.0;
                break;
            case "mm":
                convertedDistance = distance / 1000.0;
                break;
            case "km":
                convertedDistance = distance * 1000.0;
                break;
            case "ft":
                convertedDistance = distance * 0.3048;
                break;
            case "in":
                convertedDistance = distance * 0.0254;
                break;
            case "mi":
                convertedDistance = distance * 1609.34;
                break;
        }

        return convertedDistance;
    }
}
