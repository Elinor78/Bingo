/*
 * CS56 Advanced Java
 * Interface: Command
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-21-07
 *
 * Purpose: All command objects utilizing the Command design pattern implement
 * the Command interface.  Commands encapsulate requests as objects which can be
 * invoked using the execute() method.   
 */

package edu.smc.cs56Project.patterns;

public interface Command {
    public void execute();
    //public void undo();
}
