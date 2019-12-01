import java.io.IOException;

public class Emp {

    private int id;
    private String name;
    private int sal;

    public Emp(int id, String name, int sal) throws InvalidSalException {
        this.id = id;
        this.name = name;


        if (sal <= 0) {
            throw new InvalidSalException(sal, System.currentTimeMillis(), "Invalid Sal!");
        }
        this.sal = sal;

        //not flexible
       /* try {
            if( sal <= 0 ) {
                throw new InvalidSalException(sal, System.currentTimeMillis(), "Invalid Sal!");
            }
            this.sal = sal;
        }
        catch ( InvalidSalException e ) {
            System.out.println( e.getMessage() );
            this.sal = 1000;
        }*/
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) throws InvalidSalException, IOException {

        if (sal <= 0) {
            throw new InvalidSalException(sal, System.currentTimeMillis(), "Invalid Sal!");
        }
        this.sal = sal;

    }

    public void display() {
        System.out.println(id + " " + name + " " + sal);
    }
}
