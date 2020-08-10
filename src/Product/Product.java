package Product;

import java.util.HashMap;

public class Product {
    /**
     * We set unique ID for each product, to identify which product is called in certain method
     */
    private final int ID;

    /**
     * Custom name for each product
     */
    private final String productName;

    /**
     * Store payload as a hashmap to have key/value pairs
     */
    private HashMap<Item, Integer> payload = new HashMap<>();

    /**
     * Store cost as a hashmap
     */
    private HashMap<Item, Integer> cost = new HashMap<>();
    /**
     * Custom constructor with arguments
     */
    public Product(int ID, String productName) {
        this.ID = ID;
        this.productName = productName;
    }
    /**
     * Reset method for payload
     */
    public void resetPayload() {
        payload.clear();
    }
    /**
     * Generated setters and getters for private fields
     */
    public void setPayload(Item item, int count) {
        payload.put(item, count);
    }

    public void setCost(Item item, int count) {
        cost.put(item, count);
    }

    public int getID() {
        return ID;
    }

    public String getProductName() {
        return productName;
    }

    public HashMap<Item, Integer> getPayload() {
        return payload;
    }

    public HashMap<Item, Integer> getCost() {
        return cost;
    }

    /**
     * Need to override toString method for a better message in console
     */
    @Override
    public String toString() {
        return productName;
    }
}
