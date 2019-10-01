package view.board;

import javax.swing.JFrame;

import listeners.GameKeyListener;

/**
 *
 * @author marcelo
 */
public class GameMain extends JFrame {
    
    private GameBoard board;
    private GameKeyListener keyListener;
    
    public GameMain() {
        super("2048");
        board = new GameBoard();
        init();
    }
    
    public final void init() {
        setTitle("2048");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 250, 298, 328);
        setResizable(false);
        setVisible(true);
        
        buildGUI();
        buildKeyListeners();
    }
    
    private void buildGUI() {
        add(board);
    }
    
    private void buildKeyListeners() {
        keyListener = new GameKeyListener(board.holders, board);
        addKeyListener(keyListener);
    }
    
    private void buildMouseListeners() {}
}
