package gg.oa.sbs.service.lolhistory.dto.lolApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LolApiMatchReference {
	private long gameId;
	private String role;
	private int season;
	private String platformId;
	private int champion;
	private int queue;
	private String lane;
	private long timestamp;
}
