package br.com.ft.gddd.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ft.gddd.event.CreatedResourceEvent;
import br.com.ft.gddd.models.dto.AttachmentDTO;
import br.com.ft.gddd.service.AttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * Classe AttachmentController.java
 *
 * @author <a href="carolexc@gmail.com">Caroline Aguiar</a>
 *
 * @since 21 de dez de 2019
 */
@Api("Endpoint - Documento")
@RestController
@RequestMapping(value = "/attachment")
public class AttachmentController {

	@Autowired
	private AttachmentService service;
	
    @Autowired
    private ApplicationEventPublisher publisher;
	
    @ApiOperation(nickname = "attachment-post", value = "Insere um novo documento na aplicação")
    @PostMapping
	public ResponseEntity<AttachmentDTO> saveAttachement(AttachmentDTO attachmentDTO, HttpServletResponse response) {

		attachmentDTO = service.saveAttachement(attachmentDTO);
		publisher.publishEvent(new CreatedResourceEvent(this, response, attachmentDTO.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(attachmentDTO);
	}
	
}
