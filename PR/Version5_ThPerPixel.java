package PR;

import PR.PicturePack.MyPicture;
import PR.ThreadPack.HistogramThread;
import PR.ThreadPack.HistogramThread_v5_PerPixel;

public class Version5_ThPerPixel {
    static void v5(int nThreads, int mThreads, MyPicture picture) {

        var histogramThArray = new HistogramThread[nThreads][mThreads];

        for (var i = 0; i < nThreads; i++)
            for (var j = 0; j < mThreads; j++)
                (histogramThArray[i][j] = new HistogramThread_v5_PerPixel(i, j, picture)).start();


        for (var i = 0; i < nThreads; i++)
            for (var j = 0; j < mThreads; j++)

                try {
                    histogramThArray[i][j].join();
                } catch (InterruptedException ignored) {
                }
    }
}
