/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

/**
 *
 * @author Администратор
 */
public class CScorePanel extends javax.swing.JPanel
{
    public CScorePanel()
    {
        this.score = new CScore("Player", "CPU1", "CPU2", "CPU3", "Player's Team", "Enemy Team", 100);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(50, 148, 216));
        g2.setFont(new Font("Serif", Font.BOLD, 24));
        g2.drawString("Scores", 6, 25);
        g2.setStroke(new BasicStroke(2.0f));
        g2.drawLine(2, 30, 168, 30);
        g2.drawString("Team Scores", 6, 120);
        g2.setStroke(new BasicStroke(2.0f));
        g2.drawLine(2, 125, 168, 125);
        g2.setFont(new Font("Serif", Font.BOLD, 12));

        for(int i = 0;i<4;i++)
        {
            g2.drawString(this.score.getNameByPosition(i), 8, 45+15*i);
            g2.drawString(String.valueOf(this.score.getScoreByPosition(i)), 140, 45+15*i);
        }

        g2.drawString(this.score.getPlayerTeamName(), 8, 140);
        g2.drawString(String.valueOf(this.score.getPlayerTeamScores()), 140, 140);
        g2.drawString(this.score.getEnemyTeamName(), 8, 155);
        g2.drawString(String.valueOf(this.score.getEnemyTeamScores()), 140, 155);
    }

    public CScore score;
}
