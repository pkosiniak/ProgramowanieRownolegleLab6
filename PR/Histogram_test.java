package PR;

import java.util.Scanner;

import static PR.Version1.v1;
import static PR.Version2.v2;
import static PR.Version3.v3;

public class Histogram_test {


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Set image size: n (#rows), m (#kolumns)");

        var n = scanner.nextInt();
        var m = scanner.nextInt();
        var picture = new MyPicture(n,m);


        System.out.println("\nv0\n");
        v0(picture);

        picture.clear_histogram();
        System.out.println("\nv1\n");
        v1(picture);

        picture.clear_histogram();
        System.out.println("\nv2\n");
        v2(n, picture);

        System.out.println("\nv3\n");
        picture.clear_histogram();
        v3(n, picture);

        picture.printShortHistogram();

    }

    private static void v0(MyPicture picture) {
        picture.calculate_histogram();
        picture.print_histogram();
    }



}
