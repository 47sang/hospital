package com.api.hospital.mapper;

import com.api.hospital.model.entity.Collect;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PraiseAndCollectMapperTest {

    @Resource
    private PraiseAndCollectMapper praiseAndCollectMapper;

    @Test
    void getCollectCount() {
        int result = praiseAndCollectMapper.getCollectCount(1);
        assertEquals(1, result);
    }

    @Test
    void insertCollect() {
        Collect collect = new Collect();
        collect.setArticle_id(1);
        collect.setPatient_id(1);
        int result = praiseAndCollectMapper.insertCollect(collect);
        assertEquals(1, result);
    }
}