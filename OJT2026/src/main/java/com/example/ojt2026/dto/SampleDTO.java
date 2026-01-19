package com.example.ojt2026.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SampleDTO {
    private SampleVO sampleVO;

    @Getter
    @Setter
    public static class SampleVO {
        private Long id;
        private String name;
        private String email;
        private LocalDateTime createAt;
    }

}
