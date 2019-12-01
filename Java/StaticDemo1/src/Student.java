import java.util.Random;

public class Student {

    private int roll;
    private String name;

    private static String college = "XYZ";
    private static int nextRoll;

    static {
        //some instructions here
        Random random = new Random();
        nextRoll = Math.abs( random.nextInt() ) % 100;
    }

    public Student( String name) {
        this.roll = nextRoll;
        nextRoll++;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public void display() {
        System.out.println( roll + " " + name + " " + college);
        getCollege();
    }
}
