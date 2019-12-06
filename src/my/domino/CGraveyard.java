/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

/**
 *
 * @author Администратор
 */
public class CGraveyard
{
    private CHand hand;

    public CGraveyard()
    {
        this.hand = new CHand();
    }

    public void putBone(int boneID)
    {
        this.hand.putBone(boneID);
    }

    public int getBone()
    {
        if(this.hand.getCount()>0)
            return this.hand.getBone(this.hand.getCount()-1);
        else
            return -1;
    }

    public int getCount()
    {
        return this.hand.getCount();
    }

    public void emptyGraveyard()
    {
        this.hand.emptyHand();
    }
}
