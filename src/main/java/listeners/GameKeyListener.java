package listeners;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.block.BlockHolder;

/**
 *
 * @author marcelo
 * 
 * Classe que ouve as Teclas do Teclado e executa os comandos.
 */
public class GameKeyListener extends ExtendableListener implements KeyListener {
    
    public GameKeyListener (BlockHolder[][] holders, Container board) {
        super(holders, board);
    }
    
    @Override
        /* NOT WORKING PROPERLY */
    public void keyTyped(KeyEvent ke) {
        // Cria variável que guarda se houve movimentação na Board
        boolean hasMoved = false;

        // Verifica o Char do evento
        switch(ke.getKeyChar()) {
            case 'w':
                hasMoved = boardController.moveUp(holders, board);
                break;
            case 'a':
                hasMoved = boardController.moveLeft(holders, board);
                break;
            case 's':
                hasMoved = boardController.moveDown(holders, board);
                break;
            case 'd':
                hasMoved = boardController.moveRight(holders, board);
                break;
        }
        if (hasMoved)
            boardController.createRandom(holders, board);
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
    
}
