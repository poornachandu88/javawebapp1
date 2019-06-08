package com.poorna.javaweb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.poorna.javaweb.dto.UploadFile;
import com.poorna.javaweb.service.FileUploadDaoService;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadDaoService fileUploadDaoService;

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView homepage() {

		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "HomePage");
		model.addObject("ClickHome", true);

		return model;
	}
	@RequestMapping(value={"/about"})
	public ModelAndView about() {

		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "About Me");
		model.addObject("ClickAboutMe", true);

		return model;
	}

	@RequestMapping("/uploadpage")
	public ModelAndView userForm() 
	{

		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "UploadPage");
		model.addObject("ClickUploadPage", true);

		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/list", produces = MediaType.IMAGE_JPEG_VALUE)
	public ModelAndView getlist() {

		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "ListPage");
		model.addObject("ClickFilesList", true);

		model.addObject("files", fileUploadDaoService.list());

		return model;
	}

	@RequestMapping(value = "/upload")
	private ModelAndView saveDocument(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload)
			throws IOException {

		System.out.println("Saving file: " + fileUpload.getOriginalFilename());

		UploadFile uploadFile = new UploadFile();
		uploadFile.setFileName(fileUpload.getOriginalFilename());
		uploadFile.setData(fileUpload.getBytes());
		fileUploadDaoService.save(uploadFile);

		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "SuccessPage");
		model.addObject("ClickUpload", true);
		model.addObject("ok", "successfully uploaded yourfile...");

		return model;

	}

	

	@RequestMapping("/onefilesearch")
	public ModelAndView filesearch() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "SingleFileSearch");
		model.addObject("ClickSingleFileSearch", true);

		
		return model;
	}
	@RequestMapping("/onefilebyid")
	public ModelAndView file(@RequestParam int id) {
		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "SingleFile");
		model.addObject("ClickSingleFile", true);

		model.addObject("file", fileUploadDaoService.getfile(id));
		return model;
	}
}
