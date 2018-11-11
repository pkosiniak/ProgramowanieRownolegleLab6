package PR;

import PR.PicturePack.MyPicture;

import static PR.Histogram_test.v0;
import static PR.Version1_ThPerChar.v1;
import static PR.Version2_ThPerCharBlock.v2;
import static PR.Version3_ThPerLine.v3;
import static PR.Version3_ThPerLine.v3Seq;
import static PR.Version4_ThPerColumn.v4;
import static PR.Version4_ThPerColumn.v4Seq;
import static PR.Version5_ThPerPixel.v5;
import static PR.Version5_ThPerPixel.v5Seq;

public class Versions {
    Versions() {
    }

    void version0(MyPicture picture) {
        System.out.println("\nv0\n");
        v0(picture);
    }

    void version1(MyPicture picture) {
        picture.clear_histogram();
        System.out.println("\nv1\n");
        v1(picture);
    }

    void version2(MyPicture picture, int n) {
        picture.clear_histogram();
        System.out.println("\nv2\n");
        v2(n, picture);
    }

    void version3(MyPicture picture, int n) {
        picture.clear_histogram();
        System.out.println("\nv3\n");
        v3(n, picture);
    }

    void version3a(MyPicture picture, int step) {
        picture.clear_histogram();
        System.out.println("\nv3a\n");
        v3Seq(step, picture);
    }

    void version4(MyPicture picture, int m) {
        picture.clear_histogram();
        System.out.println("\nv4\n");
        v4(m, picture);
    }

    void version4a(MyPicture picture, int step) {
        picture.clear_histogram();
        System.out.println("\nv4a\n");
        v4Seq(step, picture);
    }

    void version5(MyPicture picture, int n, int m) {
        picture.clear_histogram();
        System.out.println("\nv5\n");
        v5(n, m, picture);
    }

    void version5a(MyPicture picture, int n, int m, int div) {
        picture.clear_histogram();
        System.out.println("\nv5a\n");
        v5Seq(n, m, div, picture);
    }
}
