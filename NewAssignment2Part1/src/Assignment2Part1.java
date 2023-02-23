import java.util.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Assignment2Part1{

    static class partyGuest extends Thread{
        //        private static boolean leader = false;
        private int id;
        private int numGuests;
        static AtomicInteger counter = new AtomicInteger(0);
        private int count;

        boolean everyoneVisited;

        public partyGuest(int i, int n){

            id = i;
            numGuests = n;
            count = 0;

            everyoneVisited = false;
//            if (id == 0)
//            {   System.out.println("id: " + id + " Should be leader");
//            }
//            else
//                System.out.println("not leader");
        }

        public void run(){
            outerloop:
            while (everyoneVisited != true) {
                int i = getRandomNumberInRange(0, numGuests - 1);
                if (i != 0) {
                    //System.out.println("Prisoner: " + i + " was selected");
                    if (cakeRoom.cake == false && cakeRoom.hasEaten[i] == false) {
                        cakeRoom.hasEaten[i] = true;
                        cakeRoom.cake = true;
                        //System.out.println("cake status"  + cakeRoom.cake);
                    }
                }
                else {
                    System.out.println("The Leader entered the room!");
                    if (cakeRoom.cake == true) {
                        System.out.println("Cake uneaten, eating cake & incrementing count...");
                        count = counter.incrementAndGet();
                        System.out.println("Count: " + count);
                        System.out.println("");
                        cakeRoom.cake = false;
                        if (count == numGuests - 1) {
                            System.out.println("All other guests have visited!");
                            System.out.println("Therefore, all guests have visited!");
                            everyoneVisited = true;
                            System.exit(0);
                        } else {
                            cakeRoom.cake = false;
                        }
                    }
                    else
                    {
                        System.out.println("Leader visited room but did nothing, as the cake was eaten");
                        System.out.println("");
                        continue;
                    }
                }

            }
        }
        private int getRandomNumberInRange(int min, int max) {
            if (min >= max)
                throw new IllegalArgumentException("max must be greater than min");
            Random r = new Random();
            return r.nextInt((max-min) + 1) + min;
        }

        public static class cakeRoom{
            static boolean cake;
            static boolean[] hasEaten;
            public cakeRoom(int numGuests)
            {
                int n = numGuests;
                cake = true;
                hasEaten = new boolean[numGuests];
                Arrays.fill(hasEaten, false);
            }

        }
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.println("How many guests?");
        int numGuests = scnr.nextInt();
        partyGuest.cakeRoom Room = new partyGuest.cakeRoom(numGuests);


        for (int i = 0; i < numGuests; i++)
        {
            partyGuest guest = new partyGuest(i, numGuests);
            guest.start();
            try{
                guest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
