/*
 * CS56 Advanced Java
 * Class: ProjectDriver
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Initializes, manages, and runs the Project code.
 *
 */

package edu.smc.cs56Project.drivers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;

import edu.smc.cs56Project.commands.*;
import edu.smc.cs56Project.database.RestDB;
import edu.smc.cs56Project.gui.*;
import java.awt.Color;

public class ProjectDriver extends JFrame implements CommandConstants {
    private RestDB restDB = null;
    private ReviewTablePane reviewTablePane = null;
    private TaskPane taskPane = null;
    private ButtonPane buttonPane = null;
    
    // ProjectDriver constructor
    public ProjectDriver()
    {
        super( "ProjectDriver" );
        
        initialize();
    }
    
    // Initialize ProjectDriver and add objects
    private void initialize()
    {
        restDB = new RestDB();
        restDB.connectToDB();
        try {
            restDB.giveMeAll();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        reviewTablePane = new ReviewTablePane( restDB );
        taskPane = new TaskPane();
        buttonPane = new ButtonPane();
        
        // Initialize command objects
        EnableEditMode enableEditMode = new EnableEditMode( taskPane );
        DisableEditMode disableEditMode = new DisableEditMode(taskPane, restDB);
        SearchForData searchForData = new SearchForData( taskPane, restDB );
        AddData addData = new AddData( taskPane, restDB );
        DeleteData deleteData = new DeleteData( taskPane, restDB );
        DisplayAllData displayAllData = new DisplayAllData( taskPane, restDB );

        // Set command objects
        buttonPane.setCommand(EDIT_TRUE, enableEditMode);
        buttonPane.setCommand(EDIT_FALSE, disableEditMode);
        buttonPane.setCommand(SEARCH, searchForData);
        buttonPane.setCommand(ADD, addData);
        buttonPane.setCommand(DELETE, deleteData);
        buttonPane.setCommand(DISPLAY_ALL, displayAllData);
        
        // Register observers
        taskPane.registerObserver(buttonPane);
        taskPane.registerObserver(restDB);
        reviewTablePane.registerObserver( taskPane );
        
        // Set up JFrame
        Container container = getContentPane();
        container.add( buttonPane, BorderLayout.SOUTH );
        container.add( reviewTablePane, BorderLayout.CENTER );
        container.add( taskPane, BorderLayout.WEST );
        container.validate();

        this.setMinimumSize( new Dimension( 600, 80 ) );
        this.setBackground(new Color(204, 255, 204));
        this.setSize( new Dimension( 900, 600 ) );
        this.setMinimumSize( new Dimension( 800, 700 ) );
        this.setResizable( true );
        this.setPreferredSize( new Dimension( 900, 600 ) );
        this.setVisible( true );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.addWindowListener( 
            new WindowAdapter() {
                public void windowClosed( WindowEvent event )
                {
                    restDB.disconnectFromDB();
                    System.exit( 0 );
                }
            } );
    }

    public static void main( String[] args )
    {
        new ProjectDriver();
    }

}
