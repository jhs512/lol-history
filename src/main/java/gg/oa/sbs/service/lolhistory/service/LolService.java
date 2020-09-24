package gg.oa.sbs.service.lolhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.oa.sbs.service.lolhistory.dao.LolApiDao;
import gg.oa.sbs.service.lolhistory.dto.lolApi.LolApiSummoner;

@Service
public class LolService {
	@Autowired
	LolApiDao lolApiDao;

	@Autowired
	LolApiService lolApiService;

	public LolApiSummoner getLolApiSummoner(String name) {
		LolApiSummoner lolApiSummoner = lolApiDao.getLolApiSummoner(name);

		if (lolApiSummoner == null) {
			lolApiSummoner = lolApiService.getLolApiSummoner(name);
			lolApiDao.saveLolApiSummoner(lolApiSummoner);
		}
		else if ( lolApiSummoner.isOld() ) {
			lolApiSummoner = lolApiService.getLolApiSummoner(name);
			lolApiDao.updateLolApiSummoner(lolApiSummoner);
		}

		return lolApiSummoner;

	}
}
