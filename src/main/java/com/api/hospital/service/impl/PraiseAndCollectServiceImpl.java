package com.api.hospital.service.impl;

import com.api.hospital.mapper.PraiseAndCollectMapper;
import com.api.hospital.model.entity.Collect;
import com.api.hospital.model.entity.Praise;
import com.api.hospital.model.vo.MyCollect;
import com.api.hospital.service.intf.PraiseAndCollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PraiseAndCollectServiceImpl implements PraiseAndCollectService {

    @Resource
    private PraiseAndCollectMapper praiseAndCollectMapper;

    @Override
    public int isPraise(Praise praise) {
        return praiseAndCollectMapper.isPraise(praise);
    }

    @Override
    public int selectPraiseCount(Praise praise) {
        return 0;
    }

    @Override
    public int insertPraise(Praise praise) {
        return 0;
    }

    @Override
    public int deletePraise(Praise praise) {
        return 0;
    }

    @Override
    public int deletePraiseByArticleId(int article_id) {
        return 0;
    }

    @Override
    public int isCollect(Collect collect) {
        return 0;
    }

    @Override
    public int getCollectCount(int patient_id) {
        return 0;
    }

    @Override
    public List<MyCollect> getCollectByPatientId(int patient_id) {
        return null;
    }

    @Override
    public int insertCollect(Collect collect) {
        return 0;
    }

    @Override
    public int deleteCollect(Collect collect) {
        return 0;
    }
}
