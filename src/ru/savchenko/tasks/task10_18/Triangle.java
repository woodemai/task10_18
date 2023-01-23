package ru.savchenko.tasks.task10_18;

public class Triangle {
    private final int point1X, point1Y, point2X, point2Y, point3X, point3Y;
    public int getPoint1X() {
        return point1X;
    }
    public int getPoint1Y() {
        return point1Y;
    }
    public int getPoint2X() {
        return point2X;
    }
    public int getPoint2Y() {
        return point2Y;
    }
    public int getPoint3X() {
        return point3X;
    }
    public int getPoint3Y() {
        return point3Y;
    }

    public Triangle(int point1X, int point1Y, int point2X, int point2Y, int point3X, int point3Y) {
        this.point1X = point1X;
        this.point1Y = point1Y;
        this.point2X = point2X;
        this.point2Y = point2Y;
        this.point3X = point3X;
        this.point3Y = point3Y;
    }
}
