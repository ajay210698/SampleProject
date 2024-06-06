package com.demoWorkshopFrameWork.Genric.FileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public static String getDataFromJasonFile(String key) throws  Throwable  {
		JSONParser jp = new JSONParser();
		Object parse = jp.parse(new FileReader("./src/test/resources/DDTfiles/jsonFile.json"));
		JSONObject j= (JSONObject)parse;
		 String value = (String)j.get(key);
		return value;
	}

}
