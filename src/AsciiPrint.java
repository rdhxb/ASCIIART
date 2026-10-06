public class AsciiPrint {
    public void print(int[][] brightnessArr){
//        using density string depends on how big the number is in brightness arr add the corresponding char
//        the brightness num are from 0 - 254 we have 9 symbols (. is the highest brightness and so on)

        int[][] brightArr = brightnessArr;

        String densityString = "@%#*+=-:.";
        for (int row = 0; row < brightnessArr.length; row++) {
            for (int col = 0; col < brightnessArr[row].length; col++) {

                int brightnesNum = brightnessArr[row][col];
                whatToPrint(brightnesNum);
            }
            System.out.println();
        }


    }
    //        density string - @%#*+=-:.
    public void whatToPrint(int brightNum){

//        we know that num are from 0 - 254 and we have 9 chars so
        if (brightNum < 28){
            System.out.print('@');
        } else if (brightNum < 56) {
            System.out.print('%');
        } else if (brightNum < 84) {
            System.out.print('#');
        } else if (brightNum < 112) {
            System.out.print('*');
        }else if (brightNum < 140) {
            System.out.print('+');
        }else if (brightNum < 168) {
            System.out.print('=');
        }else if (brightNum < 196) {
            System.out.print('-');
        }else if (brightNum < 224) {
            System.out.print(':');
        }else if (brightNum < 254) {
            System.out.print('.');
        }else {
            System.out.print(' ');
        }
    }
}
