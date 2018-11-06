package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v5_PerPixel implements Runnable, HistogramThread {

    private Thread myThread;
    private int nTaskNumber;
    private MyPicture picture;
    private int mTaskNumber;


    public HistogramThread_v5_PerPixel(int nTaskNumber, int mTaskNumber, MyPicture picture) {
        this.picture = picture;
        this.nTaskNumber = nTaskNumber;
        this.mTaskNumber = mTaskNumber;

        myThread = new Thread(this, String.format("%02d", nTaskNumber));
    }

    public void start() {
        myThread.start();
    }

    public void join() throws InterruptedException {
        this.myThread.join();
    }

    @Override
    public void run() {
        synchronized (picture) {
            picture.calculateHistogramPartByOnePicture(nTaskNumber, mTaskNumber);
            picture.printHistogramPartByOnePicture();
        }
    }
}