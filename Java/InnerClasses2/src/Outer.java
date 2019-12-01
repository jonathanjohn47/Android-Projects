public class Outer {

    private int out;

    public Outer(int out) {
        this.out = out;


    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public void display() {
        System.out.println("out = " + out );
    }

    public class Inner {
        private int in;

        public Inner(int in) {
            this.in = in;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public void display() {
            System.out.println("out = " + out + " in  = " + in );
        }

        public void setOut( int out ) {
            Outer.this.out = out;
        }
    }
}
