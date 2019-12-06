/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Font;

/**
 *
 * @author Администратор
 */
public class CCPUPanel extends javax.swing.JPanel
{
    public CCPUPanel()
    {
        this.cpu = new CCPU();
    }

    public CCPUPanel(String name, boolean status)
    {
        this.cpu = new CCPU(name, status);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            this.background = ImageIO.read(new File("img/cpupanelbackground.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.drawImage(this.background, 0, 0, this);

        if(this.cpu.getAlly())
            g2.setColor(Color.GREEN);
        else
            g2.setColor(new Color(50, 148, 216));
        
        g2.setFont(new Font("Serif", Font.BOLD, 18));
        g2.drawString(this.cpu.getName(), 8, 30);
        g2.setFont(new Font("Serif", Font.BOLD, 12));
        if(this.cpu.getAlly())
            g2.drawString("Напарник", 8, 45);
        else
            g2.drawString("Противник", 8, 45);
        
        try {
            this.bone = ImageIO.read(new File("img/opponentsbone.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i=0;i<this.cpu.getCount();i++)
        {
            g.drawImage(this.bone, 8+i*11, 60, this);
        }

    }

    private Image background, bone;
    public CCPU cpu;
}
