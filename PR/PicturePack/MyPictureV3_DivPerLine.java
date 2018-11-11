package PR.PicturePack;

import java.util.ArrayList;

public class MyPictureV3_DivPerLine extends MyPictureV2_DivPerCharBlock {

    MyPictureV3_DivPerLine(int n, int m) {
        super(n, m);
    }

    private ArrayList<Integer> changedState;

    public void calculateHistPartByPicLine(int line) {
        changedState = new ArrayList<>();
        for (var j = 0; j < size_m; j++)
            for (var k = 0; k < histogramSize; k++)
                if (this.pictureCharArray[line][j] == (char) (k + 33)) {
                    this.histogramIntArray[k]++;
                    changedState.add(k);
                }
    }

    public void printHistPartByPicLine() {
        for (var i : changedState) {
            System.out.print("{" + Thread.currentThread().getName() + "} [" /*  */
                    + String.format("%03d", i + 33) + "] "
                    + (char) (i + 33) + " "
                    + charsForNumberOfOccurrences(histogramIntArray[i]) + "\n");
        }
    }

    public void calculateHistPartByPicLine(int seq, int step) {
        changedState = new ArrayList<>();
        for (var i = 0; i < size_n; i++)
            for (var j = seq; j < size_m; j += step)
                for (var k = 0; k < histogramSize; k++)
                    if (this.pictureCharArray[i][j] == (char) (k + 33)) {
                        this.histogramIntArray[k]++;
                        changedState.add(k);
                    }
    }

}
