/*
 * CS56 Advanced Java
 * Class: EnableEditMode
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-21-07
 *
 * Purpose: Encapsulates request to edit TaskPane.
 * 
 */

package edu.smc.cs56Project.commands;

import edu.smc.cs56Project.gui.TaskPane;
import edu.smc.cs56Project.patterns.Command;

public class EnableEditMode implements Command {
    private TaskPane taskPane;
    
    public EnableEditMode( TaskPane tp) 
    {
        this.taskPane = tp;
    }
    
    public void execute()
    {
        taskPane.setIsEditable(true);
        System.out.println( "Edit mode enabled" ); 
    }

}
