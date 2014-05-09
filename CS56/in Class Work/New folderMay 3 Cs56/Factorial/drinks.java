
// Example of unrelated Threads
// they are three classes
// class Coffee and Tea are diferent object of different class
// two unrelated threads running
// Main class is Drink

import java.io.*;

public class drinks {

    public static void main ( String[] a) {
        // Creat a class thread and start

        Coffee c = new Coffee();
        c.start();

        // Creat an anonymous thread

        new Tea().start();
    }
}
//*****************************************

class Coffee extends Thread {

    public void run() {

         while (true){
            System.out.println(" I like Coffee");
            yield();
        }
    }
}

//****************************************

class Tea extends Thread {

    public void run() {

        while (true){
            System.out.println("I like tea");
            yield();
        }
    }
}