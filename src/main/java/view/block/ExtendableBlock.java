package view.block;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.utils.ImageFactory;
/**
 *
 * @author marcelo
 * 
 * Classe com campos básicos de um Block (Colored Block e Block Holder).
 */
public abstract class ExtendableBlock extends JLabel{

    private final ImageFactory imgFactory = new ImageFactory();
    
    public ExtendableBlock (int x, int y) {
        super();
        this.setLocation(x, y);
    }
    
    public ExtendableBlock (String imageSource, int x, int y) {
        super();
        ImageIcon img = imgFactory.createImageIcon(imageSource);
        this.setIcon(img);
        this.setLocation(x, y);
    }
}
