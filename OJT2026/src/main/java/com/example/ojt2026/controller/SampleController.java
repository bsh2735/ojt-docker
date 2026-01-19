package com.example.ojt2026.controller;

import com.example.ojt2026.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ojt2026.dto.SampleDTO.SampleVO;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/sample")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/list")
    public List<SampleVO> getSampleList() {
        return sampleService.getSampleList();
    }

    @GetMapping("/{id}")
    public SampleVO getSampleById(@PathVariable int id) {
        return sampleService.getSampleById(id);
    }
     /* ======================
       Create
     ====================== */
    @PostMapping
    public ResponseEntity<String> createSample(
            @RequestBody Map<String, String> body) {
        sampleService.createSample(
                body.get("name"),
                body.get("email")
        );
        return ResponseEntity.ok("Sample created successfully.");
    }

    /* ======================
       Update
     ====================== */
    @PutMapping("/email")
    public ResponseEntity<String> updateSampleEmail(
            @RequestBody Map<String, String> body) {
        sampleService.updateSampleEmail(
                body.get("name"),
                body.get("email")
        );
        return ResponseEntity.ok("Sample updated successfully.");
    }

    /* ======================
       Delete
     ====================== */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSample(
            @PathVariable int id) {
        sampleService.deleteSample(id);
        return ResponseEntity.ok("Sample deleted successfully.");
    }

    @GetMapping("/search")
    public List<SampleVO> searchSamples(
        @RequestParam(required = false) String keyword,
        @RequestParam(required = false) String type,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate
    ) {
        return sampleService.searchSamples(keyword, type, startDate, endDate);
    }

}

/*
@RestController
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello API SUCCESS";
    }

    @PostMapping("/hello")
    public String postHello(@RequestBody Map<String, Object> request) {
        return "POST API DATA: " + request.get("message");
    }

    @GetMapping("/api/sample")
    public String getSample() {
        return sampleService.getMessage();
    }
}*/

