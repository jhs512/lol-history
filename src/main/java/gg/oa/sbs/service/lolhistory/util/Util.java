package gg.oa.sbs.service.lolhistory.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

	public static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static <T> T getObjectFromJsonString(String rs, Class<T> cls) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return (T) objectMapper.readValue(rs, cls);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static long getPassedSeconds(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date updateDateObj = dateFormat.parse(date);
			Date nowDateObj = new Date();

			long passedSeconds = (nowDateObj.getTime() - updateDateObj.getTime()) / 1000;

			return passedSeconds;
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return 0;
	}

}
