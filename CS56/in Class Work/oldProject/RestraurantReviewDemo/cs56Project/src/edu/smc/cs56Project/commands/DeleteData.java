/*
 * CS56 Advnced Java
 * Class: DeleteData
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Encapsulates request to delete data from the database.
 * 
 */

package edu.smc.cs56Project.commands;

import java.sql.SQLException;

import edu.smc.cs56Project.database.RestDB;
import edu.smc.cs56Project.gui.TaskPane;
import edu.smc.cs56Project.patterns.Command;
import edu.smc.cs56Project.patterns.NotifyConstants;

public class DeleteData implements Command, NotifyConstants {
    private RestDB restDB;

    public DeleteData( TaskPane tp, RestDB rdb )
    {
        this.restDB = rdb;
    }

    public void execute()
    {
        
        try {
            //restDB.connectToDB();
            restDB.delEntry();
        } 
        catch( SQLException sql ) {
            sql.printStackTrace();
        }
        
        System.out.println( "Delete command executed" ); 
        
    }
    
}
