public class Model {

    private String name;

    private String description;

    @Override
    protected void finalize() {
        System.out.println("Finalize model " + name);
    }

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
