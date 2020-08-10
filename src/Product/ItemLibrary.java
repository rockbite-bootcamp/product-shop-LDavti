public enum ItemLibrary {

    CREDIT(new Item("Credit")),
    GEM(new Item("Gem")),
    LUBE(new Item("Lube")),
    CHOCOLATE(new Item("Chocolate"));

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
