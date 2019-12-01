public class Maths {

    private static Maths maths = null;

    private Maths() {
    }

    public static Maths getInstance() {
        //check if there is already an object
        //if no then create and return, if yes return the existing object

        if( maths == null ) {
            maths = new Maths();
        }

        return maths;
    }

    public int avg( int [] arr ) {
        //some calculations goes here
        return 0;
    }

    public int add( int val1, int val2 ) {
        return val1 + val2;
    }

    public int sub( int val1, int val2 ) {
        return val1 - val2;
    }
}
