/*
filename:hw1004_2
funtion:calculate the distance between a 2D data point and a line. user can input the line and the data point.
author:41243232
date:2024/10/04
version:jdk23
*/
import java.util.Scanner;

public class hw1004_2 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double dA, dB, dC, dX, dY, dDis;

        System.out.print("input A : ");
        dA = scn.nextDouble();
        System.out.print("input B : ");
        dB = scn.nextDouble();
        System.out.print("input C : ");
        dC = scn.nextDouble();
        System.out.print("input x : ");
        dX = scn.nextDouble();
        System.out.print("input y : ");
        dY = scn.nextDouble();

        dDis = Math.abs(dA * dX + dB * dY + dC) / Math.sqrt(dA * dA + dB * dB); //https://www.youtube.com/watch?v=o2tvjpux0GU&t=288s
        System.out.println("distance: " + dDis);
    }
}
