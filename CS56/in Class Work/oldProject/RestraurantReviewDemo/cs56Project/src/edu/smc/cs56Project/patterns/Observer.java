/*
 * CS56 Advanced Java
 * Interface: Observer
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-25-07
 *
 * Purpose: Interface for observer objects utilizing the Observer design pattern.
 * Observers use the update() method to register changes in a subjects state.
 * 
 */

package edu.smc.cs56Project.patterns;

public interface Observer {
    // This implementation allows the subject to "push" data through the second
    // argument. If a "pull" implementation is preferred the second argument
    // should be set to null.
    public void update( Subject s, Object arg);
}
