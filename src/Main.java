import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ImgConverter converter = new ImgConverter();
        AsciiPrint printer = new AsciiPrint();

        int[][] brightnessArr = converter.convert("/home/bazbaz/ASCIIArt/img/flower.jpg");

        printer.print(brightnessArr);

    }
}