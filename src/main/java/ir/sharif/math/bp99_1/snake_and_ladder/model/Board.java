package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.List;

public class Board {
    private List<Cell> cells;
    private List<Transmitter> transmitter;
    private List<Wall> walls;
    private List<Cell> startingCells;

    public Board(String boardDate){

    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Cell> getStartingCells() {
        return startingCells;
    }

    public List<Transmitter> getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(List<Transmitter> transmitter) {
        this.transmitter = transmitter;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setStartingCells(List<Cell> startingCells) {
        this.startingCells = startingCells;
    }

    public Cell getCell(int X, int Y){
        for(Cell cell : cells){
            if(cell.getX() == X && cell.getY() == Y)
                return cell;
        }
        return null;
    }
}
