/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LIONS
 */
public class VisitCounter extends HttpServlet 
{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    int i = 0; 
    
    @Override
    public void init ()
    {
        i=1;
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {

        PrintWriter out = response.getWriter();
        out.println(i);
        i++ ;
    }
}

