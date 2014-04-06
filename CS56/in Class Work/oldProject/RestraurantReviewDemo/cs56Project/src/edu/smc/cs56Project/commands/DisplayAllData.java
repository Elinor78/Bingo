/*
 * CS56 Advnced Java
 * Class: DisplayAllData
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Encapsulates request to display all the data in the database.
 * 
 */

package edu.smc.cs56Project.commands;

import edu.smc.cs56Project.database.RestDB;
import edu.smc.cs56Project.gui.TaskPane;
import edu.smc.cs56Project.patterns.Command;
import edu.smc.cs56Project.patterns.NotifyConstants;


public class DisplayAllData implements Command, NotifyConstants {
    private RestDB restDB;
    private TaskPane taskPane;
    
    public DisplayAllData( TaskPane tp, RestDB rdb )
    {
        this.taskPane = tp;
        this.restDB = rdb;
    }
    public void execute()
    {
        // Update database with any changes to the data
        restDB.update(taskPane, PANEL_UPDATE);
        /*
        try {
            restDB.connectToDD();
            restDB.giveMeAll();
        } 
        catch( SQLException sql ) {
            sql.printStackTrace();
        }
        */
        System.out.println( "Display all data executed" ); 

    }

}
