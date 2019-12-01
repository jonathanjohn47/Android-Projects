
public class Test {

    private Student student;
    private Subject subject;

    private boolean isAppeared;
    private long startTime, endTime;
    private int durationInMins;

    public Test( String studName, int roll, String subName, int marks  ) {

        student = this.new Student( roll, studName );
        subject = new Subject( subName, marks );

    }

    public static void rules() {
        //new Student(11, "aa");
    }

    public void start() {
    }

    public void stop() {
    }

    public void display() {
        System.out.println( student.name + " " + student.roll );
        System.out.println( subject.name + " " + subject.marks );
    }

    public class Subject {
        private String name;
        private int marks;

        public Subject(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }
    }

    public class Student {

        private int roll;
        private String name;

        public Student(int roll, String name) {
            this.roll = roll;
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
    }


}
