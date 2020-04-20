package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {


    @RequestMapping("/calculator")
    public String calculator(Model model, CalculatorForm calculatorForm) {
//    public String calculator(Model model, Integer x, Integer y, String sign) {
//        if(x != null)
//            model.addAttribute("x", Integer.toString(x));
//        if(y != null)
//            model.addAttribute("y", Integer.toString(y));
//        if(sign != null)
//            model.addAttribute("sign", sign);


        model.addAttribute("calculationForm", calculatorForm);
        int result = calculateResult(calculatorForm);
        model.addAttribute("result", result);


        return "calculator";
    }



    int calculateResult(CalculatorForm calculatorForm) {

        if (calculatorForm.getSign() == null) {
            return 0;
        }

        switch (calculatorForm.getSign()) {
            case "+":
                return calculatorForm.getX() + calculatorForm.getY();
            case "-":
                return calculatorForm.getX() - calculatorForm.getY();
            case "*":
                return calculatorForm.getX() * calculatorForm.getY();
            case "/":
                return calculatorForm.getX() / calculatorForm.getY();
        }
        return 0;
    }
}
