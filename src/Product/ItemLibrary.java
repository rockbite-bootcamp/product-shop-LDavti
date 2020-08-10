package Product;

public enum ItemLibrary {

    CREDIT(new Item("Credit")),
    GEM(new Item("Gem")),
    BUILDING(new Item("Building")),
    DECORATIONS(new Item("Decorations"));

    private final Item item;

    ItemLibrary(Item item) {

        this.item = item;
    }

    @Override
    public String toString() {

        return item.getName();
    }

    public Item get() {
        return item;
    }

}
