package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
@WebServlet(urlPatterns = "/book/abc/ServletRequestTest2")
public class ServletRequestTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        // 获取uri,统一资源标识符
        String uri = req.getRequestURI();
        // 获取url,统一资源定位符
        String url = req.getRequestURL().toString();
        String servletPath = req.getServletPath();
        writer.print("<h2>"+uri+"</h2>");
        writer.print("<h2>"+url+"</h2>");
        writer.print("<h2>"+servletPath+"</h2>");
        writer.print("<table border='1px'>");
        writer.print("<tr><td><b>Header</b></td><td><b>Value</b></td></tr>");
        // 获取请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String keys = headerNames.nextElement();
            String values = req.getHeader(keys);
            writer.print("<tr><td>"+keys+"</td><td>"+values+"</td></tr>");
        }
        writer.print("</table>");
        writer.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
