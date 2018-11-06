package PR;

import PR.PicturePack.MyPicture;
import PR.ThreadPack.HistogramThread;
import PR.ThreadPack.HistogramThread_v2_PerCharBlock;

class Version2_ThPerCharBlock {
    static void v2(int numberOfThreads, MyPicture picture) {

        var partial = (double) picture.getHistogramIntArray().length / numberOfThreads;

        if ((partial % (int) partial) != 0)
            numberOfThreads++;
        var histogramThArray = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++) {
            (histogramThArray[i] = new HistogramThread_v2_PerCharBlock(i, (int) partial, picture)).start();
        }

        for (var i = 0; i < numberOfThreads; i++) {
            try {
                histogramThArray[i].join();
            } catch (InterruptedException ignored) {
            }
        }
    }
}
