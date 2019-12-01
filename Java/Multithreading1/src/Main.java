public class Main {
    public static void main( String [] args ) {

        Thread mainThread = Thread.currentThread();
        System.out.println( mainThread.getId() + " " + mainThread.getName() + " " + mainThread.getPriority() );

        DownloadThread d1 = new DownloadThread("file1");
        d1.setName("D1");
        d1.isAlive();
        d1.setPriority( Thread.MAX_PRIORITY );

        DownloadThread d2 = new DownloadThread("file2");
        d2.setName("D2");

        /*d1.run();
        d2.run();*/

        d1.start();
        d2.start();

        try {
            d1.join();
            d2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for( int i = 0; i <= 100; i++ ) {
            System.out.println("main " + i );
            try {
                Thread.sleep( 50 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
