/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.domino;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Администратор
 */
public class DSelectBranch extends JPanel
{
    public DSelectBranch()
    {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(text = new JLabel(""));
        add(panel, BorderLayout.CENTER);

        leftButton = new JButton("Left");
        leftButton.addActionListener(new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        ok = true;
                        dialog.setVisible(false);
                    }
                }
        );

        rightButton = new JButton("Right");
        rightButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    dialog.setVisible(false);
                }
            }
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setText(String s)
    {
        this.text.setText(s);
    }

    public boolean showDialog(int x, int y)
    {
        ok = false;

        if(dialog == null)
        {
            dialog = new JDialog((Frame) null, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(leftButton);
            dialog.pack();
        }

        dialog.setLocation(x, y);
        dialog.setTitle("Выберите ветку");
        dialog.setVisible(true);

        return ok;
    }

    private JLabel text;
    private JButton leftButton, rightButton;
    private boolean ok;
    private JDialog dialog;
}
