public class Main {

    private int m;
    private static int n = 10;

    public static void main( String [] args ) {

        Loggable l = new Loggable() {

            @Override
            public void log() {
                System.out.println("this is log");
                //m++; //can not be accessed
                n++;
            }

            @Override
            public void info() {
                System.out.println("this is info");
            }
        };

        l.info();
        l.log();


        Information i = new Information() {
            @Override
            public void collect() {
                System.out.println("info collect");
            }

            @Override
            public void share() {
                System.out.println("info share");
            }
        };
        i.collect();


        Data d = new Data() {
            @Override
            public void setData(int data) {
                if( data > 0 ) {
                    super.setData(data);
                    n++;
                }
            }
        };

        d.setData( -10 );
        System.out.println( d.getData() );
        d.setData( 100 );
        System.out.println( d.getData() );

        MyData md = new MyData();


    }
}