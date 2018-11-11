package PR;

import PR.PicturePack.MyPicture;

import java.util.Scanner;

public class Histogram_test {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Set image size: n (#rows), m (#kolumns)");

        var n = scanner.nextInt();
        var m = scanner.nextInt();
        var picture = new MyPicture(n, m);
        var v = new Versions();

        v.version0(picture);
        v.version1(picture);
        v.version2(picture, n);
        v.version3(picture, n);
        v.version3a(picture, Runtime.getRuntime().availableProcessors());
        v.version4(picture, m);
        v.version4a(picture, Runtime.getRuntime().availableProcessors());
        v.version5(picture, n, m);
        v.version5a(picture, n, m, Runtime.getRuntime().availableProcessors());
        picture.printShortHistogram();
    }

    static void v0(MyPicture picture) {
        picture.calculate_histogram();
        picture.print_histogram();
    }
}
