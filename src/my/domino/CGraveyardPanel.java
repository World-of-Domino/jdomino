/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Администратор
 */
public class CGraveyardPanel extends javax.swing.JPanel
{
    public CGraveyardPanel()
    {
        this.graveyard = new CGraveyard();
        this.states = new Image[9];

        try {
            this.background = ImageIO.read(new File("img/graveyardpanelbackground.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[0] = ImageIO.read(new File("img/endturn.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[1] = ImageIO.read(new File("img/g1.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[2] = ImageIO.read(new File("img/g2.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[3] = ImageIO.read(new File("img/g3.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[4] = ImageIO.read(new File("img/g4.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[5] = ImageIO.read(new File("img/g5.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[6] = ImageIO.read(new File("img/g6.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[7] = ImageIO.read(new File("img/g7.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.states[8] = ImageIO.read(new File("img/g8.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(this.background, 0, 0, this);

        g.drawImage(this.states[this.graveyard.getCount()], 0, 0, this);
    }

    private Image background;
    private Image states[];
    public CGraveyard graveyard;
}
