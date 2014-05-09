package com.david.cs56_final_project;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArtImages 
{
	private static ArtImages artC;
	public static final int NUM_BRICK_PICS = 4;
	public static final int NUM_DEHKHODA_PIC = 30;
	public static final int NUM_BACKGROUND_PIC = 4;
	public static final int NUM_JUMP_E_PIC = 7;
	private BufferedImage dehkhodaImage[];
	private BufferedImage jumpEnemy[];
	private BufferedImage crawlEnemy[];
	private BufferedImage brick[];
	private BufferedImage background[];
	private BufferedImage gameOver;
	private GraphicsConfiguration gfxconfig;
	private int tranparent = 0;

	private ArtImages() throws IOException 
	{
		
		GraphicsEnvironment gfxEnviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gfxconfig = gfxEnviroment.getDefaultScreenDevice().getDefaultConfiguration();
		
		brick = new BufferedImage[NUM_BRICK_PICS];
		brick[Brick.BLACK_BRICK - 1] = ImageIO.read(getClass().getResource("/brick_images/brick1.png"));
		brick[Brick.YELLOW_BRICK - 1] = ImageIO.read(getClass().getResource("/brick_images/brick2.png"));
		brick[Brick.GREEN_BRICK - 1] = ImageIO.read(getClass().getResource("/brick_images/brick3.png"));
		brick[Brick.BLUE_BRICK - 1] = ImageIO.read(getClass().getResource("/brick_images/brick4.png"));
		dehkhodaImage = new BufferedImage[NUM_DEHKHODA_PIC];
		for(int i = 1; i <= NUM_DEHKHODA_PIC; i++)
		{
			dehkhodaImage[i-1] = ImageIO.read(getClass().getResource("/dehkhoda_images/char_sprite_"+i+".png"));
		}
		background = new BufferedImage[NUM_BACKGROUND_PIC];
		background[0] = ImageIO.read(getClass().getResource("/background/mountains8.png"));
		background[1] = ImageIO.read(getClass().getResource("/background/houses5.png"));
		background[2] = ImageIO.read(getClass().getResource("/background/trees3.png"));
		background[3] = ImageIO.read(getClass().getResource("/background/space_back1.jpg"));
		jumpEnemy = new BufferedImage[NUM_JUMP_E_PIC];
		for(int i = 1; i <=7; i++)
		{
			jumpEnemy[i-1] = ImageIO.read(getClass().getResource("/enemies/YJump"+i+".png"));
		}
		gameOver = ImageIO.read(getClass().getResource("/game_over1.jpg"));
		
		
		dehkhodaImage = betterBF(dehkhodaImage);
		brick = betterBF(brick);
		jumpEnemy = betterBF(jumpEnemy);
		background = betterBF(background);
		
		
	}
	
	public static synchronized ArtImages getArtImages() throws IOException
	{
		if(artC == null)
		{
			artC = new ArtImages();
		}
		return artC;
	}

	public BufferedImage[] betterBF(BufferedImage[] images){
		for (int i = 0; i < images.length; i++) {
			tranparent = images[i].getColorModel().getTransparency();
			BufferedImage compatible = gfxconfig.createCompatibleImage(images[i].getWidth(), images[i].getHeight(), tranparent);
			Graphics2D compGrax = compatible.createGraphics();
			compGrax.drawImage(images[i], 0, 0, null);
			compGrax.dispose();
			images[i] = compatible;
		}
		
		return images;
	}
	
	public BufferedImage[] getDehkhodaSprites() 
	{
		return dehkhodaImage;
	}

	public BufferedImage[] getJumpEnemySprites() 
	{
		return jumpEnemy;
	}

	public BufferedImage[] getCrawlEnemySprites() 
	{
		return crawlEnemy;
	}

	public BufferedImage[] getBrickSprites() 
	{
		return brick;
	}

	public BufferedImage[] getBackgroundSprites() 
	{
		return background;
	}
	
	public BufferedImage getGameOverImage()
	{
		return gameOver;
	}

}
