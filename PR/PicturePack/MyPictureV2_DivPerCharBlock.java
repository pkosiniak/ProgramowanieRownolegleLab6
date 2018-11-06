package PR.PicturePack;

public class MyPictureV2_DivPerCharBlock extends MyPictureV1_DivPerChar {
    MyPictureV2_DivPerCharBlock(int n, int m) {
        super(n, m);
    }

    public void calculateHistogramPartByHA(int block, int part) {
        var s = (block + 1) * part;
        for (var i = 0; i < size_n; i++)
            for (var j = 0; j < size_m; j++)
                for (var k = s - part; k < s && i < histogramSize; k++)
                    if (this.pictureCharArray[i][j] == (char) (k + 33))
                        this.histogramIntArray[k]++;
    }

    public void printHistogramPartByHA(int block, int part) {
        var s = (block + 1) * part;
        for (var i = s - part; i < s && i < histogramSize; i++)
            System.out.print("{" + Thread.currentThread().getName() + "} ["
                    + String.format("%03d", i + 33) + "] "
                    + (char) (i + 33) + " "
                    + charsForNumberOfOccurrences(histogramIntArray[i]) + "\n");
    }
}
