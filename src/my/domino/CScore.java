/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

/**
 *
 * @author Администратор
 */
public class CScore
{
    private int scores[], playerTeamScores, enemyTeamScores;
    private String names[], playerTeamName, enemyTeamName;
    private int position[];
    private int maxScore;

    public CScore()
    {
        this.names = new String[4];
        this.scores = new int[4];
        this.position = new int[4];
        this.names[0] = "";
        this.names[1] = "";
        this.names[2] = "";
        this.names[3] = "";
        this.playerTeamName = "";
        this.enemyTeamName = "";
        this.scores[0] = 0;
        this.scores[1] = 0;
        this.scores[2] = 0;
        this.scores[3] = 0;
        this.playerTeamScores = 0;
        this.enemyTeamScores = 0;
        this.position[0] = 0;
        this.position[1] = 1;
        this.position[2] = 2;
        this.position[3] = 3;
        this.maxScore = 100;
    }

    public CScore(String playerName, String cpu1Name, String cpu2Name, String cpu3Name, String pTeamName, String eTeamName, int score)
    {
        this.names = new String[4];
        this.scores = new int[4];
        this.position = new int[4];
        this.names[0] = playerName;
        this.names[1] = cpu1Name;
        this.names[2] = cpu2Name;
        this.names[3] = cpu3Name;
        this.playerTeamName = pTeamName;
        this.enemyTeamName = eTeamName;
        this.scores[0] = 0;
        this.scores[1] = 0;
        this.scores[2] = 0;
        this.scores[3] = 0;
        this.playerTeamScores = 0;
        this.enemyTeamScores = 0;
        this.position[0] = 0;
        this.position[1] = 1;
        this.position[2] = 2;
        this.position[3] = 3;
        this.maxScore = score;
    }

    public boolean addScore(int playerID, int score)
    {
        this.scores[playerID] += score;
        this.sort();

        if(this.scores[playerID] >= this.maxScore)
            return true;
        else
            return false;
    }

    public void addPlayerTeamScore(int score)
    {
        this.playerTeamScores += score;
    }

    public void addEnemyTeamScore(int score)
    {
        this.enemyTeamScores += score;
    }

    public void setName(int playerID, String name)
    {
        this.names[playerID] = name;
    }

    public void setPlayerTeamName(String name)
    {
        this.playerTeamName = name;
    }

    public void setEnemyTeamName(String name)
    {
        this.enemyTeamName = name;
    }

    public String getPlayerTeamName()
    {
        return this.playerTeamName;
    }

    public String getEnemyTeamName()
    {
        return this.enemyTeamName;
    }

    public int getScore(int playerID)
    {
        return this.scores[playerID];
    }

    public int getPlayerTeamScores()
    {
        return this.playerTeamScores;
    }

    public int getEnemyTeamScores()
    {
        return this.enemyTeamScores;
    }
    
    public String getName(int playerID)
    {
        return this.names[playerID];
    }

    public int getScoreByPosition(int position)
    {
        return this.scores[this.position[position]];
    }

    public String getNameByPosition(int position)
    {
        return this.names[this.position[position]];
    }

    public void sort()
    {
        int key;
        int j;
        int pos;

        for(int i=0;i<4;i++)
        {
            key = this.scores[this.position[i]];
            pos = this.position[i];
            j = i - 1;
            while(j>=0 && this.scores[this.position[j]]>key)
            {
                this.position[j+1] = this.position[j];
                j--;
            }
            this.position[j+1] = pos;
        }
    }

    public void setMaxScore(int score)
    {
        this.maxScore = score;
    }
}
