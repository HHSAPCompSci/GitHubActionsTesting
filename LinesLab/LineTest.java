import kchandra423.kTesting.KException;
import processing.core.PApplet;

import static kchandra423.kTesting.KAssertion.kAssertFalse;
import static kchandra423.kTesting.KAssertion.kAssertTrue;

public class LineTest {
    public static void main(String[] args) {
//        testDraw();
//        testPointCollisions();
//        testReversedPointCollisions();
//        testIntersectingLines();
//        testHorizontalLines();
//        testVerticalLines();
//        testHorizontalAndVerticalLines();
//        testParallelLines();
//        testCollinearLine();
//        testIntersectingLines();
//        testNonIntersectingLines();
//        testConstructor();
//        testSetPoint2();
//        testIntersectionY();
//        testIntersectionY();
//        testIntersects();
        String arg = args[0];
        switch (arg) {
            case "vertical":
                testVerticalLines();
                break;
            case "parallel":
                testParallelLines();
                break;
            case "intersecting":
                testIntersectingLines();
                break;
            case "non_intersecting":
                testNonIntersectingLines();
                break;
            case "collinear":
                testCollinearLine();
                break;
            case "horizontal":
                testHorizontalLines();
                break;
            case "horizontal and vertical":
                testHorizontalAndVerticalLines();
                break;
            case "reversed points":
                testReversedPointCollisions();
                break;
            case "point":
                testPointCollisions();
                break;
            case "exists_constructor":
                testConstructor();
                break;
            case "exists_setPoint2":
                testSetPoint2();
                break;
            case "exists_draw":
                testDraw();
                break;
            case "exists_getIntersectionX":
                testIntersectionX();
                break;
            case "exists_getIntersectionY":
                testIntersectionY();
                break;
            case "exists_intersects":
                testIntersects();
                break;
        }
    }

    public static void testReversedPointCollisions() {
        Line l1 = new Line(0, 0, 10, 10);
        Line l2 = new Line(0, 10, 10, 9);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(10, 9, 0, 10);
        kAssertTrue("intersects", l1, l2);
    }

    public static void testPointCollisions() {
        Line l1 = new Line(0, 0, 10, 10);
        Line l2 = new Line(0, 0, 10, 0);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(5, 5, 5, 10);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(-5, 5, 5, -5);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(10, 0, 10, 15);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(10, 0, 10, 10);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(10, 10, 0, 10);
        kAssertTrue("intersects", l1, l2);
    }

    public static void testIntersectingLines() {
        Line l1 = new Line(0, 0, 10, 10);
        Line l2 = new Line(0, 10, 10, 0);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(0, 5, 10, 5);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(5, 0, 6, 10);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(4, 5, 6, 3);
        kAssertTrue("intersects", l1, l2);
        l1.setPoint2(5, 6);
        kAssertTrue("intersects", l1, l2);
    }

    public static void testNonIntersectingLines() {
        Line l1 = new Line(0, 0, 10, 10);
        Line l2 = new Line(0, 5, 5, 10);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(5, 0, 10, 5);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(5, 10, 15, 11);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(0, 0.01, 10.01, 10.01);
        kAssertFalse("intersects", l1, l2);
    }

    public static void testCollinearLine() {
        Line l1 = new Line(0, 0, 10, 10);
        Line l2 = new Line(-5, -5, 5, 5);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(-10, -10, -1, -1);
        kAssertFalse("intersects", l1, l2);
        l2.setPoint2(15, 15);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(0, 0, 10, 10);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(2, 2, 7, 7);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(11, 11, 15, 15);
        kAssertFalse("intersects", l1, l2);
    }

    public static void testParallelLines() {
        Line l1 = new Line(0, 0, 10, 10);
        Line l2 = new Line(0, 1, 10, 11);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(0, -1, 0, 9);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(-1, -1, 9, 9);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(1, 1, 11, 11);
        kAssertTrue("intersects", l1, l2);
    }

    public static void testVerticalLines() {
        Line l1 = new Line(0, 0, 0, 10);
        Line l2 = new Line(1, 0, 1, 10);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(-1, 0, -1, 10);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(-1, -1, -1, 9);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(0, -1, 0, 9);
        //doesn't work with parallel vertical lines
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(0, 1, 0, 11);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(1, 1, 1, 11);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(0, 0, 0, 10);
        kAssertTrue("intersects", l1, l2);
    }

    public static void testHorizontalLines() {
        Line l1 = new Line(0, 0, 10, 0);
        Line l2 = new Line(5, 1, 15, 1);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(5, 0, 15, 0);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(0, 0, 10, 0);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(-5, 0, 5, 0);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(-5, -1, 5, -1);
        kAssertFalse("intersects", l1, l2);
    }

    public static void testHorizontalAndVerticalLines() {
        Line l1 = new Line(0, 0, 10, 0);
        Line l2 = new Line(5, -5, 5, 5);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(0, -5, 0, 5);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(10, -5, 10, 5);
        kAssertTrue("intersects", l1, l2);
        l2 = new Line(-5, -5, -5, 5);
        kAssertFalse("intersects", l1, l2);
        l2 = new Line(15, -5, 15, 5);
        kAssertFalse("intersects", l1, l2);
    }

    public static void testConstructor() {
        try {
            Line.class.getConstructor(double.class, double.class, double.class, double.class);
        } catch (Exception e) {
            throw new KException("Could not find constructor in Line with 4 doubles as parameters");
        }
    }

    public static void testSetPoint2() {
        try {
            Line.class.getMethod("setPoint2", double.class, double.class);
        } catch (Exception e) {
            throw new KException("setPoint2", Line.class, double.class, double.class);
        }
    }

    public static void testDraw() {
        try {
            Line.class.getMethod("draw", PApplet.class);
        } catch (Exception e) {
            throw new KException("draw", Line.class, PApplet.class);
        }
    }

    public static void testIntersectionX() {
        try {
            Line.class.getMethod("getIntersectionX", Line.class);
        } catch (Exception e) {
            throw new KException("getIntersectionX", Line.class, Line.class);
        }
    }

    public static void testIntersectionY() {
        try {
            Line.class.getMethod("getIntersectionY", Line.class);
        } catch (Exception e) {
            throw new KException("getIntersectionY", Line.class, Line.class);
        }
    }

    public static void testIntersects() {
        try {
            Line.class.getMethod("intersects", Line.class);
        } catch (Exception e) {
            throw new KException("intersects", Line.class, Line.class);
        }
    }
}
