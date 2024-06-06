import java.io.IOException;

import com.demoWorkshopFrameWork.Genric.FileUtility.PropertiesFileUtility;

public class Sample {

	public static void main(String[] args) throws Throwable {
		PropertiesFileUtility pfu = new PropertiesFileUtility();
		System.out.println(pfu.getDataFromPropertyFile("Browser"));
		
	}
}
