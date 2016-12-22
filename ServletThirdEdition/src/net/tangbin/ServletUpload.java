package net.tangbin;


import com.sun.xml.internal.ws.resources.HttpserverMessages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.Driver;
import java.util.logging.*;
import java.io.*;
/**
 * Created by TangBin on 21/12/2016.
 */
@WebServlet(name = "ServletUpload", urlPatterns = {"/ServletUpload"})
@MultipartConfig(location ="/Users/Tangbin")
public class ServletUpload extends javax.servlet.http.HttpServlet {
    private final static Logger LOGGER=Logger.getLogger(ServletUpload.class.getCanonicalName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        final PrintWriter writer = response.getWriter();
        PictureDao pictureDao = new PictureDao();
        Part part= request.getPart("file1");
        final String filename = getFileName(part);
        final String path=request.getParameter("destination");

        OutputStream out = null;
        InputStream filecontent = null;

        try {
            if (isImageFile(part)) {
                out = new FileOutputStream(new File(path + File.separator + filename));
                filecontent = part.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1)
                    out.write(bytes, 0, read);
                Picture p = new Picture();
                p.setPath(path + File.separator + filename);
                p.setOwner("tangbin");
                pictureDao.AddPictureInfoToDB(p);
                writer.println("文件" + filename + "添加成功" + " 位于：" + path);

            } else {
                writer.write("请选择图片文字");
            }
        }catch (FileNotFoundException fne){
            writer.println("New file "+filename+" created at "+path);
            writer.println("<br/> ERROR: "+fne.getMessage());
        }finally {
            if(out != null){
                out.close();
            }
            if(filecontent != null)
                filecontent.close();
            if(writer != null)
                writer.close();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    public ServletUpload() {
        super();
    }

    private Boolean isImageFile(final Part part){
        if(part==null)
            return false;
        return part.getContentType().contains("image");
    }

    private String getFileName(final Part part){
        if(part==null)
            return null;
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header {0}", partHeader);
        for(String content: part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }



    public void destroy(){
        super.destroy();
    }

}
