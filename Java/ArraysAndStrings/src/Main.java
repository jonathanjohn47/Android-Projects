public class Main {
    public static void main( String [] args ){

        for( String arg : args ) {
            System.out.println( arg );
        }


        /*//String str = new String("BitCode");
        String str = "BitCode";
        System.out.println( str + " " + str.length() );

        System.out.println( "some string".length()  );

        String s1  = "Hello World!";
        s1 = s1 + " of Java";*/


        /*Data [] arr = new Data[3];

        arr[0] = new Data( 10 );
        arr[1] = new Data( 20 );
        arr[2] = new Data( 30 );

        for( int i = 0; i < arr.length; i++ ) {
            System.out.println( arr[i].getData() );
        }

        System.out.println();

        for( Data d : arr ) {
            System.out.println( d.getData() );
        }

        arr = null;*/

        /*int [][] arr = new int[4][];
        arr[0] = new int[] { 55, 64, 88 };
        arr[1] = new int[] { 55, 64, 88, 90 };
        arr[2] = new int[] { 55, 64, 88 };
        arr[3] = new int[] { 55, 64 };

        for( int i = 0; i < arr.length; i++ ) {
            for( int j = 0; j < arr[i].length; j++ ) {
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }

        arr = null;*/


        //2D arrays
        /*int rows = 2, columns = 3;
        //int [][] arr = new int[rows][columns];
        int [][] arr = new int[][] { { 10, 20, 30 }, { 40, 50, 60 } };


        for( int i = 0; i < arr.length; i++ ) {
            for( int j = 0; j < arr[i].length; j++ ) {
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }*/

        /*for( int i = 0; i < 2; i++ ) {
            for( int j = 0; j < 3; j++ ) {
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }*/


        //1 D Array
        //int [] arr = { 10, 20, 30, 40, 50 };
        //int [] arr = new int[] { 10, 20, 30, 40, 50 };
        /*int [] arr = new int[5];

        for( int i = 0; i < arr.length; i++ ) {
            System.out.println( arr[i] );
        }

        int [] arrCopy = arr;
        arrCopy[2] = 50;

        System.out.println( arr[2] );

        arr = new int[] { 11, 22, 33, 44 };
        for( int val : arr ) {
            System.out.println( val );
        }*/

    }
}
