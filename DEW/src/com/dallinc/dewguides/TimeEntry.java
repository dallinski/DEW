package com.dallinc.dewguides;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeEntry {
	Calendar time;
	String type;
	String location;

	public TimeEntry(Calendar c, String t, String l){
		time = c;
		type = t;
		location = l;
	}
	
	public Calendar time(){
		return time;
	}
	
	public String type(){
		return type;
	}
	
	public String location(){
		return location;
	}
	
	public String toString(){
		return time.getTime().toString() + "\t" + type + "\t" + location;
	}
	
	public String vegasString(boolean showLocation){
		SimpleDateFormat sdf = new SimpleDateFormat("EEE h:mm a z");
		sdf.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		String out = "" + sdf.format(time.getTime()) + "\t" + type;
		return showLocation ? out + "\t" + location : out;
	}
}
