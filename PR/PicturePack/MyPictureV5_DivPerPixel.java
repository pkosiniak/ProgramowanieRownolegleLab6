package PR.PicturePack;

import java.util.ArrayList;

public class MyPictureV5_DivPerPixel extends MyPictureV4_DivPerColumn {
    MyPictureV5_DivPerPixel(int n, int m) {
        super(n, m);
    }

    private ArrayList<Integer> changedState;

    public void calculateHistPartByPicBlockSize1(int nStop, int mStop) {
        changedState = new ArrayList<>();
        for (var k = 0; k < histogramSize; k++)
            if (this.pictureCharArray[nStop][mStop] == (char) (k + 33)) {
                this.histogramIntArray[k]++;
                changedState.add(k);
            }
    }

    public void printHistPartByPicBlock() {
        for (var i : changedState) {
            System.out.print("{" + Thread.currentThread().getName() + "} ["
                    + String.format("%03d", i + 33) + "] "
                    + (char) (i + 33) + " "
                    + charsForNumberOfOccurrences(histogramIntArray[i]) + "\n");
        }
    }

    public void calculateHistPartByPictureBlock(int nStart, int mStart, int nStop, int mStop) {
        for (var i = nStart; i < nStop && i < this.size_n; i++) {
            for (var j = mStart; j < mStop && j < this.size_m; j++)
                System.out.print(this.pictureCharArray[i][j] + " ");
            System.out.print("\n");
        }

        changedState = new ArrayList<>();
        for (var i = nStart; i < nStop && i < this.size_n; i++)
            for (var j = mStart; j < mStop && j < this.size_m; j++)
                for (var k = 0; k < histogramSize; k++)
                    if (this.pictureCharArray[i][j] == (char) (k + 33)) {
                        this.histogramIntArray[k]++;
                        changedState.add(k);
                    }
    }
}
