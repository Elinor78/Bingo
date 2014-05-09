// Related But Unsynchronized Threads
// different objects of the same class
//
// Example of related but unsychronoized Threads involves
// partitioning a data set, and instantiating multiple copies
// of the same thread to work on different pieces of the same
// problem. Must be careful not to duplicate work, or worse, to
// let two different threads operate on same data at once

// Demo; compute factorial of a large number
import java.io.*;
public class factorial {
    public static void main (String s[]) {
        long possFac = Long.parseLong (s[0]);
        int confact = (int) (possFac/10) + 1;

        for(int i=0; i< confact; i++){
            new factRange(i*10, possFac).start();
        }
    }
}
//***********************************************
class factRange extends Thread {

    static long possFac;long Fact=1;
    long from, to;

    // constructor
    //  record the number we are to get factorial, and
    //  the sub range for factorils we are to try.

    factRange(int argFrom, long argpossFac) {

        possFac = argpossFac;
        if(argFrom==0) from=1; else from=argFrom;
        if((argFrom+9)> possFac) to=possFac; else to = argFrom + 9;
    }

    public void run() {

        for(long i=from; i<= to && i<=possFac; i++) {
            Fact = Fact * i;}


            System.out.println (
                    "sub factorial of "+from+ " to "+to+" is "+Fact+" computed by thread "+getName());
                    this.stop();

            yield();
        }
    }
