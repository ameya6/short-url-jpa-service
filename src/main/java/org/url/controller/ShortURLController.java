package org.url.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<ShortURL> create(@RequestBody ShortURL shortURL) {
        shortURL = shortURLService.create(shortURL);
        return ResponseEntity.ok(shortURL);
    }

    @GetMapping("/")
    public ResponseEntity<List<ShortURL>> get() {
        List<ShortURL> shortURLS = shortURLService.get();
        return ResponseEntity.ok(shortURLS);
    }
}
