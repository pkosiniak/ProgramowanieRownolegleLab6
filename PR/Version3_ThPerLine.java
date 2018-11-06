package PR;

import PR.PicturePack.MyPicture;
import PR.ThreadPack.HistogramThread;
import PR.ThreadPack.HistogramThread_v3_PerLine;

class Version3_ThPerLine {
    static void v3(int numberOfThreads, MyPicture picture) {

        var histogramThArray = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++)
            (histogramThArray[i] = new HistogramThread_v3_PerLine(i, picture)).start();

        for (var i = 0; i < numberOfThreads; i++)
            try {
                histogramThArray[i].join();
            } catch (InterruptedException ignored) {
            }
    }

    static void v3Seq(int numberOfThreads, MyPicture picture){
        var histogramThArray = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++)
            (histogramThArray[i] = new HistogramThread_v3_PerLine(i, picture)).start();

        for (var i = 0; i < numberOfThreads; i++)
            try {
                histogramThArray[i].join();
            } catch (InterruptedException ignored) {
            }
    }
}
