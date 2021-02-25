import java.awt.*;


public class DefectedPixel {
    private int row;
    private int col;
    private Color color;

    /*
      Constructor for Pixels
      @param row row coordinate
      @param col col coordinate
      @param color tile color
    */
    public DefectedPixel (int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }
}
