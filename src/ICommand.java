public interface ICommand extends Poolable {

    boolean redo(PoolModel poolModel);

    boolean undo(PoolModel poolModel);
}
