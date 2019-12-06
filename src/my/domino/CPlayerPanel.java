/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.io.File;

/**
 *
 * @author Администратор
 */
public class CPlayerPanel extends javax.swing.JPanel
{
    public CPlayerPanel()
    {
        this.hand = new CHand();
        this.deck = new CDeck();

        /*hand.putBone(0);
        hand.putBone(2);
        hand.putBone(3);
        hand.putBone(7);
        hand.putBone(8);
        hand.putBone(9);
        hand.putBone(4);
        hand.putBone(17);
        hand.putBone(20);
        hand.putBone(22);
        hand.putBone(19);
        hand.putBone(13);
        hand.putBone(1);*/
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        try {
            this.background = ImageIO.read(new File("img/playerpanelbackground.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        g.drawImage(background, 0, 0, this);

        g.drawString(this.string, 0, 20);


        for(int i=0;i<hand.getCount();i++)
        {
            g.drawImage(this.deck.getBone(hand.showBone(i)).getImage(), 20+i*25, 30, this);
        }

    }

    public void setDeck(CDeck newDeck)
    {
        this.deck = newDeck;
    }

    private CDeck deck;
    private Image background;
    public String string;
    public CHand hand;
}
