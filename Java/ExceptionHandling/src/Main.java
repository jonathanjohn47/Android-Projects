import java.io.IOException;

public class Main {

    public static void main( String [] args )   {

        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec("ls");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            runtime.exec("ls");
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        Emp e = null;

        try {
            e = new Emp(11, "aa", 0 );
        } catch (InvalidSalException e1) {
            e1.printStackTrace();
        }

        try {
            e.setSal(2000);
        }
        catch (Exception ex ) {

        }

    }


    /*public static void main( String [] args ){

        int res, num1 = 10, num2 = 2;
        int [] arr = new int[2];

        int sal = 0; //scan sal from user

        try {

            //Connection con = new Connection( u, p, serveraddress );
            //do something using con

            Data d = new Data(100);
            //Data d = null;
            System.out.println( d.getData() );

            //System.out.println("arr[2] = " + arr[2] );

            try {

                if (sal <= 0) {
                    throw new InvalidSalException(sal, System.currentTimeMillis(), "Invalid salary..");
                }

                System.out.println("sal = " + sal);
            }
            catch ( ArrayStoreException e ) {
                System.out.println("Some error handling is done here!");
            }


            System.out.println( num1 / num2 );

            //con.close();

        }
        catch ( ArithmeticException e ) {
            System.out.println( e.getMessage() );
            e.printStackTrace();
            //con.close();
        }
        catch ( NullPointerException e ) {
            System.out.println( e.getMessage() );
            //con.close();
        }
        catch ( InvalidSalException e ) {
            System.out.println( e.getMessage() );
            //con.close();
        }
        catch ( Exception e ) {
            System.out.println( "Exception: " + e.getMessage() );
            //con.close();
        }
        finally {
            //con.close();
        }




    }*/
}
