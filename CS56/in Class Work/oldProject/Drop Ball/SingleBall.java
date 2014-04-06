import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;

public class SingleBall extends JApplet implements MouseListener{
    
    private BufferedImage mImg;
    private Graphics mPen;
    
    private Ball mBall;
    private Thread mAnimator;
    
    private boolean mIsClicked;
//============================================================================//
    
    public void init(){
        
        this.mImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.mPen = this.mImg.getGraphics();
        
        this.mBall = new Ball(this);

        this.mIsClicked = false;
        this.addMouseListener(this);
    }
//============================================================================//
    public void start(){}
//============================================================================//
    
    public void stop(){
        
        if(this.mAnimator != null){
            
            this.mAnimator.stop();
            this.mAnimator = null;
            this.mIsClicked = false;
        }
    }
//============================================================================//
    public void paint(Graphics g){
        
        this.mPen.setColor(Color.GRAY);
        this.mPen.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        this.mPen.setColor(Color.lightGray);
        for(int i = 0; i < this.getWidth(); i += 50)
            this.mPen.drawLine(i, 0, i, this.getHeight());
        
        for(int i = 0; i < this.getHeight(); i += 50)
            this.mPen.drawLine(0, i, this.getWidth(), i);
        
        this.mPen.setColor(Color.BLACK);
        this.mPen.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        
        if(this.mAnimator == null){    
            
            this.mPen.setColor(Color.BLACK);
            this.mPen.setFont(new Font("ARIAL", Font.PLAIN, 18));
            this.mPen.drawString("Click me to start", 80, 145);
        }else
            this.mBall.paint(this.mPen);
        
        g.drawImage(this.mImg, 0, 0, null);
    }
//============================================================================//
    
    public void mouseClicked(MouseEvent e){
        
        if(this.mIsClicked == false){
            
            this.mAnimator = new Thread(this.mBall);
            this.mAnimator.start();
            this.mIsClicked = true;
        }else{
            
            this.mAnimator.stop();
            this.mIsClicked = false;
        }
    }
//============================================================================//
    public void mousePressed(MouseEvent e){}
//============================================================================//
    public void mouseReleased(MouseEvent e){}
//============================================================================//
    public void mouseEntered(MouseEvent e){}
//============================================================================//
    public void mouseExited(MouseEvent e){}
//============================================================================//
}
