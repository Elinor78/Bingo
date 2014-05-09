import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

public class MyColorChooser extends JPanel{
    
    private JSlider redSlider;
    private JSlider blueSlider;
    private JSlider greenSlider;
    
    private JLabel lblRed;
    private JLabel lblBlue;
    private JLabel lblGreen;
    
    private JTextField txtRed;
    private JTextField txtBlue;
    private JTextField txtGreen;
    
    private JPanel textFieldPanel;
    private JPanel sliderPanel;
    private JPanel buttonPanel;
    private JPanel samplePanel;
    private JPanel centerPanel;
    
    public JButton cmdApply;
//============================================================================//
    
    public MyColorChooser(){
        
        this.setLayout(new BorderLayout());
        this.initComponents();
        this.initEvents();
    }
//============================================================================//
    
    public MyColorChooser(Color color){
        this();
        this.setColor(color);
    }
//============================================================================//
    
    public void initComponents(){
        
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1));
        
        redSlider = new JSlider(0, 255, 0);
        redSlider.setPaintTicks(true);
        
        blueSlider = new JSlider(0, 255, 0);
        blueSlider.setPaintTicks(true);
        
        greenSlider = new JSlider(0, 255, 0);
        greenSlider.setPaintTicks(true);
        
        sliderPanel.add(redSlider);
        sliderPanel.add(blueSlider);
        sliderPanel.add(greenSlider);
        
        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(3, 2));
        
        lblRed = new JLabel("RED");
        lblBlue = new JLabel("BLUE");
        lblGreen = new JLabel("GREEN");
        
        txtRed = new JTextField("0");
        txtRed.setEditable(false);
        
        txtBlue = new JTextField("0");
        txtBlue.setEditable(false);
        
        txtGreen = new JTextField("0");
        txtGreen.setEditable(false);
        
        textFieldPanel.add(lblRed);
        textFieldPanel.add(txtRed);
        textFieldPanel.add(lblBlue);
        textFieldPanel.add(txtBlue);
        textFieldPanel.add(lblGreen);
        textFieldPanel.add(txtGreen);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        cmdApply = new JButton("Apply");
        
        buttonPanel.add(cmdApply);
        
        samplePanel = new JPanel();
        samplePanel.setBorder(new LineBorder(Color.BLACK));
        samplePanel.setBackground(Color.BLACK);
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout());
        
        centerPanel.add(textFieldPanel);
        centerPanel.add(sliderPanel);
        centerPanel.add(samplePanel);
        
        this.add(centerPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
//============================================================================//
    
    public void initEvents(){
        
        redSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                txtRed.setText(String.valueOf(redSlider.getValue()));
                samplePanel.setBackground(getColor(txtRed, txtBlue, txtGreen));
            }
        });
        
        blueSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                txtBlue.setText(String.valueOf(blueSlider.getValue()));
                samplePanel.setBackground(getColor(txtRed, txtBlue, txtGreen));
            }
        });
        
        greenSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                txtGreen.setText(String.valueOf(greenSlider.getValue()));
                samplePanel.setBackground(getColor(txtRed, txtBlue, txtGreen));
            }
        });
    }
    
//============================================================================//
    
    public void setColor(Color color){
        
        txtRed.setText(String.valueOf(color.getRed()));
        txtBlue.setText(String.valueOf(color.getBlue()));
        txtGreen.setText(String.valueOf(color.getGreen()));
        
        redSlider.setValue(color.getRed());
        blueSlider.setValue(color.getBlue());
        greenSlider.setValue(color.getGreen());
        
        samplePanel.setBackground(color);
    }
//============================================================================//
    
    public Color getColor(){
        int red = Integer.parseInt(txtRed.getText());
        int blue = Integer.parseInt(txtBlue.getText());
        int green = Integer.parseInt(txtGreen.getText());
        
        Color color = new Color(red, green, blue);
        
        return color;
    }
//============================================================================//
    
    public Color getColor(JTextField red, JTextField blue, JTextField green){
        
        int int_red = Integer.parseInt(red.getText());
        int int_blue = Integer.parseInt(blue.getText());
        int int_green = Integer.parseInt(green.getText());
        
        Color color = new Color(int_red, int_green, int_blue);
        
        return color;
    }
//============================================================================//
}//End of MyColorChooser


