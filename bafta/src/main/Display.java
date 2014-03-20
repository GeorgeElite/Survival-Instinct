package bafta.src.main;

import java.awt.Canvas;

import javax.swing.JFrame;

import bafta.src.main.render.Render;


public class Display extends Canvas implements Runnable {
	private static final long serialVersionUID = 8354132404191252358L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Survival Instinct";
	public static final String STATE = "Prototype";
	public static final String VERSION = "0.0.1";
	
	private Thread thread;
	private boolean running = false;
	private Render render;
	
	public Display()
	{
		render = new Render(WIDTH, HEIGHT);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
			}
		}
		
	public void running(){
	{ 
		while (running);
		tick();
		render();
		
	}
	}
	
	private void render() {
		// TODO Auto-generated method stub
		
	}

	private void tick() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
		
}
