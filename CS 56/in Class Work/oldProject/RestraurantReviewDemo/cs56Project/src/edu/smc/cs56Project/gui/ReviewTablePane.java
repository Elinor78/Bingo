/*
 * CS56 Advanced Java
 * Class: ReviewTablePane
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-31-07
 *
 * Purpose: Displays a table of reviews with the following coloumns:
 * picture, restaurant name, city, food type, and overall rating.
 *
 */

package edu.smc.cs56Project.gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.smc.cs56Project.database.RestDB;
import edu.smc.cs56Project.patterns.*;

public class ReviewTablePane extends JPanel implements Subject, NotifyConstants {
    private JScrollPane reviewTableScrollPane = null;
    private JTable reviewTable = null;

    private ArrayList<Observer> observers;
    private RestDB restDB; // TODO watch this
    private int notifyType;

    // ReviewTablePane constructor
    public ReviewTablePane( RestDB rdb )
    {
        super();
        observers = new ArrayList<Observer>();
        restDB = rdb; // TODO watch this
        initialize();
    }

    // Initialize ReviewTablePane and add it's components
    private void initialize()
    {
        this.setLayout( new BorderLayout() );
        this.setPreferredSize( new Dimension( 600, 800 ) );
        this.add( getReviewTableScrollPane(), BorderLayout.CENTER );
    }

    // Get JScrollPane to hold JTable
    private JScrollPane getReviewTableScrollPane()
    {
        if (reviewTableScrollPane == null) {
            reviewTableScrollPane = new JScrollPane( null,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
            reviewTableScrollPane.setViewportView( getReviewTable() );
        }
        return reviewTableScrollPane;
    }

    // Get JTable for displaying data
    private JTable getReviewTable()
    {
        reviewTable = new JTable();

        // Use a DefaultTableModel to et up the columns and header for the JTable
        reviewTable.setModel( new DefaultTableModel( 
                new Object[][] {},
                new String[] {"Name", "City", "Food Type", "Rating"} ) );
        reviewTable.setAutoCreateColumnsFromModel( false );
        reviewTable.getTableHeader().setReorderingAllowed( false );
        reviewTable.getTableHeader()
                .setFont( new Font( "Arial", Font.BOLD, 12 ) );

        // Set the data model for the JTable
        reviewTable.setModel( restDB );
        reviewTable.setBackground( new Color( 204, 255, 204 ) );
        reviewTable.setFont( new Font( "Arial", Font.PLAIN, 14 ) );
        reviewTable.setRowHeight( 50 );
        reviewTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

        // Add basic sorting functions to the table
        
        /*TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(
                reviewTable.getModel() );
        reviewTable.setRowSorter( sorter );
*/
        reviewTable.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseClicked( java.awt.event.MouseEvent event )
            {
                try {
                    notifyType = LIST_UPDATE;
                    notifyObservers();
                    System.out.println( "Table Index: " 
                            + reviewTable.getSelectedRow() + " "
                            + "Model Index: " +
                            restDB.getResultSet().getRow() );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } );

        return reviewTable;
    }
    
    public TableModel getReviewTableModel()
    {
        return reviewTable.getModel();
    }
    
    // Satisfy contract for Subject interface
    public void registerObserver( Observer o )
    {
        observers.add(o);
    }
    
    // Satisfy contract for Subject interface
    public void removeObserver( Observer o )
    {
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }
    
    // Satisfy contract for Subject interface
    public void notifyObservers()
    {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update( this, LIST_UPDATE);
        }
    }

}
