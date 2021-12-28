import java.util.*;

public class CinemaTicket
{
    // Making choices, the simple use of an if statement
    public void calculatePrice()   {
        int age;
        double price;
        char student;
        Scanner sc=new Scanner(System.in);
        System.out.println("What is the age of the customer ?");
        age = sc.nextInt();
        System.out.println("Is the customer a student (y/n)");
        student = sc.next().charAt(0);
        // Now for code to calculate the price
        if(age < 13) {
            // this conditional statement only executed if
            // a customer is younger than 13
            price = 3.0;
        } else if (age>=13 && age <=16) {
            // Here for customers between 13 and 16 (inclusive)
            price = 4.0;
        } else if (age >= 17 && age <=18) {
            price = 5.0;
        } else if (age >= 19 && age < 60) {
            price = 5.5;
        } else {
            price = 4;
        }
        
        if(student == 'y' || student=='Y') {
            price = price  - 0.1 * price;
        }
        System.out.println("This customer should be charged £"+price);
    }
}
