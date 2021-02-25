import java.awt.*;

public class AlmostDefectedPixel {
    private int row;
    private int col;
    private Color color;

    /*
        Constructor for Pixels
        @param row row coordinate
        @param col col coordinate
        @param color tile color
     */
    public AlmostDefectedPixel (int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }
    /*
        Method rendering AlmostDefectivePixels
     */
    public void render(Graphics g){
        int tileX    = this.col * Pixel.PIXEL_SIZE;
        int tileY    = this.row * Pixel.PIXEL_SIZE;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, Pixel.PIXEL_SIZE-Pixel.BORDER_OFFSET,  Pixel.PIXEL_SIZE-Pixel.BORDER_OFFSET);
    }
}
