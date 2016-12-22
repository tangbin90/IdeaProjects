package net.tangbin;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import java.io.*;
/**
 * Created by TangBin on 21/12/2016.
 */
public class UploadServlet extends javax.servlet.http.HttpServlet {
    private final static Logger LOGGER=Logger.getLogger(UploadServlet.class.getCanonicalName());
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Part part= request.getPart("file");
        PrintWriter outwrite = response.getWriter();
        final String path=request.getParameter("destination");
        final String filename = getFileName(part);

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        try {
            if (isImageFile(part)) {
                out = new FileOutputStream(new File(path + File.separator) + filename);
                filecontent = part.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1)
                    out.write(bytes, 0, read);

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

    public UploadServlet() {
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
        final String partHeader = part.getHeader("content-dispostion");
        LOGGER.log(Level.INFO, "Part Header {0}", partHeader);
        for(String content: part.getHeader("content-disposion").split(";")){
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
