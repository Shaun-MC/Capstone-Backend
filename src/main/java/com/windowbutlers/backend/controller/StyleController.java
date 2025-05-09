package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Styles;
import com.windowbutlers.backend.service.StyleService;
import com.windowbutlers.backend.dto.StyleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/style")
public class StyleController {;
    
    private final StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createStyle(@RequestBody StyleRequest style) {

        Integer id = styleService.createStyle(style);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Successfully created a new style (%d)", id));
    }

    // Passes Happy Path testing:
    @GetMapping("/get/singleStyle/{id}")
    public ResponseEntity<?> getSingleStyle(@PathVariable Integer id) {

        Styles style = styleService.getStyle(id);
        return ResponseEntity.status(HttpStatus.OK).body(style);
    }

    @GetMapping("/get/styleLabel/{id}")
    public ResponseEntity<?> getStyleLabel(@PathVariable Integer id) {

        String styleLabel = styleService.getStyleLabel(id);
        return ResponseEntity.status(HttpStatus.OK).body(styleLabel);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allStyles")
    public ResponseEntity<?> getAllStyles() {

        List<Styles> styles = styleService.getAllStyles();
        return ResponseEntity.status(HttpStatus.OK).body(styles);
    }

    // Technically states that nothing needs to be updateed
    @PutMapping("/update/counts/{id}")
    public ResponseEntity<?> updateStyleCounts(@PathVariable Integer id, @RequestParam(required = false) Integer large, @RequestParam(required = false) Integer small) {

        styleService.updateCounts(id, large, small);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Style Large and Small Counts for %s to %s and %s", id, large, small));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStyle(@PathVariable Integer id) {

        styleService.deleteStyle(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Style with id: %s", id));
    }
}
