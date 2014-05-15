import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FreezeThread implements Runnable{
    
        private final PlayerCard pc;
        final JPanel freezePanel = new JPanel();
        
        public FreezeThread( Card pc ) {
           this.pc = (PlayerCard) pc;
        }

    @Override
    public void run() {
        System.out.println("in cardFreeze()");
        
        int nbRunning = 0;
for (Thread t : Thread.getAllStackTraces().keySet()) {
    if (t.getState()==Thread.State.RUNNABLE) nbRunning++;
}

        int tim = 5;
        long delay = 5000;
	
        freezePanel.setBackground(Color.white);
        freezePanel.setPreferredSize( new Dimension(pc.cellPanel.getWidth(), pc.cellPanel.getHeight()));
	
        pc.remove(pc.cellPanel);
        pc.setVisible(true); 
        pc.add(freezePanel);
	pc.repaint();
	
        System.out.println("Just added the panel");
	
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException ex) {
            }
	
	/*
        do{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayerCard.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(tim / 1);
            tim = tim - 1;
           delay = delay - 1000;
        }while (delay != 0);
        */
	
        pc.remove(freezePanel);
        pc.add(pc.cellPanel);
        pc.repaint();
        System.out.println("Just removed the panel");
    }
}