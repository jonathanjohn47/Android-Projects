public class Printer {

    public void printInfo() {
        System.out.println("MFG: HP");
        System.out.println("Model: 1011PA23");
    }

    public /*synchronized*/ void print( String fileName ) {

        try {
            Thread.sleep(100);
            System.out.println("{");
            Thread.sleep(100);
            System.out.println(fileName);
            Thread.sleep(100);
            System.out.println("}");
        }
        catch (InterruptedException e ) {

        }

    }

}
