package Product;

public class Item {
    /**
     * Name of the item
     */
    private final String name;
    /**
     * Constructor
     */
    public Item(String name) {
        this.name = name;
    }
    /**
     * Getter for private field, cause our name field is final, we can't initialize setter
     */
    public String getName() {
        return name;
    }
}
