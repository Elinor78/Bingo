// Related But Unsynchronized Threads
// Two different objects of the same class
// three unrelated threads running
// Example of related but unsychronoized Threads involes
// partitioning a data set, and instantiating multiple copies
// of the same thread to work on different pieces of the same
// problem. Must be careful not to duplicate work, or worse, to
// let two different threads operate on same data at once

// Demo; is the number prime
import java.io.*;
public class testPrime {
    public static void main (String s[]) {
        long possPrime = Long.parseLong (s[0]);
        int centuries = (int) (possPrime/100) + 1;

        for(int i=0; i< centuries; i++){
            new testRange(i*100, possPrime).start();
        }
    }
}
//***********************************************
class testRange extends Thread {

    static long possPrime;
    long from, to;

    // constructor
    //  record the number we are to test, and
    //  the range of factors we are to try.

    testRange(int argFrom, long argpossPrime) {

        possPrime = argpossPrime;
        if(argFrom==0) from=2; else from=argFrom;
        to = argFrom + 99;
    }

    public void run() {

        for(long i=from; i<= to && i<possPrime; i++) {
            if (possPrime % i == 0) {// i divide possPrime exactly
            System.out.println (
                    "factor "+i+" found by thread "+getName());
                    this.stop();
            }
            yield();
        }
    }
}