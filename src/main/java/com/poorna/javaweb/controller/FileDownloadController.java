package com.poorna.javaweb.controller;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.api.xdevapi.Collection;
import com.poorna.javaweb.dto.UploadFile;
import com.poorna.javaweb.service.FileUploadDaoService;

@Controller
@Component
public class FileDownloadController{
	
	 private static final String FILE_PATH1 = "D:/Downloads/Movies/1.mp4";//these 3 are from file system
	 private static final String FILE_PATH2 = "D:/Downloads/Movies/2.mp4";
	 private static final String FILE_PATH3 = "D:/Downloads/Movies/3.mp4";
	 
	 @Autowired
		private FileUploadDaoService fileUploadDaoService;
                     
	 @RequestMapping("/filesdownload")
	   public ModelAndView fileUploadForm() 
	 
	 {
		
		 ModelAndView model = new ModelAndView("home");
			model.addObject("title", "DownLoadPage");
			model.addObject("ClickDownLoadPage", true);
	      return model;
	
	 }
	   // Using ResponseEntity<InputStreamResource>
	   @GetMapping("/download1")
	   public ResponseEntity<InputStreamResource> downloadFile1() throws IOException {

	      File file = new File(FILE_PATH1);
	      InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	      return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                  "attachment;filename=" + file.getName())
	            .contentType(MediaType.MULTIPART_FORM_DATA).contentLength(file.length())
	            .body(resource);
	   }

	   // Using ResponseEntity<ByteArrayResource>
	   @GetMapping("/download2")
	   public ResponseEntity<ByteArrayResource> downloadFile2() throws IOException {

	      Path path = Paths.get(FILE_PATH2);
	      byte[] data = Files.readAllBytes(path);
	      ByteArrayResource resource = new ByteArrayResource(data);

	      return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                  "attachment;filename=" + path.getFileName().toString())
	            .contentType(MediaType.IMAGE_JPEG).contentLength(data.length)
	            .body(resource);
	   }

	   // Using HttpServletResponse
	   @GetMapping("/download3")
	   public void downloadFile3(HttpServletResponse resonse) throws IOException {
	      File file = new File(FILE_PATH3);

	      resonse.setContentType("image/jpeg");
	      resonse.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
	      BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
	      BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());
	      
	      byte[] buffer = new byte[1024];
	     
	      int bytesRead = 0;
	      while ((bytesRead = inStrem.read(buffer)) != -1) {
	        outStream.write(buffer, 0, bytesRead);
	      }
	      outStream.flush();
	      inStrem.close();
	   }
	  //this is from database
	   @GetMapping("/downloadbypath/{id}")
	   public ResponseEntity<ByteArrayResource> downloadFile4(@PathVariable int id) throws IOException {
		   UploadFile uploadFile=new UploadFile();
		   uploadFile= fileUploadDaoService.getfile(id);
		   byte[] b=uploadFile.getData();
		   ByteArrayResource resource = new ByteArrayResource(b);
		 
		   return ResponseEntity.ok()
		            .header(HttpHeaders.CONTENT_DISPOSITION,
		                  "attachment;filename=" + uploadFile.getFileName())
		            .contentType(MediaType.IMAGE_JPEG).contentLength(b.length)
	
		            .body(resource);
	     
	   }
	
	   //this is from database
	   @GetMapping("/downloadbyid")
	   public ResponseEntity<ByteArrayResource> downloadFile5(@RequestParam int id) throws IOException {
		   UploadFile uploadFile=new UploadFile();
		   uploadFile= fileUploadDaoService.getfile(id);
		   byte[] b=uploadFile.getData();
		   ByteArrayResource resource = new ByteArrayResource(b);
		 
		   return ResponseEntity.ok()
		            .header(HttpHeaders.CONTENT_DISPOSITION,
		                  "attachment;filename=" + uploadFile.getFileName())
		            .contentType(MediaType.IMAGE_JPEG).contentLength(b.length)
		            .body(resource);
		     
		   
		 
	     
	   }


	}
	 
	 

