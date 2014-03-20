package bafta.src.main.render;

public class Render {
	
	public final int Width;
	public final int Height;
	public final int[] pixel;

	public Render(int Width, int Height) 
	{
		this.Width = Width;
		this.Height = Height;
		pixel = new int[Width * Height];
	}
	
	public void draw(Render render, int xOffset, int yOffset){
		for(int y = 0; y < render.Height; y++); {
			int yPix = y + yOffset;
			
		}
		
	}
}
