/*
 * CS56 Advanced Java
 * Class: NotesPanel
 * Author(s): Heather Ruderian
 * LAST UPDATE: 5-25-07
 *
 * Purpose: A panel to display visited status, last date visited, comments, 
 * directions, and map.
 * 
 * NOTE: Current implementation is for display purposes only.
 * 
 */

package edu.smc.cs56Project.gui;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import java.awt.Point;

public class NotesPanel extends JPanel {
    private ArrayList<Component> components;
    
    private JCheckBox visitedCheckBox = null;
    private JLabel commentsLabel = null;
    private JTextArea commentsTextArea = null;
    private JLabel mapLabel = null;
    private JPanel mapPanel = null;
    private JLabel directionsLabel = null;
    private JTextArea directionsTextArea = null;
    
    // NotesPanel constructor
    public NotesPanel()
    {
        super();
        components = new ArrayList<Component>();
        initialize();
    }
    
    // Initialize NotesPanel and add components
    private void initialize()
    {
        directionsLabel = new JLabel();
        directionsLabel.setPreferredSize(new Dimension(200, 16));
        directionsLabel.setText("Directions: ");
        
        mapLabel = new JLabel();
        mapLabel.setPreferredSize(new Dimension(200, 16));
        mapLabel.setText("Map:");
        
        commentsLabel = new JLabel();
        commentsLabel.setText("Comments:");
        commentsLabel.setPreferredSize(new Dimension(200, 16));
        
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(300, 800));
        this.setSize(new Dimension(300, 800));
        this.setLocation(new Point(0, 0));
        this.setBackground( new Color(255, 204, 153) );
        this.add(getVisitedCheckBox(), null);
        this.add(commentsLabel, null);
        this.add(getCommentsTextArea(), null);
        this.add(directionsLabel, null);
        this.add(getDirectionsTextArea(), null);
        this.add(mapLabel, null);
        this.add(getMapPanel(), null);
        
        this.validate();
    }

    private JCheckBox getVisitedCheckBox()
    {
        if (visitedCheckBox == null) {
            visitedCheckBox = new JCheckBox();
            visitedCheckBox.setEnabled(false);
            visitedCheckBox.setBackground(new Color(255, 255, 204));
            visitedCheckBox.setPreferredSize(new Dimension(200, 24));
            visitedCheckBox.setText("Visited? ");
            components.add( getVisitedCheckBox() );
        }
        return visitedCheckBox;
    }

    private JTextArea getCommentsTextArea()
    {
        if (commentsTextArea == null) {
            commentsTextArea = new JTextArea();
            commentsTextArea.setPreferredSize(new Dimension(200, 118));
            commentsTextArea.setEditable(false);
            commentsTextArea.setWrapStyleWord(true);
            components.add( getCommentsTextArea() );
        }
        return commentsTextArea;
    }

    private JTextArea getDirectionsTextArea()
    {
        if (directionsTextArea == null) {
            directionsTextArea = new JTextArea();
            directionsTextArea.setPreferredSize(new Dimension(200, 118));
            directionsTextArea.setEditable(false);
            directionsTextArea.setWrapStyleWord(true);
            components.add( getDirectionsTextArea() );
        }
        return directionsTextArea;
    }
    
    private JPanel getMapPanel()
    {
        if (mapPanel == null) {
            mapPanel = new JPanel();
            mapPanel.setLayout(new GridBagLayout());
            mapPanel.setPreferredSize(new Dimension(200, 118));
            mapPanel.setBorder(BorderFactory.createLineBorder(Color.orange, 1));
            components.add( getMapPanel() );
        }
        return mapPanel;
    }
    
    public void setIsEditable( boolean isEditable)
    {
        for (int i = 0; i < components.size(); i++) 
            components.get(i).setEnabled( isEditable );
    }

}
