package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v1_PerChar implements Runnable, HistogramThread {

    private Thread myThread;
    private int myTaskNumber;
    private final MyPicture picture;

    public HistogramThread_v1_PerChar(int taskNumber, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;

        myThread = new Thread(this, String.format("%02d", taskNumber));
    }

    @Override
    public void start() {
        myThread.start();
    }

    @Override
    public void join() throws InterruptedException {
        this.myThread.join();
    }

    @Override
    public void run() {
        synchronized (picture) {
            picture.calculateHistogramPartByHA(myTaskNumber);
            picture.printHistogramPartByHA(myTaskNumber);
        }
    }
}
