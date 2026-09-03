import java.util.Random;
import java.util.Scanner;

public class ReplApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the REPL App! ");
        String option;
        double num1;
        double num2;
        
            do{
                System.out.print(">");
                option = sc.next().toLowerCase();

                switch (option) {
                    case "help":
                        System.out.println("Available commands:\r\n" + //
                                                        "\r\n" + //
                                                        "  add\r\n" + //
                                                        "\r\n" + //
                                                        "  subtract\r\n" + //
                                                        "\r\n" + //
                                                        "  multiply\r\n" + //
                                                        "\r\n" + //
                                                        "  divide\r\n" + //
                                                        "\r\n" + //
                                                        "  random\r\n" + //
                                                        "\r\n" + //
                                                        "  reverse\r\n" + //
                                                        "\r\n" + //
                                                        "  quit");
                        break;
                    case "add":
                
                        System.out.println("Enter first number: ");
                        num1 = sc.nextDouble();
                        System.out.println("Enter second number: ");
                        num2 = sc.nextDouble();

                        System.out.println("Sum is: "+(num1+num2));

                        break;
                    case "subtract":
                        System.out.println("Enter first number: ");
                        num1 = sc.nextDouble();
                        System.out.println("Enter second number: ");
                        num2 = sc.nextDouble();

                        System.out.println("Difference is: "+(num1-num2));
                        break;
                    case "multiply":
                        System.out.println("Enter first number: ");
                        num1 = sc.nextDouble();
                        System.out.println("Enter second number: ");
                        num2 = sc.nextDouble();

                        System.out.println("Product is: "+(num1*num2));
                        break;
                    case "divide":
                        System.out.println("Enter first number: ");
                        num1 = sc.nextDouble();
                        System.out.println("Enter second number: ");
                        num2 = sc.nextDouble();
                        
                        if(num2==0){
                            System.out.println("Cannot divide by zero. ");
                        }
                        else{
                            System.out.println("Quotient is: "+(num1/num2));
                        }
                        
                        break;
                    case "random":
                        System.out.println("Minimum: ");
                        int min = sc.nextInt();
                        System.out.println("Maximum: ");
                        int max = sc.nextInt();

                        int randomValue = random.nextInt((max - min) + 1) + min;

                        System.out.println("Random number is: "+randomValue);  
                        
                        break;
                    case "reverse":
                        System.out.println("Enter a string to reverse: ");
                        String str = sc.next();

                        String rev = new StringBuilder(str).reverse().toString();
                        System.out.println("Reversed: "+rev);

                        break;
                    case "quit":
                        System.out.println("Exiting.");
                        break;
                    default:
                        System.out.println("Invalid operation. Use \"help\" to see available commands. ");

                }


            }while(!option.equals("quit"));

           



        
        

        System.out.println("Thank you for using REPL App! ");
        sc.close();

        


    }
}
