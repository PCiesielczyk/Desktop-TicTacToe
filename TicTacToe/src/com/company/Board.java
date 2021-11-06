package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Board extends JPanel {

    JLabel labelStatus = new JLabel("Game in progress");
    JButton resetButton = new JButton("Reset");
    JButton[][] button = new JButton[3][3];
    boolean xTurn = true;


    public Board() {
        setLayout(null);
        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.LIGHT_GRAY);
        boardPanel.setBounds(0,0,540,630);
        boardPanel.setLayout(null);
        add(boardPanel);

        labelStatus.setBounds(20, 550, 200, 30);
        LabelStatus();
        add(labelStatus);

        resetButton.setBounds(390, 550, 100, 30);
        resetButton.setFocusPainted(false);
        add(resetButton);

        ActionListener actionListener = actionEvent -> {
            JButton button = (JButton)actionEvent.getSource();
            labelStatus.setText("Game in progress");
            if (!button.getText().equals("O") && !button.getText().equals("X")
                    && !gameOn().equals("X wins") && !gameOn().equals("O wins")) {
                if(xTurn) {
                    xTurn = false;
                    button.setText("X");
                } else {
                    xTurn = true;
                    button.setText("O");
                }
            }
            if(gameOn().equals("X wins"))  {
                labelStatus.setText(gameOn());
            } else if(gameOn().equals("O wins")) {
                labelStatus.setText(gameOn());
            } else if(gameOn().equals("Draw")) {
                labelStatus.setText(gameOn());
            }
        };

        Font fieldFont = new Font("TimesRoman", Font.BOLD, 110);
        int butSizeY = 0;
        int butSizeX = 0;
        int j = 0;
        for (int i = 3; i > 0; i--) {
            for (char start = 'A'; start < 'D'; start++) {
                if (start == 'A') butSizeX = 0;
                String cellName = start + String.valueOf(i);
                button[j][i-1] = new JButton(" ");
                button[j][i-1].setName("Button" + cellName);
                button[j][i-1].setPreferredSize(new Dimension(180, 180));
                button[j][i-1].setBounds(butSizeX, butSizeY, 180, 180);
                butSizeX += 180;
                button[j][i-1].setFont(fieldFont);
                button[j][i-1].setFocusPainted(false);
                button[j][i-1].addActionListener(actionListener);
                boardPanel.add(button[j][i-1]);
                j++;
            }
            j = 0;
            butSizeY += 180;
        }
        boardPanel.add(labelStatus);
        boardPanel.add(resetButton);

        resetButton.addActionListener(e -> {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    button[x][y].setText(" ");
                    button[x][y].setForeground(Color.BLACK);
                }
            }
            labelStatus.setText("Game is not started");
            xTurn = true;
        });
    }


    private void LabelStatus () {
        String status = "Game is not started";
        labelStatus.setText(status);
        Font statusFont = new Font("TimesRoman", Font.BOLD, 13);
        labelStatus.setFont(statusFont);
    }
    private String gameOn () {
        boolean draw = true;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (button[x][y].getText().equals(" ")) {draw = false;}
            }
        }
        if (button[0][2].getText().equals(button[1][2].getText())
                && button[1][2].getText().equals(button[2][2].getText())
                && !button[0][2].getText().equals(" ")) {
            for (int i = 0; i < 3; i++) {button[i][2].setForeground(Color.RED);}
            if (button[0][2].getText().equals("X")) {
                return "X wins";
            } else {return "O wins";}
        } else if (button[0][1].getText().equals(button[1][1].getText())
                && button[1][1].getText().equals(button[2][1].getText())
                && !button[0][1].getText().equals(" ")) {
            for (int i = 0; i < 3; i++) {button[i][1].setForeground(Color.RED);}
            if (button[0][1].getText().equals("X")) {
                return "X wins";
            } else {return "O wins";}
        } else if (button[0][0].getText().equals(button[1][0].getText())
                && button[1][0].getText().equals(button[2][0].getText())
                && !button[0][0].getText().equals(" ")) {
            for (int i = 0; i < 3; i++) {button[i][0].setForeground(Color.RED);}
            if (button[0][0].getText().equals("X")) {
                return "X wins";
            } else {return "O wins";}
        } else if (button[0][2].getText().equals(button[0][1].getText())
                && button[0][1].getText().equals(button[0][0].getText())
                && !button[0][2].getText().equals(" ")) {
            for (int i = 0; i < 3; i++) {button[0][i].setForeground(Color.RED);}
            if (button[0][2].getText().equals("X")) {
                labelStatus.setText("X wins");
                return "X wins";
            } else {return "O wins";}
        } else if (button[1][2].getText().equals(button[1][1].getText())
                && button[1][1].getText().equals(button[1][0].getText())
                && !button[1][2].getText().equals(" ")) {
            for (int i = 0; i < 3; i++) {button[1][i].setForeground(Color.RED);}
            if (button[1][2].getText().equals("X")) {
                return "X wins";
            } else {return "O wins";}
        } else if (button[2][2].getText().equals(button[2][1].getText())
                && button[2][1].getText().equals(button[2][0].getText())
                && !button[2][2].getText().equals(" ")) {
            for (int i = 0; i < 3; i++) {button[2][i].setForeground(Color.RED);}
            if (button[2][2].getText().equals("X")) {
                return "X wins";
            } else {return "O wins";}
        } else if (button[0][2].getText().equals(button[1][1].getText())
                && button[1][1].getText().equals(button[2][0].getText())
                && !button[0][2].getText().equals(" ")) {
            button[0][2].setForeground(Color.RED);
            button[1][1].setForeground(Color.RED);
            button[2][0].setForeground(Color.RED);
            if (button[0][2].getText().equals("X")) {
                return "X wins";
            } else {return "O wins";}
        } else if (button[2][2].getText().equals(button[1][1].getText())
                && button[1][1].getText().equals(button[0][0].getText())
                && !button[2][2].getText().equals(" ")) {
            for (int i = 0; i < 3; i++) {button[i][i].setForeground(Color.RED);}
            if (button[2][2].getText().equals("X")) {
                return "X wins";
            } else {return "O wins";}
        } else if (draw) {
            return "Draw";
        } else {return "Game in progress";}
    }
}
