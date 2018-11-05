package PR;

public class MyPictureVersion1 extends MyPictureVersion0 {
    MyPictureVersion1(int n, int m) {
        super(n, m);
    }

    public void calculateHistogramPartByHA(int myColor) {
        for (var i = 0; i < size_n; i++)
            for (var j = 0; j < size_m; j++)
                if (this.pictureCharArray[i][j] == (char) (myColor + 33))
                    this.histogramIntArray[myColor]++;
    }

    public void printHistogramPartByHA(int myColor) {
        System.out.print("{" + Thread.currentThread().getName() + "} ["
                + String.format("%03d", myColor + 33) + "] "
                + (char) (myColor + 33) + " "
                + charsForNumberOfOccurrences(histogramIntArray[myColor]) + "\n");
    }
}
