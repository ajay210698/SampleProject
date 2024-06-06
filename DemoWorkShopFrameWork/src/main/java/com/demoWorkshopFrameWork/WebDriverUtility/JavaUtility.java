package com.demoWorkshopFrameWork.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public  int randomNumber(int num) {
		Random random = new Random();
		int rnum = random.nextInt(num);
        return rnum;
	}
	public String getSystemDateYYYYDDMM()
	{
		 Date dateObj = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		 String date = sdf.format(dateObj);
		 return date;
	}
	public String getRequiredDateYYYYDDMM (int days)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		Calendar cal =sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate ;
	}

}
