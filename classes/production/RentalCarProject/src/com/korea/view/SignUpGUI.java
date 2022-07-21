package com.korea.view;

import com.korea.controller.FrontController;
import com.korea.dto.MemberDTO;
import com.korea.TUI.Viewer;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SignUpGUI extends javax.swing.JFrame implements SuperViewer
{

    public SignUpGUI()
    {
        getContentPane().setBackground(new Color(239, 228, 176));
        setBackground(Color.LIGHT_GRAY);
        setIconImage(Toolkit.getDefaultToolkit().getImage("image//LOGO.png"));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        background = new javax.swing.JPanel();
        background.setBackground(new Color(239, 228, 176));
        Member_idL = new javax.swing.JLabel();
        Member_pwL = new javax.swing.JLabel();
        Member_licenseL = new javax.swing.JLabel();
        license_numL = new javax.swing.JLabel();
        license_startL = new javax.swing.JLabel();
        license_endL = new javax.swing.JLabel();
        Member_nameL = new javax.swing.JLabel();
        Member_ageL = new javax.swing.JLabel();
        Member_sexL = new javax.swing.JLabel();
        Member_phoneL = new javax.swing.JLabel();
        Member_addrL = new javax.swing.JLabel();
        Member_id = new javax.swing.JTextField();
        Member_pw = new javax.swing.JTextField();
        Member_name = new javax.swing.JTextField();
        Member_age = new javax.swing.JTextField();
        Member_phone = new javax.swing.JTextField();
        Member_addr = new javax.swing.JTextField();
        Member_license = new javax.swing.JTextField();
        license_num = new javax.swing.JTextField();
        license_start = new javax.swing.JTextField();
        license_end = new javax.swing.JTextField();
        Member_sex_Man = new javax.swing.JRadioButton();
        Member_sex_Woman = new javax.swing.JRadioButton();
        SignUp = new javax.swing.JButton();
        back = new javax.swing.JButton();
        radiogroup = new javax.swing.ButtonGroup();
        controller = new FrontController();
        view = new Viewer();

        SignUp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == SignUp)
                {
                    try
                    {
                        String id = Member_id.getText();
                        String pw = Member_pw.getText();
                        String name = Member_name.getText();
                        int age = Integer.parseInt(Member_age.getText());
                        String phone = Member_phone.getText();
                        String addr = Member_addr.getText();
                        String license = Member_license.getText();
                        String License_num = license_num.getText();
                        Date License_start = Date.valueOf(license_start.getText());
                        Date License_end = Date.valueOf(license_end.getText());
                        String sex;
                        if(Member_sex_Man.isSelected())
                        {
                            sex = "남";
                        }
                        else
                        {
                            sex = "여";
                        }
                        MemberDTO dto = new MemberDTO(id, pw, name, age, sex, phone, addr, license, License_num, License_start, License_end);
                        boolean r = controller.SubControllerEX("Member", 1, dto, view);
                        if(r)
                        {
                            JOptionPane.showMessageDialog(null, "회원가입 성공");
                            setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "중복된 ID 입니다.");
                        }
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "정해진 양식과 맞지않습니다.");
                    }

                }
            }
        });
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == back)
                {
                    setVisible(false);
                }
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("회원가입 창입니다");

        jLabel1.setText("회원 가입 창 입니다");

        Member_idL.setText("ID");

        Member_pwL.setText("PW");

        Member_licenseL.setText("면허종류");

        license_numL.setText("면허번호");

        license_startL.setText("취득일(년-월-일)");

        license_endL.setText("만료일(년-월-일)");

        Member_nameL.setText("이름");

        Member_ageL.setText("나이");

        Member_sexL.setText("성별");

        Member_phoneL.setText("전화번호");

        Member_addrL.setText("주소");

        Member_id.setText("");

        Member_pw.setText("");

        Member_name.setText("");

        Member_age.setText("");

        Member_phone.setText("");

        Member_addr.setText("");

        Member_license.setText("");

        license_num.setText("");

        license_start.setText("");

        license_end.setText("");

        Member_sex_Man.setText("남");

        Member_sex_Woman.setText("여");

        radiogroup.add(Member_sex_Man);
        radiogroup.add(Member_sex_Woman);

        Member_sex_Man.setSelected(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(backgroundLayout.createSequentialGroup().addContainerGap().addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(Member_idL).addComponent(Member_pwL).addComponent(Member_nameL).addComponent(Member_ageL).addComponent(Member_sexL).addComponent(Member_phoneL).addComponent(Member_addrL).addComponent(Member_licenseL).addComponent(license_numL).addComponent(license_startL).addComponent(license_endL)).addGap(37, 37, 37).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(Member_age).addComponent(Member_phone).addComponent(Member_addr).addComponent(Member_license).addComponent(license_num).addComponent(license_start).addComponent(license_end).addComponent(Member_pw).addComponent(Member_name).addGroup(backgroundLayout.createSequentialGroup().addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(backgroundLayout.createSequentialGroup().addComponent(Member_sex_Man).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(Member_sex_Woman)).addComponent(Member_id, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
        backgroundLayout.setVerticalGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(backgroundLayout.createSequentialGroup().addContainerGap().addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_idL).addComponent(Member_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_pwL).addComponent(Member_pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_nameL).addComponent(Member_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_ageL).addComponent(Member_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_sexL).addComponent(Member_sex_Man).addComponent(Member_sex_Woman)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_phoneL).addComponent(Member_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_addrL).addComponent(Member_addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Member_licenseL).addComponent(Member_license, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(license_numL).addComponent(license_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(license_startL).addComponent(license_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(license_endL).addComponent(license_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(46, Short.MAX_VALUE)));

        SignUp.setText("회원가입");

        back.setText("뒤로가기");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap(455, Short.MAX_VALUE).addComponent(SignUp).addGap(18).addComponent(back).addGap(20)).addGroup(layout.createSequentialGroup().addGap(18).addComponent(background, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(76, Short.MAX_VALUE)).addGroup(Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE).addContainerGap(464, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(background, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(SignUp).addComponent(back)).addContainerGap(20, Short.MAX_VALUE)));
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>

    private javax.swing.JTextField Member_addr;
    private javax.swing.JLabel Member_addrL;
    private javax.swing.JTextField Member_age;
    private javax.swing.JLabel Member_ageL;
    private javax.swing.JTextField Member_id;
    private javax.swing.JLabel Member_idL;
    private javax.swing.JTextField Member_license;
    private javax.swing.JLabel Member_licenseL;
    private javax.swing.JTextField Member_name;
    private javax.swing.JLabel Member_nameL;
    private javax.swing.JTextField Member_phone;
    private javax.swing.JLabel Member_phoneL;
    private javax.swing.JTextField Member_pw;
    private javax.swing.JLabel Member_pwL;
    private javax.swing.JLabel Member_sexL;
    private javax.swing.JRadioButton Member_sex_Man;
    private javax.swing.JRadioButton Member_sex_Woman;
    private javax.swing.JButton SignUp;
    private javax.swing.JButton back;
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField license_end;
    private javax.swing.JLabel license_endL;
    private javax.swing.JTextField license_num;
    private javax.swing.JLabel license_numL;
    private javax.swing.JTextField license_start;
    private javax.swing.JLabel license_startL;
    private javax.swing.ButtonGroup radiogroup;
    private FrontController controller;
    private Viewer view;
}
