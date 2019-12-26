package br.com.ft.gddd.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

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
public class AttachmentService implements GenericService<AttachmentDTO, Long> {

	@Autowired
	private AttachmentRepository repository;

	@Autowired
	private GridFsOperations gridFsOperations;

	@Autowired
	private GridFsTemplate gridFsTemplate;

	public String saveAttachement(String id, MultipartFile document) throws Exception {

		DBObject metaData = new BasicDBObject();
		byte[] bytes = document.getBytes();

		File tempFile = new File(document.getOriginalFilename());
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(tempFile));
		stream.write(bytes);
		stream.close();

		InputStream content = new FileInputStream(tempFile);

		metaData.put("id", id);
		ObjectId objId = gridFsOperations.store(content, document.getOriginalFilename(), document.getContentType(),
				metaData);

		return objId.toString();
	}

	public File getAttachement(String id) throws IllegalStateException, IOException {
		GridFSFile gsFile = gridFsTemplate.findOne(new Query(Criteria.where("metadata.id").is(id))); 
		File file = new File(gsFile.getFilename()); 
	
		InputStream inputStream = gridFsOperations.getResource(gsFile).getInputStream();

		byte[] buffer = new byte[inputStream.available()];
		inputStream.read(buffer);
		OutputStream outStream = new FileOutputStream(file);
		outStream.write(buffer);

		return file; 
	}
}
