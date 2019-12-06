/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.util.Random;

/**
 *
 * @author Администратор
 */
public class CCPU
{
    private CHand hand;
    private String name;
    private boolean ally;
    
    public CCPU()
    {
        this.hand = new CHand();
        this.name = new String("");
        this.ally = false;
    }

    public CCPU(String newName, boolean status)
    {
        this.hand = new CHand();
        this.name = new String(newName);
        this.ally = status;
    }

    public int getCount()
    {
        return this.hand.getCount();
    }

    public void putBone(int boneID)
    {
        this.hand.putBone(boneID);
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAlly(boolean status)
    {
        this.ally = status;
    }

    public boolean getAlly()
    {
        return this.ally;
    }

    public int getBiggestDouble(CDeck deck)
    {
        return this.hand.getBiggestDouble(deck);
    }

    public int getBiggestScore(CDeck deck)
    {
        return this.hand.getBiggestScore(deck);
    }

    public int getBone(int boneID)
    {
        return this.hand.getBone(boneID);
    }

    public int showBone(int boneID)
    {
        return this.hand.showBone(boneID);
    }

    public int makeMove(CDeck deck, int numl, int numr)
    {
        int bones[] = new int[13];
        int count = 0;
        Random rand = new Random();

        for(int i=0;i<this.hand.getCount();i++)
        {
            if(deck.getBone(this.hand.showBone(i)).getUp() == numl || deck.getBone(this.hand.showBone(i)).getDown() == numl
               || deck.getBone(this.hand.showBone(i)).getUp() == numr || deck.getBone(this.hand.showBone(i)).getDown() == numr)
            {
                bones[count] = i;
                count++;
            }
        }

        if(count > 0)
            return this.hand.getBone(bones[rand.nextInt(count)]);
        else
            return -1;
    }

    public int getScores(CDeck deck)
    {
        return this.hand.getScores(deck);
    }

    public boolean canMoves(CDeck deck, int numl, int numr)
    {
        return this.hand.canMoves(deck, numl, numr);
    }

    public void emptyHand()
    {
        this.hand.emptyHand();
    }
}
