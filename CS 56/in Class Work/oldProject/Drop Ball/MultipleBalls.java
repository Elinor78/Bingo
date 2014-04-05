import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JApplet;

public class MultipleBalls extends JApplet implements MouseListener{
    private final int SIZE = 6;
    
    private BufferedImage mImg;
    private Graphics mPen;
    
    private Ball mBalls[];
    private Thread mAnimators[];
    
    private int mIndex;
//============================================================================//
    
    public void init(){
        
        this.mImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.mPen = this.mImg.getGraphics();
        
        this.mBalls = new Ball[this.SIZE];
        this.mAnimators = new Thread[this.SIZE];
        
        this.mIndex = 0;
        this.addMouseListener(this);
    }
//============================================================================//
    public void start(){}
//============================================================================//
    public void stop(){
        
        for(int i = 0; i < 5; i++){
            
            this.mAnimators[i].stop();
            this.mAnimators[i] = null;
        }
    }
//============================================================================//
    
    public void paint(Graphics g){
        int j = 0;
        
        this.mPen.setColor(Color.GRAY);
        this.mPen.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        this.mPen.setColor(Color.lightGray);
        for(int i = 0; i < this.getWidth(); i += 50)
            this.mPen.drawLine(i, 0, i, this.getHeight());
        
        for(int i = 0; i < this.getHeight(); i += 50)
            this.mPen.drawLine(0, i, this.getWidth(), i);
        
        this.mPen.setColor(Color.BLACK);
        this.mPen.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        
        if(this.mAnimators[0] == null){
            
            this.mPen.setColor(Color.BLACK);
            this.mPen.setFont(new Font("ARIAL", Font.PLAIN, 18));
            this.mPen.drawString("Click me to start", 80, 145);
        }else{
            
            while(this.mAnimators[j] != null){
                
                this.mBalls[j].paint(this.mPen);
                j++;
            }
        }
        
        g.drawImage(this.mImg, 0, 0, null);
    }
    
//============================================================================//
    
    public void mouseClicked(MouseEvent e){
        
        if(this.mIndex < 5){
            
            this.mBalls[this.mIndex] = new Ball(e.getX(), e.getY(), this);
            this.mAnimators[this.mIndex] = new Thread(this.mBalls[this.mIndex]);
            this.mAnimators[this.mIndex].start();
        }
        
        this.mIndex++;
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
