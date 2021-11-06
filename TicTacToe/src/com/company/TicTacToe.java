package com.company;

import javax.swing.*;
import java.awt.*;


public class TicTacToe extends JFrame {

    Board board = new Board();

    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 630);
        setLocationRelativeTo(null);
        setResizable(false);

        add(board);

        setVisible(true);

    }
}
