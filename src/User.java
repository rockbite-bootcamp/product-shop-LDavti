import java.util.HashMap;

public class User implements IInventory {
    private HashMap<Item, Integer> inventory = new HashMap<>();

    @Override
    public boolean hasItem(Item item, int count) {
        if (!inventory.containsKey(item)) {
            return false;
        }

        return inventory.get(item) > 0;
    }

    @Override
    public void spendItem(Item item, int count) {
        if (!inventory.containsKey(item) || inventory.get(item) < count) {
            System.out.println("Trying to spend item that we don't have enough of");
        }

        if (inventory.containsKey(item)) {
            int currCount = inventory.get(item);
            inventory.put(item, currCount - count);
        }
    }

    @Override
    public void addItem(Item item, int count) {
        if (!inventory.containsKey(item)) {
            inventory.put(item, count);
        } else {
            inventory.put(item, inventory.get(item) + count);
        }
    }

    public void outputInventory() {
        for (Item singleItem : inventory.keySet()) {
            int count = inventory.get(singleItem);
            System.out.println(new StringBuilder(singleItem.getName()).append(":").append(count).toString());
        }
    }
}
