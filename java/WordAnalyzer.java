import java.util.Scanner;
public class WordAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String word = sc.nextLine().toLowerCase();
        int digits = 0;
        int vowels = 0;
        int cons = 0;
        int spaces = 0; 

        for (int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(Character.isDigit(ch)){
                digits++;
            }
            else if(word.charAt(i) == (' ')){
                spaces++;
            }
            else if(ch=='a' ||ch== 'e'||ch== 'i'||ch== 'o'||ch== 'u'){
                vowels++;
            }
            else if (ch >= 'a' && ch <= 'z') {
                cons++;
            }



        }
        sc.close();

        System.out.println("Characters:" +word.length() + //
                        "\r\n" + //
                        "Vowels: "+vowels + //
                        "\r\n" + //
                        "Consonants: "+cons + //
                        "\r\n" + //
                        "Digits: "+digits + //
                        "\r\n" + //
                        "Spaces: "+spaces);
        
    }
    
}
