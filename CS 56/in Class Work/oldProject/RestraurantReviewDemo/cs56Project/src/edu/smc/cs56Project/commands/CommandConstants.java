/*
 * CS56 Advanced Java
 * Interface: CommandConstants
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-21-07
 *
 * Purpose: Standard interface for adding commands to a Command array.
 * 
 */

package edu.smc.cs56Project.commands;

public interface CommandConstants {
    public final static int COMMAND_COUNT = 6;
    
    public final static int EDIT_TRUE = 0;
    public final static int EDIT_FALSE = 1;
    public final static int SEARCH = 2;
    public final static int ADD = 3;
    public final static int DELETE = 4;
    public final static int DISPLAY_ALL = 5;
}
