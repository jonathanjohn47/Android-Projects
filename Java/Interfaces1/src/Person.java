public class Person extends Object implements Rules {

    private String aNo;
    private String name;

    public Person(String aNo, String name) {
        this.aNo = aNo;
        this.name = name;
    }

    public String getaNo() {
        return aNo;
    }

    public void setaNo(String aNo) {
        this.aNo = aNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void rule1() {
        System.out.println("p: " + name  + " rule1");
    }

    @Override
    public void rule2() {
        System.out.println("p: " + name  + " rule2");
    }

    @Override
    public void rule3() {
        System.out.println("p: " + name  + " rule3");
    }
}

