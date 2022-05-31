package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Collect;
import com.api.hospital.model.entity.Praise;
import com.api.hospital.model.vo.MyCollect;

import java.util.List;

public interface PraiseAndCollectService {
    int isPraise(Praise praise);

    int getPraiseCount(Praise praise);

    void insertPraise(Praise praise);

    void deletePraise(Praise praise);

    int deletePraiseByArticleId(int article_id);

    int isCollect(Collect collect);

    int getCollectCount(int patient_id);

    List<MyCollect> getCollectByPatientId(int patient_id);

    int insertCollect(Collect collect);

    int deleteCollect(Collect collect);
}
