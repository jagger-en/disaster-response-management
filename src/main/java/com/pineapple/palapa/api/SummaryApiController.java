package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pineapple.palapa.model.Summary;
import com.pineapple.palapa.service.SummaryService;

import java.util.List;

@RestController
@RequestMapping("/api/summaries")

public class SummaryApiController {
    private final SummaryService summaryService;

    public SummaryApiController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Summary>> getAllSummaries() {
        List<Summary> summaries = summaryService.findAllSummaries();
        return new ResponseEntity<>(summaries, HttpStatus.OK);
    }
}
