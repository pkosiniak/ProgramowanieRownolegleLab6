package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v3_PerLine implements Runnable, HistogramThread {

    private int tCase;
    private int numOfTasks;
    private Thread myThread;
    private int myTaskNumber;
    private MyPicture picture;

    public HistogramThread_v3_PerLine(int taskNumber, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;
        this.tCase = 0;

        myThread = new Thread(this, String.format("%02d", taskNumber));
    }

    public HistogramThread_v3_PerLine(int taskNumber, int numOfTasks, MyPicture picture) {
        this.picture = picture;
        this.myTaskNumber = taskNumber;
        this.numOfTasks = numOfTasks;
        this.tCase = 1;

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
                simpleV3();
                break;
            case 1:
                cycleV3();
                break;
            default:
                break;
        }
    }

    private void simpleV3() {
        synchronized (picture) {
            picture.calculateHistPartByPicLine(myTaskNumber);
            picture.printHistPartByPicLine();

        }
    }

    private void cycleV3() {
        synchronized (picture) {
            picture.calculateHistPartByPicLine(myTaskNumber, numOfTasks);
            picture.printHistPartByPicLine();

        }
    }
}
