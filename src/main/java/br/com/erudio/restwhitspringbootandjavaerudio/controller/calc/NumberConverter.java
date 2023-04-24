package br.com.erudio.restwhitspringbootandjavaerudio.controller.calc;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null){
            return 0D;
        }
        String number = strNumber.replace(",", ".");
        if(verify(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }

    public static boolean verify(String strNumber) {
        if(strNumber == null){
            return false;
        }
        String number = strNumber.replace(",", ".");

        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
