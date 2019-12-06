/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

/**
 *
 * @author Администратор
 */
public class CHand
{
    private int bones[];
    private int count;

    public CHand()
    {
        count = 0;
        bones = new int[13];
    }

    public boolean putBone(int boneID)
    {
        if(this.count<13)
        {
            this.bones[this.count] = boneID;
            this.count++;
            this.sortBones();
            return true;
        }
        else
            return false;
    }

    public int showBone(int boneID)
    {
        if(boneID<this.count)
        {
            return this.bones[boneID];
        }
        else
            return -1;
    }

    public int getBone(int boneID)
    {
        if(boneID<this.count)
        {
            int bone = this.bones[boneID];
            for(int i=boneID;i<12;i++)
            {
                this.bones[i] = this.bones[i+1];
            }
            this.count--;
            return bone;
        }
        else
            return -1;
    }

    public void sortBones()
    {
        int key;
        int j;

        for(int i=0;i<this.count;i++)
        {
            key = this.bones[i];
            j = i - 1;
            while(j>=0 && this.bones[j]>key)
            {
                this.bones[j+1] = this.bones[j];
                j--;
            }
            this.bones[j+1] = key;
        }
    }

    public int getCount()
    {
        return this.count;
    }

    public int getBiggestDouble(CDeck deck)
    {
        int num = -1;
        int score = -1;

        for(int i=0;i<this.count;i++)
        {
            if(deck.getBone(this.bones[i]).getUp() == deck.getBone(this.bones[i]).getDown())
            {
                if(deck.getBone(this.bones[i]).getUp() >= score)
                {
                    score = deck.getBone(this.bones[i]).getUp();
                    num = i;
                }
            }
        }
        
        return num;
    }

    public int getBiggestScore(CDeck deck)
    {
        int num = -1;
        int score = -1;

        for(int i=0;i<this.count;i++)
        {
            if(deck.getBone(this.bones[i]).getUp() + deck.getBone(this.bones[i]).getDown() >= score)
            {
                score = deck.getBone(this.bones[i]).getUp();
                num = i;
            }
        }

        return num;
    }

    public boolean canMoves(CDeck deck, int numl, int numr)
    {
        boolean result = false;
        for(int i=0;i<this.count;i++)
        {
            if(deck.getBone(this.bones[i]).getUp() == numl || deck.getBone(this.bones[i]).getDown() == numl
               || deck.getBone(this.bones[i]).getUp() == numr || deck.getBone(this.bones[i]).getDown() == numr)
                result = true;
        }

        return result;
    }

    public int getScores(CDeck deck)
    {
        int scores = 0;

        for(int i=0;i<this.count;i++)
        {
            scores += deck.getBone(this.bones[i]).getUp() + deck.getBone(this.bones[i]).getDown();
        }

        return scores;
    }

    public void emptyHand()
    {
        for(int i=this.count-1;i>=0;i--)
        {
            this.getBone(i);
        }
    }
}
