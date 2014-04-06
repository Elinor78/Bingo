/*
 * CS56 Advanced Java
 * Class: TaskPane
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-24-07
 *
 * Purpose: A JTabbedPane that displays the Details, Notes, and Find panels
 * 
 */

package edu.smc.cs56Project.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.smc.cs56Project.patterns.Observer;
import edu.smc.cs56Project.patterns.Subject;

public class TaskPane extends JTabbedPane implements Subject {
    private ArrayList<Observer> observers;
    private String selectedTabTitle;
    
    NotesPanel notesPanel = null;
    DetailsPanel detailsPanel = null;
    FindPanel findPanel = null;

    // TaskPane constructor
    public TaskPane()
    {
        super();
        observers = new ArrayList<Observer>();
        initialize();
    }

    // Initialize TaskPAne and add components
    private void initialize()
    {
        this.setTabPlacement( JTabbedPane.BOTTOM );
        this.setPreferredSize( new Dimension( 200, 800 ) );
        this.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
        this.addTab( "Details", null, getDetailsPanel(), null );
        this.addTab( "Notes", null, getNotesPanel(), null );
        this.addTab( "Find", null, getFindPanel(), null );
        this.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                  JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                  int tabIndex = sourceTabbedPane.getSelectedIndex();
                  selectedTabTitle = sourceTabbedPane.getTitleAt( tabIndex );
                  notifyObservers();
            }
        });
      }

    private JPanel getDetailsPanel()
    {
        if (detailsPanel == null)
            detailsPanel = new DetailsPanel();
        return detailsPanel;
    }

    private NotesPanel getNotesPanel()
    {
        if (notesPanel == null)
            notesPanel = new NotesPanel();
        return notesPanel;
    }

    private JPanel getFindPanel()
    {
        if (findPanel == null)
            findPanel = new FindPanel();
        return findPanel;
    }

    public void setIsEditable( boolean isEditable)
    {
        notesPanel.setIsEditable( isEditable );
        detailsPanel.setIsEditable( isEditable );
    }
    
    public String getSelectedTabTitle()
    {
        return selectedTabTitle;
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
            observer.update( this, null );
        }
    }

}
