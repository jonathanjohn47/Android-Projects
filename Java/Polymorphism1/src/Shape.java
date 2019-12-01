public abstract class Shape  {

    private int x, y;
    private final float PI = 3.14f;

    public Shape() {
        x = y = 0;
    }

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void draw();

    public final void info() {
        System.out.println("Created By: BitCode");
    }
}
