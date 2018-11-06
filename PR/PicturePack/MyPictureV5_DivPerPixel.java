package PR.PicturePack;

public class MyPictureV5_DivPerPixel extends MyPictureV4_DivPerColumn {
    MyPictureV5_DivPerPixel(int n, int m) {
        super(n, m);
    }

    //    private ArrayList<Integer> changedState;
    private int changedState;

    public void calculateHistogramPartByOnePicture(int nStop, int mStop) {
//        changedState = new ArrayList<>();
        for (var k = 0; k < histogramSize; k++)
            if (this.pictureCharArray[nStop][mStop] == (char) (k + 33)) {
                this.histogramIntArray[k]++;
                changedState = k;
//                changedState.add(k);
            }
    }

    public void printHistogramPartByOnePicture() {
//        for (var i : changedState) {
        System.out.print("{" + Thread.currentThread().getName() + "} [" /*  */
                + String.format("%03d", changedState + 33) + "] "
                + (char) (changedState + 33) + " "
                + charsForNumberOfOccurrences(histogramIntArray[changedState]) + "\n");
    }
}
