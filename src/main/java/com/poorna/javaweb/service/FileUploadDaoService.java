package com.poorna.javaweb.service;

import java.util.List;



import com.poorna.javaweb.dto.UploadFile;

public interface FileUploadDaoService {
	void save(UploadFile uploadFile);
    List<UploadFile> list();
    public UploadFile getfile(int id);
}
