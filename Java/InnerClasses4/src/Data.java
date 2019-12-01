public class Data {

    private int data;

    public Data(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Object fun( String info ) {

        final int local = 100;

        class Info {
            private String info;

            public Info(String info) {
                this.info = info;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public void display() {
                System.out.println("info = " + info  + " local = " + local );
            }

            public String toString() {
                //local++;
                return "info = " + info  + " local = " + local;
            }
        }

        //Info infoRef = new Info("Some Info!");
        Info infoRef = new Info( info );
        infoRef.display();

        return infoRef;
    }
}
