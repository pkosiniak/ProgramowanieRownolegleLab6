package PR;

import PR.PicturePack.MyPicture;
import PR.ThreadPack.HistogramThread;
import PR.ThreadPack.HistogramThread_v1_PerChar;

class Version1_ThPerChar {
    static void v1(MyPicture picture) {

        var numberOfThreads = picture.getHistogramIntArray().length;
        var singleHistogramCounterThA = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++) {
            (singleHistogramCounterThA[i] = new HistogramThread_v1_PerChar(i, picture)).start();
        }

        for (var i = 0; i < numberOfThreads; i++) {
            try {
                singleHistogramCounterThA[i].join();
            } catch (InterruptedException ignored) {
            }
        }
    }
}
