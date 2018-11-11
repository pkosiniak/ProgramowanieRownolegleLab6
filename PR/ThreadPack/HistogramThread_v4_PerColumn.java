package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v4_PerColumn implements Runnable, HistogramThread {

    private int numOfTask;
    private Thread myThread;
    private int myTaskNumber;
    private MyPicture picture;
    private int tCase;

    public HistogramThread_v4_PerColumn(int taskNumber, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;
        tCase = 0;

        myThread = new Thread(this, String.format("%02d", taskNumber));
    }

    public HistogramThread_v4_PerColumn(int taskNumber, int numOfTasks, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;
        this.numOfTask = numOfTasks;
        tCase = 1;

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
        switch (tCase) {
            case 0:
                simpleV4();
                break;
            case 1:
                cycleV4();
                break;
            default:
                break;
        }

    }

    private void simpleV4() {
        synchronized (picture) {
            picture.calculateHistPartByPicColumn(myTaskNumber);
            picture.printHistPartByPicColumn();
        }
    }

    private void cycleV4() {
        synchronized (picture) {
            picture.calculateHistPartByPicColumn(myTaskNumber, numOfTask);
            picture.printHistPartByPicColumn();
        }
    }


}