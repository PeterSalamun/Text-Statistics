package appLogicTests.TextOperations;

import org.apache.commons.math3.util.Precision;

public class GeneralOperations {

    public GeneralOperations() {}

    protected double round(double number, int decimalPlaces) {
        if (Double.isNaN(number))
            return 0.0;
        return Precision.round(number, decimalPlaces, 4);
    }

    protected double percentage(double value1, double value2, int decimal) {
        if(value1 < 0)
            return 0;
        return round((value1 / value2) * 100, decimal);
    }

    public double getRound(double number, int decimalPlaces) {
        return round(number, decimalPlaces);
    }

    public double getPercentage(double value1, double value2, int decimal) {
               return percentage(value1, value2, decimal);
    }
}
