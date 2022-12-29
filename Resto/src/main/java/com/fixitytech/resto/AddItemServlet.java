package com.fixitytech.resto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fixitytech.DAO.ItemDAO;


/**
 * Servlet implementation class AddItemServlet
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/additem")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ItemDAO itemdao;
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
        itemdao = new ItemDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  RequestDispatcher requestDispatcher = request.getRequestDispatcher("additem.jsp");
          requestDispatcher.forward(request, response);  
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	Double price  = Double.parseDouble(request.getParameter("price"));
 byte[] byteArray=null;
	 InputStream inputStream = null; 
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
       
            inputStream = filePart.getInputStream();
       
            byte[] buffer = new byte[1000];
      
            ByteArrayOutputStream byteArrayOutputStream
                = new ByteArrayOutputStream();
      
         
            try {
                int temp=-1;
      
                while ((temp = inputStream.read(buffer))
                       != -1) {
                    byteArrayOutputStream.write(buffer, 0,
                                                temp);
                }
            }
      
           
            catch (IOException e) {
      
                System.out.println(e);
            }
      
            
            byteArray
                = byteArrayOutputStream.toByteArray();
      
        }

	
	boolean b = itemdao.addItem(id,name,price,byteArray);
	if(b) {
		HttpSession hs = request.getSession();
		hs.setAttribute("iid", id);
		response.sendRedirect("message.jsp");
	}else {
		request.setAttribute("err", "Something went wrong.");
		doGet(request, response);	
	}
	}
}
	   





















/* URL uri= new URL("https://media.istockphoto.com/id/1325172440/photo/spaghetti-alla-puttanesca-italian-pasta-dish-with-tomatoes-black-olives-capers-anchovies-and.jpg?b=1&s=170667a&w=0&k=20&c=0XEgTZ2pcp83v0rBgjtQ0bH9pXkxYDQgW7mrc5aNX30=");
BufferedImage bImage = ImageIO.read(new File(uri.getFile()));
  ByteArrayOutputStream bos = new ByteArrayOutputStream();
  ImageIO.write(bImage, "jpg", bos );
  byte [] data = bos.toByteArray();
  
  	InputStream inputStream = null; 

        String message = null;
    
        Part filePart = request.getPart("photo");
        if (filePart != null) {
      
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }*/
	
	
	
	
	/*		
	 * 
		*/
