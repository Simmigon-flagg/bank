/**
 * Simmigon Flagg Program: Bank.java Date: 4/15/2015
 * ***********************************************
 * A. Purpose: This program's
 * purpose is to simulate a traffic of customers in a bank using queues. There
 * are 5 tellers in the bank. We assume that all the tellers are occupied in the
 * beginning of the simulation. Between 2-6 seconds a new customer comes to the
 * bank. Each will be put in the queue. Between 2-5 seconds the program
 * generates a random number. This random number is assigned as the amount of
 * time the customer wants to spend with the teller.
 * 
 * The Teller class purpose it to maintain all operation for counting 
 * assigning and process the bank procedures.
 * The purpose of the Customer class it to get an object with different wait time
 * values
 * 
* B. Solution/Algorithms: 1.
* 1.	Create a static method to keep track of time in seconds.
2.	Create a static method to keep track of Randomly arriving customer
3.	Create a queue and instantiate it using a linked list.
4.	Create a scanner to get user input to run the simulation again or quit.
5.	Create a string object to hold the value the user will key in later in the program and set it to null
6.	Create a do while loop.
7.	Create a for loop that loops five times placing five new customers in the customer Line queue
8.	Create a array list that hold Teller objects.
9.	Create a for loop that add teller to the teller Array List set their first customer and counts that first customer.
10.	Create a variable to store long values and give it the value of the current time and the arrival time of the time the next customer will want to wait.
11.	Declare a long variable to hold the time plus the how long the program should run.
12.	If the second run over 59 second subtract 60 from it total and that will tell us when the program will stop.
13.	Start a while loop if the current time and the run time are not equal continue looping 
14.	If the current time equal the time for the next customer add a new customer object to the list, next get the time for the next customer to randomly be added to the list
15.	If the second run over 59 second subtract 60 from it total and that will tell us when the program will stop.
16.	If the first customer process time is equal to the current time the teller is done with the customer. Set that teller occupied value to false.
17.	If the tell occupied value is false and the customer Line Queue is not empty.
        a.	Set the next customer time.
        b.	Set the occupied value to true.
        c.	Set the count occupied value to 1.
        d.	Set the count the number of customer value to 1.

*
*
 *
* 
 * 
* C. Data Structure: The data structures used for this program are: 1. Queues -
 * used for adding customers 2. Arraylist - used for each teller 3. LinkedList - 
 * to instantiate the customers Queues.
 * 
* D. How to use the program, Inputs, and Outputs:
 * 
* After clicking on the run button in the IDE, the simulation will run for 59 seconds. And
 * 
* Input: The user don't need to enter any iniatial input during the simulation. 
* The only time the user needs to provide an input is when prompted if he/she wants to
 * start the simulation all over again. 
 * 
* Output: Once the program starts running, the simulation begins. The following
 * should be printed out in the console: a. The total amount of customers that
 * visited the bank for that 59 seconds. b. The total amount of customers that
 * each teller helped. c. The total amount of time that each teller was
 * occupied. d. The total amount of customers that did not get to see a teller.
 * 
 */
package bank;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Flagg
 */
public class Bank {

    static Scanner sInput = new Scanner(System.in);

    static long time() {
        long runningClock = (long) System.currentTimeMillis();
        runningClock /= 1000;
        runningClock %= 60;
        return runningClock;
    }

    static int timeTillNewArrival() {
        int TillNewArrival = (int) (Math.random() * 10);
        while (!((TillNewArrival >= 2) && (TillNewArrival <= 6))) {
            TillNewArrival = (int) (Math.random() * 10);

        }
        return TillNewArrival;

    }

    public static void main(String[] args) {
        Queue<Customer> customersLine = new LinkedList<>();
        Scanner runSimulation  = new Scanner(System.in);
         String quit = null;  
      do {
          for (int i = 0; i < 5; i++) {
            customersLine.add(new Customer());
        }
        
        ArrayList<Teller> tellers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tellers.add(new Teller());
            tellers.get(i).setNextCustomerTime(time(), customersLine.remove().getTimeWithTeller());
            tellers.get(i).setCountNumberOfCustomers(1);
        }

        long timeTillNextCustomer = timeTillNewArrival() + time();
        if (timeTillNextCustomer > 59) {
            timeTillNextCustomer -= 60;  
        }
        
        long lenghtOfRun = time();
        lenghtOfRun += 59;
        if (lenghtOfRun > 59) {
            lenghtOfRun -= 60;
        }
        
        System.out.println("Running....");
           
        while (!(time() == lenghtOfRun)) {
       
            if (time() == timeTillNextCustomer) {
                customersLine.add(new Customer());
                timeTillNextCustomer = timeTillNewArrival() + time();
                if (timeTillNextCustomer > 59) {
                    timeTillNextCustomer -= 60;
                }
            }

            for (int i = 0; i < tellers.size(); i++) {

                if (tellers.get(i).getNextCustomerTime() == time()) {
                    tellers.get(i).setOccupied(false);
                }
                if (!tellers.get(i).isOccupied()) {
                    if (!customersLine.isEmpty()) {
                        tellers.get(i).setNextCustomerTime(time(), customersLine.remove().getTimeWithTeller());
                        tellers.get(i).setOccupied(true);
                        tellers.get(i).setCountOccupied(1);
                        tellers.get(i).setCountNumberOfCustomers(1);
                    }
                }
            }
        }
        int CountAllTheVisitors = 0;
        for (int i = 0; i < tellers.size(); i++) {
            CountAllTheVisitors += tellers.get(i).getCountNumberOfCustomers();
        }
        System.out.println("1. The total amount of customers that visited the bank for that 1 minutes: " + CountAllTheVisitors);
        System.out.println();
        System.out.println("2. The total amount of customers that each teller helped");
        System.out.println();
        int tellersCount = 0;
        for (int i = 0; i < tellers.size(); i++) {
            System.out.println("Teller: " + (++tellersCount) + " helped " + tellers.get(i).getCountNumberOfCustomers() + " customers.");
        }
        System.out.println();
        System.out.println("3. The total amount of time that each teller was occupied.");
        System.out.println();
        tellersCount = 0;
        for (int i = 0; i < tellers.size(); i++) {
            System.out.println("Teller: " + (++tellersCount) + " was occupied " + tellers.get(i).getCountOccupied() + " time.");
        }
        System.out.println();
        System.out.println("4. The total amount of customers that did not get to see a teller: " + customersLine.size());
        if (!customersLine.isEmpty()) {
            customersLine.clear();
        }

          
          
          System.out.println("\nTo quit the simulation press q."
                  + "\nTo continue press any letter and press enter.");
          
          quit = runSimulation .nextLine();                  
        } while (!quit.contains("q"));
        System.out.println("Good bye!");

       
    }

    static class Customer {

        private int TimeWithTeller;

        public Customer() {
            this.TimeWithTeller = getTimeWithTeller();
        }

        public int getTimeWithTeller() {
            int randomTimeWithTeller = (int) (Math.random() * 10);
            while (!((randomTimeWithTeller >= 2) && (randomTimeWithTeller <= 5))) {
                randomTimeWithTeller = (int) (Math.random() * 10);

            }
            return this.TimeWithTeller = randomTimeWithTeller;
        }

    }

    static class Teller {

        private boolean Occupied = true;
        private int nextCustomerTime;
        private int countNumberOfCustomers = 0;
        private int countOccupied = 1;

        public boolean isOccupied() {
            return Occupied;
        }

        public void setOccupied(boolean Occupied) {
            this.Occupied = Occupied;
        }

        public int getNextCustomerTime() {
            return nextCustomerTime;
        }

        public void setNextCustomerTime(long currentTime, int nextCustomerTime) {
            int futurnTime = nextCustomerTime += currentTime;

            if (futurnTime > 59) {
                futurnTime -= 60;
            }
            //System.out.println("futurnTime" + futurnTime);
            this.nextCustomerTime = futurnTime;
        }

        public int getCountNumberOfCustomers() {
            return countNumberOfCustomers;
        }

        public void setCountNumberOfCustomers(int countNumberOfCustomers) {

            this.countNumberOfCustomers += countNumberOfCustomers;
        }

        public int getCountOccupied() {
            return countOccupied;
        }

        public void setCountOccupied(int countOccupied) {
            this.countOccupied += countOccupied;
        }

    }
}
