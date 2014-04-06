/*
 * CS56 Advnced Java
 * Class: DisableEditMode
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Encapsulates request to disable editing of TaskPane.
 * 
 */

package edu.smc.cs56Project.commands;

import edu.smc.cs56Project.database.RestDB;
import edu.smc.cs56Project.gui.TaskPane;
import edu.smc.cs56Project.patterns.Command;
import edu.smc.cs56Project.patterns.NotifyConstants;

public class DisableEditMode implements Command, NotifyConstants {
    private TaskPane taskPane;
    private RestDB restDB;
    
    public DisableEditMode( TaskPane tp, RestDB rdb ) 
    {
        this.restDB = rdb;
        this.taskPane = tp;
    }
    
    public void execute()
    {
        taskPane.setIsEditable(false);
        System.out.println( "Edit mode disabled" ); 
        
        // Update database with any changes to the data
        restDB.update( taskPane, PANEL_UPDATE );
    }

}
