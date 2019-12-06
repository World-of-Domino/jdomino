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
public class CDeck
{
    private CBone bones[];
    private int indexes[];

    public CDeck()
    {
        bones = new CBone[28];
        indexes = new int[28];

        for(int i=0;i<28;i++)
        {
            bones[i] = new CBone(i);
            indexes[i] = i;
        }

        this.Shuffle();
    }

    public void Shuffle()
    {
        Random rng = new Random();  // java.util.Random
        // n is the number of items remaining to be shuffled.
        for (int n = this.indexes.length; n > 1; n--)
        {
            // Pick a random element to swap with the nth element.
            int k = rng.nextInt(n);  // 0 <= k <= n-1 (0-based array)
            // Swap array elements.
            int tmp = this.indexes[k];
            this.indexes[k] = this.indexes[n-1];
            this.indexes[n-1] = tmp;
        }
    }

    public CBone getBone(int number)
    {
        if(number >= 0 && number < 28)
            return this.bones[this.indexes[number]];
        else
            return null;
    }
}
