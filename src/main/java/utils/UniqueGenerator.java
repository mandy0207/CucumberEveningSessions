package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class UniqueGenerator {

	public static Faker getFaker() {
		return  new Faker();
		
	}
	
	public static int getRandomNumber() {
		return (int)(Math.random() * 10000);
	}
	
	public static  String getUniqueString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
       return  "client"+sdf.format(now).replace("-", "").replace(":", "").replace(" ", "");
      
	}
}
