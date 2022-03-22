package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/findWord")
public class ServletWord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        InputStream in = getServletContext().getResourceAsStream("/WordTest.docx");
        OutputStream out = resp.getOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while((len = in.read(buff)) != -1){
            out.write(buff,0,buff.length);
        }
        out.close();
        in.close();
    }
}
