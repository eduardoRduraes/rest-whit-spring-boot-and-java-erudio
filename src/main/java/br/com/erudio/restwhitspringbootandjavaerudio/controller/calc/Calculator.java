package br.com.erudio.restwhitspringbootandjavaerudio.controller.calc;

import br.com.erudio.restwhitspringbootandjavaerudio.exception.UnsupportedMathOperationException;

public class Calculator {

    private double resultado;
    public Calculator(String numberOne, String numberTwo, String simbolo){
        this.calculo(numberOne,numberTwo,simbolo);
    }

    private void calculo(String numberOne, String numberTwo, String simbolo){
        if(!NumberConverter.verify(numberOne) || !NumberConverter.verify(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        switch (simbolo) {
            case "+" -> this.resultado = NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
            case "-" -> this.resultado = NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
            case "*" -> this.resultado = NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
            case "/" -> this.resultado = NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
            case "media" -> this.resultado = (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2;
            case "raiz" -> this.resultado = Math.sqrt(NumberConverter.convertToDouble(numberOne));
            default -> System.out.println("algo deu errado!");
        }
    }
    public String toString(){
        return "Resultado: " + this.resultado;
    }

    public double getResultado(){
        return this.resultado;
    }
}
