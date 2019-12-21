package br.com.ft.gddd.models.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe PatientDTO.java
 * 
 * @author <a href="mailto:carolexc@gmail.com">Caroline Aguiar</a>
 * 
 * @since 15 de set de 2019
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class AttachmentDTO implements Serializable{
	
	private static final long serialVersionUID = 6532897013227857364L;
	
	private Long id;
	
	private String descrition;
	
	private String type;
	
	private byte[] document;

}
