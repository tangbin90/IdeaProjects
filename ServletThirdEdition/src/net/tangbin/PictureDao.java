package net.tangbin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TangBin on 22/12/2016.
 */
public class PictureDao {


    public List<Picture> find(int page){
        List<Picture> list=new ArrayList<Picture>();
        Connection conn= DataBaseAccess.getConnection();
        String sql="select * from tb_picture order by id desc limit ?,?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1)*Picture.PAGE_SIZE);
            ps.setInt(2, Picture.PAGE_SIZE);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Picture p = new Picture();
                p.setStoretime(rs.getDate("storedate"));
                p.setOwner(rs.getString("owner"));
                p.setPath(rs.getString("path"));
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

    public int findCount(){
        int count=0;
        Connection conn=DataBaseAccess.getConnection();
        String sql = "select count(*) from tb_picture";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
                count = rs.getInt(1);
            rs.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

     public boolean AddPictureInfoToDB(Picture p){
        PictureDao pictureDao = new PictureDao();
        Connection conn= DataBaseAccess.getConnection();
        String sql = "insert into tb_picture(path,owner,storedate) values(?,?,curdate())";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getPath());
            ps.setString(2, p.getOwner());
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
}

