package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

import pojo.Book;

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
	
	public static Book getBook() {
		String isbn = UniqueGenerator.getFaker().name().firstName();
		String aisle = Integer.toString(UniqueGenerator.getRandomNumber());
		String author = UniqueGenerator.getFaker().book().author();
		String bookName = UniqueGenerator.getFaker().book().title();
		return new Book(bookName, isbn, aisle, author);
	}
}
