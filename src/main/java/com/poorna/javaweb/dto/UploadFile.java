package com.poorna.javaweb.dto;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "files_upload")
public class UploadFile {
   //upload_id, file_name, file_data 
	 @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "upload_id")
	private int id;
	 
	 @Column(name = "file_name")
    private String fileName;
    
   
    @Column(name = "file_data")
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] data;
 
   
    public long getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
   
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] bs) {
        this.data = bs;
    }

	
	

	public UploadFile() {
		super();
	}

	public UploadFile(int id, String fileName, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.data = data;
	}

	
	
	
}