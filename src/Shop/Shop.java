import java.util.HashMap;

public class Shop implements IShop, Poolable {
    /**
     * Need to find specified product
     */
    private HashMap<ShopCategory, HashMap<Integer, Product>> categoryMap = new HashMap<>();

    /**
     * Need this one for searching by specified ID
     */
    private HashMap<Integer, Product> productMap = new HashMap<>();

    public void addProduct(Product product, ShopCategory category) {
        productMap.put(product.getID(), product);

        if (!categoryMap.containsKey(category)) {
            categoryMap.put(category, new HashMap<>());
        }

        categoryMap.get(category).put(product.getID(), product);
    }

    @Override
    public HashMap<Integer, Product> getProducts(ShopCategory category) {
        return categoryMap.get(category);
    }

    @Override
    public Product getProduct(int ID) {
        return productMap.get(ID);
    }


    /**
     * Provider is proxy between user and shop, but we need to check if user is able to get specified product
     */
    @Override
    public boolean isAbleToPay(IInventory inventoryProvider, int ID) {
        Product product = productMap.get(ID);
        if (product == null) return false;

        for (Item singleItem : product.getCost().keySet()) {
            int count = product.getCost().get(singleItem);
            if (!inventoryProvider.hasItem(singleItem, count)) {
                return false;
            }
        }

        return true;
    }

    /**
     * return true, if buyer can buy this product and transaction succeed
     */
    @Override
    public boolean transaction(IInventory inventoryProvider, int ID) {

        Product product = productMap.get(ID);

        if (product != null) {

            if (isAbleToPay(inventoryProvider, ID)) {
                for (Item item : product.getCost().keySet()) {
                    int count = product.getCost().get(item);
                    inventoryProvider.spendItem(item, count);
                }

                for (Item item : product.getPayload().keySet()) {
                    int count = product.getPayload().get(item);
                    inventoryProvider.addItem(item, count);
                }

                System.out.println("transaction complete for product: " + product.getProductName());
                System.out.println(new StringBuilder("transaction complete for product: "));
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean cancelTransaction(IInventory inventoryProvider, int ID) {

        Product product = productMap.get(ID);

        if (product != null) {

            if (isAbleToPay(inventoryProvider, ID)) {
                for (Item singleItem : product.getCost().keySet()) {
                    int count = product.getCost().get(singleItem);
                    inventoryProvider.addItem(singleItem, count);
                }

                for (Item singleItem : product.getPayload().keySet()) {
                    int count = product.getPayload().get(singleItem);
                    inventoryProvider.spendItem(singleItem, count);
                }
                System.out.println(new StringBuilder("transaction complete for product: ").append(product.getProductName()).toString());
                return true;
            }
        }

        return false;
    }

    @Override
    public void reset() {

    }
}
