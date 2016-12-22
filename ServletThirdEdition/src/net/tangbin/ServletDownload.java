package net.tangbin;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by TangBin on 22/12/2016.
 */
@WebServlet(name = "ServletDownload", urlPatterns = "/ServletDownload")
public class ServletDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String path=request.getParameter("path");
        System.out.println(path);
        File file = new File(path);

        if(!file.exists()) {
            PrintWriter outwrite = response.getWriter();
            outwrite.println("文件不存在");
            outwrite.close();
            return;
        }
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(path,"UTF-8"));
        InputStream in = new FileInputStream(path);
        OutputStream out = response.getOutputStream();
        int b;
        while((b=in.read())!=-1)
        {
            out.write(b);
        }
        in.close();
        out.close();
        PrintWriter writer = response.getWriter();
    }
}
