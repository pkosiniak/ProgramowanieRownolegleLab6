package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v4_PerColumn implements Runnable, HistogramThread {

    private Thread myThread;
    private int myTaskNumber;
    private MyPicture picture;

    public HistogramThread_v4_PerColumn(int taskNumber, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;

        myThread = new Thread(this, String.format("%02d", taskNumber));
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
            picture.calculateHistogramPartByPictureVertical(myTaskNumber);
            picture.printHistogramPartByPictureVertical();
        }
    }
}