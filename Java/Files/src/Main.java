import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    public static void main( String [] args ) {


        System.out.println( System.out.getClass().getName() );



        /*File myDir  = new File("/Users/vishal/java");
        printInfo( myDir );

        //File myFile = new File("/Users/vishal/java", "jdk-8u201-macosx-x64.dmg");
        File myFile = new File(myDir, "jdk-8u201-macosx-x64.dmg");
        printInfo( myFile );



        File newDir = new File( myDir, "new dir" );
        if( !newDir.exists() ) {
            newDir.mkdir();
        }
        printInfo( newDir);

        File newFile = new File( newDir, "newfile.txt");
        *//*if( newFile.exists() ) {
            newFile.delete();
        }*//*
        if( !newFile.exists() ) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        printInfo( newFile );

        File someDir = new File(
                newDir.getAbsolutePath() +
                        "/test/data/somedir"
        );
        //someDir.mkdir();
        someDir.mkdirs();


        //list file under a directory
        System.out.println( myDir.getAbsolutePath() );
        String [] fileNames = myDir.list();
        for( String name : fileNames ) {
            File file = new File( myDir, name );
            System.out.println( name + " " + file.isFile() );
        }
        System.out.println();


        File [] files = myDir.listFiles();
        for ( File file : files ) {
            System.out.println( file.getName() + " " + file.isFile() );
        }*/


        File dir = new File("/Users/vishal/java/workspaces/");

        /*String [] fileNames = dir.list( new MyFileNameFilter() );
        for( String fileName : fileNames ) {
            System.out.println( fileName );
        }*/

        File [] files = dir.listFiles( new MyFileFilter() );
        for( File file : files ) {
            System.out.println( file.getName() );
        }


    }

    public static void printInfo( File file ) {

        System.out.println( file.getName()  + " Exists: " + file.exists() );
        System.out.println( file.getAbsolutePath() );
        System.out.println( "File: " + file.isFile() + " Dir: " + file.isDirectory() );
        System.out.println( "RWX: " + ( file.canRead() ? "1" : 0 ) + ( file.canWrite() ? "1" : 0 ) + ( file.canExecute() ? "1" : 0 ) );
        System.out.println( "last modified: " + file.lastModified() );
        System.out.println( "size: " + file.length() );
        System.out.println("----------------------------------");

    }
}

class MyFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {

        return pathname.getAbsolutePath().endsWith(".txt");
    }
}


class MyFileNameFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {

        System.out.println("testing : " + name );

        return name.endsWith(".txt");

    }
}

