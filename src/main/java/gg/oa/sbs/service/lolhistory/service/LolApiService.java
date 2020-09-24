package gg.oa.sbs.service.lolhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import gg.oa.sbs.service.lolhistory.dto.lolApi.LolApiMatchlist;
import gg.oa.sbs.service.lolhistory.dto.lolApi.LolApiSummoner;
import gg.oa.sbs.service.lolhistory.util.Util;

@Service
public class LolApiService {
	private static final int HTTP_STATUS_CODE_RATE_LIMIT_EXCEEEDED = 429;

	@Value("${custom.lolApi.apiKey}")
	private String apiKey;
	private String apiUrlHead = "https://kr.api.riotgames.com/lol/";

	@Autowired
	private UrlResponseService urlResponseService;

	private boolean isRateLimitExceededExceptionMessage(String message) {
		return message.indexOf(HTTP_STATUS_CODE_RATE_LIMIT_EXCEEEDED + "") != -1;
	}

	public LolApiSummoner getLolApiSummoner(String name) {
		while (true) {
			try {
				String rs = urlResponseService
						.callUrl(apiUrlHead + "summoner/v4/summoners/by-name/" + name + "?api_key=" + apiKey);

				LolApiSummoner lolApiSummoner = Util.getObjectFromJsonString(rs, LolApiSummoner.class);

				return lolApiSummoner;
			} catch (HttpClientErrorException e) {
				if (isRateLimitExceededExceptionMessage(e.getMessage())) {
					Util.sleep(500);
					continue;
				}

				throw e;
			}
		}
	}

	public LolApiMatchlist getLolApiMatchlist(String accountId) {

		int beginIndex = 0;
		int endIndex = 20;

		while (true) {
			try {
				String rs = urlResponseService.callUrl(apiUrlHead + "match/v4/matchlists/by-account/" + accountId
						+ "?endIndex=" + endIndex + "&beginIndex=" + beginIndex + "&api_key=" + apiKey);

				LolApiMatchlist lolApiMatchlist = Util.getObjectFromJsonString(rs, LolApiMatchlist.class);

				return lolApiMatchlist;
			} catch (HttpClientErrorException e) {
				if (isRateLimitExceededExceptionMessage(e.getMessage())) {
					Util.sleep(500);
					continue;
				}

				throw e;
			}
		}
	}
}
