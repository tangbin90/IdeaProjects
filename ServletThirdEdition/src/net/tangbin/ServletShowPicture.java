package net.tangbin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
/**
 * Created by TangBin on 20/12/2016.
 */
@WebServlet(name = "ShowPicture", urlPatterns = {"/ServletShowPicture"})
public class ServletShowPicture extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currPage=1;
        if(request.getParameter("page")!=null){
            currPage = Integer.parseInt(request.getParameter("page"));
        }

        PictureDao dao = new PictureDao();
        List<Picture> list = dao.find(currPage);
        request.setAttribute("list",list );

        int pages;
        int count = dao.findCount();
        if(count % Picture.PAGE_SIZE==0)
            pages=count/Picture.PAGE_SIZE;
        else
            pages=count/Picture.PAGE_SIZE+1;

        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=pages;i++) {
            if(i==currPage)
                sb.append("["+i+"]");
            else
                sb.append("<a href='ServletShowPicture?page="+i+"'>"+i+"</a>");
            sb.append(" ");
        }

        request.setAttribute("bar", sb.toString());
        request.getRequestDispatcher("picture_list.jsp").forward(request, response);
    }
}
