package br.com.erudio.restwhitspringbootandjavaerudio.controller;

import br.com.erudio.restwhitspringbootandjavaerudio.controller.calc.Calculator;
import br.com.erudio.restwhitspringbootandjavaerudio.controller.calc.NumberConverter;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculator")
public class MathController {


    @RequestMapping(value = "/soma/{numberOne}/{numberTwo}" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public double getSoma(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) {
        if(!NumberConverter.verify(numberOne) || !NumberConverter.verify(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return new Calculator(numberOne, numberTwo, "+").getResultado();
    }

    @RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public double getSubtracao(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) {
        return new Calculator(numberOne, numberTwo, "-").getResultado();
    }

    @RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public double getMultiplicacao(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) {
        return new Calculator(numberOne, numberTwo, "*").getResultado();
    }
    @RequestMapping(value = "/divisao/{numberOne}/{numberTwo}" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public double getDivisao(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) {
        return new Calculator(numberOne, numberTwo, "/").getResultado();
    }
    @RequestMapping(value = "/media/{numberOne}/{numberTwo}" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public double getMedia(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) {
        return new Calculator(numberOne, numberTwo, "media").getResultado();
    }
    @RequestMapping(value = "/raizquadrada/{numberOne}" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public double getRaizquadrada(@PathVariable(value="numberOne") String numberOne) {
        return new Calculator(numberOne, "0","raiz").getResultado();
    }
}
