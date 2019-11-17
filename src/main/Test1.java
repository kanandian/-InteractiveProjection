package main;

import javax.swing.*;

public class Test1 {
    public static void main(String[] args) {
//        int[][] pixel1 = ImageUtil.getImagePixel("images/sun.jpeg");
//        int[][] pixel2 = ImageUtil.getImagePixel("images/sun1.jpeg");

        int[][] pixel = ImageUtil.getChangedArea("images/me1.jpeg", "images/me2.jpeg");

//        for (int i=0;i<pixel1.length;i++) {
//            for (int j=0;j<pixel1.length;j++) {
//                pixel1[i][j] -= pixel2[i][j];
//            }
//        }


        for (int i=0;i<pixel.length;i++) {
            for (int j = 0; j < pixel[i].length; j++) {
                if (pixel[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print("1 ");
                }
//                System.out.print(pixel[i][j]);
            }
            System.out.println();
        }

    }

}



