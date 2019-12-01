package in.bitcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) {

        try {

            Circle c1 = Circle.class.newInstance();
            c1.draw();

            Method m1 = c1.getClass()
                    .getMethod("getR", null );
            m1.invoke(c1, null);

            int i = 1;
            Shape s;

            if( i == 1 ) {
                s = new Circle();
            }
            else {
                s = new Rect();
            }

            s.getClass().newInstance(); //preferred

            if( s.getClass().getName().equals("in.bitcode.Circle")) {

            }
            if( s.getClass().getName().equals("in.bitcode.Rect")) {

            }
            if( s.getClass() == Circle.class ) {
                new Circle();
            }

            s = new Circle();
            if( s instanceof Circle ) {
                ((Circle) s).getR();
            }



        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*printClassInfo(Main.class);
        printClassInfo(Shape.class);
        printClassInfo(Circle.class);
        printClassInfo(Rect.class);*/

    }

    public static void printClassInfo(Class c) {
        System.out.println("Name: " + c.getName());
        System.out.println("Base: " + c.getSuperclass().getName());
        System.out.println("Package: " + c.getPackage().getName());

        Method[] methods = c.getMethods();
        System.out.println("Methods: ");
        for (Method m : methods) {
            System.out.println(
                    "\t" + m.getReturnType()+
                            "  " + m.getName() +
                            "  " + m.getParameterCount()
            );
            Parameter [] parameters = m.getParameters();
            for( Parameter p : parameters ) {
                System.out.println( "\t\t" + p.getType().getName() + "  " + p.getName() );
            }
        }

        System.out.println();
        System.out.println();
    }
}
