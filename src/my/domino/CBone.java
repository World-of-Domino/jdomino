/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Администратор
 */
public class CBone
{
    private int id, up, down;
    private Image image;

    public CBone()
    {
        this.id = 0;
        this.up = 0;
        this.down = 0;
    }
    
    public CBone(int bone_id)
    {
        this.id = bone_id;
        this.up = this.getUp(bone_id);
        this.down = this.getDown(bone_id);
        try {
            this.image = ImageIO.read(new File("img/"+this.getFileName(bone_id)));
        } catch (IOException ex) {
            Logger.getLogger(CBone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getID()
    {
        return this.id;
    }

    public int getUp()
    {
        return this.up;
    }

    public int getDown()
    {
        return this.down;
    }

    public Image getImage()
    {
        return this.image;
    }

    private String getFileName(int bone_id)
    {
        switch(bone_id)
        {
            case 0:
                return "00.gif";
            case 1:
                return "01.gif";
            case 2:
                return "02.gif";
            case 3:
                return "03.gif";
            case 4:
                return "04.gif";
            case 5:
                return "05.gif";
            case 6:
                return "06.gif";
            case 7:
                return "11.gif";
            case 8:
                return "12.gif";
            case 9:
                return "13.gif";
            case 10:
                return "14.gif";
            case 11:
                return "15.gif";
            case 12:
                return "16.gif";
            case 13:
                return "22.gif";
            case 14:
                return "23.gif";
            case 15:
                return "24.gif";
            case 16:
                return "25.gif";
            case 17:
                return "26.gif";
            case 18:
                return "33.gif";
            case 19:
                return "34.gif";
            case 20:
                return "35.gif";
            case 21:
                return "36.gif";
            case 22:
                return "44.gif";
            case 23:
                return "45.gif";
            case 24:
                return "46.gif";
            case 25:
                return "55.gif";
            case 26:
                return "56.gif";
            case 27:
                return "66.gif";
            default:
                return "00.gif";
        }
    }

    private int getUp(int bone_id)
    {
        switch(bone_id)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return 0;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return 1;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return 2;
            case 18:
            case 19:
            case 20:
            case 21:
                return 3;
            case 22:
            case 23:
            case 24:
                return 4;
            case 25:
            case 26:
                return 5;
            case 27:
                return 6;
            default:
                return 0;
        }
    }

    private int getDown(int bone_id)
    {
        switch(bone_id)
        {
            case 0:
                return 0;
            case 1:
            case 7:
                return 1;
            case 2:
            case 8:
            case 13:
                return 2;
            case 3:
            case 9:
            case 14:
            case 18:
                return 3;
            case 4:
            case 10:
            case 15:
            case 19:
            case 22:
                return 4;
            case 5:
            case 11:
            case 16:
            case 20:
            case 23:
            case 25:
                return 5;
            case 6:
            case 12:
            case 17:
            case 21:
            case 24:
            case 26:
            case 27:
                return 6;
            default:
                return 0;
        }
    }
}
