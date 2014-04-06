
Make project dir
make src and classes subdir
place all *.java in src

Ex: MyIO and MyRect where placed in package
mylib.lib

package mylib.lib;//first line of MyIO and
MyRect

then
javac -d ../classes *.java

now go to classes dir
and make a manifest.text which contains
Main-Class: Test<enter>
note test is the driver contains main method

now

jar -cvmf manifest.txt MyJar.jar *.class mylib

last

java -jar MyJar.jar


