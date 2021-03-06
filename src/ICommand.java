import Pool.PoolModel;
import Pool.Poolable;

public interface ICommand extends Poolable {

    boolean redo(PoolModel poolModel);

    boolean undo(PoolModel poolModel);
}
