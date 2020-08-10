package Pool;

public class PoolModel implements Poolable {
    private int ID;

    public PoolModel(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void reset() {

    }
}
