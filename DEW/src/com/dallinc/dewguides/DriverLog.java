package com.dallinc.dewguides;

import java.text.*;
import java.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.view.*;
import android.widget.*;

public class DriverLog extends Activity {
	
	RelativeLayout MainLayout;
	ArrayList<TimeEntry> times;
	boolean useLocation;
	int width;
	int height;
	int OFF_DUTY;
	int DRIVING;
	int NOT_DRIVING;
	int START_X;
	int LOCATION_Y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.driver_log_draw);
		
		useLocation = getIntent().getBooleanExtra("useLocation", false);
		
		times = new ArrayList<TimeEntry>();
		
		ArrayList<String> templist = getIntent().getStringArrayListExtra("entries");
		for(int i=0; i<templist.size(); i++){
			String[] timetype = templist.get(i).split("\t");
			String calendarString = timetype[0];
			String type = timetype[1];
			String location = "";
			if(timetype.length > 2)
				location = timetype[2];
			
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
			Date d = new Date();
			try {
				d = sdf.parse(calendarString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			
			times.add(new TimeEntry(c, type, location));
		}
		
		Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        OFF_DUTY = (int) (height/9.6);
        DRIVING = (int) (height/4.6);
        NOT_DRIVING = (int) (height/3.6);
        START_X = (int) (width/8.16);
        LOCATION_Y = (int) (height/2.7);
		
        MainLayout = (RelativeLayout) findViewById(R.id.main_screen);
        CustomView customview = new CustomView(this);
        MainLayout.addView(customview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.driver_log_draw, menu);
		return true;
	}
	
	private class CustomView extends View {
		
		public CustomView(Context context) {
			super(context);
	    }
		@Override
	    protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
	        Paint paint = new Paint();;
	        paint.setColor(Color.BLACK);
	        paint.setStrokeWidth(2);
	        paint.setTextSize(20);
	        
	        int oldx = START_X;
	        int oldy = OFF_DUTY;
	        int newx = oldx;
	        int newy = oldy;
	        
	        for(TimeEntry te: times){
	        	String location = te.location();
	        	newx = parseTime(te.time());
	        	canvas.drawLine(oldx, oldy, newx, oldy, paint);
	        	newy = parseType(te.type());
	        	canvas.drawLine(newx, oldy, newx, newy, paint);
	        	if(useLocation){
	        		writeLocation(canvas, newx, oldx, oldy, location, paint);
	        	}
	        	oldx = newx;
	        	oldy = newy;
	        }
	        if(useLocation){ //the last entry
        		String location = times.get(times.size()-1).location();
        		canvas.drawLine(newx, LOCATION_Y, newx, LOCATION_Y+35, paint);
    			canvas.drawLine(newx, LOCATION_Y+35, newx-150, LOCATION_Y+165, paint);
    			
    			canvas.rotate(-41, newx-150, LOCATION_Y+165);
    			// draw the rotated text
    			canvas.drawText(location, newx-150, LOCATION_Y+160, paint);
    			
    			//undo the rotate
    			canvas.rotate(41, newx-150, LOCATION_Y+165);
        	}
		}	
	}
	
	public void writeLocation(Canvas canvas, int xvalue, int xstart, int prevType, String location, Paint paint){
		//don't forget to draw if it is the first entry  -- xstart == START_X
		if(xstart == START_X || prevType == DRIVING){ 
			canvas.drawLine(xvalue, LOCATION_Y, xvalue, LOCATION_Y+35, paint);
			canvas.drawLine(xvalue, LOCATION_Y+35, xvalue-150, LOCATION_Y+165, paint);
			
			canvas.rotate(-41, xvalue-150, LOCATION_Y+165);
			// draw the rotated text
			canvas.drawText(location, xvalue-150, LOCATION_Y+160, paint);
			
			//undo the rotate
			canvas.rotate(41, xvalue-150, LOCATION_Y+165);
		}
	}
	
	public int parseTime(Calendar c){
		double timePlace = 0;
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		timePlace = hour + ((double)minute/60);
		return timeToPixel(timePlace);
	}
	
	public int timeToPixel(double t){
		int time = START_X;
		double oneHourInPixels = width/28.44;
		time += (int) (t*oneHourInPixels);
		return time;
	}
	
	public int parseType(String typename){
		int typeValue = 0;
		if(typename.equals("Off Duty"))
			typeValue = OFF_DUTY;
		else if(typename.equals("Driving"))
			typeValue = DRIVING;
		else if(typename.equals("Not Driving"))
			typeValue = NOT_DRIVING;
		return typeValue;
	}

}
