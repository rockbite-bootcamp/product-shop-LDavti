package Pool;

import java.util.ArrayList;

public abstract class Pool<T extends Poolable> {

   public ArrayList<T> freeObjects = new ArrayList<>();

   public ArrayList<T> usedObjects = new ArrayList<>();

    protected abstract T newObject();

    public T obtain (T model) {
        if (freeObjects.isEmpty()) {
            freeObjects.add(model);
        }

        T object = freeObjects.remove(0);
        usedObjects.add(object);

        return object;
    }

    public void free (T object) {
        usedObjects.remove(object);
        freeObjects.add(object);

        object.reset();
    }

}
