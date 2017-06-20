package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@WebServlet("/RegisterServlet")  
public class RegisterServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
         
    /** 
     * @see HttpServlet#HttpServlet() 
     */  
    public RegisterServlet() {  
        super();
    }  
  
    /** 
     * http://localhost:8080/ServletTest/RegisterServlet?
     * X=6833&Y=123456&Z=166&Alpha=10.08&Beta=10.08&Gamma=10.08&
     * J1_Tor=10.08&J2_Tor=10.08&J3_Tor=10.08&J4_Tor=10.08&J5_Tor=10.08&J6_Tor=10.08&J7_Tor=10.08
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

        String X = request.getParameter("X"); // 从 request 中获取名为 X 的参数的值  
        String Y = request.getParameter("Y"); // 从 request 中获取名为 Y 的参数的值  
        String Z = request.getParameter("Z"); // 从 request 中获取名为 Y 的参数的值 
        String Alpha = request.getParameter("Alpha"); // 从 request 中获取名为 Alpha 的参数的值  
        String Beta = request.getParameter("Beta"); // 从 request 中获取名为Beta 的参数的值  
        String Gamma = request.getParameter("Gamma"); // 从 request 中获取名为 Gamma 的参数的值 
        
        String J1_Tor = request.getParameter("J1_Tor"); // 从 request 中获取名为J1_Tor的参数的值  
        String J2_Tor = request.getParameter("J2_Tor"); // 从 request 中获取名为J2_Tor的参数的值  
        String J3_Tor = request.getParameter("J3_Tor"); // 从 request 中获取名为J3_Tor的参数的值  
        String J4_Tor = request.getParameter("J4_Tor"); // 从 request 中获取名为J4_Tor的参数的值  
        String J5_Tor = request.getParameter("J5_Tor"); // 从 request 中获取名为J5_Tor的参数的值   
        String J6_Tor = request.getParameter("J6_Tor"); // 从 request 中获取名为J6_Tor的参数的值  
        String J7_Tor = request.getParameter("J7_Tor"); // 从 request 中获取名为J7_Tor的参数的值  
        
        System.out.println("X:" + X + "\nY:" + Y + "\nZ:" + Z + 
        		"\nAlpha:" + Alpha + "\nBeta:" + Beta + "\nGamma:" + Gamma+ 
        		"\nJ1_Tor:" + J1_Tor+ "\nJ2_Tor:" + J2_Tor+ "\nJ3_Tor:" + J3_Tor+ "\nJ4_Tor:" + 
        		J4_Tor+ "\nJ5_Tor:" + J5_Tor+ "\nJ6_Tor:" + J6_Tor+ "\nJ7_Tor:" + J7_Tor); // 打印出来看一看  
        
/*        String resCode = "";
        String resMsg = "";
        String userId = "";*/
          
          
        //这里为一个最简单的数据存储至mysql数据库的demo
        try {
            Connection connect = DBUtil.getConnect();  
            Statement statement = (Statement) connect.createStatement(); // Statement可以理解为数据库操作实例，对数据库的所有操作都通过它来实现  
            String sqlInsertData = "insert into " + DBUtil.TABLE_XY + 
                "(X,Y,Z,Alpha,Beta,Gamma,J1_Tor,J2_Tor,J3_Tor,J4_Tor,J5_Tor,J6_Tor,J7_Tor) values('" + 
                X + "','" + Y + "','" + Z + "','" + Alpha + "','" + Beta + "','" + Gamma + "','" + 
                J1_Tor + "','" + J2_Tor + "','" + J3_Tor + "','" + J4_Tor + "','" + J5_Tor + "','" + J6_Tor + "','" + J7_Tor + "')";  
                // 更新类操作返回一个int类型的值，代表该操作影响到的行数  
                int row1 = statement.executeUpdate(sqlInsertData); // 插入数据至mysql数据库 
                System.out.println(row1);

        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
          
/*        HashMap<String, String> map = new HashMap<String, String>();  
        map.put("resCode", resCode);  
        map.put("resMsg", resMsg);  
        map.put("userId", userId);  
          
        response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式  
        PrintWriter pw = response.getWriter(); // 获取 response 的输出流  
        pw.println(map.toString()); // 通过输出流把业务逻辑的结果输出  
        pw.flush();  */
    }  
  
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doGet(request, response);  
    }  
  
}
