import java.util.*;

import static java.lang.Thread.sleep;

public class Assignment2Part2 {

    static class partyGuest extends Thread{
        private int id;
        private int numGuests;

        public partyGuest(int i, int n)
        {
            id = i;
            numGuests = n;
        }

        public void run() {
            for (int i = 0; i < numGuests; i++) {
                //System.out.println(getName() + " " + id);
                Random rand = new Random();
                int upperbound = 10;
                int int_random = rand.nextInt(upperbound);
                if (int_random > 8)
                {
                    showroom.enterRoom(i);
                }
            }
        }
    }

    public static class showroom {
        private static boolean Available = true;

        public showroom(int numGuests) {
            int n = numGuests;
        }
        public static void enterRoom(int i)
        {
            if (Available == true) {
                Available = false;
                try {
                    System.out.println("Guest " + (i + 1) + " in room");
                    sleep(500);
                    System.out.println("Guest leaving room");
                    Available = true;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Welcome 10 guests!");
        int numGuests = 10;
        showroom Room = new showroom(numGuests);

        for (int i = 1; i <= numGuests; i++)
        {
            partyGuest guest = new partyGuest(i, numGuests);
            guest.start();
            try {
                guest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    System.out.println("Party's over!");
    }
}
