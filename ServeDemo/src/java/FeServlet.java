
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FeServlet extends HttpServlet 
{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {   
        
        
        String str = request.getParameter("t1");
        
 //       HttpSession session = request.getSession();
 //       session.setAttribute("t1", str); 
 //       response.sendRedirect("SeServlet"); 
        
        Cookie cookie = new Cookie ("t1", str);
        response.addCookie(cookie);
       
        
    }

}
