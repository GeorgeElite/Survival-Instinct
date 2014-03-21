package bafta.src.main.render;

public class Render {
	
	public final int width;
	public final int height;
	public final int[] pixels;

	public Render(int Width, int Height) 
	{
		this.width = Width;
		this.height = Height;
		pixels = new int[width * height];
	}
	
	public void draw(Render render, int xOffset, int yOffset){
		for(int y = 0; y < render.height; y++) {
			int yPix = y + yOffset;
			for(int x = 0; x < render.height; x++) {
				int xPix = x + xOffset;
				
				pixels[xPix + yPix * width] = render.pixels[x + y * render.width];
			}
		}
		
	}
}
