package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Styles;
import com.windowbutlers.backend.service.StyleService;
import com.windowbutlers.backend.dto.CountsUpdateRequest;
import com.windowbutlers.backend.dto.StyleRequest;
import com.windowbutlers.backend.validation.ValidIntegerID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/style")
public class StyleController {
    
    private final StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    // Passes Happy Path testing: 5/11/25
    @PostMapping("/create")
    public ResponseEntity<?> createStyle(@RequestBody @Valid StyleRequest style) {

        Integer id = styleService.createStyle(style);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Successfully created a new style (%d)", id));
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/singleStyle/{id}")
    public ResponseEntity<?> getSingleStyle(@PathVariable @ValidIntegerID Integer id) {

        Styles style = styleService.getStyle(id);
        return ResponseEntity.status(HttpStatus.OK).body(style);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/allStyles")
    public ResponseEntity<?> getAllStyles() {

        List<Styles> styles = styleService.getAllStyles();
        return ResponseEntity.status(HttpStatus.OK).body(styles);
    }

    @GetMapping("/get/styleLabel/{id}")
    public ResponseEntity<?> getStyleLabel(@PathVariable @ValidIntegerID Integer id) {

        String styleLabel = styleService.getStyleLabel(id);
        return ResponseEntity.status(HttpStatus.OK).body(styleLabel);
    }

    // Technically states that nothing needs to be updateed
    @PutMapping("/update/counts/{id}")
    public ResponseEntity<?> updateStyleCounts(@PathVariable @ValidIntegerID Integer id, @RequestBody @Valid CountsUpdateRequest req) {

        List<Integer> counts = styleService.updateCounts(id, req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Style Large and Small Counts for Style (%s) to %d and %d", id, counts.get(0), counts.get(1)));
    }

    // Passes Happy Path testing: 5/11/25
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStyle(@PathVariable @ValidIntegerID Integer id) {

        styleService.deleteStyle(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Style with id: %s", id));
    }
}
