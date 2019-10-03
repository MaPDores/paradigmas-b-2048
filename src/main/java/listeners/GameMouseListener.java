package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public class GameMouseListener extends ExtendableListener implements MouseListener {
    private static int clickX, clickY, releaseX, releaseY;
    public GameMouseListener (BlockHolder[][] holders) {
        super(holders);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    clickX = e.getX();
    clickY = e.getY();       
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
   public void mouseReleased(MouseEvent e) {
       boolean hasMoved = false;
       try {
           int xVariation, yVariation;
           releaseX = e.getX();
           releaseY = e.getY();
           xVariation = (releaseX - clickX);
           yVariation = (releaseY - clickY);
           if (xVariation > 0 && yVariation < 0) {
               yVariation = (yVariation * (-1));
               if (xVariation > yVariation) {
                   System.out.println("Movimentacao nao detectada, tente novamente");
               } else {
                   boardController.moveUp(holders);
                   hasMoved = true;
                   yVariation = (yVariation * (-1));
               }
           }
           if (xVariation > 0 && yVariation > 0) {
               if (xVariation > yVariation) {
                   hasMoved = boardController.moveRight(holders);
               } else {
                   hasMoved = boardController.moveDown(holders);
               }
           }
           if (xVariation < 0 && yVariation > 0) {
               xVariation = (xVariation * (-1));
               if (xVariation > yVariation) {
                   boardController.moveLeft(holders);
                   hasMoved = true;
               } else {
                   System.out.println("Movimentacao nao detectada, tente novamente");
               }
           }
           if (hasMoved)
               boardController.createRandom(holders);
       } catch (java.lang.NullPointerException me) {
       }
   }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
