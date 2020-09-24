package gg.oa.sbs.service.lolhistory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import gg.oa.sbs.service.lolhistory.dto.UrlResponse;

@Mapper
public interface UrlResponseDao {
	UrlResponse getUrlResponse(@Param("url") String url);

	void saveUrlResponse(@Param("url") String url, @Param("body") String body);

	void updateUrlResponse(@Param("url") String url, @Param("body") String body);
}
