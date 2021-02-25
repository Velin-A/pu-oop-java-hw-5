import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/*
  Method, setting dimensions and functionality for the display
 */
public class Display extends JFrame implements MouseListener {
    private int sideTileCount = 64;
    private Object[][]pixels;
    private Object selected;

    public Display (){
        this.pixels = new Object[sideTileCount][sideTileCount];

        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    /*
        Method, checking the condition of pixels on the display
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int col = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getX());
        int row = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getY());

        if(mouseEvent.getClickCount() == 1) {

            Random definer = new Random();
            int Corrupting = definer.nextInt(3);

            if(Corrupting == 0) {
                this.pixels[row][col] = new DefectedPixel(row, col, Color.BLACK);
                this.repaint();
            }
        }
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
    /*
        Method setting the color of every pixel at random
     */
    private Color getPixelColor() {

        Random rand = new Random();
        int color = rand.nextInt(3);

        if (color == 0) return Color.RED;
        if (color == 1) return Color.GREEN;
        if (color == 2) return Color.BLUE;
        return Color.BLACK;
    }
    /*
        Method, generating the status of the pixel based on number at random
     */
    private int getPixelStatus(){
        Random rand = new Random();

        return rand.nextInt(3);
    }

    /*
        Method rendering the "Display"
     */
    public void renderDisplay(Graphics g, int row, int col){
        Color pixelColor = this.getPixelColor();
        Pixel pixel = new Pixel(row, col, pixelColor);
        pixel.render(g);
    }

    /*
        Method painting the application
     */
    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < 64; row++) {
            for (int col = 0; col < 64; col++) {
                this.renderDisplay(g, row, col);
            }
        }
    }
    /*
        Method getting the coordinates of the clocked area
     */
    private int getFieldDimensionsBasedOnCoordinates(int coordinates){
        return coordinates / Pixel.PIXEL_SIZE;
    }
}


