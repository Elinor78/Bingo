/*
 * CS56 Advanced Java
 * Class: SearchForData
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Encapsulates request to search for data.
 * 
 */

package edu.smc.cs56Project.commands;
import java.sql.SQLException;

import edu.smc.cs56Project.patterns.*;
import edu.smc.cs56Project.database.*;
import edu.smc.cs56Project.gui.TaskPane;

public class SearchForData implements Command, NotifyConstants {
    private RestDB restDB;
    private TaskPane taskPane;
            
    public SearchForData( TaskPane tp, RestDB rdb ) 
    {
        this.taskPane = tp;
        this.restDB = rdb;
    }
    
    public void execute()
    {
        try {
        // Update database with any changes to the data
        restDB.update(taskPane, PANEL_UPDATE);
                
        
            restDB.find(taskPane.getSearchParameters());
            System.out.println("Search Complete!");
        } 
        catch( SQLException sql ) {
            sql.printStackTrace();
        }
        
        System.out.println("Search command executed");
    }        
}