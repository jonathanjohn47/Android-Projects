public class Student implements Comparable{

    private int roll;
    private String name;
    private float marks;

    public Student(int roll, String name, float marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
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

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return roll + " " + name + " " + marks;
    }

    @Override
    public int compare(Object o) {

        Student s = (Student) o;

        if( this.roll > s.roll ) {
            return 1;
        }
        if( this.roll < s.roll ) {
            return -1;
        }

        return 0;
    }
}

