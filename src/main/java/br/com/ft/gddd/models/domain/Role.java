package br.com.ft.gddd.models.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe Perfil.java
 * 
 * @author <a href="mailto:viniciosarodrigues@gmail.com">Vinícios Rodrigues</a>
 * 
 * @since 6 de set de 2019
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable{

	private static final long serialVersionUID = 3841123920964263130L;

	@Id
    private Long id;

    private String description;

}
