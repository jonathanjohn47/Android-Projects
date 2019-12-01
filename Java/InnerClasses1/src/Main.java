public class Main {
    public static void main(String[] args) {

        Test t1 = new Test("AA", 11, "Maths", 50);
        t1.display();

        Test t2 = new Test("AA", 11, "Maths", 50);
        t1.display();

        Test.Subject s1 = t1.new Subject("Android", 100 );

    }
}

