public class Alien  {

    private String name;
    private String planet;

    public Alien(String name, String planet) {
        this.name = name;
        this.planet = planet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void rule1() {
        System.out.println( "A:" + name  + " rule1");
    }

    public void rule2() {
        System.out.println( "A:" + name  + " rule2");
    }

    public void rule3() {
        System.out.println( "A:" + name  + " rule3");
    }
}
