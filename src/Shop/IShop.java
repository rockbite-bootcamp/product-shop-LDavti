package Shop;

import Product.Product;
import Product.IInventory;

import java.util.HashMap;

public interface IShop {

    /**
     * "Get" method for product in specified category
     */
    HashMap<Integer, Product> getProducts(ShopCategory category);

    /**
     * need to specify ID, which is unique, to get the right product
     */
    Product getProduct(int ID);

    /**
     * return true if specified user can buy product with specified ID, otherwise, return false
     * need to check every time when perform transaction
     */
    boolean isAbleToPay(IInventory user, int ID);

    /**
     * perform transaction for particular product with provider
     */
    boolean transaction(IInventory inventory, int ID);

    /**
     * cancel specified transaction
     */
    boolean cancelTransaction(IInventory inventory, int ID);

}

