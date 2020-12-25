package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import java.awt.*;

public class GraphicalCell extends GraphicalModel {
    private final GraphicalColor color;
    private final GraphicalPrize graphicalPrize;
    private GraphicalPiece graphicalPiece;
    private final int x, y;

    public GraphicalCell(GraphicalColor color, GraphicalPrize graphicalPrize, GraphicalPiece graphicalPiece, int x, int y) {
        this.color = color;
        this.graphicalPrize = graphicalPrize;
        this.graphicalPiece = graphicalPiece;
        this.x = (y - 1) * 80;
        this.y = (x - 1) * 80;
    }

    public GraphicalColor getColor() {
        return color;
    }

    public GraphicalPrize getGraphicalPrize() {
        return graphicalPrize;
    }

    public GraphicalPiece getGraphicalPiece() {
        return graphicalPiece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public GraphicalPiece getPiece() {
        return graphicalPiece;
    }

    public GraphicalPrize getPrize() {
        return graphicalPrize;
    }

    public void setPiece(GraphicalPiece graphicalPiece) {
        this.graphicalPiece = graphicalPiece;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        // paint this
        graphics2D.setColor(color.getColor());
        graphics2D.translate(x, y);
        graphics2D.fillRect(0, 0, 80, 80);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(0, 0, 80, 80);
        if (graphicalPrize != null) graphicalPrize.paint(graphics2D);
        if (graphicalPiece != null) graphicalPiece.paint(graphics2D);
        graphics2D.translate(-x, -y);
    }
}
