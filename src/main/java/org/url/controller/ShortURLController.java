package org.url.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.url.api.model.ShortURLDTO;
import org.url.model.ShortURL;
import org.url.service.ShortURLService;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/v1/jpa/url")
public class ShortURLController {

    @Autowired
    private ShortURLService shortURLService;

    @PostMapping("/create")
    public ResponseEntity<ShortURLDTO> create(@RequestBody ShortURLDTO shortURLDTO) {
        try {
            shortURLDTO = shortURLService.create(shortURLDTO);
            return ResponseEntity.ok(shortURLDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(errorResponse(e));
        }
    }

    @GetMapping("/fetch/{alias}")
    public ResponseEntity<ShortURLDTO> findByAlias(@PathVariable String alias) {
        try {
            ShortURLDTO shortURLDTO = shortURLService.findAbyAlias(alias);
            return ResponseEntity.ok(shortURLDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(errorResponse(e));
        }
    }

    private ShortURLDTO errorResponse(Exception e) {
        return ShortURLDTO.builder()
                .message(e.getMessage())
                .build();
    }
}
