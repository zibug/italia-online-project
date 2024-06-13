package com.challenge.italiaonline.controller;

import com.challenge.italiaonline.model.Articolo;
import com.challenge.italiaonline.service.ArticoliService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ArticoliController {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private ArticoliService service;

    @GetMapping("/news")
    public ResponseEntity<List<Articolo>> getNews() {
        List<Articolo> response = null;
        try {
            response = service.getNews();
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/news/{source}")
    public ResponseEntity<List<Articolo>> getNewsFromSource(@PathVariable("source") String source) {
        List<Articolo> response = null;
        try {
            response = service.getNewsFromSource(source);
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Articolo> saveArticolo(@RequestBody Articolo articolo) {
        try {
            service.saveArticolo(articolo);
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Articolo>> getListaArticoli() {
        List<Articolo> response = null;
        try {
            response = service.getListaArticoli();
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
