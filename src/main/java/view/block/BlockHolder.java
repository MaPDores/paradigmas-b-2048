package view.block;

/**
 *
 * @author marcelo
 */
public class BlockHolder extends ExtendableBlock {

    private ColoredBlock block;

    public BlockHolder (int x, int y) {
        super(x, y);
    }
    
    public ColoredBlock createBlock(int number) {
        block = new ColoredBlock(number, this.getX(), this.getY());
        return block;
    }
    
    public void setBlock(ColoredBlock block) {
        this.block = block;
        this.block.setLocation(this.getX(), this.getY());
    }
    
    public ColoredBlock getBlock() {
        return block;
    }
    
    public ColoredBlock removeBlock() {
        ColoredBlock b = block;
        block = null;
        return b;
    }
}
