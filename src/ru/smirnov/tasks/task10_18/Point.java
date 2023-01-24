package ru.smirnov.tasks.task10_18;

public class Point {
    private final double X;
    private final double Y;
    private final int QUARTER;

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
    public int getQUARTER() {
        return QUARTER;
    }

    public Point(double x, double y) {
        X = x;
        Y = y;
        QUARTER = quarter(x, y);
    }

    public static int quarter(double x, double y) {
        if (x >= 0) {
            if (y >= 0) {
                return 1;
            }
            if (y <= 0) {
                return 4;
            }
        }
        if (x <= 0) {
            if (y >= 0) {
                return 2;
            }
            if (y <= 0) {
                return 3;
            }
        }
        return 0;
    }


}
