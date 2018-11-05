package PR;

public class MyPictureVersion0  extends MyPictureBaseClass {
    MyPictureVersion0(int n, int m) {
        super(n, m);
    }

    public void calculate_histogram() {
        for (var i = 0; i < size_n; i++) {
            for (var j = 0; j < size_m; j++) {
                for (var k = 0; k < histogramSize; k++) {
                    if (this.pictureCharArray[i][j] == (char) (k + 33))
                        this.getHistogramIntArray()[k]++;
                }
            }
        }
    }

    public void print_histogram() {
        for (var i = 0; i < histogramSize; i++) {
            System.out.print("{" + Thread.currentThread().getName() + "} ["
                    + String.format("%03d", i + 33) + "] "
                    + (char) (i + 33)
                    + " " + this.histogramIntArray[i] + "\n");
        }
    }

}
