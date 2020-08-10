import pool.Poolable;

public class PoolImplementation<T extends Poolable> extends Pool<T> {

    @Override
    protected T newObject() {
        return (T) new Object();
    }
}
