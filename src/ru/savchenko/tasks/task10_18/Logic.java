package ru.savchenko.tasks.task10_18;

public class Logic {

    public static boolean[] oneQuarter(Triangle[] triangles) {
        boolean[] inOneQuarter = new boolean[triangles.length];
        for (int i = 0; i < triangles.length; i++) {

            if (triangles[i].getPoint1X() >= 0 && triangles[i].getPoint2X() >= 0 && triangles[i].getPoint3X() >= 0) {
                if (triangles[i].getPoint1Y() >= 0 && triangles[i].getPoint2Y() >= 0 && triangles[i].getPoint3Y() >= 0) {
                    // первая четверть
                    inOneQuarter[i] = true;
                }else if (triangles[i].getPoint1Y() <= 0 && triangles[i].getPoint2Y() <= 0 && triangles[i].getPoint3Y() <= 0) {
                    // четвертая четверть
                    inOneQuarter[i] = true;
                }
            } else if (triangles[i].getPoint1X() <= 0 && triangles[i].getPoint2X() <= 0 && triangles[i].getPoint3X() <= 0) {
                if (triangles[i].getPoint1Y() >= 0 && triangles[i].getPoint2Y() >= 0 && triangles[i].getPoint3Y() >= 0) {
                    // вторая четверть
                    inOneQuarter[i] = true;
                }else if (triangles[i].getPoint1Y() <= 0 && triangles[i].getPoint2Y() <= 0 && triangles[i].getPoint3Y() <= 0) {
                    // третья четверть
                    inOneQuarter[i] = true;
                }
            } else {
                inOneQuarter[i] = false;
            }
        }
        return inOneQuarter;
    }
}
