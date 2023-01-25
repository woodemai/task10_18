package ru.smirnov.tasks.task10_18;

public class Triangle {
    private final Point POINT1;
    private final Point POINT2;
    private final Point POINT3;

    public Triangle(Point POINT1, Point POINT2, Point POINT3) {
        this.POINT1 = POINT1;
        this.POINT2 = POINT2;
        this.POINT3 = POINT3;
    }

    public Point getPOINT1() {
        return POINT1;
    }

    public Point getPOINT2() {
        return POINT2;
    }

    public Point getPOINT3() {
        return POINT3;
    }
    public static boolean oneQuarter(Triangle triangle) {
        return triangle.getPOINT1().getQUARTER() == triangle.getPOINT2().getQUARTER() && triangle.getPOINT2().getQUARTER() == triangle.getPOINT3().getQUARTER()  && triangle.getPOINT1().getQUARTER() == triangle.getPOINT3().getQUARTER();
    }
}
