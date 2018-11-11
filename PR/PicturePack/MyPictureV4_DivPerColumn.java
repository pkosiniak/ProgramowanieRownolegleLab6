package PR.PicturePack;

import java.util.ArrayList;

public class MyPictureV4_DivPerColumn extends MyPictureV3_DivPerLine {

    MyPictureV4_DivPerColumn(int n, int m) {
        super(n, m);
    }

    private ArrayList<Integer> changedState;

    public void calculateHistPartByPicColumn(int col) {
        changedState = new ArrayList<>();
        for (var j = 0; j < size_n; j++)
            for (var k = 0; k < histogramSize; k++)
                if (this.pictureCharArray[j][col] == (char) (k + 33)) {
                    this.histogramIntArray[k]++;
                    changedState.add(k);
                }
    }

    public void printHistPartByPicColumn() {
        for (var i : changedState) {
            System.out.print("{" + Thread.currentThread().getName() + "} [" /*  */
                    + String.format("%03d", i + 33) + "] "
                    + (char) (i + 33) + " "
                    + charsForNumberOfOccurrences(histogramIntArray[i]) + "\n");
        }
    }

    public void calculateHistPartByPicColumn(int seq, int step) {
        changedState = new ArrayList<>();
        for (var i = seq; i < size_n; i += step)
            for (var j = 0; j < size_m; j++)
                for (var k = 0; k < histogramSize; k++)
                    if (this.pictureCharArray[i][j] == (char) (k + 33)) {
                        changedState.add(k);
                        this.histogramIntArray[k]++;
                    }
    }

}