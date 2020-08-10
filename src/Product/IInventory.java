public interface IInventory {

    boolean hasItem(Item item, int count);

    void spendItem(Item item, int count);

    void addItem(Item item, int count);

}
