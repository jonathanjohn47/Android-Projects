import java.util.Random;

public class DownloadThread extends Thread {

    private String filePath;

    public DownloadThread(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {

        Thread ct = Thread.currentThread();
        System.out.println( ct.getId() + " " + ct.getName() + " " + ct.getPriority() );


        //start a setup thread
        SetupThread setupThread =
                new SetupThread(  Math.abs( new Random().nextInt() ) );

        setupThread.start();

        //Check server connection
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server connection checked by " + getName() );


        try {
            setupThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //start downloading data
        for( int i = 0; i <= 100; i++ ) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Downloading: " + filePath + " " + i  + "%");
        }

    }
}
