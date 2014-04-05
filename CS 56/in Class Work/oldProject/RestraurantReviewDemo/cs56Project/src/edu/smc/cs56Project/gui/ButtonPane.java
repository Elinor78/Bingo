/*
 * CS56 Advanced Java
 * Class: ActionButtonPane
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-30-07
 *
 * Purpose: Holds all the buttons that control the user interface.  These
 * buttons include: edit, search, add, delete, and displayAll.
 * 
 */

package edu.smc.cs56Project.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

import edu.smc.cs56Project.commands.CommandConstants;
import edu.smc.cs56Project.patterns.*;

public class ButtonPane extends JPanel implements Observer, CommandConstants, NotifyConstants {
    private JPanel taskButtonsPanel = null;
    private JPanel listButtonsPanel = null;
    private JPanel DisplayButtonPanel = null;
    
    private JToggleButton editToggleButton = null;
    private JButton searchButton = null;
    private JButton addButton = null;
    private JButton deleteButton = null;
    private JButton DisplayButton = null;
    
    private Command[] commands;
    
    // ActionButtonPane constructor
    public ButtonPane()
    {
        super();
        
        commands = new Command[COMMAND_COUNT];
        Command noCommand = new NoCommand();
        for (int i = 0; i < COMMAND_COUNT; i++)
            commands[i] = noCommand;
            
        this.initialize();
    }

    // Initialize ActionButtonPane and add components
    private void initialize()
    {
        this.setLayout( new BorderLayout() );
        this.setPreferredSize( new Dimension( 900, 50 ) );
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 153), 1));
        this.setBounds( new Rectangle( 0, 0, 900, 50 ) );
        this.add( getTaskButtonsPanel(), BorderLayout.WEST );
        this.add( getDisplayButtonPanel(), BorderLayout.EAST );
        this.add( getListButtonsPanel(), BorderLayout.CENTER );
    }
    
    private JPanel getTaskButtonsPanel()
    {
        if (taskButtonsPanel == null) {
            FlowLayout flowLayout1 = new FlowLayout();
            flowLayout1.setAlignment( java.awt.FlowLayout.LEFT );
            flowLayout1.setHgap( 3 );
            taskButtonsPanel = new JPanel();
            taskButtonsPanel.setLayout( flowLayout1 );
            taskButtonsPanel.setPreferredSize( new Dimension( 200, 35 ) );
            taskButtonsPanel.add(getEditToggleButton(), null);
            taskButtonsPanel.add(getSearchButton(), null);
        }
        return taskButtonsPanel;
    }
    
    private JPanel getListButtonsPanel()
    {
        if (listButtonsPanel == null) {
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment( java.awt.FlowLayout.LEFT );
            flowLayout.setHgap( 3 );
            listButtonsPanel = new JPanel();
            listButtonsPanel.setLayout( flowLayout );
            listButtonsPanel.setPreferredSize( new Dimension( 200, 35 ) );
            listButtonsPanel.add( getAddButton(), null );
            listButtonsPanel.add( getDeleteButton(), null );
        }
        return listButtonsPanel;
    }
    

    private JPanel getDisplayButtonPanel()
    {
        if (DisplayButtonPanel == null) {
            FlowLayout flowLayout2 = new FlowLayout();
            flowLayout2.setHgap( 3 );
            flowLayout2.setAlignment( java.awt.FlowLayout.RIGHT );
            DisplayButtonPanel = new JPanel();
            DisplayButtonPanel.setLayout( flowLayout2 );
            DisplayButtonPanel.setPreferredSize( new Dimension( 200, 35 ) );
            DisplayButtonPanel.add( getDisplayButton(), null );
        }
        return DisplayButtonPanel;
    }
    
    public JToggleButton getEditToggleButton()
    {
        if (editToggleButton == null) {
            editToggleButton = new JToggleButton();
            editToggleButton.setText("Edit");
            editToggleButton.setFont(new Font("Arial", Font.PLAIN, 12));
            editToggleButton.setPreferredSize(new Dimension(80, 23));
            editToggleButton.addActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed( java.awt.event.ActionEvent e )
                {
                    if (editToggleButton.isSelected()) 
                        buttonWasPushed(CommandConstants.EDIT_TRUE);
                    else 
                        buttonWasPushed(CommandConstants.EDIT_FALSE);
                }
            } );
        }
        return editToggleButton;
    }

    public JButton getSearchButton()
    {
        if (searchButton == null) {
            searchButton = new JButton();
            searchButton.setText( "Search" );
            searchButton.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
            searchButton.setPreferredSize( new Dimension( 80, 23 ) );
            searchButton.setEnabled(false);                             // TODO Enable buttons based on initial set up.
            searchButton.addActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed( java.awt.event.ActionEvent e )
                {
                    System.out.println( "Search actionPerformed()" ); 
                    buttonWasPushed(CommandConstants.SEARCH);
                }
            } );
        }
        return searchButton;
    }

    private JButton getAddButton()
    {
        if (addButton == null) {
            addButton = new JButton();
            addButton.setText( "Add" );
            addButton.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
            addButton.setPreferredSize( new Dimension( 80, 23 ) );
            addButton.addActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed( java.awt.event.ActionEvent e )
                {
                    System.out.println( "Add actionPerformed()" ); 
                    buttonWasPushed(CommandConstants.ADD);
                }
            } );
        }
        return addButton;
    }

    private JButton getDeleteButton()
    {
        if (deleteButton == null) {
            deleteButton = new JButton();
            deleteButton.setText( "Delete" );
            deleteButton.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
            deleteButton.setPreferredSize( new Dimension( 80, 23 ) );
            deleteButton.addActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed( java.awt.event.ActionEvent e )
                {
                    System.out.println( "Delete actionPerformed()" ); 
                    buttonWasPushed(CommandConstants.DELETE);
                }
            } );
        }
        return deleteButton;
    }

    private JButton getDisplayButton()
    {
        if (DisplayButton == null) {
            DisplayButton = new JButton();
            DisplayButton.setText( "Display All" );
            DisplayButton.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
            DisplayButton.setPreferredSize(new Dimension(100, 23));
            DisplayButton.addActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed( java.awt.event.ActionEvent e )
                {
                    System.out.println( "Diplay All actionPerformed()" ); 
                    buttonWasPushed(CommandConstants.DISPLAY_ALL);
                }
            } );
        }
        return DisplayButton;
    }
    
    // Satisfy contract for Observer interface
    public void update( Subject s, Object arg )
    {
        if ( s instanceof TaskPane && arg instanceof Integer){
            TaskPane tp = (TaskPane) s;
            int notify = (Integer) arg;
            if (notify == TAB_UPDATE) {
                if (tp.getSelectedTabTitle() == "Find") {
                    searchButton.setEnabled(true);
                    editToggleButton.setEnabled(false);
                }
                else {
                    searchButton.setEnabled(false);
                    editToggleButton.setEnabled(true);
                }
            }
        }
    }

    // Invoker method for Command design pattern
    public void setCommand( int slot, Command command)
    {
        commands[slot] = command;
    }
    
    // Invoker method for Command design pattern
    public void buttonWasPushed( int slot )
    {
        commands[slot].execute();
    }
}