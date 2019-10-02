package view.animation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import view.block.ColoredBlock;
import view.utils.ImageFactory;

/**
 *
 * @author marcelo
 */
public class BlockAnimator implements ActionListener {
    
    private Container board;
    private ColoredBlock block;
    private Icon icon;
    private Timer timer;
    private ImageFactory imgFactory = new ImageFactory();
    
    private int i = 0;
    private double x = 1;
    private boolean isExpanding = true;
    
    public BlockAnimator () {
        timer = new Timer(5, this);
    }
    
    public void start(ColoredBlock block, Container board) {
        this.block = block;
        this.board = board;
        this.icon = block.getIcon();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (x >= 1.2)
            isExpanding = false;

        if (isExpanding) {
            x += 0.01;
        }
        else if (x != 1) {
            x -= 0.01;
        } else {
            timer.stop();
        }
        System.out.println("X:"+x+" count:"+i++);
        resize();
        board.repaint();
    }
    
    private void resize() {
        //System.out.println((int) (block.getIcon().getIconWidth() * x));
        block.setIcon(imgFactory.createResizedImageIcon((ImageIcon) this.icon, (int) (this.icon.getIconWidth() * x),(int) (this.icon.getIconHeight() * x)));
    }
}
