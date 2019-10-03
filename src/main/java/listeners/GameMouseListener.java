package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public class GameMouseListener extends ExtendableListener implements MouseListener {
    private static int clickX, clickY, soltarX, soltarY;
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
           int deltaX = 0, deltaY = 0;
           soltarX = e.getX();
           soltarY = e.getY();
           deltaX = (soltarX - clickX);
           deltaY = (soltarY - clickY);
           System.out.println("click x: " + clickX + " clickY: " + clickY + "\nsoltarX: " + soltarX + " soltarY: " + soltarY);
           if (deltaX < 0 && deltaY < 0) {
               deltaX = (deltaX * (-1));
               deltaY = (deltaY * (-1));
               if (deltaX > deltaY) {
                   System.out.println("Movimentacao nao detectada, tente novamente");
                   deltaX = (deltaX * (-1));
                   deltaY = (deltaY * (-1));
               } else {
                   System.out.println("Movimentacao nao detectada, tente novamente");
                   deltaX = (deltaX * (-1));
                   deltaY = (deltaY * (-1));
               }
           }
           if (deltaX > 0 && deltaY < 0) {
               deltaY = (deltaY * (-1));
               if (deltaX > deltaY) {
                   System.out.println("Movimentacao nao detectada, tente novamente");
                   deltaY = (deltaY * (-1));
               } else {
                   boardController.moveUp(holders);
                   hasMoved = true;
                   deltaY = (deltaY * (-1));
               }
           }
           if (deltaX > 0 && deltaY > 0) {
               if (deltaX > deltaY) {
                   boardController.moveRight(holders);
                   hasMoved = true;
               } else {
                   boardController.moveDown(holders);
                   hasMoved = true;
               }
           }
           if (deltaX < 0 && deltaY > 0) {
               deltaX = (deltaX * (-1));
               if (deltaX > deltaY) {
                   boardController.moveLeft(holders);
                   hasMoved = true;
                   deltaX = (deltaX * (-1));
               } else {
                   System.out.println("Movimentacao nao detectada, tente novamente");
                   deltaX = (deltaX * (-1));
               }
           }
           if (hasMoved)
               boardController.createRandom(holders);
       } catch (java.lang.NullPointerException e1) {
       }
   }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
