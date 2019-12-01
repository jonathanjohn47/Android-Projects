public class Data {

    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data = " + data ;
    }
}

class MyData extends Data {

    @Override
    public void setData(int data) {
        if( data > 0 ) {
            super.setData(data);
            //n++;
        }
    }
}
