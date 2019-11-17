package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageUtil {
    private ImageUtil() {

    }

    public static int[][] getChangedArea(String image1, String image2) {
        int[] rgb1 = new int[3], rgb2 = new int[3];
        File file1 = new File(image1);
        File file2 = new File(image2);
        BufferedImage bi1 = null, bi2 = null;
        try {
            bi1 = ImageIO.read(file1);
            bi2 = ImageIO.read(file2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi1.getWidth();
        int height = bi1.getHeight();
        int minx = bi1.getMinX();
        int miny = bi1.getMinY();
        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");

        int[][] pixels = new int[width][height];
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel1 = bi1.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
                rgb1[0] = (pixel1 & 0xff0000) >> 16;
                rgb1[1] = (pixel1 & 0xff00) >> 8;
                rgb1[2] = (pixel1 & 0xff);

                int pixel2 = bi2.getRGB(i, j);
                rgb2[0] = (pixel2 & 0xff0000) >> 16;
                rgb2[1] = (pixel2 & 0xff00) >> 8;
                rgb2[2] = (pixel2 & 0xff);


                pixels[i][j] = Math.abs(rgb1[0]-rgb2[0])+Math.abs(rgb1[1]-rgb2[1])+Math.abs(rgb1[2]-rgb2[2]);

                if (pixels[i][j] < 100) {
                    pixels[i][j] = 0;
                }
//                System.out.println("i=" + i + ",j=" + j + ":(" + rgb1[0] + ","
//                        + rgb1[1] + "," + rgb1[2] + ")");
            }
        }

//        for (int i = minx; i < width; i++) {
//            for (int j = miny; j < height; j++) {
//                pixels[i][j] = bi.getRGB(i, j);
//            }
//        }



        return pixels;

    }


//    public static int[][] getImagePixel(String image) {
//        int[] rgb = new int[3];
//        File file = new File(image);
//        BufferedImage bi = null;
//        try {
//            bi = ImageIO.read(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int width = bi.getWidth();
//        int height = bi.getHeight();
//        int minx = bi.getMinX();
//        int miny = bi.getMinY();
//        System.out.println("width=" + width + ",height=" + height + ".");
//        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
////        for (int i = minx; i < width; i++) {
////            for (int j = miny; j < height; j++) {
////                int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
////                rgb[0] = (pixel & 0xff0000) >> 16;
////                rgb[1] = (pixel & 0xff00) >> 8;
////                rgb[2] = (pixel & 0xff);
////                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
////                        + rgb[1] + "," + rgb[2] + ")");
////            }
////        }
//
//        int[][] pixels = new int[width][height];
//        for (int i = minx; i < width; i++) {
//            for (int j = miny; j < height; j++) {
//                pixels[i][j] = bi.getRGB(i, j);
//            }
//        }
//
//        return pixels;
//
//    }

}
