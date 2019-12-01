import com.sun.tools.internal.ws.wsdl.document.Output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main( String [] args ){


        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        runtime.availableProcessors();
        //runtime.exit( 0);
        runtime.runFinalization();

        try {
            Process process = runtime.exec("ls /");


            InputStream in = process.getInputStream();

            byte [] arr = new byte[1024];
            int count;
            while( ( count = in.read( arr ) ) != -1 ) {
                System.out.print( new String( arr, 0, count ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Integer iObj = new Integer(11 );

        iObj = 22; //Auto boxing
        iObj = new Integer(22);

        int j = iObj.intValue();
        j = iObj; //Auto unboxing




        int i  = Integer.parseInt("0x1234", 16);


        System.out.println( Short.MIN_VALUE + " " + Short.MAX_VALUE);

        Float f1 = new Float("12.12");
        Float f2 = new Float(12.12 );

        System.out.println( f1.isInfinite() );

        System.out.println( f1.compareTo( f1 ) );

        System.out.println( Float.compare(12.12f, 12.1200001f ));

        System.out.println( f1.floatValue() );
        */

    }
}
