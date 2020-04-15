package com.study.kokhrimenko.algoriths.external.coursera.geometry;

import lombok.Data;

@Data
public class Point2D {

    private final double x;
    private final double y;

    /**
     * Return positions of the points relative to each other.
     * 
     * @param pointA
     * @param pointB
     * @param pointC
     * @return
     *      -1 - clockwise;
     *      1 - counter - clockwise;
     *      0 - collinear.
     */
    public static int ccw(Point2D pointA, Point2D pointB, Point2D pointC) {
        double area = (pointB.getX() - pointA.getX()) * (pointC.getY() - pointA.getY()) - (pointB.getY() - pointA.getY()) * (pointC.getX() - pointA.getX());
        // clockwise
        if (area < 0) {
            return -1;
        }
        // counter - clockwise
        if (area > 0) {
            return 1;
        }
        return 0;
    }
}
