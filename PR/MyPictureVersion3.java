package PR;

import java.util.ArrayList;

public class MyPictureVersion3 extends MyPictureVersion2{

    MyPictureVersion3(int n, int m) {
        super(n, m);
    }

    public void calculateHistogramPartByPicture(int line) {
        changedState = new ArrayList<>();
        for (var j = 0; j < size_m; j++)
            for (var k = 0; k < histogramSize; k++)
                if (this.pictureCharArray[line][j] == (char) (k + 33)) {
                    this.histogramIntArray[k]++;
                    changedState.add(k);
                }
    }

    public void printHistogramPartByPicture() {
        for (var i : changedState) {
            System.out.print("{" + Thread.currentThread().getName() + "} [" /*  */
                    + String.format("%03d", i + 33) + "] "
                    + (char) (i + 33) + " "
                    + charsForNumberOfOccurrences(histogramIntArray[i]) + "\n");
        }
    }
}
