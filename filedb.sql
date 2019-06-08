--Mysql--
drop database if exists filedb;

CREATE DATABASE `filedb`;
 
 use filedb;
 
CREATE TABLE `files_upload` (
  `upload_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(128) DEFAULT NULL,
  `file_data` longblob,
  PRIMARY KEY (`upload_id`)
);

SHOW VARIABLES LIKE 'max_allowed_packet';

SET GLOBAL max_allowed_packet=16777216;



insert into files_upload values(4,'poonra','C:\Users\poorna\Downloads\ghg.jpeg');

select *from files_upload;

--Db Properties mysql
# MySQL properties
mysql.driver=com.mysql.jdbc.Driver
mysql.url=jdbc:mysql://localhost:3306/filedb?useSSL=false
mysql.user=root
mysql.password=root

# Hibernate properties
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update

#C3P0 properties
hibernate.c3p0.min_size=5
hibernate.c3p0.max_size=20
hibernate.c3p0.acquire_increment=1
hibernate.c3p0.timeout=1800
hibernate.c3p0.max_statements=150




--Sql Server

--------------
CREATE TABLE [dbo].[files_upload] (
  [upload_id] [int] IDENTITY (1, 1) NOT NULL,
  [file_name] [varchar] (1000) NULL,
   [file_data] [image]  NULL

  CONSTRAINT [PK_files_upload]
  PRIMARY KEY CLUSTERED
  (
    [upload_id] ASC
  )
  WITH (PAD_INDEX = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, IGNORE_DUP_KEY = OFF, STATISTICS_NORECOMPUTE = OFF, DATA_COMPRESSION = NONE)
  ON [PRIMARY]
) ON [PRIMARY];
GO



-----------
--Db Properties Sql server


database.driver=com.microsoft.sqlserver.jdbc.SQLServerDriver
database.url=jdbc:sqlserver://localhost:1433;databaseName=vtmsjavacmm
database.user=sa
database.password=kpcr
hibernate.dialect=org.hibernate.dialect.SQLServerDialect
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update



