package com.poorna.javaweb.dao;

import java.util.List;


import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poorna.javaweb.dto.UploadFile;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO{

	
	 @Autowired
	   private SessionFactory sessionFactory;
	 
	 public void save(UploadFile uploadFile) {
	      sessionFactory.getCurrentSession().save(uploadFile);
	   }

	   public List<UploadFile> list() {
	      @SuppressWarnings("unchecked")
	      TypedQuery<UploadFile> query = sessionFactory.getCurrentSession().createQuery("from UploadFile");
	      return query.getResultList();
	   }

	@Override
	public UploadFile getfile(int id) {
	
		
		
		UploadFile uf=new UploadFile();
		
		Session session=sessionFactory.openSession();
					
		session.beginTransaction();
			
		uf=session.get(UploadFile.class, id);
		return uf;
		
		
		
		
	}

	
	 
}  
	  
	

	


