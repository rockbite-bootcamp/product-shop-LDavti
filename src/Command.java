import Pool.*;

    /**
    * Structure class Command , here generic type T , which is exactly a "placeholder" need to extend Poolable for obtaining "reset" method"
     */
    public class Command<T extends Poolable> implements ICommand {
        private PoolImplementation<T> pool;

    public Command(PoolImplementation<T> pool) {
        this.pool = pool;
    }

    /**
     * need to get particular object from usedObjects and then add it to freeObjects
     */
    @Override
    public boolean redo(PoolModel poolModel) {
        for (int i = 0; i < pool.usedObjects.size(); i++) {
            PoolModel item = (PoolModel) pool.usedObjects.get(i);
            if (compare(poolModel, item)) {
                T temp = pool.usedObjects.remove(i);
                pool.freeObjects.add(temp);
                return true;
            }
        }
        return false;
    }

    /**
     * same logic as in redo
     */
    @Override
    public boolean undo(PoolModel poolModel) {
        for (int i = 0; i < pool.freeObjects.size(); i++) {
            PoolModel item = (PoolModel) pool.freeObjects.get(i);
            if (compare(poolModel, item)) {
                T temp = pool.freeObjects.remove(i);
                pool.usedObjects.add(temp);
                return true;
            }
        }
        return false;
    }

    @Override
    public void reset() {

    }

    public boolean compare(PoolModel o1, PoolModel o2) {
        return (o1.getID() == o2.getID());
    }

}
