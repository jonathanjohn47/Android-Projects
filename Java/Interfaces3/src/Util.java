public class Util {


    public static void sort( Comparable [] arr ) {

        int passes = arr.length - 1;
        int comps = arr.length - 1;

        for( int i = 0; i < passes; i++ ) {

            for( int j = 0; j < ( comps - i); j++ ) {

                int res = arr[j].compare( arr[j+1] );

                if( res == 1 ) {

                    Comparable temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }

            }

        }
    }


    /*public static void sort( int [] arr ) {

        int passes = arr.length - 1;
        int comps = arr.length - 1;

        for( int i = 0; i < passes; i++ ) {

            for( int j = 0; j < ( comps - i); j++ ) {

                if( arr[j+1] < arr[j] ) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }

        }


    }

    public static void sort( Emp [] arr ) {

        int passes = arr.length - 1;
        int comps = arr.length - 1;

        for( int i = 0; i < passes; i++ ) {

            for( int j = 0; j < ( comps - i); j++ ) {

                if( arr[j].getId() > arr[j+1].getId() ) {
                    Emp temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }

        }


    }*/

}
