import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import javax.swing.*;

public class Problem1412 extends JFrame{
    
    private JTabbedPane tabPane = new JTabbedPane();
    
    private MyColorChooser strokePanel = new MyColorChooser();
    private MyColorChooser fillPanel = new MyColorChooser(Color.lightGray);
    private MyColorChooser backgroundPanel = new MyColorChooser(Color.WHITE);
    
    private Container c = getContentPane();
//============================================================================//
    
    public Problem1412(){
        super("My Color Chooser");
        
        this.initComponents();
        this.initEvents();
        this.setSize(480, 580);
        this.setVisible(true);
        this.setResizable(false);
    }
//============================================================================//
    
    public void initComponents(){
        
        c.setLayout(new BorderLayout());
        
        tabPane.addTab("Stroke Color", null, strokePanel);
        tabPane.addTab("Fill Color", null, fillPanel);
        tabPane.addTab("Background Color", null, backgroundPanel);
        
        c.add(tabPane, BorderLayout.SOUTH);
        c.setBackground(Color.WHITE);
    }
//============================================================================//
    
    public void initEvents(){
        
        strokePanel.cmdApply.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                repaint();
            }
        });
        
        fillPanel.cmdApply.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                repaint();
            }
        });
        
        backgroundPanel.cmdApply.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                c.setBackground(backgroundPanel.getColor());
                repaint();
            }
        });
        
    }
//============================================================================//
    
    public void paint(Graphics g){
        Graphics2D pen = (Graphics2D)g;
        
        super.paint(g);
        
        pen.setStroke(new BasicStroke(2.0f));
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        pen.setColor(fillPanel.getColor());
        pen.fillOval((this.getWidth() / 2 - 30), (this.getHeight() / 2 - 100), 65, 65);
        
        pen.setColor(strokePanel.getColor());
        pen.drawOval((this.getWidth() / 2 - 30), (this.getHeight() / 2 - 100), 65, 65);
    }
//============================================================================//
    
    public static void main(String []args){
        Problem1412 p = new Problem1412();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//============================================================================//
}//End of Problem1412


