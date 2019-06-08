package com.poorna.javaweb.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poorna.javaweb.dao.FileUploadDAO;
import com.poorna.javaweb.dto.UploadFile;

@Service
public class FileUploadDaoServiceImpl implements FileUploadDaoService{

	   @Autowired
	   private FileUploadDAO fileUploadDAO;

	   @Transactional
	   public void save(UploadFile user) {
		   fileUploadDAO.save(user);
	   }

	   @Transactional(readOnly = true)
	   public List<UploadFile> list() {
	      return fileUploadDAO.list();
	   }

	@Override
	@Transactional
	public UploadFile getfile(int id) {
		// TODO Auto-generated method stub
		return fileUploadDAO.getfile(id);
	}
	
	
	

}
