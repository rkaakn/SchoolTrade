package com.rka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UploadItemServlet
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.rka.data.Item;
import com.rka.data.User;
import com.rka.service.ItemService;
import com.rka.service.implement.ItemServiceImplement;
 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadItemServlet extends HttpServlet {
     
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
    	request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        float price=Float.parseFloat(request.getParameter("price"));
        String description=request.getParameter("description");
         System.out.println("name"+name);
         System.out.println("price"+price);
         System.out.println("description:"+description);
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
        	Item item=new Item();
            // prints out some information for debugging
            System.out.println(filePart.getSize());//得到文件大小
            System.out.println(filePart.getContentType());//得到文件类型（这里上传的是图片）
            System.out.println(filePart.getSubmittedFileName());//得到文件名字
            String filename=filePart.getSubmittedFileName();
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            OutputStream outputStream = null;
            try{
            	request.setAttribute("Message", "成功");
            	//上传图片的保存路径
                String filepath="E:\\workspace\\SchoolTrade\\WebContent\\uploaddata\\"+filename;
                File file=new File(filepath);
            	outputStream=new FileOutputStream(file);
                byte[] bytes = new byte[1024];
                int num = 0;
                while ((num = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, num);
                    outputStream.flush();
                }
                HttpSession session=request.getSession();
                User user=(User)session.getAttribute("user");
                item.setOwnerName(user.getName());
                item.setPic(filePart.getSubmittedFileName());
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);
                
            }catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
            	request.setAttribute("Message", "失败");
            	System.out.println("复制文件出现错误");
            	inputStream=null;
            	outputStream=null;
                getServletContext().getRequestDispatcher("/failMessage.jsp").forward(request, response);
			}finally {
				if(inputStream!=null){
					try {
						inputStream.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				if(outputStream!=null){
					try{
						outputStream.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				ItemService itemService=new ItemServiceImplement();
				itemService.uploadItem(item);
				
			}

        }
        getServletContext().getRequestDispatcher("/successMessage.jsp").forward(request, response);
    }
}