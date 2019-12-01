public class SetupThread extends Thread {

    private int buffSize;

    public SetupThread(int buffSize) {
        this.buffSize = buffSize;
    }

    @Override
    public void run() {
        //code to setup
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Setup done: " + buffSize + " bytes allocated!");
    }
}
