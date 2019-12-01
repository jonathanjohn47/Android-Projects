public class Student {

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
}


class StudentComparator implements Comparator {
    public int compare( Object o1, Object o2 ) {

        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        if( s1.getRoll() == s2.getRoll() ) {
            return 0;
        }
        if( s1.getRoll() > s2.getRoll() ) {
            return 1;
        }

        return -1;
    }
}
