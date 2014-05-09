package com.david.cs56_final_project;

import java.awt.Color;

import javax.swing.JFrame;


public class GameMain1 
{
	private static JFrame test = new JFrame();

	public static void main(String[] args) 
	
    {
		   
	        
        try 
        {
        	
        	GameMenu menu = new GameMenu();
        	test.add(menu);
        	Thread gameMeunThread = new Thread(menu);
        	gameMeunThread.start();
        	
        	
        	test.setSize(640, 480);
            test.getContentPane().setBackground(Color.BLACK);
            test.setUndecorated(true);
            test.setLocationRelativeTo(null);
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            test.setVisible(true);
            test.createBufferStrategy(1);
            
            
	
        	
        	while(gameMeunThread.isAlive()){
        		Thread.sleep(20);
        		test.repaint();
    			test.revalidate();
        	}
        	
        	
        
        	
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
			System.exit(1);
		}
        
        //GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        //gd.setFullScreenWindow(test);
        //gd.setDisplayMode(new DisplayMode (640,480, gd.getDisplayMode().getBitDepth(),gd.getDisplayMode().getRefreshRate()));
        
    }
	
	
	

	

}
