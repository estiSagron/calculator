package calculator.controller;

import calculator.UserInput;
import calculator.exception.CustomException;
import calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

   @Autowired
   private CalculatorService calculatorService;

   @PostMapping("/displayResult")
   public String displayResult(@RequestBody UserInput input) throws CustomException {
      return calculatorService.displayResult(input);
   }
}
