/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

/**
 *
 * @author Администратор
 */
public class CGameSettings
{
    private int maxScore;
    private String playerName, cpu1Name, cpu2Name, cpu3Name, playerTeamName, enemyTeamName;
    private boolean gameTypeDraw;
    private int difficulty;
    private boolean gameStarted;
    private boolean ok;

    public CGameSettings()
    {
        this.maxScore = 100;
        this.playerName = "Player";
        this.cpu1Name = "CPU1";
        this.cpu2Name = "CPU2";
        this.cpu3Name = "CPU3";
        this.playerTeamName = "Player's Team";
        this.enemyTeamName = "Enemy Name";
        this.gameTypeDraw = true;
        this.difficulty = 0;
        this.ok = false;
    }

    public void setPlayerName(String name)
    {
        this.playerName = name;
    }

    public void setCPU1Name(String name)
    {
        this.cpu1Name = name;
    }

    public void setCPU2Name(String name)
    {
        this.cpu2Name = name;
    }

    public void setCPU3Name(String name)
    {
        this.cpu3Name = name;
    }

    public void setPlayerTeamName(String name)
    {
        this.playerTeamName = name;
    }

    public void setEnemyTeamName(String name)
    {
        this.enemyTeamName = name;
    }

    public void setGameTypeDraw(boolean draw)
    {
        this.gameTypeDraw = draw;
    }

    public void setMaxScore(int score)
    {
        this.maxScore = score;
    }

    public String getPlayerName()
    {
        return this.playerName;
    }

    public String getCPU1Name()
    {
        return this.cpu1Name;
    }

    public String getCPU2Name()
    {
        return this.cpu2Name;
    }

    public String getCPU3Name()
    {
        return this.cpu3Name;
    }

    public String getPlayerTeamName()
    {
        return this.playerTeamName;
    }

    public String getEnemyTeamName()
    {
        return this.enemyTeamName;
    }

    public boolean isGameTypeDraw()
    {
        return this.gameTypeDraw;
    }

    public int getMaxScore()
    {
        return this.maxScore;
    }

    public int getDifficulty()
    {
        return this.difficulty;
    }

    public void startGame()
    {
        this.gameStarted = true;
    }

    public void endGame()
    {
        this.gameStarted = false;
    }

    public boolean isGameStarted()
    {
        return this.gameStarted;
    }

    public void setOK(boolean nok)
    {
        this.ok = nok;
    }

    public boolean getOK()
    {
        return this.ok;
    }
}
