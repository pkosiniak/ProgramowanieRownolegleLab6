package PR;

class Version3 {
    static void v3(int numberOfThreads, MyPicture picture) {

        var histogramThArray = new HistogramThread[numberOfThreads];

        for (var i = 0; i < numberOfThreads; i++)
            (histogramThArray[i] = new HistogramThread3(i, picture)).start();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        picture.printShortHistogram();

        for (var i = 0; i < numberOfThreads; i++)
            try {
                histogramThArray[i].join();
            } catch (InterruptedException ignored) {
            }
    }
}
