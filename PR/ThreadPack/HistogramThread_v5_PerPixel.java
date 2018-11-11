package PR.ThreadPack;

import PR.PicturePack.MyPicture;

public class HistogramThread_v5_PerPixel implements Runnable, HistogramThread {

    private int nSize;
    private int mSize;
    private Thread myThread;
    private int nTaskNumber;
    private MyPicture picture;
    private int mTaskNumber;
    int tCase;


    public HistogramThread_v5_PerPixel(int nTaskNumber, int mTaskNumber, int counter, MyPicture picture) {
        this.picture = picture;
        this.nTaskNumber = nTaskNumber;
        this.mTaskNumber = mTaskNumber;
        tCase = 0;

        myThread = new Thread(this, String.format("%02d", counter));
    }

    public HistogramThread_v5_PerPixel(int nTaskNumber, int mTaskNumber, int counter, int nSize, int mSize, MyPicture picture) {
        this.picture = picture;
        this.nTaskNumber = nTaskNumber;
        this.mTaskNumber = mTaskNumber;
        this.nSize = nSize;
        this.mSize = mSize;
        tCase = 1;

        myThread = new Thread(this, String.format("%02d", counter));
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
                simpleV5();
                break;
            case 1:
                cycleV5();
                break;
            default:
                break;
        }
    }

    private void simpleV5() {
        synchronized (picture) {
            picture.calculateHistPartByPicBlockSize1(nTaskNumber, mTaskNumber);
            picture.printHistPartByPicBlock();
        }
    }

    private void cycleV5() {
        synchronized (picture) {
            picture.calculateHistPartByPictureBlock(
                    nSize * nTaskNumber,
                    mSize * mTaskNumber,
                    (nTaskNumber + 1) * nSize,
                    (mTaskNumber + 1) * mSize
            );
            picture.printHistPartByPicBlock();
        }
    }
}