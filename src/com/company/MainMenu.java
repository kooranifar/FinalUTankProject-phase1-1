package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    Window frame;

//    JButton button;

    public MainMenu() {

        JButton start = new JButton("Start");
        this.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // timer he o dastan bayad biad inja
                MainMenu.super.setVisible(false);

//                frame.setSize(700,700);

                Game game = new Game();

                game.setVisible(true);
                game.setFocusable(true);
                game.requestFocusInWindow();

                JButton akbar = new JButton("Quit");
                akbar.setBounds(200,100,300,300);
                akbar.setVisible(true);

                game.addKeyListener(new GameActionListener());

//                frame.add(game);

//                frame.game = game;
                frame.setGame(game);
                game.add(akbar);

                frame.setLayout(null);
                frame.setVisible(true);

                akbar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame.game.setVisible(false);

//                        mainMenu.setVisible(true);
                        MainMenu.super.setVisible(true);

                    }

                });

                new Timer(
                        10,
                        e -> {
                            game.updateState();
                            game.repaint();
                        }
                ).start();

            }
        });


        JButton quit = new JButton("Quit");
        this.add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // what to do here;
            }
        });

        JButton rules = new JButton("Rules");
        this.add(rules);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainMenu.super.setVisible(false);
                frame.rulesMenu.setVisible(true);
            }
        });
    }
}