import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;



public class ChoiceFrame extends JFrame {

private JLabel sampleField;
private JCheckBox italicCheckBox, boldCheckBox;
private JRadioButton smallButton,mediumButton,largeButton;

private JComboBox facenameCombo;

private ActionListener listener;




    public ChoiceFrame(){

     sampleField = new JLabel("Big Java");
     add(sampleField,BorderLayout.CENTER);

     // listener class

       class ChoiceListener implements ActionListener {

           public void actionPerformed(ActionEvent e){

               setSampleFont();
           }
       }

/////////////////////////////

       listener = new ChoiceListener();
       createControlPanel();
       setSampleFont();
       setSize(300,400);

    }
    public void createControlPanel(){
       JPanel facenamePanel = createComboBox();
       JPanel sizeGroupPanel = createCheckBoxes();
       JPanel styleGroupPanel = createRadioButtons();

//   line up component panels

    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new GridLayout(3,1));
    controlPanel.add(facenamePanel);
    controlPanel.add(sizeGroupPanel);
    controlPanel.add(styleGroupPanel);

// Add panels to content pane

   add(controlPanel, BorderLayout.SOUTH);
   }

   public JPanel createComboBox(){

      facenameCombo= new JComboBox();
      facenameCombo.addItem("Serif"); 
      facenameCombo.addItem("SansSerif");
      facenameCombo.addItem("Monospaced");
      facenameCombo.setEditable(true);
      facenameCombo.addActionListener(listener);

      JPanel panel= new JPanel();
      panel.add(facenameCombo);
      
      return panel;
   }

   public JPanel createCheckBoxes(){

     italicCheckBox = new JCheckBox("Italic");
     italicCheckBox.addActionListener(listener);

     boldCheckBox = new JCheckBox("Bold");
     boldCheckBox.addActionListener(listener);

     JPanel panel = new JPanel();
   
     panel.add(italicCheckBox);
     panel.add(boldCheckBox);
     panel.setBorder( new TitledBorder(new EtchedBorder(), "Style"));

     return panel;
    }

   public JPanel createRadioButtons(){

      smallButton = new JRadioButton("Small");
      smallButton.addActionListener(listener);

      mediumButton = new JRadioButton("Medium");
      mediumButton.addActionListener(listener);

      largeButton = new JRadioButton("Large");
      largeButton.addActionListener(listener);
      largeButton.setSelected(true);

      ButtonGroup group = new ButtonGroup();
      group.add(smallButton);
      group.add(mediumButton);
      group.add(largeButton);

      JPanel panel = new JPanel();
      panel.add(smallButton);
      panel.add(mediumButton);
      panel.add(largeButton);

      panel.setBorder(
             new TitledBorder( new EtchedBorder(), "Size"));

      return panel;
   }

   public void setSampleFont(){

      String facename = (String) facenameCombo.getSelectedItem();

      // get Font style

      int style=0;
      if( italicCheckBox.isSelected())
          style= style+ Font.ITALIC;
      if(boldCheckBox.isSelected())
          style= style + Font.BOLD;

     // get the size of font

     int size=0;
 
     final int SMALL_SIZE=24;
     final int MEDIUM_SIZE = 36;
     final int LARGE_SIZE =48;

     if (smallButton.isSelected())
        size = SMALL_SIZE;
     else if(mediumButton.isSelected())
        size= MEDIUM_SIZE;
     else if(largeButton.isSelected())
        size = LARGE_SIZE;

     // set font of the text field

     sampleField.setFont(new Font(facename,style,size));
     sampleField.repaint();
    }
  }
      