package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = "/requestTest")
public class ServletRequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletRequestTest收到Get请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletRequestTest收到Post请求");
        System.out.println("------------------------------");
        System.out.println("请求头Host值为："+req.getHeader("host"));
        System.out.println("PATH:"+req.getServletPath());
        System.out.println("URL:"+req.getRequestURI());
        System.out.println("------------------------------");
        // 把接收的请求改为UTF-8格式
        System.out.println("ServletRequestTest开始响应Post请求");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String sex = req.getParameter("sex");
        String[] hobby = req.getParameterValues("hobby");
        String[] info = req.getParameterValues("info");
        System.out.println(name+","+phone+","+sex+","+Arrays.toString(hobby)+","+Arrays.toString(info));
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<h1>姓名:"+name+"</h1>");
        printWriter.print("<h1>电话:"+phone+"</h1>");
        printWriter.print("<h1>性别:"+sex+"</h1>");
        printWriter.print("<h1>爱好:"+ Arrays.toString(hobby)+"</h1>");
        printWriter.print("<h1>个人介绍:"+ Arrays.toString(info)+"</h1>");
        printWriter.close();
    }
}
