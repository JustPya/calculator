import java.util.Scanner;
public class Main {
    static String OFF_KEY = "off";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true) {
            options();
            String oper = sc.next();
            if (isKeyOff(oper)) break;
            System.out.println("Enter two numbers");
            double a = sc.nextDouble();
            double b = sc.nextDouble();

            userOutput(oper, a, b);
        }

    }
    //Decide operation
    public static double operation(String oper, double a, double b) throws Exception {
        if(oper.equals("sum")){
            return sum(a, b);
        } else if (oper.equals("subtract")) {
            return subtract(a, b);
        } else if (oper.equals("multiply")) {
            return multiply(a, b);
        } else if (oper.equals("divide") ){
            return divide(a, b);
        }else {
            throw new Exception(wrongOperationError());
        }
    }

    // calculator options
    public static void options(){
        System.out.println("Options: \n1. sum \n2. subtract \n3. multiply \n4. divide \noff (Turn off calculator)");
    }

    // Turn off the calculator
    public static boolean isKeyOff(String key){
        return key.equals(OFF_KEY);
    }

    // Basic operations
    public static double sum(double a, double b){
        return a + b;
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static double divide(double a, double b) throws Exception {
        boolean doOperation = validateDivisionByZero(b);
        if (doOperation){
            return a / b;
        } else {
            throw new Exception(divisionByZeroError());
        }
    }
    // validations
    public static boolean validateDivisionByZero(double b){
        return b == 0? false : true;
    }

    // error messages
    public static String divisionByZeroError(){
        return "Can not perform division by zero";
    }
    public static String wrongOperationError() {
        return "Wrong operation";
    }

    public static void userOutput(String oper, double a, double b) throws Exception {
        String result = a + " " + oper + " " + b + " = " + operation(oper, a, b);
        System.out.println(result);
    }

}
