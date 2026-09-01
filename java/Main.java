public class Main {

   public static void main(String[] args) {

    //challenge 1: HELLO
    System.out.println("Hello World");

    //challenge 2: PRINTING
    int age = 23;
    double height = 175.26; //cm
    String name = "Huzaifa";

    //challenge 3: OPERATORS

    int a = 20;
    int b = 10;

    System.out.println("Addition: " + (a + b));
    System.out.println("Subtraction: " + (a - b));
    System.out.println("Multiplication: " + (a * b));
    System.out.println("Division: " + (a / b));

    boolean isAGreaterThanB = a > b;
    System.out.println("Is A greater than B? " + isAGreaterThanB);

    boolean isAGreaterThanBAndBGreaterThan0 = (a > b) && (b > 0);
    System.out.println("Is A greater than B and B greater than 0? " + isAGreaterThanBAndBGreaterThan0);


    //challenge 4: CONTROL FLOW

    int grade = 70;

    if (grade >=50) {
        System.out.println("Pass");
    } else {
        System.out.println("Fail");
    }

    if (grade >= 90) {
        System.out.println("A");
    } else if (grade >= 75) {
        System.out.println("B");
    } else if (grade >= 60) {
        System.out.println("C");
    } else {
        System.out.println("D");
    }

    //challenge 5: LOOPS
    System.out.println("For loop:");
    for (int i = 1; i <= 5; i++) {
        System.out.print(i);
        if (i < 5) {
            System.out.print(" ");
        }
    }

    System.out.println();
    System.out.println("While loop:");
    int i = 1;
    while (i <= 5) {
        System.out.print(i);
        if (i < 5) {
            System.out.print(" ");
        }
        i++;
    }

    System.out.println();
    System.out.println("Do-while loop:");
    int j = 1;
    do {
        System.out.print(j);
        if (j < 5) {
            System.out.print(" ");
        }
        j++;
    } while (j <= 5);
    System.out.println();

    //challenge 6: CALCULATOR  
    double num1 = 7;
    double num2 = 3;
    char operator = '+';

    String again = "y";
    double result = 0;
    while(again.equals("y")) {


        if(operator == '+') {
            result = num1 + num2;
            System.out.println("Result: " + result);

        }
        else if (operator == '-') {
            result = num1 - num2;
            System.out.println("Result: " + result);
        }
        else if (operator == '*') {
            result = num1 * num2;
            System.out.println("Result: " + result);
        }
        else if (operator == '/') {
            if (num2 == 0) {
                System.out.println("Cannot divide by zero");
                
            } else {
            result = num1 / num2;
            System.out.println("Result: " + result);
            }


        }
        else {
            System.out.println("Invalid operator");
        }
        again = "n"; 
    }
    System.out.println("Thank you for using the calculator");



}}

