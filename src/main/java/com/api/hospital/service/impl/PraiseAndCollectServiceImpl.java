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
        int result = praiseAndCollectMapper.isPraise(praise);
        return result == 1 ? 1 : 0;
    }

    @Override
    public int getPraiseCount(Praise praise) {
        int result = praiseAndCollectMapper.getPraiseCount(praise);
        return Math.max(result, 0);
    }

    @Override
    public void insertPraise(Praise praise) {
        int result = praiseAndCollectMapper.insertPraise(praise);
        if (result != 1) throw new RuntimeException("插入失败");
    }

    @Override
    public void deletePraise(Praise praise) {
        int result = praiseAndCollectMapper.deletePraise(praise);
        if (result != 1) throw new RuntimeException("删除失败");
    }

    @Override
    public int deletePraiseByArticleId(int article_id) {
        return praiseAndCollectMapper.deletePraiseByArticleId(article_id);
    }

    @Override
    public int isCollect(Collect collect) {
        int result = praiseAndCollectMapper.isCollect(collect);
        return result == 1 ? 1 : 0;
    }

    @Override
    public int getCollectCount(int patient_id) {
        int result = praiseAndCollectMapper.getCollectCount(patient_id);
        return Math.max(result, 0);
    }

    @Override
    public List<MyCollect> getCollectByPatientId(int patient_id) {
        List<MyCollect> data = praiseAndCollectMapper.getCollectByPatientId(patient_id);
        if (data.size() > 0) return data;
        else throw new RuntimeException("无数据");

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
