package com.sp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sp.db.DbConnection;

import org.json.JSONObject;

import com.sp.dao.StudentDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Do Get ");
//		 if (request.getParameterMap().containsKey("emailid")){
//			String emailID = request.getParameter("emailid");
//			System.out.println("EmailID received "+emailID);
//			Statement stmt = null;
//			DbConnection conn = null;
//			try{
//				conn = new DbConnection();
//				String sql;
//				sql = "SELECT email FROM student WHERE email ='" + emailID + "'";
//				stmt = conn.DbConnectionForPreparedStatement(sql);
//				ResultSet rs = stmt.executeQuery(sql);
//				JSONObject obj = new JSONObject();				
//				if(rs.next()){
//					obj.put("val", new Boolean(true));
//				}
//				else{
//					obj.put("val", new Boolean(false));
//				}
//				response.setContentType("application/json");
//			    response.setCharacterEncoding("UTF-8");
//			    obj.write(response.getWriter());
//				//STEP 8: Clean-up environment
//				rs.close();
//			    stmt.close();
//				conn.close();
//			}catch(SQLException se){
//				//Handle errors for JDBC
//				se.printStackTrace();
//			}catch(Exception e){
//				//Handle errors for Class.forName
//				e.printStackTrace();
//			}finally{
//				//finally block used to close resources
//				try{
//					if(stmt!=null)
//						stmt.close();
//				}catch(SQLException se2){
//				}// nothing we can do
//				if(conn!=null)
//					conn.close();
//				
//			}
//		}
		String emailID = request.getParameter("emailid");
		System.out.println("EmailID received "+emailID);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	
        	if(StudentDAO.isEmailPresent(emailID))
        	{

            out.println("true");
        	}
        	else
        	{
        		out.println("false");
        	}


        } finally {
            out.close();
        }
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Reached");
		String userEmail = request.getParameter("userEmail");
//		System.out.println(userEmail);
		String password = request.getParameter("confirmPassword");
//		System.out.println(password);
		StudentDAO.addStudent(userEmail, password);
//		doGet(request, response);
	}
	
	

}
