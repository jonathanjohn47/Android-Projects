public class Emp implements Comparable {

    private int id;
    private String name;
    private int sal;

    public Emp(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
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

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + sal;
    }

    @Override
    public int compare(Object o) {

        Emp e = (Emp) o;

        if( this.id == e.id ) {
            return 0;
        }
        if( this.id > e.id ) {
            return 1;
        }

        return -1;
    }
}



