package listeners;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public class GameMouseListener extends ExtendableListener implements MouseListener {

    public GameMouseListener (BlockHolder[][] holders, Container board) {
        super(holders, board);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
    
}
