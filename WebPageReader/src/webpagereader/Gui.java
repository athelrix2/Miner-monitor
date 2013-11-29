/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webpagereader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

/**
 *
 * @author Justin
 */
public class Gui implements ActionListener{
    private JFrame window;
    private JPanel ori;
    private JLabel label;
    private JButton key;
    private String keytext;
    public Gui () {
        keytext=keyGetter();
        window=new JFrame();
        ori=new JPanel();
        label=new JLabel("ddddd");
        label.setFont(new Font("Papyrus",100,100));
        key=new JButton("update key");
        ori.add(label);
        ori.add(key);
        window.add(ori);
        window.setSize(700,300);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        key.addActionListener(this);
        loop();
    }
    private String keyGetter()
    {
        return JOptionPane.showInputDialog("Enter a key");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        keytext=keyGetter();
    }
    private void loop()
    {
        while(true)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch(Exception e){}
            String input=Reader.getText(keytext);
            if(!input.equals(""))
                label.setText(input);
        }
    }
}
