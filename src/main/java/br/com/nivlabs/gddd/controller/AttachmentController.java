package br.com.ft.gddd.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService service;

    @ApiOperation(nickname = "attachment-post", value = "Insere um novo documento na aplicação")
    @PostMapping("/{id}")
    public ResponseEntity<String> saveAttachement(@RequestParam(name = "file", required = true) MultipartFile file, @PathVariable("id") String id, HttpServletResponse response) throws Exception {

        id = service.saveAttachement(id, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
    
    @ApiOperation(nickname = "attachment-get", value = "Insere um novo documento na aplicação")
    @GetMapping("/{id}")
    public ResponseEntity<File> getAttachement( @PathVariable("id") String id, HttpServletResponse response) throws Exception {

        File file = service.getAttachement(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(file);
    }

}
