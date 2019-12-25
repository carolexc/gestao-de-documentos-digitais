package br.com.ft.gddd.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.ft.gddd.models.dto.AttachmentDTO;
import br.com.ft.gddd.repository.AttachmentRepository;


/**
 * 
 * Classe AttachmentService.java
 *
 * @author <a href="carolexc@gmail.com">Caroline Aguiar</a>
 *
 * @since 21 de dez de 2019
 */
@Service
public class AttachmentService  implements GenericService<AttachmentDTO, Long>{

	@Autowired
	private AttachmentRepository repository;
	
	@Autowired
	private GridFsOperations gridFsOperations;
	
	public String saveAttachement(String id, MultipartFile document) throws Exception {

		DBObject metadata = new BasicDBObject();
		byte[] bytes = document.getBytes();

        File tempFile=new File(document.getOriginalFilename());
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(tempFile));
        stream.write(bytes);
        stream.close();

		InputStream content = new FileInputStream(tempFile);

		metadata.put("id", id);
		ObjectId objId = gridFsOperations.store(content, metadata);
		

		return id;
	}
}
