/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

/**
 *
 * @author Администратор
 */

public class CGameField
{
    private int bones[][], position[][];
    private int num[], count[];
    private int startBone;
    private boolean startBonePutted;
    private DSelectBranch selectBranchDialog;
    private int x, y;

    public CGameField()
    {
        this.bones = new int[2][27];
        this.position = new int[2][27];
        this.startBone = 0;
        this.num = new int[2];
        this.num[0] = 0;
        this.num[1] = 0;
        this.count = new int[2];
        this.count[0] = 0;
        this.count[1] = 0;
        this.startBonePutted = false;
        this.x = 0;
        this.y = 0;
    }

    public void setDialogPosition(int dx, int dy)
    {
        this.x = dx;
        this.y = dy;
    }

    public void makeMove(int boneID, int num, int position, int branch)
    {
            this.bones[branch][this.count[branch]] = boneID;
            this.num[branch] = num;
            this.position[branch][this.count[branch]] = position;
            this.count[branch]++;
    }

    public void makeFirstMove(int boneID, int up, int down)
    {
        this.startBone = boneID;
        this.num[0] = up;
        this.num[1] = down;
        this.startBonePutted = true;
    }

    public int getStartBone()
    {
        return this.startBone;
    }

    public int getCount(int branch)
    {
        return this.count[branch];
    }

    public int getBone(int boneID, int branch)
    {
        return this.bones[branch][boneID];
    }

    public int getPosition(int boneID, int branch)
    {
        return this.position[branch][boneID];
    }

    public int getNum(int branch)
    {
        return this.num[branch];
    }

    public void makeMove(CBone bone, int boneID, boolean human)
    {
        int branch = 0;
        if(!this.startBonePutted)
        {
            this.makeFirstMove(boneID, bone.getUp(), bone.getDown());
        }
        else
        {
            if(human && ((bone.getUp() == this.num[0] && bone.getUp() == this.num[1])
               || (bone.getDown() == this.num[0] && bone.getDown() == this.num[1])
               || (bone.getUp() == this.num[0] && bone.getDown() == this.num[1])
               || (bone.getDown() == this.num[0] && bone.getUp() == this.num[1])))
            {
                branch = this.showDialog();

                if(branch == 0)
                {
                    if(bone.getDown() == this.num[0])
                        this.makeMove(boneID, bone.getUp(), 0, 0);
                    else if(bone.getUp() == this.num[0])
                        this.makeMove(boneID, bone.getDown(), 1, 0);
                }
                else
                {
                    if(bone.getDown() == this.num[1])
                        this.makeMove(boneID, bone.getUp(), 0, 1);
                    else if(bone.getUp() == this.num[1])
                        this.makeMove(boneID, bone.getDown(), 1, 1);
                }
            }
            else
            {
                if(bone.getDown() == this.num[0])
                    this.makeMove(boneID, bone.getUp(), 0, 0);
                else if(bone.getUp() == this.num[0])
                    this.makeMove(boneID, bone.getDown(), 1, 0);
                else if(bone.getDown() == this.num[1])
                    this.makeMove(boneID, bone.getUp(), 0, 1);
                else if(bone.getUp() == this.num[1])
                    this.makeMove(boneID, bone.getDown(), 1, 1);
            }
        }
    }

    public boolean isStartBonePutted()
    {
        return this.startBonePutted;
    }

    public boolean canMove(CBone bone)
    {
        if(bone.getUp() == this.num[0] || bone.getUp() == this.num[1]
           || bone.getDown() == this.num[0] || bone.getDown() == this.num[1])
            return true;
        else
        {
            return false;
        }
    }

    public void emptyGameField()
    {
        this.count[0] = 0;
        this.count[1] = 0;
        this.startBonePutted = false;

    }

    public int showDialog()
    {
        if(selectBranchDialog==null)
            selectBranchDialog= new DSelectBranch();

        selectBranchDialog.setText("Выберите ветку");
        return (selectBranchDialog.showDialog(this.x, this.y))?0:1;
    }
}
