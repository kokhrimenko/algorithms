package com.study.kokhrimenko.algoriths.external.coursera.geometry.colinear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Examines 4 points at a time and checks whether they all lie on the same line segment, returning all such line segments.
 * To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes between p and q,
 * between p and r, and between p and s are all equal.
 * 
 * The method segments() should include each line segment containing 4 points exactly once.
 * If 4 points appear on a line segment in the order p→q→r→s, then you should include either the line segment p→s or s→p (but not both) and you should not include
 * subsegments such as p→r or q→r. For simplicity, we will not supply any input to BruteCollinearPoints that has 5 or more collinear points.
 * 
 * Algorithm:
 *   - Think of p as the origin;
 *   - For each other point q, determine the slope it makes with p;
 *   - Sort the points according to the slopes they makes with p;
 *   - Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. If so, these points, together with p, are collinear.
 *
 * Corner cases. Throw an IllegalArgumentException if the argument to the constructor is null, if any point in the array is null, or if the argument to 
 * the constructor contains a repeated point.
 *
 * Performance requirement. The order of growth of the running time of your program should be n2 log n in the worst case and it should use space proportional to n plus
 * the number of line segments returned. FastCollinearPoints should work properly even if the input has 5 or more collinear points.
 *
 * @author kostic
 *
 */
public class FastCollinearPoints {

    private final List<LineSegment> linesWith4Points = new ArrayList<>();

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points) {
        if (points == null || points.length == 0) {
            throw new NullPointerException("The input array of points can't be NULL or empty.");
        }
        for (Point point : points) {
            if (point == null) {
                throw new NullPointerException("Noone's of the input array of points can't be NULL");
            }
        }
        Point[] internalArray = new Point[points.length];
        System.arraycopy(points, 0, internalArray, 0, points.length);
        Arrays.sort(internalArray);
        for (int i = 0; i < internalArray.length - 2; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicated points are not allowed as an input.");
            }
        }
        int length = internalArray.length;
        for (int i = 0; i < length; i++) {
            Point pointP = internalArray[i];
            Point[] pointsBySlope = internalArray.clone();
            Arrays.sort(pointsBySlope, pointP.slopeOrder());
            int j = 1;
            while (j < length) {
                List<Point> potentialSegmentSlope = new ArrayList<>();
                final double currentSlope = pointP.slopeTo(pointsBySlope[j]);
                do {
                    potentialSegmentSlope.add(pointsBySlope[j++]);
                } while (j < length && Double.compare(currentSlope, pointP.slopeTo(pointsBySlope[j])) == 0);

                if (potentialSegmentSlope.size() >= 3 && pointP.compareTo(potentialSegmentSlope.get(0)) < 0) {
                    Point lastSegmentPoint = potentialSegmentSlope.get(potentialSegmentSlope.size() - 1);
                    linesWith4Points.add(new LineSegment(pointP, lastSegmentPoint));
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return linesWith4Points.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return linesWith4Points.toArray(new LineSegment[0]);
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        /*Point[] points = { new Point(19000, 10000), new Point(18000, 10000), new Point(32000, 10000), new Point(21000, 10000), new Point(1234, 5678),
                new Point(14000, 10000) };*/
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw(); 
        }
        StdDraw.show();
    }
}
