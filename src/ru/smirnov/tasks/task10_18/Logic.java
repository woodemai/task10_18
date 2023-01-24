package ru.smirnov.tasks.task10_18;

import java.util.ArrayList;

public class Logic {
    public static ArrayList<Triangle> createTriangles(double[][] matrix) {
        ArrayList<Triangle> triangles = new ArrayList<>();
        for (double[] doubles : matrix) {
            Point point1 = new Point(doubles[0], doubles[1]);
            Point point2 = new Point(doubles[2], doubles[3]);
            Point point3 = new Point(doubles[4], doubles[5]);

            triangles.add(new Triangle(point1, point2, point3));
        }
        return triangles;
    }
    public static double[][] createMatrix (ArrayList<Triangle> triangles) {
        double[][] matrix = new double[triangles.size()][6];
        for (int i = 0; i < triangles.size(); i++) {
            matrix[i][0] = triangles.get(i).getPOINT1().getX();
            matrix[i][1] = triangles.get(i).getPOINT1().getY();
            matrix[i][2] = triangles.get(i).getPOINT2().getX();
            matrix[i][3] = triangles.get(i).getPOINT2().getY();
            matrix[i][4] = triangles.get(i).getPOINT3().getX();
            matrix[i][5] = triangles.get(i).getPOINT3().getY();
        }
        return matrix;
    }
}
