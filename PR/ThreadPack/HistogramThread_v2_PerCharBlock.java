package PR.ThreadPack;


import PR.PicturePack.MyPicture;

public class HistogramThread_v2_PerCharBlock implements Runnable, HistogramThread {

    private Thread myThread;
    private int myTaskNumber;
    private final MyPicture picture;
    private int part;

    public HistogramThread_v2_PerCharBlock(int taskNumber, int part, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;

        myThread = new Thread(this, String.format("%02d", taskNumber));
        this.part = part;
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
            picture.calculateHistogramPartByHA(myTaskNumber, part);
            picture.printHistogramPartByHA(myTaskNumber, part);
        }
    }
}
