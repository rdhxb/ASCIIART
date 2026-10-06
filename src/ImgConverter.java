import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class ImgConverter {
//    convert img into brightness int[][]
    public int[][] convert(String imgPath) throws IOException {

        BufferedImage original = ImageIO.read(new File(imgPath));

        BufferedImage img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(original, 0, 0, 64, 64, null);
        g2d.dispose();


        int width = img.getWidth();
        int height = img.getHeight();
        int[][] brightnessArray = new int[width][height];

//      loop to go through every pixel in the image and calculate the brightness of that pixel then we save the birghtness to Array
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {

                int pixelColor = img.getRGB(row,col);

                //  move bit >> x , and & operator
                //  00000000 (A) 00000000(R) 00000000(G) 00000000(B)
                //  0xFF with and operator works like mask for other bits
                int r = (pixelColor >> 16) & 0xFF;
                int g = (pixelColor >> 8) & 0xFF;
                int b = pixelColor & 0xFF;

                //  0.2126R + 0.7152G + 0.0722B
                int brightness = (int) ((r * 0.2126) + ( g * 0.7152) + (b * 0.0722));

                brightnessArray[col][row] = brightness;

            }

        }

//        System.out.println(Arrays.deepToString(brightnessArray));
//        int max = Arrays.stream(brightnessArray).flatMapToInt(Arrays::stream)
//                .max()
//                .orElseThrow();


        return brightnessArray;
    }
}
