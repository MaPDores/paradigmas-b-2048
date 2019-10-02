package listeners;

import controller.BoardController;
import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public abstract class ExtendableListener {

    protected BlockHolder[][] holders;
    protected BoardController boardController;
    
    public ExtendableListener (BlockHolder[][] holders) {
        this.holders = holders;
        this.boardController = BoardController.getInstance(holders);
    }
}
