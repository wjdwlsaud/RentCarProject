package com.korea.domain;

import com.korea.dto.MemberDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO extends DAO
{
    public MemberDAO()
    {
    }

    public boolean MemberSignUp(MemberDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("insert into member_tbl values(?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getMember_pw());
            pstmt.setString(3, dto.getMember_name());
            pstmt.setInt(4, dto.getMember_age());
            pstmt.setString(5, dto.getMember_sex());
            pstmt.setString(6, dto.getMember_phone());
            pstmt.setString(7, dto.getMember_addr());
            pstmt.setString(8, dto.getMember_license());
            pstmt.setString(9, dto.getLicense_num());
            pstmt.setDate(10, dto.getLicense_start());
            pstmt.setDate(11, dto.getLicense_end());

            int result = pstmt.executeUpdate();

            if(result != 0)
            {
                return true;    // Insert 성공
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public ResultSet MemberSelect()
    {
        try
        {
            pstmt = conn.prepareStatement("select * from member_tbl");
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet MemberSearch(MemberDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("select * from member_tbl where INSTR(Member_id, ?) > 0");
            pstmt.setString(1, dto.getMember_id());
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean MemberUpdate(MemberDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("UPDATE Member_tbl SET Member_pw = ?, Member_name = ?, Member_age = ?, Member_sex = ?, Member_phone = ?, Member_addr = ?, Member_license = ?, license_num = ?, license_start = ?, LICENSE_END = ? WHERE Member_id = ?");
            pstmt.setString(11, dto.getMember_id());
            pstmt.setString(1, dto.getMember_pw());
            pstmt.setString(2, dto.getMember_name());
            pstmt.setInt(3, dto.getMember_age());
            pstmt.setString(4, dto.getMember_sex());
            pstmt.setString(5, dto.getMember_phone());
            pstmt.setString(6, dto.getMember_addr());
            pstmt.setString(7, dto.getMember_license());
            pstmt.setString(8, dto.getLicense_num());
            pstmt.setDate(9, dto.getLicense_start());
            pstmt.setDate(10, dto.getLicense_end());

            int result = pstmt.executeUpdate();

            if(result != 0)
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean MemberDelete(MemberDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("delete from member_tbl where Member_id = ?");
            pstmt.setString(1, dto.getMember_id());
            int result = pstmt.executeUpdate();
            if(result != 0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
