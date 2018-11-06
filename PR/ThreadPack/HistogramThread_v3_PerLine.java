package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v3_PerLine implements Runnable, HistogramThread {

    private Thread myThread;
    private int myTaskNumber;
    private MyPicture picture;

    public HistogramThread_v3_PerLine(int taskNumber, MyPicture picture) {
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
        simple();
    }

    void simple(){
        synchronized (picture) {
            picture.calculateHistPartByPicLine(myTaskNumber);
            picture.printHistPartByPicLine();

        }
    }

    void cycle(){
        synchronized (picture) {
            picture.calculateHistPartByPicLine(myTaskNumber);
            picture.printHistPartByPicLine();

        }
    }


}
