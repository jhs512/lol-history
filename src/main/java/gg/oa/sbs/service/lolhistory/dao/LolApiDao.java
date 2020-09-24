package gg.oa.sbs.service.lolhistory.dao;

import org.apache.ibatis.annotations.Mapper;

import gg.oa.sbs.service.lolhistory.dto.lolApi.LolApiSummoner;
import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface LolApiDao {
	LolApiSummoner getLolApiSummoner(@Param("name") String name);

	void saveLolApiSummoner(LolApiSummoner lolApiSummoner);

	void updateLolApiSummoner(LolApiSummoner lolApiSummoner);
}
