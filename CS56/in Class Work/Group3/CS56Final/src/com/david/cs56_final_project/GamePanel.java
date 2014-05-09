package com.david.cs56_final_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WINDOW_HEIGHT = 480; /* Window Height */
	public static final int WINDOW_WIDTH = 640; /* Window Width */
	private Dehkhoda mainChar; /* Main Character game */
	private Enemy enemies[]; /* Array of Enemies */
	private FloorManager floor; /* Floor Manager */
	private Background bg; /* BackGround */
	private ArtImages art; /* All the Images */
	public static ArrayList<ArrayList<Brick>> brickArray; /* All the bricks */
	private Set<Integer> keyPressedSet = new HashSet<>();
	private boolean isRunning = true;
	private boolean isPainting = false;
	private BufferedImage graphicsimg;
	private long startTime = System.currentTimeMillis();
	private long time = 0;

	public GamePanel() throws IOException {

		art = ArtImages.getArtImages();
		graphicsimg = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT * 2, BufferedImage.TYPE_4BYTE_ABGR);
		floor = new FloorManager();
		floor.initFloorArray();
		brickArray = floor.getBrickArray();
		mainChar = new Dehkhoda(WINDOW_WIDTH / 2, 10, art.getDehkhodaSprites(), WINDOW_WIDTH);
		mainChar.setOnFloor(false);
		enemies = new Enemy[2];
		enemies[0] = new JumpingEnemy(WINDOW_WIDTH, 0, art.getJumpEnemySprites());
		enemies[1] = new JumpingEnemy(WINDOW_WIDTH - 100, 0, art.getJumpEnemySprites());

		enemies[0].setMainChar(mainChar);
		enemies[1].setMainChar(mainChar);
		enemies[1].setBrickArray(brickArray);
		enemies[0].setBrickArray(brickArray);
		bg = new Background(0, GamePanel.WINDOW_HEIGHT - Brick.BRICK_HEIGHT, art.getBackgroundSprites());
		setDoubleBuffered(true);
		addKeyListener(this);
		setFocusable(true);
		setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		setBackground(Color.BLACK);
	}

	@Override
	public void run() {
		synchronized (this) {

			try {
				while (isRunning) {
					updateGame();
					time = (System.currentTimeMillis() - startTime) / 1000;
					Thread.sleep(2);

				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public static synchronized void playSound(final URL url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
					clip.open(inputStream);
					clip.start();
					Thread.sleep(4000);
					clip.close();

				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}

	private synchronized void updateGame() throws InterruptedException {
		if (mainChar.getHealth() <= 0 || mainChar.getY() > WINDOW_HEIGHT) {

			playSound(getClass().getResource("/sounds/gameover.wav"));
			isRunning = false;

		}
		if (!isPainting) {
			enemies[0].jump();
			enemies[1].jump();
			enemies[0].turnOnGravity();
			enemies[1].turnOnGravity();
			mainChar.turnOnGravity();
			floorColliding();
			if (keyPressedSet.contains(KeyEvent.VK_A)) {
				moveLeftWorld();
			}

			if (keyPressedSet.contains(KeyEvent.VK_D)) {
				moveRightWorld();
			}

			if (keyPressedSet.contains(KeyEvent.VK_SPACE) || mainChar.isJumping()) {
				mainChar.jump();
			}
			correctCollision();
		}
	}

	private void moveRightWorld() {
		mainChar.moveRight();
		if (mainChar.getX() > Dehkhoda.SCREEN_MOVE_POSITION_RIGHT - 1) {
			floor.moveRight();
			enemies[0].moveLeft();
			enemies[1].moveLeft();
			bg.moveLeft();
		}
	}

	private void moveLeftWorld() {
		mainChar.moveLeft();
		if (mainChar.getX() < Dehkhoda.SCREEN_MOVE_POSITION_LEFT + 1) {
			floor.moveLeft();
			enemies[0].moveRight();
			enemies[1].moveRight();
			bg.moveRight();
		}
	}

	private void correctCollision() {

		for (int i = floor.getStartBrick(); i < floor.getEndBrick(); i++) {

			for (int j = 0; j < brickArray.get(i).size(); j++) {
				Brick checkB = brickArray.get(i).get(j);

				if (mainChar.checkCollision(checkB)) {
					if (mainChar.checkCollision(GameSprites.TOP_RECT, checkB)) {
						mainChar.stopJump();
					}

					if (mainChar.checkCollision(GameSprites.BOTTOM_RECT, checkB)) {
						mainChar.moveUp();
						mainChar.moveUp();
						mainChar.moveUp();
					}

					if (mainChar.checkCollision(GameSprites.LEFT_RECT, checkB)) {
						moveRightWorld();
					}

					if (mainChar.checkCollision(GameSprites.RIGHT_RECT, checkB)) {
						moveLeftWorld();
					}

				}
			}
		}

		boolean validHit = false;
		for (int i = 0; i < enemies.length; i++) {

			if (!enemies[i].wasHit()) {

				if (mainChar.checkCollision(GameSprites.TOP_RECT, enemies[i])) {
					validHit = true;
					mainChar.stopJump();
					enemies[i].hitHappen(true);

				}

				if (mainChar.checkCollision(GameSprites.BOTTOM_RECT, enemies[i])) {
					mainChar.moveUp();
					mainChar.moveUp();
				}

				if (mainChar.checkCollision(GameSprites.LEFT_RECT, enemies[i])) {
					validHit = true;
					moveRightWorld();
					enemies[i].hitHappen(true);

				}

				if (mainChar.checkCollision(GameSprites.RIGHT_RECT, enemies[i])) {
					validHit = true;
					moveLeftWorld();
					enemies[i].hitHappen(true);

				}
			}
		}

		if (validHit) {
			// mainChar.DisableCol();
			GamePanel.playSound(getClass().getResource("/sounds/hit.wav"));
			mainChar.setHealth((mainChar.getHealth() - 1));
		}
	}

	private void floorColliding() {
		// System.out.println(floor.getStartBrick() +"---" +
		// floor.getEndBrick());

		boolean restore = false;
		if (mainChar.isDisabledCol()) {
			restore = true;
			mainChar.EnableCol();
		}
		for (int i = floor.getStartBrick(); i < floor.getEndBrick(); i++) {

			for (int j = 0; j < brickArray.get(i).size(); j++) {
				Brick checkB = brickArray.get(i).get(j);

				if (mainChar.checkCollision(checkB)) {
					if (mainChar.checkCollision(GameSprites.BOTTOM_RECT, checkB)) {
						mainChar.moveUp();
						mainChar.setOnFloor(true);
					}
				}
			}

		}
		if (restore)
			mainChar.DisableCol();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			keyPressedSet.add(e.getKeyCode());
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			keyPressedSet.add(e.getKeyCode());
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keyPressedSet.add(e.getKeyCode());
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keyPressedSet.add(e.getKeyCode());
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			mainChar.ToggleColBox();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			keyPressedSet.remove(e.getKeyCode());
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			keyPressedSet.remove(e.getKeyCode());
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keyPressedSet.remove(e.getKeyCode());
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keyPressedSet.remove(e.getKeyCode());
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		isPainting = true;
		Graphics2D imgGraphics = (Graphics2D) graphicsimg.getGraphics();
		imgGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		super.paintComponent(imgGraphics);
		bg.draw(imgGraphics);
		if (isRunning) {
			for (int i = 0; i < brickArray.size(); i++) {
				/*
				 * if (i > brickArray.size()) { i = brickArray.size() - 1; }
				 */
				for (int j = 0; j < brickArray.get(i).size(); j++) {
					if (brickArray.get(i).get(j).getX() < GamePanel.WINDOW_WIDTH && brickArray.get(i).get(j).getX() > -50) {
						brickArray.get(i).get(j).draw(imgGraphics);
					}
				}
			}
			mainChar.draw(imgGraphics);
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].draw(imgGraphics);
			}
			imgGraphics.fillRect(488, 33, 105, 25);
			imgGraphics.setColor(Color.RED.darker());

			imgGraphics.fillRect(490, 35, (int) mainChar.getHealth(), 20);
			imgGraphics.setColor(Color.BLACK);
			imgGraphics.setFont(new Font("Sansserif", Font.BOLD, 15));
			imgGraphics.drawString("Health " + mainChar.getHealth(), 496, 50);
			imgGraphics.setColor(Color.white);
			imgGraphics.drawString("" + time, 450, 50);
		} else {
			BufferedImage gameOver = art.getGameOverImage();
			imgGraphics.drawImage(gameOver, getWidth() / 2 - gameOver.getWidth() / 2, getHeight() / 2 - gameOver.getHeight() / 2, null);
		}
		g.drawImage(graphicsimg, 0, 0, this);
		imgGraphics.dispose();
		isPainting = false;
	}
}