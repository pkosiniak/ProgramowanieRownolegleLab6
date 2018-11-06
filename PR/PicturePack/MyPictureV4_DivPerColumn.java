package PR.PicturePack;

import java.util.ArrayList;

public class MyPictureV4_DivPerColumn extends MyPictureV3_DivPerLine {

    MyPictureV4_DivPerColumn(int n, int m) {
        super(n, m);
    }

    private ArrayList<Integer> changedState;

    public void calculateHistogramPartByPictureVertical(int line) {
        changedState = new ArrayList<>();
        for (var j = 0; j < size_n; j++)
            for (var k = 0; k < histogramSize; k++)
                if (this.pictureCharArray[j][line] == (char) (k + 33)) {
                    this.histogramIntArray[k]++;
                    changedState.add(k);
                }
                else
                    continue; // this line is here only because intellij says that it is the same as Version 3
    }

    public void printHistogramPartByPictureVertical() {
        for (var i : changedState) {
            System.out.print("{" + Thread.currentThread().getName() + "} [" /*  */
                    + String.format("%03d", i + 33) + "] "
                    + (char) (i + 33) + " "
                    + charsForNumberOfOccurrences(histogramIntArray[i]) + "\n");
        }
    }
}