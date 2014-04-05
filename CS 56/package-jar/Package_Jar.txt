Direction:

make structures
                Project
                /     \
              classes  src
                        \
                       edu
                          \
                         smc
                          \
                        *.java  (note: all java source with
                                       pakage edu.smc;
                                and Driver class with
                                       import edu.smc.*;

then go to src directory:
     javac -d ../classes edu/smc/*.java
Note: Complete qualification name

then go to classes directory and execute as:

java Driver

Make a jar for excecutable file.

Go to classes and make 
manifest.txt file contain

Main-Class: Driver'\n'

from dos and in classes directory

>jar -cvmf manifest.txt MyJar.jar *.class edu/smc

MyJar.jar is clickable for excecution and movable
anywhere

you can also run

java -jar MyJar.jar

You can see inside of MyJar.Jar by:

jar -tf MyJar.jar
jar -xf MyJar.jar to unjar