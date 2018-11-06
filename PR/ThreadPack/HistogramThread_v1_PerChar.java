package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v1_PerChar implements Runnable, HistogramThread {


    //region init
    private Thread myThread;
    private int myTaskNumber;
    private MyPicture picture;

    public HistogramThread_v1_PerChar(int taskNumber, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;

        myThread = new Thread(this, String.format("%02d", taskNumber));
    }
    //endregion


    //region ThreadThings
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
//        }
//        synchronized (picture) {
            picture.printHistogramPartByHA(myTaskNumber);
        }

    }
    //endregion


}
