import Pool.PoolImplementation;
import Pool.PoolModel;
import Product.*;
import Shop.*;

public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop();

        User user = new User();

        user.addItem(ItemLibrary.CREDIT.get(), 2000);

        user.outputInventory();
        if (shop.isAbleToPay(user, 3)) {
            shop.transaction(user, 3);
        } else {
            System.out.println(new StringBuilder("player can't afford:").append(shop.getProduct(3)).toString());
        }
        for (int i = 0; i < 2; i++) {
            shop.transaction(user, 1);
        }
        user.outputInventory();

        PoolImplementation<PoolModel> pool = new PoolImplementation<PoolModel>();
        if (shop.isAbleToPay(user, 3)) {
            shop.transaction(user, 3);
            pool.obtain(new PoolModel(3));
            Command<PoolModel> command = new Command<PoolModel>(pool);

        } else {
            System.out.println(new StringBuilder("player can't afford:").append(shop.getProduct(3)).toString());
        }
        user.outputInventory();
    }
}
