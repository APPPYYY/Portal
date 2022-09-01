package com.esspl.first.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

	/*
	 * public final String
	 * ABS_PATH="D:\\J2EE\\Springboot workplace\\FirstSpringbootApplication\\src\\main\\resources\\static\\images\\"
	 * ;
	 */
	public final String ABS_PATH=new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public FileUtil()throws Exception{
		
	}
	
	boolean upFile=false;
	public boolean uploadFile(MultipartFile mfile) {
		try {
			
			Files.copy(mfile.getInputStream(),Paths.get(ABS_PATH+mfile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			upFile=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return upFile;
	}
	
	
	
	
}
