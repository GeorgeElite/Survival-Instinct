package bafta.src.main.render;

import java.util.Random;

public class Screen extends Render {

	private Render Test;
	
	public Screen(int Width, int Height) {
		super(Width, Height);
		Random random = new Random();
		Test = new Render(256, 256);
		for (int i = 0; i <256*256; i++)
		Test.pixels[i] = random.nextInt();
	}

	public void render()
	{
		draw(Test, 0, 0);
	}
}
