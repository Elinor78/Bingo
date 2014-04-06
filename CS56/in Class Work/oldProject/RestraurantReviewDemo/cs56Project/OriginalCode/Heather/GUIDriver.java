/*
 * CS56 Advanced Java
 * Class: GUIDriver
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-22-07
 *
 * Purpose: Tests the GUI code.
 *
 */

package edu.smc.cs56Project.drivers;

import java.awt.Container;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import edu.smc.cs56Project.commands.*;
import edu.smc.cs56Project.database.dbstatements;
import edu.smc.cs56Project.gui.*;

public class GUIDriver extends JFrame implements CommandConstants {

    // GUIDriver constructor
    public GUIDriver()
    {
        super("GUIDriver");
        initialize();
    }
    
    // Initialize GUIDriver and add objects
    private void initialize()
    {
        ReviewTablePane reviewTablePane = null;
        reviewTablePane = new ReviewTablePane(new dbstatements());
        TaskPane taskPane = new TaskPane();
        ButtonPane actionButtonPanel = new ButtonPane();
        
        // Initialize command objects
        EnableEditMode enableEditMode = new EnableEditMode(taskPane);
        DisableEditMode disableEditMode = new DisableEditMode(taskPane, dbstatements);

        
        // Set command objects
        actionButtonPanel.setCommand(EDIT_TRUE, enableEditMode);
        actionButtonPanel.setCommand(EDIT_FALSE, disableEditMode);

        // Register observers
        taskPane.registerObserver(actionButtonPanel);
        

        Container container = getContentPane();
        container.add( actionButtonPanel, BorderLayout.SOUTH );
        container.add( reviewTablePane, BorderLayout.CENTER );
        container.add( taskPane, BorderLayout.WEST );
        container.validate();

        this.setMinimumSize( new Dimension( 600, 80 ) );
        this.setSize( new Dimension( 900, 600 ) );
        this.setMinimumSize( new Dimension( 600, 400 ) );
        this.setResizable( true );
        this.setPreferredSize( new Dimension( 900, 600 ) );
        this.setVisible( true );
    }

    public static void main( String[] args )
    {
     
        GUIDriver guiDriver = new GUIDriver();
        guiDriver.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

}
