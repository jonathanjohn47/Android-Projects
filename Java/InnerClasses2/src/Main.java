public class Main {
    public static void main( String [] args ) {

        Outer o1 = new Outer( 100 );
        Outer.Inner in11 = o1.new Inner( 11 );
        Outer.Inner in12 = o1.new Inner( 11 );

        o1.display();
        in11.display();
        in12.display();

        System.out.println();

        Outer o2 = new Outer( 200 );
        Outer.Inner in21 = o2.new Inner( 21 );
        Outer.Inner in22 = o2.new Inner( 21 );

        o2.display();
        in21.display();
        in22.display();

        System.out.println("--------------------");

        in11.setOut( 110 );
        in22.setOut( 220 );

        o1.display();
        o2.display();

    }
}
