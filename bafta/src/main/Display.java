package bafta.src.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import bafta.src.main.render.Render;
import bafta.src.main.render.Screen;


public class Display extends Canvas implements Runnable {
	private static final long serialVersionUID = 8354132404191252358L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Survival Instinct";
	public static final String STATE = "Prototype";
	public static final String VERSION = "0.0.1";
	
	private Thread thread;
	private boolean running = false;
	private BufferedImage img;
	private int[] pixels;
	private Screen screen;
	private Render render;
	
	public Display()
	{
		screen = new Screen(WIDTH, HEIGHT);
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
		
	}
	
	private void Start()
	{
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() 
	{
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
			}
		}
		
	public void running(){
	{ 
		while (running);
		render();
		tick();
		
	}
	}
	
	private void tick() 
	{
		
	}
	private void render() 
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) 
		{
			screen.render();
			createBufferStrategy(3);
			return;
		}

		
		for (int i = 0; i<WIDTH * HEIGHT; i++)
		{
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		bs.show();
		g.dispose();
		
	}

	public static void main(String[] args) 
	{
		Display Game = new Display();
		JFrame frame = new JFrame();
		
		frame.add(Game);
		frame.pack();
		frame.setTitle(TITLE + " - " + STATE + " " + VERSION);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		System.out.println("Launching " + TITLE + " - " + STATE + " " + VERSION);
		
		Game.Start();
	}

	@Override
	public void run() {
		
	}
		
}
