import java.awt.*;
import javax.swing.*;
  import javax.swing.event.*;
  import java.applet.*;
  import java.awt.event.*;

  public class Calculator extends JApplet implements ActionListener
{
   private JTextField op1,op2;
   private JButton plus,minus,mult,divide;
   private JTextArea jt; private JPanel p1,p2,p3;static String w,h;

   public Calculator()
   { //setTitle("Calculator");
     Container c= getContentPane(); c.setLayout(new GridLayout(3,1));
     builtPanel1();builtPanel2();builtPanel3();builtListener();
     c.add(p1);c.add(p2);c.add(p3);
   //  setSize(400,400);
    // setVisible(true);
   }
   public void builtPanel1()
   {
     p1 = new JPanel();p1.setLayout(new GridLayout(2,2));p1.add(new JLabel("Operand1"));
     op1= new JTextField(10); p1.add(op1);p1.setBackground(Color.GREEN);
     p1.add(new JLabel("Operand2"));
     op2= new JTextField(10); p1.add(op2);
   }
   public void builtPanel2()
   {
     p2 = new JPanel();p2.setLayout(new FlowLayout());p2.setBackground(Color.YELLOW);
     plus= new JButton("+");minus= new JButton("-");mult= new JButton("X");
     divide= new JButton("/");p2.add(plus);p2.add(minus);p2.add(mult);p2.add(divide);
   }
    public void builtPanel3()
   {
     p3 = new JPanel();p3.setLayout(new BorderLayout());
     jt= new JTextArea();
     JScrollPane sr= new JScrollPane(jt);
     p3.add(sr);
   }
   public void builtListener()
   {
     plus.addActionListener(this);minus.addActionListener(this);

     mult.addActionListener(this);divide.addActionListener(this);
   }
    public void actionPerformed(ActionEvent e)
    {
      if ( e.getSource()==plus)
       {
         double n1= Double.parseDouble(op1.getText());
         double n2= Double.parseDouble(op2.getText());
         jt.append(""+ n1 + " + "+n2+" = "+(n1+n2)+"\n");
         op1.setText("");op2.setText("");op1.requestFocus();
       }
      else if ( e.getSource()==minus)
       {
         double n1= Double.parseDouble(op1.getText());
         double n2= Double.parseDouble(op2.getText());
         jt.append(""+ n1 + " - "+n2+" = "+(n1-n2)+"\n");
         op1.setText("");op2.setText("");op1.requestFocus();
       }
      else if ( e.getSource()==mult )
       {
         double n1= Double.parseDouble(op1.getText());
         double n2= Double.parseDouble(op2.getText());
         jt.append(""+ n1 + " X "+n2+" = "+(n1*n2)+"\n");
         op1.setText("");op2.setText("");op1.requestFocus();
       }
      else
          {
         double n1= Double.parseDouble(op1.getText());
         double n2= Double.parseDouble(op2.getText());
         jt.append(""+ n1 + " / "+n2+" = "+(n1/n2)+"\n");
         op1.setText("");op2.setText("");op1.requestFocus();
          }
       repaint();
      }
   
      public static void main(String[] args)
      {
          Calculator ap = new Calculator();
           w=ap.getParameter("test1");h=ap.getParameter("test2");
      System.out.println("===>"+h+ "====>"+w);
          JFrame win = new JFrame();
          Container c=win.getContentPane(); c.add(ap);
          //win.setSize(w,h);
          win.setVisible(true);
         
          
          
          win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      }
       }




































     




















