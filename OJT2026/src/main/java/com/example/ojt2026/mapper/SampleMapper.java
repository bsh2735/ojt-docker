package com.example.ojt2026.mapper;

import java.util.List;
import java.util.Map;
import com.example.ojt2026.dto.SampleDTO.SampleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

    int insertWavus(Map<String, Object> param);

    List<SampleVO> selectWavusList();

    SampleVO selectWavusById(int id);

    int updateWavusEmail(Map<String, Object> param);

    int deleteWavus(int id);

    List<SampleVO> searchWavus(Map<String, Object> param);
}

