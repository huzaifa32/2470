import java.util.Scanner;
public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Create a new password");
        String password = sc.next();
        Boolean isValid = true;
        String rejected = "Password Rejected: ";

        if(password.length()<8){
            isValid = false;
            System.out.println("");
            rejected += "\n - Must be over 8 characters. ";
        }
        if(!password.matches(".*[a-z].*")){
            isValid = false;
            System.out.println("");
            rejected += "\n - Must contain at least one lowercase character. ";
        }
        if(!password.matches(".*[A-Z].*")){
            isValid = false;
            System.out.println("");
            rejected += "\n - Must contain at least one uppercase character. ";
        }
        if(!password.matches(".*[0-9].*")){
            isValid = false;
            System.out.println("");
            rejected += "\n - Must contain at least one digit. ";
            
        }
        if(!isValid){
            System.out.println(rejected);
        }
        
        else{
            System.out.println("Password Accepted! ");
        }
        sc.close();
    }
    
}
