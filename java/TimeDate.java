import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class TimeDate {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        LocalDate ld = LocalDate.now();
        int year = ld.getYear();
        Month month = ld.getMonth();
        int day = ld.getDayOfMonth();

        System.out.println("Date: " +ld+"\r\n" + //
                        "Year: "+year+"\r\n" + //
                        "Month: "+month+"\r\n" + //
                        "Day: "+day);


        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateInput = sc.nextLine();

        LocalDate startDate = LocalDate.parse(dateInput);

        Period period = Period.between(startDate, ld);

        int years = period.getYears();
        System.out.println("You are "+years+ " years old. ");



        LocalDate birthDate = startDate;
        LocalDate bdayThisYear = birthDate.withYear(ld.getYear());
        LocalDate nextBday;


        if (bdayThisYear.isBefore(ld)){
            nextBday = bdayThisYear.plusYears(1);;
        }
        else{
            nextBday = bdayThisYear;
            
        }

        Long days = ChronoUnit.DAYS.between(ld, nextBday);
        System.out.println("Your next birthday is in "+days+ " days. ");
        
        
    }
    
}
