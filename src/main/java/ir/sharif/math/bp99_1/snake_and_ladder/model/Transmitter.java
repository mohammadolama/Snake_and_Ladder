package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class Transmitter {
    private final Cell firstCell,lastCell;
    private final String name;

    public Transmitter(Cell firstCell,Cell lastCell , String name){
        this.firstCell = firstCell;
        this.lastCell = lastCell;
        this.name = name;
    }

    public Cell getFirstCell() {
        return firstCell;
    }

    public Cell getLastCell() {
        return lastCell;
    }

    public String getName() {
        return name;
    }

    public void transmit(Piece piece){
        // Your Code
    }
}
