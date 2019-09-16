package Model;

public class ListItem {
    private String name, description;
    //-----------Constructor--------------------------------
    public ListItem(int ic_launcher_background, String name, String description) {
        this.name = name;
        this.description = description;
    }
    //-----------generated getters and setters-------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
