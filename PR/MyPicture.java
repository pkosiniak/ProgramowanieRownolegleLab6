package PR;

public class MyPicture extends MyPictureVersion3 {

    public MyPicture(int n, int m) {
        super(n, m);
    }

    public void printShortHistogram() {
        System.out.println("\nShortcut:\n");
        for (var i = 0; i < histogramSize; i++)
            if (histogramIntArray[i] != 0)
                System.out.print("{" + Thread.currentThread().getName() + "} ["
                        + String.format("%03d", i + 33) + "] "
                        + (char) (i + 33) + " "
                        + charsForNumberOfOccurrences(histogramIntArray[i]) + "\n");
    }
}
