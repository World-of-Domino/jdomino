/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
public class CGameFieldPanel extends javax.swing.JPanel
{
    public CGameFieldPanel()
    {
        this.gamefield = new CGameField();
        this.gamefield.setDialogPosition(this.getX()+this.getWidth()/2, this.getY()+this.getHeight());
        this.deck = new CDeck();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        try {
            this.background = ImageIO.read(new File("img/gamefieldpanelbackground.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CPlayerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.drawImage(this.background, 0, 0, this);
        
        if(gamefield.isStartBonePutted())
            g.drawImage(deck.getBone(gamefield.getStartBone()).getImage(), 230, 113, this);

        this.drawBones(g2, deck, gamefield, 0, 230, 125, 0, 0, this.getWidth(), 0, 100);
        this.drawBones(g2, deck, gamefield, 1, 250, 125, 1, 0, this.getWidth(), 170, this.getHeight());
    }

    private void drawBones(Graphics2D g2, CDeck deck, CGameField gamefield, int branch, int X, int Y, int rotation, int minX, int maxX, int minY, int maxY)
    {
        for(int i=0;i<gamefield.getCount(branch);i++)
        {
                switch(rotation)
                {
                    case 0:

                            if(gamefield.getPosition(i, branch)==0)
                            {
                                X-=44;
                                g2.rotate(Math.toRadians(270), X, Y+20);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X, Y+20, this);
                                g2.rotate(Math.toRadians(-270), X, Y+20);

                            }
                            else if(gamefield.getPosition(i, branch)==1)
                            {
                                g2.rotate(Math.toRadians(90), X, Y);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X, Y, this);
                                g2.rotate(Math.toRadians(-90), X, Y);
                                X-=44;
                            }
                            else
                            {
                                X-=20;
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X, Y-12, this);
                            }



                        if(X<=minX+44)
                        {
                            rotation = 2;

                            if(X<=minX+20)
                                Y-=44;
                            else
                            {
                                X-=20;
                                Y-=24;
                            }
                        }
                    break;
                    case 1:

                            if(gamefield.getPosition(i, branch)==0)
                            {
                                X+=44;
                                g2.rotate(Math.toRadians(90), X, Y);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X, Y, this);
                                g2.rotate(Math.toRadians(-90), X, Y);

                            }
                            else if(gamefield.getPosition(i, branch)==1)
                            {
                                g2.rotate(Math.toRadians(270), X, Y);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X-20, Y, this);
                                g2.rotate(Math.toRadians(-270), X, Y);
                                X+=44;
                            }
                            else
                            {

                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X, Y-12, this);
                                X+=20;
                            }

                        if(X>=maxX-44)
                        {
                            rotation = 3;
                            if(X>=maxX-20)
                            {
                                X-=20;
                                Y+=20;
                            }
                        }
                    break;
                    case 2:
                        //Y-=44;

                            if(gamefield.getPosition(i, branch)==0)
                            {
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X, Y, this);
                                Y-=44;
                            }
                            else if(gamefield.getPosition(i, branch)==1)
                            {
                                g2.rotate(Math.toRadians(180), X, Y);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X-20, Y-44, this);
                                g2.rotate(Math.toRadians(-180), X, Y);
                                Y-=44;
                            }
                            else
                            {
                                Y-=20;
                                g2.rotate(Math.toRadians(90), X, Y);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X+44, Y-32, this);
                                g2.rotate(Math.toRadians(-90), X, Y);
                            }

                        if(Y<=minY+20)
                        {
                            rotation=1;
                            Y+=24;
                        }
                    break;
                    case 3:
                        //Y+=44;


                            if(gamefield.getPosition(i, branch)==0)
                            {
                                g2.rotate(Math.toRadians(180), X, Y);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X-20, Y-44, this);
                                g2.rotate(Math.toRadians(-180), X, Y);
                                Y+=44;
                            }
                            else if(gamefield.getPosition(i, branch)==1)
                            {
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X, Y, this);
                                Y+=44;
                            }
                            else
                            {
                                Y+=20;
                                g2.rotate(Math.toRadians(90), X, Y);
                                g2.drawImage(deck.getBone(gamefield.getBone(i, branch)).getImage(), X-20, Y-32, this);
                                g2.rotate(Math.toRadians(-90), X, Y);
                            }

                            if(Y>=maxY-44)
                            {
                                rotation=0;
                                //Y-=20;
                                X+=20;
                            }
                    break;
                }
        }
    }

    private Image background;
    public CGameField gamefield;
    public CDeck deck;
}
