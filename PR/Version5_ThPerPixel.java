package PR;

import PR.PicturePack.MyPicture;
import PR.ThreadPack.HistogramThread;
import PR.ThreadPack.HistogramThread_v5_PerPixel;

class Version5_ThPerPixel {
    static void v5(int nThreads, int mThreads, MyPicture picture) {

        var histogramThArray = new HistogramThread[nThreads][mThreads];

        var c = 0;
        for (var i = 0; i < nThreads; i++)
            for (var j = 0; j < mThreads; j++, c++)
                (histogramThArray[i][j] = new HistogramThread_v5_PerPixel(i, j, c, picture)).start();

        for (var i = 0; i < nThreads; i++)
            for (var j = 0; j < mThreads; j++)

                try {
                    histogramThArray[i][j].join();
                } catch (InterruptedException ignored) {
                }
    }

    static void v5Seq(int nSize, int mSize, int divider, MyPicture picture) {

        var n = (double) nSize / divider;
        n = (n % (int) n) == 0 ? (int) n : (int) n + 1;

        var m = (double) mSize / divider;
        m = (m % (int) m) == 0 ? (int) m : (int) m + 1;

        var histogramThArray = new HistogramThread[divider][divider];

        var c = 0;
        for (var i = 0; i < divider; i++)
            for (var j = 0; j < divider; j++, c++)
                (histogramThArray[i][j]
                        = new HistogramThread_v5_PerPixel(
                        i, j, c, (int) n, (int) m, picture
                )).start();

        for (var i = 0; i < divider; i++)
            for (var j = 0; j < divider; j++)
                try {
                    histogramThArray[i][j].join();
                } catch (InterruptedException ignored) {
                }
    }
}
