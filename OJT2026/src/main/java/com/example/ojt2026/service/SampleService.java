package com.example.ojt2026.service;

import com.example.ojt2026.mapper.SampleMapper;
import org.springframework.stereotype.Service;
import com.example.ojt2026.dto.SampleDTO.SampleVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SampleService {

    private final SampleMapper sampleMapper;

    public SampleService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    public List<SampleVO> getSampleList() {
        return sampleMapper.selectWavusList();
    }
    public SampleVO getSampleById(int id) {
        return sampleMapper.selectWavusById(id);
    }

    /* ======================
       Create
     ====================== */
    public int createSample(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("email", email);
        int result = sampleMapper.insertWavus(param);

        if (result == 0) {
            throw new RuntimeException("Failed to insert sample.");
        }
        return result;
    }
    /* ======================
       Update
     ====================== */
    public int updateSampleEmail(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("email", email);
        int result = sampleMapper.updateWavusEmail(param);
        if (result == 0) {
            throw new RuntimeException("No data updated. Name not found.");
        }
        return result;
    }

    /* ======================
       Delete
     ====================== */
    public int deleteSample(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid id.");
        }
        int result = sampleMapper.deleteWavus(id);

        if (result == 0) {
            throw new RuntimeException("No data deleted. ID not found.");
        }
        return result;
    }
    public List<SampleVO> searchSamples(
        String keyword,
        String type,
        String startDate,
        String endDate
    ) {
        Map<String, Object> param = new HashMap<>();
        param.put("keyword", keyword);
        param.put("type", type);
        param.put("startDate", startDate);
        param.put("endDate", endDate);

        return sampleMapper.searchWavus(param);
    }
}
/*@Service
public class SampleService {

    public String getMessage() {
        return "GET API SEUCCUESS";
    }

    public String saveMessage(String message) {
        return "POST API DATA: " + message;
    }
}*/
