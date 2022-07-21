package com.korea.view;

import com.korea.controller.FrontController;
import com.korea.dto.CarDTO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class CarManagementGUI extends JFrame implements SuperViewer
{
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private FrontController controller = new FrontController();

    public CarManagementGUI()
    {
        CarManagementGUI cmgui = this;
        setTitle("차량 관리");
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
        JButton btnNewButton = new JButton("차량 검색");
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setNumRows(0);
                if(textField.getText().equals(""))
                {
                    controller.SubControllerEX("Car", 1, null, cmgui);
                }
                else
                {
                    String Car_Name = textField.getText();
                    CarDTO dto = new CarDTO(Car_Name, 1);
                    boolean result2 = controller.SubControllerEX("Car", 2, dto, cmgui);
                }
            }
        });
        btnNewButton.setBounds(639, 10, 91, 40);
        panel.add(btnNewButton);

        String[] header = {"차량번호", "차종", "인승", "차량색상", "대여가격", "대여가능여부"};
        DefaultTableModel model = new DefaultTableModel(header, 0)
        {
            public boolean isCellEditable(int row, int column)
            {
                return !(column == 0);
            }
        };
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollTable = new JScrollPane(table);
        scrollTable.setBounds(12, 60, 1044, 380);
        panel.add(scrollTable);
        textField_1 = new JTextField();
        textField_1.setBounds(12, 450, 115, 34);
        panel.add(textField_1);
        textField_1.setColumns(10);
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(139, 450, 115, 34);
        panel.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(266, 450, 115, 34);
        panel.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(393, 450, 115, 34);
        panel.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(520, 450, 115, 34);
        panel.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(647, 450, 115, 34);
        panel.add(textField_6);

        JTextField[] fields = {textField_1, textField_2, textField_3, textField_4, textField_5, textField_6};
        btnNewButton_1 = new JButton("수정");
        btnNewButton_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int row = table.getSelectedRow();
                String Car_Code = table.getModel().getValueAt(row, 0).toString();
                String Car_Name = table.getModel().getValueAt(row, 1).toString();
                int Car_Person = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
                String Car_Color = table.getModel().getValueAt(row, 3).toString();
                int Car_Price = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
                CarDTO dto = new CarDTO(Car_Code, Car_Name, Car_Person, Car_Color, Car_Price);
                controller.SubControllerEX("Car", 4, dto, cmgui);
            }
        });
        btnNewButton_1.setBounds(774, 450, 71, 34);
        panel.add(btnNewButton_1);

        btnNewButton_2 = new JButton("추가");
        btnNewButton_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addRecord(fields);
            }
        });
        btnNewButton_2.setBounds(857, 450, 71, 34);
        panel.add(btnNewButton_2);

        btnNewButton_3 = new JButton("삭제");
        btnNewButton_3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int column = 0;
                int row = table.getSelectedRow();
                String value = table.getModel().getValueAt(row, column).toString();
                CarDTO dto = new CarDTO(value);
                controller.SubControllerEX("Car", 5, dto, cmgui);
                removeRecord(row);
            }
        });
        btnNewButton_3.setBounds(940, 450, 71, 34);
        panel.add(btnNewButton_3);

        btnNewButton_4 = new JButton("뒤로가기");
        btnNewButton_4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new EmployeeGUI();
                setVisible(false);
            }
        });
        btnNewButton_4.setBounds(965, 10, 91, 40);
        panel.add(btnNewButton_4);

        JLabel lblNewLabel = new JLabel("차량번호");
        lblNewLabel.setBounds(12, 488, 71, 15);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("차종");
        lblNewLabel_1.setBounds(139, 488, 71, 15);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("차량인승");
        lblNewLabel_2.setBounds(266, 488, 71, 15);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("차량색상");
        lblNewLabel_3.setBounds(393, 488, 71, 15);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("대여가격");
        lblNewLabel_4.setBounds(520, 488, 71, 15);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("대여가능여부");
        lblNewLabel_5.setBounds(645, 488, 85, 15);
        panel.add(lblNewLabel_5);
        setResizable(false);
    }

    private boolean isInvalidInput(String input)
    {
        return input == null || input.length() == 0;
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

    public void addRecord(JTextField[] fields)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] record = new String[6];
        for(int i = 0; i < 6; i++)
        {
            if(isInvalidInput(fields[i].getText()))
            {
                System.out.println("Invalid Input");
                return;
            }
            record[i] = fields[i].getText();
        }
        model.addRow(record);
        CarDTO dto = new CarDTO(record[0], record[1], Integer.parseInt(record[2]), record[3], Integer.parseInt(record[4]));
        controller.SubControllerEX("Car", 3, dto, this);
        //모든 TextField 비우기
        for(int i = 0; i < 6; i++)
            fields[i].setText("");

        fields[0].requestFocus();
    }

    public void SelectRecord(ResultSet rs)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try
        {
            while(rs.next())
            {
                String code = rs.getString("Car_Code");
                String name = rs.getString("Car_Name");
                String person = rs.getString("Car_Person");
                String color = rs.getString("Car_Color");
                String price = rs.getString("Car_Price");
                String rentable = rs.getString("Car_Rentable");
                String[] record = {code, name, person, color, price, rentable};
                model.addRow(record);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}