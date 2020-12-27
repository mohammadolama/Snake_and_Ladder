package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.model.pieces.Piece;

public class Game {
    private final GameState gameState;

    public Game(GameState gameState) {
        this.gameState = gameState;
    }

    public void rollDice(int playerNumber) {
        Player player = gameState.getPlayer(playerNumber);
        if (!player.equals(gameState.getCurrentPlayer()))
            return;
        if (player.isDicePlayedThisTurn())
            return;
        int diceNumber = player.getDice().roll();
        player.setMoveLeft(diceNumber);
        player.setDicePlayedThisTurn(true);
        if (!player.hasMove(gameState.getBoard(), diceNumber)) {
            gameState.nextTurn();
            // todo decrease score
        }
    }

    public void selectPiece(Piece piece) {
        Player player = gameState.getCurrentPlayer();
        if (!player.isDicePlayedThisTurn())
            return;
        if (!player.equals(piece.getPlayer())) {
            selectCell(piece.getCurrentCell());
            return;
        }
        if (piece.isSelected()) {
            piece.setSelected(false);
            player.setSelectedPiece(null);
        } else {
            piece.setSelected(true);
            if (player.getSelectedPiece() != null)
                player.getSelectedPiece().setSelected(false);
            player.setSelectedPiece(piece);
        }
    }

    public void selectCell(Cell cell) {
        Player player = gameState.getCurrentPlayer();
        Piece piece = player.getSelectedPiece();
        if (!player.isDicePlayedThisTurn())
            return;
        if (piece == null)
            return;
        if (piece.isValidMove(cell, player.getMoveLeft())) {
            piece.moveTo(cell);
            gameState.nextTurn();
            // todo check prize and snakes
        }
    }

}