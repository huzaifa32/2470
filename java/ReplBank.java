import java.util.Scanner;
public class ReplBank {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        double balance = 0;

        //Challenge 2:
        while(option !=4){
            System.out.println("Select an option: \n1.Check Balace\n2.Deposit\n3.Withdraw\n4.Exit");
            option = sc.nextInt();

            switch (option) {
                case 1: //Check Balance
                    System.out.println("Your Account Balance is: $"+balance);
                    break;
                case 2: //Deposit 
                    double deposit = 0;
                    while (deposit<=0){
                        System.out.println("Enter an amount to deposit: ");
                        deposit = sc.nextDouble();
                        if(deposit<=0){
                            System.out.println("Amount must be greater than $0.00. Try again.");
                        }

                    }
                    
                    balance+=deposit;
                    System.out.println("$"+deposit+" has been deposited to your account.");
                    System.out.println("Your new balance is: $"+balance);
                    break;

                    
                    
                    
                case 3: //Withdraw
                    double withdrawal = 0;

                    while (withdrawal<=0){
                        System.out.println("Enter an amount to withdraw: ");
                        withdrawal = sc.nextDouble();
                        if(withdrawal<=0){
                            System.out.println("Amount must be greater than $0.00. Try again.");
                        }

                    }
                    if (balance - withdrawal < 0 ){
                        System.out.println("Insufficient funds.");
                        System.out.println("Your balance is: $"+balance);
                        break;
                    }
                    else{
                        balance-=withdrawal;
                        System.out.println("$"+withdrawal+" has been withdrawn from your account.");
                        System.out.println("Your new balance is: $"+balance);

                    }
                    
                    
                    break;
                default:
                    break;
            }
            
            if(option!=4){
                System.out.println("Would you like to perform another task? (y/n) ");
                String res = sc.next().toLowerCase();
                if (res.equals("n")){
                    option = 4;
                }

            }
            
        }

        System.out.println("Thank you for using REPL ATM! ");
        sc.close();

        


    }
}
