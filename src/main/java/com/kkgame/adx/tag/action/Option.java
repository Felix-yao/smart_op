package com.kkgame.adx.tag.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kkgame.adx.base.BaseAction;

public class Option extends BaseAction {

	public static final String KEY = "key";

	public static final String VALUE = "value";
	
	public List<HashMap<String,String>> getAppMode(){
		List<HashMap<String, String>> list =new ArrayList<HashMap<String,String>>();
		HashMap<String, String> item = new HashMap<String,String>();
		item.put(KEY, "0");
		item.put(VALUE, "--Integration Mode--");
		list.add(item);
		item =new HashMap<String,String>();
		item.put(KEY, "1");
		item.put(VALUE, "SDK");
		list.add(item);
		item = new HashMap<String,String>();
		item.put(KEY, "2");
		item.put(VALUE, "Smartlink");
		list.add(item);
		item = new HashMap<String,String>();
		item.put(KEY, "3");
		item.put(VALUE, "Online API");
		list.add(item);
		item = new HashMap<String,String>();
		item.put(KEY, "4");
		item.put(VALUE, "JS Tag");
		list.add(item);
		item = new HashMap<String,String>();
		item.put(KEY, "5");
		item.put(VALUE, "RTB");
		list.add(item);
		item = new HashMap<String,String>();
		item.put(KEY, "6");
		item.put(VALUE, "Offline API");
		list.add(item);
		item = new HashMap<String,String>();
		item.put(KEY, "8");
		item.put(VALUE, "GP");
		list.add(item);
//		item = new HashMap<String,String>();
//		item.put(KEY, "7");
//		item.put(VALUE, "Video Sdk");
//		list.add(item);
		return list;
	}
	
	public List<HashMap<String,String>> getOfferCategory(){
		List<HashMap<String, String>> list =new ArrayList<HashMap<String,String>>();
		HashMap<String, String> item = new HashMap<String,String>();
		item.put(KEY, "1");
		item.put(VALUE, "Banner");
		list.add(item);
		return list;
	}
	
	public List<HashMap<String,String>> getOfferSize(){
		List<HashMap<String, String>> list =new ArrayList<HashMap<String,String>>();
		HashMap<String, String> item = new HashMap<String,String>();
		item.put(KEY, "101");
		item.put(VALUE, "300x250");
		list.add(item);
		item =new HashMap<String,String>();
		item.put(KEY, "102");
		item.put(VALUE, "320x50");
		list.add(item);
		item =new HashMap<String,String>();
		item.put(KEY, "103");
		item.put(VALUE, "320x480");
		list.add(item);
		return list;
	}
	
	
	public List<HashMap<String, String>> getUserStatus(){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> item =new HashMap<String,String>();
		item.put(KEY, "-1");
		item.put(VALUE, "-Status-");
		list.add(item);
		item = new HashMap<String, String>();
		item.put(KEY, "0");
		item.put(VALUE, "Pending");
		list.add(item);
		item = new HashMap<String, String>();
		item.put(KEY, "1");
		item.put(VALUE, "Approve");
		list.add(item);
		item = new HashMap<String, String>();
		item.put(KEY, "2");
		item.put(VALUE, "Deny");
		list.add(item);
		item = new HashMap<String, String>();
		item.put(KEY, "3");
		item.put(VALUE, "Block");
		list.add(item);
		return list;
		
	}

}
