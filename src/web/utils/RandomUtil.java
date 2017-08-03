package web.utils;

import java.util.UUID;

public class RandomUtil {
	
	public static String getId(){
		return UUID.randomUUID().toString();
	}

}
