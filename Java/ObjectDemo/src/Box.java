import in.bitcode.shapes.Rect;

public class Box extends Rect {

    private int d;

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public void draw() {
        System.out.println( w );
        super.draw();
    }
}
