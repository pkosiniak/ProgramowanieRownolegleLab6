package PR;

class Version1 {
    static void v1(MyPicture picture) {

        var numberOfThreads = picture.getHistogramIntArray().length;
        var singleHistogramCounterThA = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++) {
            (singleHistogramCounterThA[i] = new HistogramThread1(i, picture)).start();
        }

        for (var i = 0; i < numberOfThreads; i++) {
            try {
                singleHistogramCounterThA[i].join();
            } catch (InterruptedException ignored) {
            }
        }
    }
}
