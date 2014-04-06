/*
 * CS56 Advanced Java
 * Interface: Subject
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-21-07
 *
 * Purpose: Interface for subject objects utilizing the Observer design pattern.
 * Subjects use the registerObserver() and removeObserver() methods to add and 
 * remove observers.  The notifyObservers() method notfies the subject's
 * observers of a change in the subjects state, usually by instructing the
 * observers to call their update() method.
 * 
 */

package edu.smc.cs56Project.patterns;

public interface Subject {
    public void registerObserver( Observer o );
    public void removeObserver( Observer o);
    public void notifyObservers();
}
