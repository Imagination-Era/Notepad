import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

 

public class About extends JFrame implements ActionListener{
            JButton b1;

    About() {
        setSize(600, 500);
        setLocation(200, 100);
        setLayout(new BorderLayout());

        ImageIcon winImage = new ImageIcon("Win1.jpg");
        JLabel winLabel = new JLabel(winImage);
        add(winLabel, BorderLayout.NORTH);

       ImageIcon iconImage = new ImageIcon("NoteIcon1.png");
        JLabel iconLabel = new JLabel(iconImage);
        JPanel iconPanel = new JPanel();
        iconPanel.add(iconLabel);
        add(iconPanel, BorderLayout.WEST);

        String aboutText = "<html>Microsoft Window<br> Version 2.22223<br> All rights reserved<br><br>Notepad is a word processing program, <br>which allows changing of text in a computer file.<br>Notepad is a simple text editor for basic text-editing program<br> which enables computer users to create documents. </html>";
        JLabel aboutLabel = new JLabel(aboutText);
        aboutLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        add(aboutLabel, BorderLayout.CENTER);

        b1 = new JButton("OK");
        b1.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
