package com.projetos.processamentodados.resource;

import com.projetos.processamentodados.domain.Header;
import com.projetos.processamentodados.service.AdquirenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/header")
public class HeaderResource {

    @Autowired
    AdquirenteService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getHeader(){
        Header header = service.getHeader();

        return ResponseEntity.ok().body(header);
    }

}
