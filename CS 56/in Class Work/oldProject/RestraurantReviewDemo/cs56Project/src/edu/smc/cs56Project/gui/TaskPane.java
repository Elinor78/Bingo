/*
 * CS56 Advanced Java
 * Class: TaskPane
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-31-07
 *
 * Purpose: A JTabbedPane that displays the Details, Notes, and Find panels
 */

package edu.smc.cs56Project.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.smc.cs56Project.patterns.NotifyConstants;
import edu.smc.cs56Project.patterns.Observer;
import edu.smc.cs56Project.patterns.Subject;
import java.awt.Color;

public class TaskPane extends JTabbedPane implements Subject, Observer, NotifyConstants {
    
    private ArrayList<Observer> observers;
    private int notifyType;
    private String selectedTabTitle;
    
    NotesPanel notesPanel = null;
    DetailsPanel detailsPanel = null;
    FindPanel findPanel = null;

    // TaskPane constructor
    public TaskPane()
    {
        super();
        initialize();
        
        observers = new ArrayList<Observer>();
    }

    // Initialize TaskPane and add components
    private void initialize()
    {
        this.setTabPlacement( JTabbedPane.BOTTOM );
        this.setSize(new Dimension(300, 800));
        this.setBackground(new Color(204, 255, 204));
        this.setPreferredSize(new Dimension(300, 800));
        this.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
        this.addTab( "Details", null, getDetailsPanel(), null );
        this.addTab( "Notes", null, getNotesPanel(), null );
        this.addTab( "Find", null, getFindPanel(), null );
        this.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                  JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                  int tabIndex = sourceTabbedPane.getSelectedIndex();
                  selectedTabTitle = sourceTabbedPane.getTitleAt( tabIndex );
                  notifyType = TAB_UPDATE;
                  notifyObservers();
            }
        });
      }

    private JPanel getDetailsPanel()
    {
        if (detailsPanel == null)
            detailsPanel = new DetailsPanel();
            detailsPanel.setBackground(new Color(255, 255, 204));
        return detailsPanel;
    }

    private NotesPanel getNotesPanel()
    {
        if (notesPanel == null)
            notesPanel = new NotesPanel();
            notesPanel.setBackground(new Color(255, 255, 204));
        return notesPanel;
    }

    private JPanel getFindPanel()
    {
        if (findPanel == null)
            findPanel = new FindPanel();
            findPanel.setBackground(new Color(255, 255, 204));
        return findPanel;
    }
    
    public String getSelectedTabTitle()
    {
        return selectedTabTitle;
    }
    
    public HashMap getSearchParameters()
    {
        return findPanel.getFields();
    }
    
    public void setIsEditable( boolean isEditable)
    {
        notesPanel.setIsEditable( isEditable );
        detailsPanel.setIsEditable( isEditable );
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
            observer.update( this, notifyType);
        }
    }

    // Satisfy contract for Observer interface
    public void update( Subject s, Object arg )
    {
        /*
         if (s instanceof ReviewTablePane) {
             ReviewTablePane rtp = (ReviewTablePane) s;
             if (rtp.getReviewTableModel() instanceof RestDB) {
                 RestDB rdb = (RestDB) rtp.getReviewTableModel();
                 detailsPanel.setFields( rdb );
                 System.out.println( "TaskPane updated by ReviewTablePane." );
             }
         }
         */
    }

}
