import kchandra423.kTesting.KException;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static kchandra423.kTesting.KAssertion.*;

public class ShapesTest {

    public static void main(String[] args) throws Exception {
        String choice = args[0];
        if (choice.equals("all")) {
            Method[] methods = ShapesTest.class.getMethods();
            for (Method m :
                    methods) {
                if (!m.getName().equals("main") && Modifier.isPublic(m.getModifiers()) && Modifier.isStatic(m.getModifiers())) {
                    m.invoke(null);
                }
            }
        } else {
            Method m = ShapesTest.class.getMethod(choice);
            m.invoke(null);
        }
    }

    public static void existsShape() {
        getClass("Shape");
    }

    public static void existsCircle() {
        getClass("Circle");
    }

    public static void existsRectangle() {
        getClass("Rectangle");
    }

    public static void existsNoArgConstructorRectangle() {
        kAssertConstructorExists(getClass("Rectangle"));
    }

    public static void existsNoArgConstructorCircle() {
        kAssertConstructorExists(getClass("Circle"));
    }

    public static void existsConstructorRectangle() {
        kAssertConstructorExists(getClass("Rectangle"), double.class, double.class, double.class, double.class);
    }

    public static void existsConstructorCircle() {
        kAssertConstructorExists(getClass("Circle"), double.class, double.class, double.class);
    }

    public static void existsIsPointInsideRectangle() {
        Object rec1 = getRectangle();
        kAssertMethodExists("isPointInside", rec1, double.class, double.class);
    }

    public static void existsIsPointInsideCircle() {
        Object rec1 = getCircle();
        kAssertMethodExists("isPointInside", rec1, double.class, double.class);
    }

    public static void existsGetPerimeterRectangle() {
        Object rec1 = getRectangle();
        kAssertMethodExists("getPerimeter", rec1);
    }

    public static void existsGetPerimeterCircle() {
        Object rec1 = getCircle();
        kAssertMethodExists("getPerimeter", rec1);
    }

    public static void existsGetAreaRectangle() {
        Object rec1 = getRectangle();
        kAssertMethodExists("getArea", rec1);
    }

    public static void existsGetAreaCircle() {
        Object rec1 = getCircle();
        kAssertMethodExists("getArea", rec1);
    }

    public static void isPointInsideRectangleEdges() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertTrue("isPointInside", rec1, 0., 5.);
        kAssertTrue("isPointInside", rec1, 10., 0.);
        kAssertTrue("isPointInside", rec1, 10., 20.);
        kAssertTrue("isPointInside", rec1, 0., 20.);
        kAssertTrue("isPointInside", rec1, 5., 20.);
    }

    public static void isPointInsideCircleEdges() {
        Object rec1 = getCircle(0, 0, 20);
        kAssertTrue("isPointInside", rec1, 0., 10.);
        kAssertTrue("isPointInside", rec1, 10., 0.);
        kAssertTrue("isPointInside", rec1, -10., 0.);
        kAssertTrue("isPointInside", rec1, 0., -10.);
        kAssertTrue("isPointInside", rec1, 8., -6.);
        kAssertTrue("isPointInside", rec1, -6., 8.);
        kAssertTrue("isPointInside", rec1, 6., -8.);
    }

    public static void isPointInsideRectangleInside() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertTrue("isPointInside", rec1, 5., 10.);
        kAssertTrue("isPointInside", rec1, 7., 15.);
        kAssertTrue("isPointInside", rec1, 2., 5.);
    }

    public static void isPointInsideCircleInside() {
        Object rec1 = getCircle(0, 0, 10);
        kAssertTrue("isPointInside", rec1, 0., 0.);
        kAssertFalse("isPointInside", rec1, 5., 15.);
        kAssertTrue("isPointInside", rec1, 2., 4.);
        kAssertFalse("isPointInside", rec1, 10., 10.);
    }

    public static void isPointInsideRectangleOutside() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertFalse("isPointInside", rec1, 11., 10.);
        kAssertFalse("isPointInside", rec1, -1., 10.);
        kAssertFalse("isPointInside", rec1, 5., -1.);
        kAssertFalse("isPointInside", rec1, 5., 21.);
        kAssertFalse("isPointInside", rec1, 11., -1.);
        kAssertFalse("isPointInside", rec1, 11., 21.);
    }

    public static void isPointInsideCircleOutside() {
        Object rec1 = getCircle(0, 0, 20);
        kAssertFalse("isPointInside", rec1, 11., 10.);
        kAssertFalse("isPointInside", rec1, -1., 10.);
        kAssertFalse("isPointInside", rec1, 10., -1.);
        kAssertFalse("isPointInside", rec1, 5., 21.);
        kAssertFalse("isPointInside", rec1, 11., -1.);
        kAssertFalse("isPointInside", rec1, 11., 21.);
    }

    public static void getPerimeterRectangle() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertEquals("getPerimeter", rec1, 60.);
        rec1 = getRectangle(0, 0, 10, 10);
        kAssertEquals("getPerimeter", rec1, 40.);
        rec1 = getRectangle(0, 0, 20, 20);
        kAssertEquals("getPerimeter", rec1, 80.);
        rec1 = getRectangle(0, 0, 10, 5);
        kAssertEquals("getPerimeter", rec1, 30.);
    }

    public static void getPerimeterCircle() {
        Object rec1 = getCircle(0, 0, 20);
        kAssertEquals("getPerimeter", rec1, Math.PI * 20);
        rec1 = getCircle(0, 0, 10);
        kAssertEquals("getPerimeter", rec1, Math.PI * 10);
        rec1 = getCircle(0, 0, 15);
        kAssertEquals("getPerimeter", rec1, Math.PI * 15);
        rec1 = getCircle(0, 0, 5);
        kAssertEquals("getPerimeter", rec1, Math.PI * 5);
    }

    public static void getAreaRectangle() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertEquals("getArea", rec1, 200.);
        rec1 = getRectangle(0, 0, 10, 10);
        kAssertEquals("getArea", rec1, 100.);
        rec1 = getRectangle(0, 0, 20, 20);
        kAssertEquals("getArea", rec1, 400.);
        rec1 = getRectangle(0, 0, 10, 5);
        kAssertEquals("getArea", rec1, 50.);
    }

    public static void getAreaCircle() {
        Object rec1 = getCircle(0, 0, 10);
        kAssertEquals("getArea", rec1, Math.PI * Math.pow((10. / 2), 2));
        rec1 = getCircle(0, 0, 15);
        kAssertEquals("getArea", rec1, Math.PI * Math.pow((15. / 2), 2));
        rec1 = getCircle(0, 0, 20);
        kAssertEquals("getArea", rec1, Math.PI * Math.pow((20. / 2), 2));
        rec1 = getCircle(0, 0, 8);
        kAssertEquals("getArea", rec1, Math.PI * Math.pow((8. / 2), 2));
    }

    public static void rectangleExtendsShape() {
        Class shape = getClass("Shape");
        Class rectangle = getClass("Rectangle");
        Class superClass = rectangle.getSuperclass();
        kAssertTrue("equals", shape, superClass);
    }

    public static void circleExtendsShape() {
        Class shape = getClass("Shape");
        Class rectangle = getClass("Circle");
        Class superClass = rectangle.getSuperclass();
        kAssertTrue("equals", shape, superClass);
    }

    private static Class getClass(String className) {
        String foundClass = getFullyQualifiedName(className);
        if (foundClass == null) {
            throw new KException(className);
        }
        try {
            return Class.forName(foundClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getCircle() {
        try {
            return getClass("Circle").newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getRectangle() {
        try {
            return getClass("Rectangle").newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getRectangle(double x, double y, double width, double height) {
        try {
            return getClass("Rectangle").getConstructor(double.class, double.class, double.class, double.class).newInstance(x, y, width, height);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getCircle(double x, double y, double diameter) {
        try {
            return getClass("Circle").getConstructor(double.class, double.class, double.class).newInstance(x, y, diameter);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getFullyQualifiedName(String className) {
        File src = null;
        if (System.getProperty("os.name").contains("win")) {
            src = new File(System.getProperty("user.dir"));
        } else {
            src = new File(System.getProperty("user.dir") + "/src");
        }
        return getFullyQualifiedName(src, className, "");
    }

    private static String getFullyQualifiedName(File dir, String className, String current) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                String val = getFullyQualifiedName(file, className, current + file.getName() + ".");
                if (val != null) {
                    return val;
                }
            } else if (file.getName().equals(className + ".java")) {
                return current + className;
            }
        }
        return null;
    }


}
