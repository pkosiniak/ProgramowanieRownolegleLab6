package PR;


public class HistogramThread2 implements Runnable, HistogramThread {


    //region init
    private Thread myThread;
    private int myTaskNumber;
    private MyPicture picture;
    private int part;

    public HistogramThread2(int taskNumber, int part, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;

        myThread = new Thread(this, String.format("%02d", taskNumber));
        this.part = part;
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
            picture.calculateHistogramPartByHA(myTaskNumber, part);
//        }
//        synchronized (picture) {
            picture.printHistogramPartByHA(myTaskNumber, part);

        }

    }
    //endregion
}
