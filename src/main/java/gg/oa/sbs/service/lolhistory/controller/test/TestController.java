package gg.oa.sbs.service.lolhistory.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gg.oa.sbs.service.lolhistory.dto.lolApi.LolApiMatchlist;
import gg.oa.sbs.service.lolhistory.dto.lolApi.LolApiSummoner;
import gg.oa.sbs.service.lolhistory.service.LolApiService;
import gg.oa.sbs.service.lolhistory.service.LolService;

@Controller
public class TestController {
	@Autowired
	private LolApiService lolApiService;
	@Autowired
	private LolService lolService;

	// API에서 가져오기
	@RequestMapping("/test/lolApiService__getLolApiSummoner")
	@ResponseBody
	public LolApiSummoner test__lolApiService__getLolApiSummoner(String name) {
		return lolApiService.getLolApiSummoner(name);
	}

	// 자체 캐시데이터 저장소(lolApiSummoner 테이블) 이용, API에서 가져오기
	@RequestMapping("/test/lolService__getLolApiSummoner")
	@ResponseBody
	public LolApiSummoner test__lolService__getLolApiSummoner(String name) {
		return lolService.getLolApiSummoner(name);
	}

	// API에서 가져오기
	@RequestMapping("/test/lolApiService__getLolApiMatchList")
	@ResponseBody
	public LolApiMatchlist test__lolApiService__getLolApiMatchList(String accountId) {
		return lolApiService.getLolApiMatchlist(accountId);
	}
}
