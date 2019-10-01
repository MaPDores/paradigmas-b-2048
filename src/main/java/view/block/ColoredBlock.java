package view.block;

public class ColoredBlock extends ExtendableBlock{    
    public ColoredBlock (int number, int x, int y) {
        super("/assets/"+number+".png", x, y);
        this.setSize(65, 65);
    }
}
