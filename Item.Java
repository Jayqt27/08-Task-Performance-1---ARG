public class Item {
    private String name;
    private String description;

    // Constructor to initialize the fields
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getter for the name field
    public String getName() {
        return this.name;
    }

    // Getter for the description field
    public String getDescription() {
        return this.description;
    }

    // Optional: Overriding toString for better debugging or printing
    @Override
    public String toString() {
        return "Item{name='" + name + "', description='" + description + "'}";
    }
}
