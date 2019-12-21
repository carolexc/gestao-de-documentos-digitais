package br.com.ft.gddd.service;

import org.bson.internal.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ft.gddd.models.domain.Attachment;
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
	
	public AttachmentDTO saveAttachement(AttachmentDTO attachmentDTO) {
		Attachment attachment = new Attachment();
		BeanUtils.copyProperties(attachmentDTO, attachment, "id");
		attachment.setDocument(Base64.encode(attachmentDTO.getDocument()));
		attachment = repository.save(attachment);
		BeanUtils.copyProperties(attachment, attachmentDTO);
		
		return attachmentDTO;
	}
}
