public class Main {
    public static void main( String [] args ) {

        Data d1 = new Data( 100 );
        Object o =  d1.fun("Info1");
        String str = o.toString();
        System.out.println( str );

        System.out.println();

        /*Data d2 = new Data( 200 );
        d2.fun("Info2");*/


    }
}
