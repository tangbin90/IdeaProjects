package net.tangbin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TangBin on 22/12/2016.
 */
public class UserDao {
    public List<User> find(int page){
        List<User> list=new ArrayList<User>();
        Connection conn= DataBaseAccess.getConnection();
        String sql="select * from tb_user order by id desc limit ?,?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1)*User.PAGE_SIZE);
            ps.setInt(2, User.PAGE_SIZE);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                User p = new User();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("name"));
                p.setPassword(rs.getString("password"));
                list.add(p);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();

        }
        return list;
    }

    public int CountUser(){
        int count=0;
        Connection conn=DataBaseAccess.getConnection();
        String sql = "select count(*) from tb_user";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            if(rst.next())
                count = rst.getInt(1);
            rst.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    public boolean AddUserInfoToDB(User p){
        PictureDao pictureDao = new PictureDao();
        Connection conn= DataBaseAccess.getConnection();
        String sql = "insert into tb_user(name, password) values(?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPassword());
            int row =ps.executeUpdate();
            if(row>0){
                System.out.println("成功添加了"+row +"条数据！");
            }
            ps.close();
            conn.close();
        }catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

        return true;
    }

    public boolean checklogin(User p){
        int count=0;
        Connection conn=DataBaseAccess.getConnection();
        String sql = "select * from tb_user where name='"+p.getName()+"'";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            while(rst.next()) {
                String password=rst.getString("password");
                if(password.equals(p.getPassword()))
                    return true;
            }
            rst.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
