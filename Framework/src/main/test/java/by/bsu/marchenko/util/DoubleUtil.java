package by.bsu.marchenko.util;

public class DoubleUtil {
    public static double parseStringToDouble(String value){
        return Double.parseDouble(value.replaceAll("[^\\d.]", ""));
    }
}
