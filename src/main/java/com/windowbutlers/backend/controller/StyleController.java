package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.BackendApplication;
import com.windowbutlers.backend.entity.Style;
import com.windowbutlers.backend.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/style")
public class StyleController {;
    
    @Autowired
    private StyleService styleService;

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createStyle(@RequestBody Style style) {

        styleService.createStyle(style);
        return ResponseEntity.status(HttpStatus.CREATED).body(style);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/singleStyle/{id}")
    public ResponseEntity<?> getSingleStyle(@PathVariable String ID) {

        Style style = styleService.getStyle(ID);
        return ResponseEntity.status(HttpStatus.OK).body(style);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allStyles")
    public ResponseEntity<?> getAllStyles() {

        List<Style> styles = styleService.getAllStyles();
        return ResponseEntity.status(HttpStatus.OK).body(styles);
    }

    @PutMapping("/update/counts/{id}")
    public ResponseEntity<?> updateStyleCounts(@PathVariable String ID, @RequestParam(required = false) Integer large, @RequestParam(required = false) Integer small) {

        styleService.updateStyleCounts(ID, large, small);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Style Large and Small Counts for %s to %s and %s", ID, large, small));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStyle(@PathVariable String ID) {

        styleService.deleteStyle(ID);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Style with ID: %s", ID));
    }
}
