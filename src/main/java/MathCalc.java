import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class MathCalc {

    public static void main(String[] args) throws ScriptException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the expression : ");
        String expresion = scan.nextLine();

        double a, b;
        double result = 0;

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        switch (expresion) {
            case "+":
            case "-":
            case "/":
            case "*":
                a = scan.nextDouble();
                b = scan.nextDouble();
                result = Double.parseDouble(String.valueOf(engine.eval(a + expresion + b)));
                break;
            case "sqrt":
                a = scan.nextDouble();
                result =  Double.parseDouble(String.valueOf(engine.eval("Math.sqrt("+a+")")));
                break;
            case "sqr":
                a = scan.nextDouble();
//                result = Math.pow(a,2);
                result =  Double.parseDouble(String.valueOf(engine.eval(a + "*" + a)));
                break;
        }
        System.out.println(result);
    }

}
