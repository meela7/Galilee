package org.galilee.dms.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class StoreSensorData
 */
public class StoreSensorData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreSensorData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String data = request.getParameter("msg");
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		CSNMsg msg = mapper.readValue(data, CSNMsg.class);
		System.out.println("ID: " + msg.getId());
		System.out.println("TimeStampe: " + msg.getTimestamp());
		System.out.println("Value: " + msg.getValue());
		
		out.println("ID: " + msg.getId());
		out.println("TimeStampe: " + msg.getTimestamp());
		out.println("Value: " + msg.getValue());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
