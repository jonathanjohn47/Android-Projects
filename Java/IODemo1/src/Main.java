import java.io.*;

public class Main {
    public static void main( String [] args ) {

        //readFromFile();
        //readFromByteArray();
        //readFromStringBuffer();
        //readFromSequenceInputStream();
        //readFromBufferedInputStream();
        //readFromPushBackInputStream();
        //readFromConsole();
    }

    static void readFromConsole() {

        try {

            char ch = (char) System.in.read();
            System.out.println( ch );

            byte [] data = new byte[1024];
            int count;

            System.in.read();

            count = System.in.read( data );
            System.out.println( new String( data, 0, count ) );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void readFromPushBackInputStream() {

        byte [] arr = "this is a string! Use of the string is for testing purpose...".getBytes();
        ByteArrayInputStream bin = new ByteArrayInputStream( arr );

        PushbackInputStream pin = new PushbackInputStream( bin, 200 );

        byte [] data = new byte[20];
        int count;

        try {

            count = pin.read( data );
            System.out.println( new String( data, 0, count ) );

            pin.unread( data, 0, count );

            count = pin.read( data );
            System.out.println( new String( data, 0, count ) );

            pin.close();


        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    static void readFromBufferedInputStream() {

        String path = "/Users/vishal/java/workspaces/demo1.txt";

        try {

            long startTime = System.currentTimeMillis();

            //FileInputStream fin = new FileInputStream( path );
            InputStream fin =
                    new BufferedInputStream(
                            new FileInputStream( path ),
                            1024*32
                    );

            System.out.println("bytes to read: " + fin.available() );

            int val;
            int count;
            byte [] data = new byte[1024*32];

            //while ( ( val = fin.read() ) != -1 ) {
            while( ( count = fin.read( data) ) != -1) {
                //System.out.print( (char)val );
            }

            System.out.println("bytes to read: " + fin.available() );
            fin.close();

            System.out.println( System.currentTimeMillis() - startTime );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void readFromSequenceInputStream() {

        try {

            FileInputStream fin =
                    new FileInputStream(
                            "/Users/vishal/java/workspaces/MyJava.java"
                    );

            ByteArrayInputStream bin =
                    new ByteArrayInputStream(
                            "this is a string!".getBytes()
                    );

            SequenceInputStream sin =
                    new SequenceInputStream( fin, bin );

            int val;
            while( ( val = sin.read() ) != -1 ) {
                System.out.print( (char) val );
            }
            sin.close();

        } catch ( Exception e) {
            e.printStackTrace();
        }


    }


    public static void readFromStringBuffer() {

        StringBufferInputStream sin = new StringBufferInputStream("this is a string! Use of the string is for testing purpose...");
        int val;
        while ( ( val = sin.read() ) != -1 ){
            System.out.print( (char) val );
        }

        try {
            sin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromByteArray() {

        byte [] arr = "this is a string! Use of the string is for testing purpose...".getBytes();

        //ByteArrayInputStream bin = new ByteArrayInputStream( arr );
        ByteArrayInputStream bin = new ByteArrayInputStream( arr, 5, 10 );

        int val;
        while ( ( val = bin.read() ) != -1 ){
            System.out.print( (char) val );
        }

        try {
            bin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public static void readFromAnyStream(  InputStream in ) {

    }


    public static void readFromFile() {

        String path = "/Users/vishal/java/workspaces/demo1.txt";

        try {

            long startTime = System.currentTimeMillis();

            //FileInputStream fin = new FileInputStream( path );
            InputStream fin = new FileInputStream( path );

            System.out.println("bytes to read: " + fin.available() );

            int val;
            int count;
            byte [] data = new byte[1024*32];

            //while ( ( val = fin.read() ) != -1 ) {
            while( ( count = fin.read( data) ) != -1) {
                //System.out.print( (char)val );
            }

            System.out.println("bytes to read: " + fin.available() );
            fin.close();

            System.out.println( System.currentTimeMillis() - startTime );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fun() {
        try {
            FileOutputStream fout = new FileOutputStream("/Users/vishal/java/workspaces/demo1.txt", true);


            byte [] data = new byte[1024*8];
            int count;

            for( int i = 0; i < 15; i++ ) {

                FileInputStream fin = new FileInputStream("/Users/vishal/java/workspaces/demo.txt");
                while ((count = fin.read(data)) != -1) {
                    fout.write(data);
                }
                fin.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
