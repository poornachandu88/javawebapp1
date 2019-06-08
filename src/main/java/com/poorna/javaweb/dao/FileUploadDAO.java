package com.poorna.javaweb.dao;

import java.util.List;


import com.poorna.javaweb.dto.UploadFile;

public interface FileUploadDAO {
    void save(UploadFile uploadFile);
    List<UploadFile> list();
    public UploadFile getfile(int id);
}
