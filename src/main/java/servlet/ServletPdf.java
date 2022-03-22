package servlet;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/findPDF")
public class ServletPdf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("收到GET请求");
        // 设置响应的内容类型
        resp.setContentType("application/pdf");
        // 获取上下文对象
        ServletContext servletContext = getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("/PdfTest.pdf");
        // 根据指定文件，获取输出流对象
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while((len= resourceAsStream.read(buff)) != -1){
            // 将缓冲区中的数据写出到输出流中
            outputStream.write(buff,0,buff.length);
        }
        outputStream.close();
        resourceAsStream.close();
        System.out.println("收到GET请求");

    }

}
