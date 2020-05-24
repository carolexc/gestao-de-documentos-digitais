package br.com.ft.gddd.models.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe Attachment.java
 * 
 * @author <a href="mailto:carolexc@gmail.com">Caroline Aguiar</a>
 * 
 * @since 21 de dez de 2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Document")
@Data
public class Attachment implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -9092633058275606682L;
	@Id
	private Long id;
	
	private String descrition;
	
	private String type;
	
	private String document;
}
