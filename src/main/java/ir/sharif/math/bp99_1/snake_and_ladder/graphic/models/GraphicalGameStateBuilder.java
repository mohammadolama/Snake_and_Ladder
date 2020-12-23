package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.*;

import java.util.*;
import java.util.LinkedList;

public class GraphicalGameStateBuilder {

    public static GraphicalGameState build(GameState g){
        GraphicalGameState gss;
        GraphicalPlayer p1 = createGP(g.getPlayer(1));
        GraphicalPlayer p2 = createGP(g.getPlayer(2));
        GraphicalBoard b = createBoard(g.getBoard());
        gss = new GraphicalGameState(b,p1,p2);
        return gss;
    }


    private static GraphicalPlayer createGP(Player p){
        ArrayList<GraphicalPiece> gp = convertPieces((ArrayList<Piece>) p.getPieces());
        return new GraphicalPlayer(p.getName() , p.getPoint() ,gp);
    }

    private static GraphicalBoard createBoard(Board b){
        GraphicalBoard gb = new GraphicalBoard(convertCells(b.getCells()) , convertTransmitter(b.getTransmitter()));
        return gb;
    }

    private static LinkedList<GraphicalCell> convertCells(List<Cell> cells){
        LinkedList<GraphicalCell> gc = new LinkedList<>();

        for (Cell cell : cells) {
            gc.add(new GraphicalCell(cell.getColor() , convertPrize(cell.getPrize()) , convertPiece(cell.getPiece()) , cell.getX() , cell.getY()));
        }
        return gc;
    }

    private static LinkedList<GraphicalTransmitter> convertTransmitter(List<Transmitter> l){
        LinkedList<GraphicalTransmitter> gtl = new LinkedList<>();
        for (Transmitter transmitter : l) {
            gtl.add(new GraphicalTransmitter(convertCell(transmitter.getFirstCell()) ,
                    convertCell(transmitter.getLastCell()) ,transmitter.getName()));
        }
        return gtl;
    }


    private static GraphicalCell convertCell(Cell cell){
        GraphicalCell gc = new GraphicalCell(cell.getColor() , convertPrize(cell.getPrize()) , convertPiece(cell.getPiece()) , cell.getX() , cell.getY());
        return gc;
    }

    private static GraphicalPiece convertPiece(Piece piece){
        GraphicalPiece gp = new GraphicalPiece(piece.getColor());
        return gp;

    }

    private static GraphicalPrize convertPrize(Prize prize){
        return new GraphicalPrize(prize.getName());
    }



    private static ArrayList<GraphicalPiece> convertPieces(ArrayList<Piece> l){
        ArrayList<GraphicalPiece> pi =new ArrayList<>();
        for (Piece a: l) {
            pi.add(new GraphicalPiece(a.getColor()));
        }
        return pi;
    }


}
