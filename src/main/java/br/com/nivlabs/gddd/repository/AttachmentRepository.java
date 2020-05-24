package br.com.nivlabs.gddd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.nivlabs.gddd.models.domain.Attachment;

/**
 * Classe AttachementRepository.java
 * 
 * @author <a href="mailto:carolexc@gmail.com">Caroline Aguiar</a>
 * 
 * @since 21 de dez de 2019
 */
@Repository
public interface AttachmentRepository extends MongoRepository<Attachment, Long>{

}
