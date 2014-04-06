/*
 * CS56 Advanced Java
 * Interface: NoCommand
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-21-07
 *
 * Purpose: A null object that can serve as a placeholder, remmoving the 
 * responsibility of checking for null from the client.
 */

package edu.smc.cs56Project.patterns;

public class NoCommand implements Command {

    public void execute()
    {
        // Intentionally empty
    }

}
