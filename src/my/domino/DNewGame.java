/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Администратор
 */
public class DNewGame extends JPanel
{
    public DNewGame()
    {
        this.settings = new CGameSettings();

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));
        panel.add(playerNameLabel = new JLabel("Имя игрока"));
        panel.add(playerNameField = new JTextField(""));
        panel.add(cpu1NameLabel = new JLabel("Имя первого противника"));
        panel.add(cpu1NameField = new JTextField(""));
        panel.add(cpu2NameLabel = new JLabel("Имя напарника"));
        panel.add(cpu2NameField = new JTextField(""));
        panel.add(cpu3NameLabel = new JLabel("Имя второго противника"));
        panel.add(cpu3NameField = new JTextField(""));
        panel.add(playerTeamNameLabel = new JLabel("Название команды игрока"));
        panel.add(playerTeamNameField = new JTextField(""));
        panel.add(enemyTeamNameLabel = new JLabel("Название команды противника"));
        panel.add(enemyTeamNameField = new JTextField(""));
        panel.add(gameTypeLabel = new JLabel("Тип игры"));
        panel.add(gameTypeBox = new JComboBox());
        gameTypeBox.addItem("Draw");
        gameTypeBox.addItem("Block");
        panel.add(difficultyLabel = new JLabel("Сложность"));
        panel.add(difficultyBox = new JComboBox());
        difficultyBox.addItem("Простой");
        difficultyBox.addItem("Средний");
        difficultyBox.addItem("Сложный");
        panel.add(maxScoreLabel = new JLabel("Количество очков"));
        panel.add(maxScoreBox = new JComboBox());
        maxScoreBox.addItem(20);
        maxScoreBox.addItem(100);
        maxScoreBox.addItem(500);
        add(panel, BorderLayout.CENTER);

        okButton = new JButton("OK");
        okButton.addActionListener(new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        if(playerNameField.getText().isEmpty())
                            settings.setPlayerName("Player");
                        else
                            settings.setPlayerName(playerNameField.getText());

                        if(cpu1NameField.getText().isEmpty())
                            settings.setCPU1Name("CPU1");
                        else
                            settings.setCPU1Name(cpu1NameField.getText());

                        if(cpu2NameField.getText().isEmpty())
                            settings.setCPU2Name("CPU1");
                        else
                            settings.setCPU2Name(cpu2NameField.getText());

                        if(cpu3NameField.getText().isEmpty())
                            settings.setCPU3Name("CPU1");
                        else
                            settings.setCPU3Name(cpu3NameField.getText());

                        if(playerTeamNameField.getText().isEmpty())
                            settings.setPlayerTeamName("Player's Team");
                        else
                            settings.setPlayerTeamName(playerTeamNameField.getText());

                        if(enemyTeamNameField.getText().isEmpty())
                            settings.setEnemyTeamName("Player's Team");
                        else
                            settings.setEnemyTeamName(enemyTeamNameField.getText());

                        switch(gameTypeBox.getSelectedIndex())
                        {
                            case 0:
                                settings.setGameTypeDraw(true);
                                break;
                            case 1:
                                settings.setGameTypeDraw(false);
                                break;
                        }

                        switch(maxScoreBox.getSelectedIndex())
                        {
                            case 0:
                                settings.setMaxScore(20);
                                break;
                            case 1:
                                settings.setMaxScore(100);
                                break;
                            case 2:
                                settings.setMaxScore(500);
                                break;
                        }
                        
                        settings.setOK(true);
                        dialog.setVisible(false);
                    }
                }
        );

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    settings.setOK(false);
                    dialog.setVisible(false);
                }
            }
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setPlayerName(String s)
    {
        this.playerNameField.setText(s);
    }

    public void setCPU1Name(String s)
    {
        this.cpu1NameField.setText(s);
    }

    public void setCPU2Name(String s)
    {
        this.cpu2NameField.setText(s);
    }

    public void setCPU3Name(String s)
    {
        this.cpu3NameField.setText(s);
    }

    public void setPlayerTeamName(String s)
    {
        this.playerTeamNameField.setText(s);
    }

    public void setEnemyTeamName(String s)
    {
        this.enemyTeamNameField.setText(s);
    }

    public void setMaxScore(int score)
    {
        this.maxScoreBox.setSelectedItem(score);
    }

    public void setGameType(boolean draw)
    {
        if(draw)
            this.gameTypeBox.setSelectedIndex(0);
        else
            this.gameTypeBox.setSelectedIndex(1);
    }

    public void setDifficulty(int difficulty)
    {
        switch(difficulty)
        {
            default:
            case 0:
                this.difficultyBox.setSelectedIndex(0);
                break;
            case 1:
                this.difficultyBox.setSelectedIndex(1);
                break;
            case 2:
                this.difficultyBox.setSelectedIndex(2);
                break;
        }
    }

    public CGameSettings showDialog(Component parent)
    {
        settings.setOK(false);
        
        if(dialog == null)
        {
            dialog = new JDialog((Frame) parent, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        dialog.setTitle("Новая игра");
        dialog.setLocation(parent.getX()+parent.getWidth()/2-this.getWidth()/2, parent.getY()+parent.getHeight()/2-this.getHeight()/2);
        dialog.setVisible(true);

        return settings;
    }

    private JTextField playerNameField, cpu1NameField, cpu2NameField, cpu3NameField;
    private JTextField playerTeamNameField, enemyTeamNameField;
    private JLabel playerNameLabel, cpu1NameLabel, cpu2NameLabel, cpu3NameLabel;
    private JLabel playerTeamNameLabel, enemyTeamNameLabel;
    private JComboBox gameTypeBox, difficultyBox, maxScoreBox;
    private JLabel gameTypeLabel, difficultyLabel, maxScoreLabel;
    private JButton okButton, cancelButton;
    private CGameSettings settings;
    private JDialog dialog;
}
