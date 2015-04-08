/**
 * Explain the purpose of the program as detail as possible - 13%.
 *
 * Develop asolution for the problem and mention algorithms to be used - 16%.
 *
 * The Data structures we will use is Queues and ArrayList. ---Done
 *
 * Give a description of how to use the program and expected input/output - 5%.
 *
 * Explain the purpose of each class you develop in the program. The purpose of
 * the
 *
 */
package bank;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Flagg
 */
public class Bank {

    static Scanner sInput = new Scanner(System.in);

    public static void main(String[] args) {

        Date clock;
        String time = "";
        Customers customers1 = new Customers();
        System.out.println("Seconds: "+processTime(customers1.getTimeWithTeller()));
     

        //Get the current Time and add to minutes
        while (true) {

            clock = new Date();
            String[] myclock = clock.toString().split(" ");
            time = myclock[3];

            System.out.println("Time: " + time);
        }

        /*Customers customers1 = new Customers();
         Customers customers2 = new Customers();
         Customers customers3 = new Customers();
         Customers customers4 = new Customers();

         System.out.println("Wait time: " + customers1.getTimeWithTeller());
         System.out.println(" ");
         System.out.println("Wait time: " + customers2.getTimeWithTeller());
         System.out.println(" ");
         System.out.println("Wait time: " + customers3.getTimeWithTeller());
         System.out.println(" ");
         System.out.println("Wait time: " + customers4.getTimeWithTeller());*/
//        do {
//
//            //Code happens here.
//            System.out.println("Would you like to run this simulations again?"
//                    + " Type \"y\" for yes.");
//            run = sInput.next();
//        } while (run.equalsIgnoreCase("y"));
    }

    static int processTime(int customersWaitTime) {
        long theTime = (long) System.currentTimeMillis();
        theTime /= 1000;
        theTime %= 60;
        System.out.println("Current Time: " + theTime);
        System.out.println("Time Customer wants to wait: " + customersWaitTime + " seconds.");
        int currentTime = (int) theTime + customersWaitTime;
        if (currentTime < 59) {
            return currentTime;
        } else {
            currentTime = (int) theTime + customersWaitTime;
            return currentTime -= 60;

        }

    }
}

class Customers {

    private long timeWithTeller;

    public int getTimeWithTeller() {
        int secondsCustomerWantToWait = 0;
        for (int i = 0; i < 10; i++) {
            secondsCustomerWantToWait = (int) (Math.random() * 10);
            if ((secondsCustomerWantToWait >= 2) && (secondsCustomerWantToWait <= 6)) {
                break;
            }
        }

        // System.out.println("The Seconds for the current time: " + currentTime);       
        // secondsCustomerWantToWait + System.currentTimeMillis();
        return secondsCustomerWantToWait;
    }

    public void setTimeWithTeller(long timeWithTeller) {

        this.timeWithTeller = timeWithTeller;
    }
}

class Teller {

    private String teller;
    private boolean isOccupied = true;
    private long firstCustomersTime;

    public Teller(String teller, long firstCustomersTime) {
        this.teller = teller;
        this.firstCustomersTime = firstCustomersTime;
    }

    public String getTeller() {
        return teller;
    }

    public void setTeller(String teller) {
        this.teller = teller;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public long getFirstCustomers() {
        return firstCustomersTime;
    }

    public void setFirstCustomers(long firstCustomers) {
        this.firstCustomersTime = firstCustomers;
    }

}
