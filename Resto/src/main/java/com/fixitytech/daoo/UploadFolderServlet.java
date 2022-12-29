package com.fixitytech.daoo;

 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fixitytech.DAO.ItemDAO;
import com.fixitytech.resto.Item;

 


 

/**
* Servlet implementation class UploadItemServlet
*/
@WebServlet("/uploadFolder")
@MultipartConfig(maxFileSize = 16177215)
public class UploadFolderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       ItemDAO itemdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFolderServlet() {
        super();
        itemdao =new ItemDAO();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher rd=request.getRequestDispatcher("additem.jsp");
        rd.forward(request, response);
    }

 

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    private static final String UPLOAD_DIR = "uploads";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        Item item=new Item();


        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        InputStream inputStream = null; // input stream of the upload file
        Part filePart = request.getPart("photo");
   
        String path=getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
        
        System.out.println(path);
        
        File d=new File(path+"/"+id);
        if(!d.exists())
        	d.mkdir();
        
        filePart.write(path+"/"+id+"/"+filePart.getSubmittedFileName());
    }
}
        
       /*   item.setId(id);
            item.setName(name);
             item.setPrice(price);

             boolean m=itemdao.addItem();


        String imagefilename=filePart.getSubmittedFileName();
        inputStream = filePart.getInputStream();
        // gets absolute path of the web application

        String applicationPath = request.getServletContext().getRealPath("");
     // constructs path of the directory to save uploaded file

        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();

        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());


        String destination=uploadFilePath+"/"+id;
        System.out.println(destination);
        try 
        {

            File file=new File(destination);
            boolean n= file.mkdirs();
            System.out.println(n);
             InputStream inputFile=filePart.getInputStream();
             FileOutputStream outputFile=new FileOutputStream(destination+"/"+imagefilename);
             byte b[]=new byte[1024];
             int noOfBytes=0;
             while((noOfBytes=inputFile.read(b))>0) {
                 outputFile.write(b, 0, noOfBytes);
             }
             inputFile.close();
             outputFile.close();

 

        }
        catch(FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
*/

    

 
 

       

   
 