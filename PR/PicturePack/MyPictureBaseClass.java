package PR.PicturePack;

import java.util.Random;

public class MyPictureBaseClass {

    //region init
    //region fields
    final static int histogramSize = 94;
    int size_n;
    int size_m;
    char[][] pictureCharArray;
    int[] histogramIntArray = new int[histogramSize];
    //endregion fields

    MyPictureBaseClass(int n, int m) {

        this.size_n = n;
        this.size_m = m;
        this.pictureCharArray = new char[n][m];
        final var random = new Random();

        System.out.print("\n\n");
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                this.pictureCharArray[i][j] = (char) (random.nextInt(histogramSize) + 33);  // ascii 33-127
                System.out.print(this.pictureCharArray[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");

        clear_histogram();
    }

    public void clear_histogram() {
        for (var i = 0; i < histogramSize; i++) this.getHistogramIntArray()[i] = 0;
    }

    public int[] getHistogramIntArray() {
        return histogramIntArray;
    }

    public char[][] getPictureCharArray() {
        return pictureCharArray;
    }

    //endregion init


    //region common

    String charsForNumberOfOccurrences(int times) {
        return new String(new char[times]).replace("\0", "+");
    }
    //endregion common
}
