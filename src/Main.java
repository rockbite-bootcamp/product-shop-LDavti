public class Main {

    public static void main(String[] args) {

        // Initializing Shop object
        Shop shop = new Shop();

        // Initializing 3 different products, and specifying their categories
        shop.addProduct(new Product(1, "Gem"), ShopCategory.CUSTOM);
        shop.addProduct(new Product(3, "Romantic Pack"), ShopCategory.DISCOUNT);

        // configuring cost and payload for product 1
        shop.getProduct(1).setPayload(ItemLibrary.GEM.get(), 1);
        shop.getProduct(1).setCost(ItemLibrary.CREDIT.get(), 10);


        // configuring cost and payload for product 3
        shop.getProduct(3).setPayload(ItemLibrary.LUBE.get(), 1);
        shop.getProduct(3).setPayload(ItemLibrary.CHOCOLATE.get(), 1);
        shop.getProduct(3).setCost(ItemLibrary.GEM.get(), 2);

        // Initializing the player
        User user = new User();

        // Player has some initial credits
        user.addItem(ItemLibrary.CREDIT.get(), 2000);

        // outputting player inventory
        user.outputInventory();

        // lets see if we can purchase product number 3, the romantic pack, we should not be able to since player has no gems
        if (shop.isAbleToPay(user, 3)) {
            shop.transaction(user, 3);
        } else {
            System.out.println("player can't afford: " + shop.getProduct(3));
        }

        // to purchase missing 2 gems we need to purchase product number 1 - 2 times
        for (int i = 0; i < 2; i++) {
            shop.transaction(user, 1);
        }

        // outputting player inventory
        user.outputInventory();

        PoolImplementation<PoolModel> pool = new PoolImplementation<>();

        // lets' try to do the transaction again
        if (shop.isAbleToPay(user, 3)) {
            shop.transaction(user, 3);
            pool.obtain(new PoolModel(3));
            Command<PoolModel> command = new Command<>(pool);

        } else {
            System.out.println("player can't afford: " + shop.getProduct(3));
        }

        // outputting player inventory, this time finally it should show that player has chocolate and lube in their inventory
        user.outputInventory();
    }
}
