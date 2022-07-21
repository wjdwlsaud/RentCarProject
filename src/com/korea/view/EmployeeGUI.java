package com.korea.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;

public class EmployeeGUI extends JFrame implements SuperViewer
{

    private JPanel contentPane;

    public EmployeeGUI()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage("image//LOGO.png"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 320, 155, 170);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setResizable(false);
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBounds(12, 10, 150, 121);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("차량관리");
        btnNewButton.setBounds(12, 20, 91, 23);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("회원관리");
        btnNewButton_1.setBounds(12, 50, 91, 23);
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("뒤로가기");

        btnNewButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new CarManagementGUI();
                setVisible(false);
            }
        });

        btnNewButton_1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MemberManagementGUI();
                setVisible(false);
            }
        });
        btnNewButton_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               new MainGUI();
               setVisible(false);
            }
        });
        btnNewButton_2.setBounds(12, 80, 91, 23);
        panel.add(btnNewButton_2);
    }

}
