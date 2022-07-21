package com.korea.view;

import com.korea.controller.FrontController;
import com.korea.dto.AuthDTO;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainGUI extends javax.swing.JFrame implements SuperViewer
{
    MainGUI mgui = this;

    public MainGUI()
    {
        getContentPane().setBackground(new Color(239, 228, 176));
        setIconImage(Toolkit.getDefaultToolkit().getImage("image//LOGO.png"));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(239, 228, 176));
        id = new javax.swing.JTextField();
        id.setFont(new Font("굴림", Font.BOLD, 16));
        id1 = new javax.swing.JLabel();
        pw1 = new javax.swing.JLabel();
        pw = new TextField();
        pw.setFont(new Font("굴림", Font.BOLD, 16));
        employee = new javax.swing.JRadioButton();
        member = new javax.swing.JRadioButton();
        radiogroup = new ButtonGroup();
        login = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        controller = new FrontController();
        id.setFocusTraversalKeysEnabled(false);
        id.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_TAB)
                    pw.requestFocus();
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });
        pw.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == 10)
                {
                    if(member.isSelected())
                    {
                        String tmpid = id.getText();
                        String tmppw = pw.getText();
                        AuthDTO dto = new AuthDTO(tmpid, tmppw);
                        boolean r1 = controller.SubControllerEX("Auth", 1, dto, mgui);
                        if(r1)
                        {
                            //인증성공 -> 회원메뉴 출력
                            JOptionPane.showMessageDialog(null, tmpid + " 님 환영합니다!", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "ID/PW 를 확인해주세요", "※ 경고 ※", JOptionPane.DEFAULT_OPTION);
                        }
                    }
                    // 직원 체크박스 클릭후 로그인 -> 직원
                    else if(employee.isSelected())
                    {
                        String tmpid2 = id.getText();
                        String tmppw2 = pw.getText();
                        AuthDTO dto2 = new AuthDTO(tmpid2, tmppw2);
                        boolean r2 = controller.SubControllerEX("Auth", 2, dto2, mgui);
                        if(r2)
                        {
                            //인증성공 -> 회원메뉴 출력
                            new EmployeeGUI();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "ID/PW 를 확인해주세요", "※ 경고 ※", JOptionPane.DEFAULT_OPTION);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });

        login.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(member.isSelected())
                {
                    String tmpid = id.getText();
                    String tmppw = pw.getText();
                    AuthDTO dto = new AuthDTO(tmpid, tmppw);
                    boolean r1 = controller.SubControllerEX("Auth", 1, dto, mgui);
                    if(r1)
                    {
                        //인증성공 -> 회원메뉴 출력
                        JOptionPane.showMessageDialog(null, tmpid + " 님 환영합니다!", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "ID/PW 를 확인해주세요", "※ 경고 ※", JOptionPane.DEFAULT_OPTION);
                    }
                }
                // 직원 체크박스 클릭후 로그인 -> 직원
                else if(employee.isSelected())
                {
                    String tmpid2 = id.getText();
                    String tmppw2 = pw.getText();
                    AuthDTO dto2 = new AuthDTO(tmpid2, tmppw2);
                    boolean r2 = controller.SubControllerEX("Auth", 2, dto2, mgui);
                    if(r2)
                    {
                        //인증성공 -> 회원메뉴 출력
                        new EmployeeGUI();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "ID/PW 를 확인해주세요", "※ 경고 ※", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });
        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(-1);
            }
        });
        SignUp = new javax.swing.JButton();
        SignUp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                SignUpGUI sutmp = new SignUpGUI();
                sutmp.setVisible(true);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GO RENTCAR");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        id1.setFont(new java.awt.Font("맑은 고딕", 0, 24)); // NOI18N
        id1.setText("아이디");

        pw1.setFont(new java.awt.Font("맑은 고딕", 0, 24)); // NOI18N
        pw1.setText("비밀번호");
        employee.setText("직원 로그인");
        member.setText("멤버 로그인");
        login.setText("로그인");
        exit.setText("종 료");
        SignUp.setText("회원가입");
        radiogroup.add(member);
        radiogroup.add(employee);
        member.setSelected(true);
        pw.setEchoChar('*');

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(23).addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(id1).addPreferredGap(ComponentPlacement.RELATED, 316, Short.MAX_VALUE).addComponent(member)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(pw1).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED).addComponent(pw, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)).addComponent(id, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false).addComponent(login, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE).addComponent(exit, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE).addComponent(SignUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addComponent(employee)))).addGap(22)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(112).addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addComponent(member).addComponent(id1)).addPreferredGap(ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(employee).addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(8).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(pw1, Alignment.TRAILING).addComponent(login, Alignment.TRAILING)).addPreferredGap(ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(pw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(SignUp)).addPreferredGap(ComponentPlacement.RELATED).addComponent(exit).addGap(58)));
        jPanel1.setLayout(jPanel1Layout);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("image//LOGO.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(52).addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE).addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(58)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(98).addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(101, Short.MAX_VALUE)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(177, Short.MAX_VALUE).addComponent(lblNewLabel).addGap(162)));
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>

    public void run()
    {
        try
        {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainGUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JButton SignUp;
    private javax.swing.JRadioButton employee;
    private javax.swing.JButton exit;
    private javax.swing.JTextField id;
    private javax.swing.JLabel id1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JRadioButton member;
    private TextField pw;
    private javax.swing.JLabel pw1;
    private javax.swing.ButtonGroup radiogroup;
    private FrontController controller;
}