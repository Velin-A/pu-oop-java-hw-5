import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Display extends JFrame implements MouseListener {
    private int sideTileCount = 64;
    private Object[][]figures;
    private Object selected;

    public Display (){
        this.figures = new Object[sideTileCount][sideTileCount];

        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }




    private Color getPixelColor() {

        Random rand = new Random();
        int color = rand.nextInt(3);

        if (color == 0) return Color.RED;
        if (color == 1) return Color.GREEN;
        if (color == 2) return Color.BLUE;
        return Color.BLACK;
    }

    private int getPixelStatus(){
        Random rand = new Random();

        return rand.nextInt(3);
    }

    private Color hasDefectedPixel(){

        return Color.BLACK;

    }

    private String setPixelStatus(){
        if(getPixelColor() == Color.RED)   return  "Defect";
        if(getPixelStatus() == 1) return  "Almost Defect";
        if(getPixelStatus() == 2)  return  "Active";
        return "";
    }
    /*
        Method rendering the field(board)
     */
    public void renderDisplay(Graphics g, int row, int col){
        Color tileColor = this.getPixelColor();
        Pixel tile = new Pixel(row, col, tileColor);
        tile.render(g);
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < 64; row++) {
            for (int col = 0; col < 64; col++) {

                this.renderDisplay(g, row, col);
                //this.renderGPS  (g, row, col);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(getPixelColor() == Color.RED) {
            hasDefectedPixel();
            }
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private int getFieldDimensionsBasedOnCoordinates(int coordinates){
        return coordinates / Pixel.PIXEL_SIZE;
    }
}


