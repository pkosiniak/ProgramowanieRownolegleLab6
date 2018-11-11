package PR;

import PR.PicturePack.MyPicture;
import PR.ThreadPack.HistogramThread;
import PR.ThreadPack.HistogramThread_v4_PerColumn;

class Version4_ThPerColumn {
    static void v4(int numberOfThreads, MyPicture picture) {

        var histogramThArray = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++)
            (histogramThArray[i] = new HistogramThread_v4_PerColumn(i, picture)).start();

        for (var i = 0; i < numberOfThreads; i++)
            try {
                histogramThArray[i].join();
            } catch (InterruptedException ignored) {
            }
    }

    static void v4Seq(int numberOfThreads, MyPicture picture) {

        var histogramThArray = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++)
            (histogramThArray[i] = new HistogramThread_v4_PerColumn(i, numberOfThreads, picture)).start();

        for (var i = 0; i < numberOfThreads; i++)
            try {
                histogramThArray[i].join();
            } catch (InterruptedException ignored) {
            }
    }
}
