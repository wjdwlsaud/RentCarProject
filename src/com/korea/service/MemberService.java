package com.korea.service;

import com.korea.domain.MemberDAO;
import com.korea.dto.MemberDTO;
import com.korea.view.SuperViewer;

import java.sql.ResultSet;

public class MemberService
{
    MemberDAO dao = new MemberDAO();
    ResultSet rs;
    public boolean MemberSignUp(MemberDTO dto)
    {
        return dao.MemberSignUp(dto);
    }

    public boolean MemberSelect(MemberDTO dto, SuperViewer view)
    {
//        MemberManagementGUI gui = (MemberManagementGUI) view;
        try
        {
            rs = dao.MemberSelect();
//            gui.SelectRecord(rs);
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("id\t\tpw\t\t이름\t나이\t성별\t전화번호\t\t주소\t면허종류\t면허번호\t취득일\t\t만료일");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            while(rs.next())
            {
                System.out.println(rs.getString("Member_id") + "\t" + rs.getString("Member_pw") + "\t" + rs.getString("Member_name") + "\t" + rs.getString("Member_age") + "\t\t" + rs.getString("Member_sex") + "\t\t" + rs.getString("Member_phone") + "\t" + rs.getString("Member_addr") + "\t" + rs.getString("Member_license") + "\t\t\t" + rs.getString("license_num") + "\t" + rs.getString("license_start") + "\t" + rs.getString("license_end"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }


    public boolean MemberSearch(MemberDTO dto, SuperViewer view)
    {
//        MemberManagementGUI gui = (MemberManagementGUI) view;

        try
        {
            rs = dao.MemberSearch(dto);
//            gui.SelectRecord(rs);
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("id\t\tpw\t\t이름\t나이\t성별\t전화번호\t\t주소\t면허종류\t면허번호\t취득일\t\t만료일");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            while(rs.next())
            {
                System.out.println(rs.getString("Member_id") + "\t" + rs.getString("Member_pw") + "\t" + rs.getString("Member_name") + "\t" + rs.getString("Member_age") + "\t\t" + rs.getString("Member_sex") + "\t\t" + rs.getString("Member_phone") + "\t" + rs.getString("Member_addr") + "\t" + rs.getString("Member_license") + "\t\t\t" + rs.getString("license_num") + "\t" + rs.getString("license_start") + "\t" + rs.getString("license_end"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public boolean MemberUpdate(MemberDTO dto)
    {
        return dao.MemberUpdate(dto);
    }
    public boolean MemberDelete(MemberDTO dto)
    {
        return dao.MemberDelete(dto);
    }
}
