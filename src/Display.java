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
    private Object[][]figures;
    private Object selected;

    public Display (){
        this.figures = new Object[sideTileCount][sideTileCount];

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

        if(this.selected != null){

            if(getPixelColor() == Color.RED){
                this.figures[row][col] = (new DefectedPixel(row, col, Color.BLACK));
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
        Method setting the status of the pixel to Defective if the number generated in
        getPixelStatus was 0
     */
    public boolean hasDefectedPixel(int row, int col){
        return getPixelStatus() == 0;
    }
    /*
       Method setting the status of the pixel to Almost Defective if the number generated in
       getPixelStatus was 1
    */
    public boolean hasAlmostDefectedPixel(){
        return getPixelStatus() == 1;
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
        Method rendering Defected pixels
    */
    public void renderDefectedPixel(Graphics g, int row, int col){
        if(this.hasDefectedPixel(row, col)){
            DefectedPixel pixel = new DefectedPixel(row, col, Color.BLACK);
            pixel.render(g);
        }

    }
    /*
        Method rendering Almost Defected pixels
     */
    public void renderAlmostDefectedPixel(Graphics g, int row, int col){
        if(this.hasAlmostDefectedPixel()){
            AlmostDefectedPixel pixel = new AlmostDefectedPixel(row, col, Color.ORANGE);
            pixel.render(g);
        }

    }

    /*
        Method painting the application
     */
    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < 64; row++) {
            for (int col = 0; col < 64; col++) {

                this.renderDefectedPixel(g, row, col);
                this.renderAlmostDefectedPixel(g, row, col);
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


