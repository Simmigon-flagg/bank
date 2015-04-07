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

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Flagg
 */
public class Bank {

    static Scanner sInput = new Scanner(System.in);

    public static void main(String[] args) {

        String run = null;
        int countCustomers = 0;
        String teller;
        long startTime = System.currentTimeMillis();
        
        int secondCustomerWantToWait = 0;
        while(secondCustomerWantToWait < 2){
        secondCustomerWantToWait = (int)Math.random() * 10;
        }
        System.out.println("Second Customer Want To Wait: " + secondCustomerWantToWait);
        
        
       
//        do {
//
//            //Code happens here.
//            System.out.println("Would you like to run this simulations again?"
//                    + " Type \"y\" for yes.");
//            run = sInput.next();
//        } while (run.equalsIgnoreCase("y"));
    }

}

class Customers {

    private long timeWithTeller;

    public long getTimeWithTeller() {
        return timeWithTeller;
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
