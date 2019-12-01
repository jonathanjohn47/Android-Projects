public class Main {
    public static void main( String [] args ){

        Container c = new Container();

        new Producer( c ).start();
        new Consumer( c ).start();

        int type = 10;

        if( type == Drawable.TYPE_CIRCLE ) {
            //do something related to Circle
        }
        if( type == Drawable.TYPE_RECT  ) {
            //do something related to Rect
        }

    }
}


interface Drawable {
    int TYPE_CIRCLE = 1;
    int TYPE_RECT = 2;
    int TYPE_TRIANGLE = 3;
}
