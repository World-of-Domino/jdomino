/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Администратор
 */
class DShowWinner extends JPanel
{
    public DShowWinner()
    {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.add(end = new JLabel(""));
        panel.add(score_label = new JLabel(""));
        panel.add(score1 = new JLabel(""));
        panel.add(score2 = new JLabel(""));
        panel.add(score3 = new JLabel(""));
        panel.add(score4 = new JLabel(""));
        panel.add(end_game = new JLabel(""));
        add(panel, BorderLayout.CENTER);

        okButton = new JButton("OK");
        okButton.addActionListener(new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        ok = true;
                        dialog.setVisible(false);
                    }
                }
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        add(buttonPanel, BorderLayout.SOUTH);

        this.names = new String[4];
        this.scores = new int[4];
    }

    public void setWinner(String s, String gs)
    {
        this.winnerName = s;
        this.gameWinnerName = gs;
    }

    public void setNames(String playerName, String cpu1Name, String cpu2Name, String cpu3Name)
    {
        this.names[0] = playerName;
        this.names[1] = cpu1Name;
        this.names[2] = cpu2Name;
        this.names[3] = cpu3Name;
    }

    public void setScores(int playerScore, int cpu1Score, int cpu2Score, int cpu3Score)
    {
        this.scores[0] = playerScore;
        this.scores[1] = cpu1Score;
        this.scores[2] = cpu2Score;
        this.scores[3] = cpu3Score;
    }

    public void setText()
    {
        if(this.winnerName.length() == 0)
            this.end.setText("Раунд окончен в ничью.");
        else
            this.end.setText("Раунд окончен. Победил "+ this.winnerName);

        this.score_label.setText("Полученные очки:");
        this.score1.setText(this.names[0] + " --- " + String.valueOf(this.scores[0]));
        this.score2.setText(this.names[1] + " --- " + String.valueOf(this.scores[1]));
        this.score3.setText(this.names[2] + " --- " + String.valueOf(this.scores[2]));
        this.score4.setText(this.names[3] + " --- " + String.valueOf(this.scores[3]));

        if(this.gameWinnerName.length() != 0)
            this.end_game.setText("Игра окончена! Победил " + this.gameWinnerName);
        else
            this.end_game.setText("");
    }

    public boolean showDialog(Component parent, boolean endGame)
    {
        ok = true;

        if(dialog == null)
        {
            dialog = new JDialog((Frame) parent, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }
        dialog.setLocation(parent.getX()+parent.getWidth()/2-this.getWidth()/2, parent.getY()+parent.getHeight()/2-this.getHeight()/2);

       
        if(endGame)
        {
            dialog.setTitle("Игра окончена!");
        }
        else
        {
            dialog.setTitle("Раунд окончен!");
        }
        
        this.setText();
        dialog.setVisible(true);

        return ok;
    }

    private JLabel end, score_label, score1, score2, score3, score4, end_game;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;
    private String names[];
    private int scores[];
    private String winnerName, gameWinnerName;
}
