package com.david.cs56_final_project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameMenu extends JPanel implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel startLab;
	private int currentIndex = 0;
	private GamePanel gamePanel;
	private Thread gameThread;
	private JLabel stopLab;
	private boolean hasntStart = true;
	private boolean stopPressed = false;
	ActionListener listener;
	private Timer time = new Timer(50, this);
	private int sup, dehkhoda, ind = 20;
	private boolean ok, fine, d, s;

	public GameMenu() throws IOException {

		time.start();
		setLayout(null);
		setBackground(Color.BLACK);
		gameThread = new Thread();

		startLab = new JLabel();
		startLab.setIcon(new ImageIcon(getClass().getResource("/menu/start.png")));
		startLab.setBounds(10, 233, 200, 60);
		//
		startLab.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				synchronized (this) {

					try {
						hasntStart = false;
						gamePanel = new GamePanel();
						gameThread = new Thread(gamePanel);
						GameMenu.this.add(gamePanel);
						gamePanel.requestFocusInWindow();
						(GameMenu.this).remove(startLab);
						(GameMenu.this).remove(stopLab);
						gameThread.start();
						time.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			public void mouseEntered(MouseEvent e) {
				fine = false;
				if (!fine) {

					GamePanel.playSound(getClass().getResource("/sounds/Do_It.wav"));
					fine = true;
				}
			}

		});

		stopLab = new JLabel();
		stopLab.setIcon(new ImageIcon(getClass().getResource("/menu/stop.png")));
		stopLab.setBounds(450, 233, 166, 60);

		stopLab.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			public void mouseEntered(MouseEvent e) {
				fine = false;
				if (!fine) {

					GamePanel.playSound(getClass().getResource("/sounds/Stop_It.wav"));
					fine = true;
				}
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		ind++;
		if (sup < 150) {
			sup += 3;

			if (!s) {
				GamePanel.playSound(getClass().getResource("/sounds/Super.wav"));
				s = true;
			}
		}

		if (dehkhoda < 150 && sup > 149) {
			dehkhoda += 3;

			if (!d) {
				GamePanel.playSound(getClass().getResource("/sounds/Dehkhoda.wav"));
				d = true;
			}
		}
		if (ind > 200) {
			Component c = GameMenu.this.getTopLevelAncestor();
			GameMenu.this.add(stopLab);
			GameMenu.this.add(startLab);
			c.validate();
			c.repaint();
			if (!ok) {

				GamePanel.playSound(getClass().getResource("/sounds/Good_Morning.wav"));
				ok = true;
			}
		}
	}

	protected void paintComponent(Graphics g) {

		Graphics2D imgGraphics = (Graphics2D) g;
		imgGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		super.paintComponent(imgGraphics);

		BufferedImage backGround, title, title2;
		BufferedImage runningMan[];

		try {

			title = ImageIO.read(getClass().getResource("/menu/coollogo_com-180791128.png"));// http://www.flamingtext.com/logo/Design-Standing-3D,#3516de
			title2 = ImageIO.read(getClass().getResource("/menu/coollogo_com-309335621.png"));
			imgGraphics.drawImage(title, 70, 50, sup + 50, sup, null);
			imgGraphics.drawImage(title2, 300, 50, dehkhoda + 150, dehkhoda, null);
		} catch (IOException e) {

			e.printStackTrace();
		}

		imgGraphics.setColor(Color.WHITE);
		imgGraphics.setFont(new Font("sansserif", Font.BOLD, 20));
		imgGraphics.drawString("Created by", 200, 300);
		imgGraphics.drawString("David Vilarreal", 200, 320);
		imgGraphics.drawString("Noa Altschul", 200, 340);
		imgGraphics.drawString("Greg Sandoval", 200, 360);
		imgGraphics.drawString("Joshua Lee", 200, 380);
		imgGraphics.drawString("Martin Reyes", 200, 400);
		imgGraphics.drawString("Zhang Suajun", 200, 420);

		// imgGraphics.setFont(new Font("sansserif", Font.BOLD, sup));
		// imgGraphics.drawString("Super", 120, 80);
		// imgGraphics.setFont(new Font("sansserif", Font.BOLD, dehkhoda));
		// imgGraphics.drawString("      Dehkhoda", 200, 80);

		if (ind > 200) {
			try {

				backGround = ImageIO.read(getClass().getResource("/background/space_back1.jpg"));
				runningMan = ArtImages.getArtImages().getDehkhodaSprites();

				int manWidht = runningMan[currentIndex].getWidth() / 2;
				int manHeight = runningMan[currentIndex].getHeight() / 2;

				imgGraphics.drawImage(backGround, 0, 0, null);
				imgGraphics.drawImage(runningMan[currentIndex], getWidth() / 2 - manWidht / 2, getHeight() / 2 - manHeight / 2, manWidht, manHeight, null);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void run() {
		synchronized (this) {
			
		
		try {
			while (!stopPressed) {
				while (hasntStart) {
					if (currentIndex < ArtImages.NUM_DEHKHODA_PIC - 1) {
						currentIndex++;
					} else {
						currentIndex = 0;
					}
					Thread.sleep(50);
				}
				while (gameThread != null && gameThread.isAlive()) {
					// Thread.sleep(10);
				}
				if (gameThread != null && !gameThread.isAlive() && !hasntStart) {
					Thread.sleep(3000);
					hasntStart = true;
					remove(gamePanel);
					gamePanel = null;
					gameThread = null;
					add(startLab);
					add(stopLab);
					requestFocusInWindow();
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}