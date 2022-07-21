package com.korea.view;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.korea.controller.FrontController;
import com.korea.dto.MemberDTO;

import java.awt.Font;
import java.text.SimpleDateFormat;

public class MemberManagementGUI extends JFrame implements SuperViewer
{
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private FrontController controller = new FrontController();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public MemberManagementGUI()
    {
        MemberManagementGUI mmgui = this;
        setTitle("회원 관리");
        setIconImage(Toolkit.getDefaultToolkit().getImage("image//LOGO.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1106, 571);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(12, 10, 1068, 513);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(344, 10, 283, 40);
        panel.add(textField);
        textField.setColumns(10);
        JButton btnNewButton = new JButton("회원 검색");
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setNumRows(0);
                if(textField.getText().equals(""))
                {
                    controller.SubControllerEX("Member", 2, null, mmgui);
                }
                else
                {
                    String member_id = textField.getText();
                    MemberDTO dto = new MemberDTO(member_id);
                    controller.SubControllerEX("Member", 3, dto, mmgui);
                }
            }
        });
        btnNewButton.setBounds(639, 10, 91, 40);
        panel.add(btnNewButton);

        String[] header = {"아이디", "비밀번호", "이름", "나이", "성별", "전화번호", "주소", "면허종류", "면허번호", "면허시작일", "면허만료일"};
        DefaultTableModel model = new DefaultTableModel(header, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return !(column == 0);
            }
        };
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollTable = new JScrollPane(table);
        scrollTable.setBounds(12, 60, 1044, 390);

        panel.add(scrollTable);

        TableColumnModel columnModel = this.table.getColumnModel();
        for(int column = 0; column < table.getColumnCount(); column++)
        {
            int width = 15;
            for(int row = 0; row < table.getRowCount(); row++)
            {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }

        btnNewButton_1 = new JButton("수정");
        btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 12));
        btnNewButton_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int row = table.getSelectedRow();
                String Member_id = table.getModel().getValueAt(row, 0).toString();
                String Member_pw = table.getModel().getValueAt(row, 1).toString();
                String Member_name = table.getModel().getValueAt(row, 2).toString();
                int Member_age = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
                String Member_sex = table.getModel().getValueAt(row, 4).toString();
                String Member_phone = table.getModel().getValueAt(row, 5).toString();
                String Member_addr = table.getModel().getValueAt(row, 6).toString();
                String Member_license = table.getModel().getValueAt(row, 7).toString();
                String license_num = table.getModel().getValueAt(row, 8).toString();
                Date license_start = Date.valueOf(table.getModel().getValueAt(row, 9).toString());
                Date license_end = Date.valueOf(table.getModel().getValueAt(row, 10).toString());
                MemberDTO dto = new MemberDTO(Member_id,Member_pw, Member_name, Member_age, Member_sex, Member_phone, Member_addr, Member_license, license_num, license_start, license_end);
                controller.SubControllerEX("Member", 4, dto, mmgui);
            }
        });
        btnNewButton_1.setBounds(858, 460, 93, 43);
        panel.add(btnNewButton_1);

        btnNewButton_2 = new JButton("삭제");
        btnNewButton_2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int column = 0;
                int row = table.getSelectedRow();
                String value = table.getModel().getValueAt(row, column).toString();
                MemberDTO dto = new MemberDTO(value);
                controller.SubControllerEX("Member", 5, dto, mmgui);
                removeRecord(row);
            }
        });
        btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 12));
        btnNewButton_2.setBounds(963, 460, 93, 43);
        panel.add(btnNewButton_2);

        btnNewButton_3 = new JButton("뒤로가기");
        btnNewButton_3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new EmployeeGUI();
                setVisible(false);
            }
        });
        btnNewButton_3.setBounds(965, 10, 91, 40);
        panel.add(btnNewButton_3);
        setResizable(false);

    }

    public void SelectRecord(ResultSet rs)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try
        {
            while(rs.next())
            {
                String id = rs.getString("member_id");
                String pw = rs.getString("member_pw");
                String name = rs.getString("member_name");
                String age = rs.getString("member_age");
                String sex = rs.getString("member_sex");
                String phone = rs.getString("member_phone");
                String addr = rs.getString("member_addr");
                String license = rs.getString("member_license");
                String license_num = rs.getString("license_num");
                String license_start = simpleDateFormat.format(rs.getDate("license_start"));
                String license_end = simpleDateFormat.format(rs.getDate("license_end"));
                String[] record = {id, pw, name, age, sex, phone, addr, license, license_num, license_start, license_end};
                model.addRow(record);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void removeRecord(int selected)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if(selected < 0)
        {
            if(table.getRowCount() == 0)//비어있는 테이블이면
                return;
            selected = 0;
        }
        model.removeRow(selected);
    }
}