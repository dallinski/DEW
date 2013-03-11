package com.dallinc.dewguides;

import java.text.*;
import java.util.*;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.*;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.text.format.DateFormat;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainPages extends FragmentActivity implements ActionBar.TabListener {
	
	static SharedPreferences settings;
	static Calendar entryTime;
	static ArrayList<TimeEntry> driverLogEntries;
	static boolean useLocation;
	static int opentabposition;

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_tabs_pager);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
				opentabposition = position;
			}
		});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		mViewPager.setCurrentItem(opentabposition);
		
		driverLogEntries = new ArrayList<TimeEntry>();
		settings = getPreferences(MODE_PRIVATE);
		
		for(int i=0; i<settings.getAll().size(); i++){
			String[] temp = settings.getString("" + i, "Does Not Exist").split("\t");
			if(settings.getString("" + i, "Does Not Exist").equals("Does Not Exist")){
				System.out.println("Found a bad setting!");
				continue;
			}
			
			String calendarString = temp[0];
			String type = temp[1];
			String location = "";
			if(temp.length > 2){
				location = temp[2];
			}			
			
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
			Date d = new Date();
			try {
				d = sdf.parse(calendarString);
				int offset = d.getTimezoneOffset();
				if(offset == (60*7)){
					d.setHours(d.getHours()+1);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			
			driverLogEntries.add(new TimeEntry(c, type, location));
		}
		
		entryTime = Calendar.getInstance();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fragment_tabs_pager, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		DialogFragment newFragment = new AboutFragment();
	    newFragment.show(getSupportFragmentManager(), "About");
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 4 total pages.
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.info);
			case 1:
				return getString(R.string.tango);
			case 2:
				return getString(R.string.driver_log);
			case 3:
				return getString(R.string.contacts);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
				return inflater.inflate(R.layout.information, container, false);
			}
			else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
				return inflater.inflate(R.layout.tango, container, false);
			}
			else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){
				View v = inflater.inflate(R.layout.driver_log, container, false);
				InitializeCheckBox(v);
				
				TextView timestamp = (TextView) v.findViewById(R.id.timeStamps);
				updateTimeStamp(timestamp);
	       	 	
				return v;
			}
			else if(getArguments().getInt(ARG_SECTION_NUMBER) == 4){
				View v = inflater.inflate(R.layout.contacts, container, false);
				InitializeContacts(v);
				return v;
			}
			else{
				// Create a new TextView and set its text to the fragment's section
				// number argument value.
				TextView textView = new TextView(getActivity());
				textView.setGravity(Gravity.CENTER);
				textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
				return textView;
			}
		}
		
		public void updateTimeStamp(TextView timestamp){
			String toDisplay = "";
    		for(int i=0; i< driverLogEntries.size(); i++){
    			toDisplay += driverLogEntries.get(i).vegasString(useLocation) + "\n";
    		}
       	 	timestamp.setText(toDisplay);
		}
		
		public void InitializeCheckBox(View v){
			CheckBox locationCheckBox = (CheckBox) v.findViewById(R.id.locationCheckBox);
			final TextView timestamp = (TextView) v.findViewById(R.id.timeStamps);
			locationCheckBox.setChecked(useLocation);
			locationCheckBox.setOnClickListener(new OnClickListener() {
				  @Override
				  public void onClick(View v) {
					if (((CheckBox) v).isChecked()) { useLocation = true; }
					else{ useLocation = false; }
					updateTimeStamp(timestamp);
				  }
				});
		}
		
		public void InitializeContacts(View v){
			QuickContactBadge dallinC = (QuickContactBadge) v.findViewById(R.id.dallinC);
			//dallinC.assignContactFromPhone("8013806895", true);
			QuickContactBadge dallinS = (QuickContactBadge) v.findViewById(R.id.dallinS);
			//dallinS.assignContactFromPhone("8017225994", true);
			QuickContactBadge chrisM = (QuickContactBadge) v.findViewById(R.id.chrisM);
			//chrisM.assignContactFromPhone("8016823906", true);
			QuickContactBadge chrisS = (QuickContactBadge) v.findViewById(R.id.chrisS);
			//chrisS.assignContactFromPhone("7024985158", true);
			QuickContactBadge chrisV = (QuickContactBadge) v.findViewById(R.id.chrisV);
			//chrisV.assignContactFromPhone("8019417558", true);
			QuickContactBadge paul = (QuickContactBadge) v.findViewById(R.id.paul);
			//paul.assignContactFromPhone("8014192198", true);
			QuickContactBadge jordan = (QuickContactBadge) v.findViewById(R.id.jordan);
			//jordan.assignContactFromPhone("2082066378", true);
			QuickContactBadge grant = (QuickContactBadge) v.findViewById(R.id.grant);
			//grant.assignContactFromPhone("4134644244", true);
			QuickContactBadge eric = (QuickContactBadge) v.findViewById(R.id.eric);
			//eric.assignContactFromPhone("7028848636", true);
			QuickContactBadge mot = (QuickContactBadge) v.findViewById(R.id.mot);
			//mot.assignContactFromPhone("7023735931", true);
			QuickContactBadge ryan = (QuickContactBadge) v.findViewById(R.id.ryan);
			//ryan.assignContactFromPhone("7022100798", true);
			QuickContactBadge marc = (QuickContactBadge) v.findViewById(R.id.marc);
			//marc.assignContactFromPhone("8016876895", true);
			QuickContactBadge bill = (QuickContactBadge) v.findViewById(R.id.bill);
			//bill.assignContactFromPhone("8019711044", true);
			QuickContactBadge stephen = (QuickContactBadge) v.findViewById(R.id.stephen);
			//stephen.assignContactFromPhone("8017874164", true);
			QuickContactBadge nate = (QuickContactBadge) v.findViewById(R.id.nate);
			nate.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Nate doesn't give out his number!", Toast.LENGTH_LONG).show();
	             }
	         });
			QuickContactBadge reed = (QuickContactBadge) v.findViewById(R.id.reed);
			reed.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "No info for Reed yet!", Toast.LENGTH_LONG).show();
	             }
	         });
			
			dallinC.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			dallinS.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			chrisM.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			chrisS.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			chrisV.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			paul.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			jordan.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			grant.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			eric.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			mot.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			ryan.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			marc.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			bill.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
			stephen.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Toast.makeText(getActivity(), "Contact info only available to DEW Guides!", Toast.LENGTH_SHORT).show();
	             }
	         });
		}
	}
	
	public void InfoButtonPressed(View v){
		Button b = (Button) v;
		Intent i = new Intent(getApplicationContext(), InfoMenus.class);
		i.putExtra("tabname", b.getText().toString());
		startActivity(i);
	}
	
	public void TangoButtonPressed(View v){
		Button b = (Button) v;
		Intent i = new Intent(getApplicationContext(), Tango.class);
		i.putExtra("tabname", b.getText().toString());
		startActivity(i);
	}
	
	public void DriverButtonPressed(View v){
		
		ArrayList<String> templist = new ArrayList<String>();
		for(int i=0; i< driverLogEntries.size(); i++){
			templist.add(driverLogEntries.get(i).toString());
		}
		
		Intent i = new Intent(getApplicationContext(), DriverLog.class);
		i.putStringArrayListExtra("entries", templist);
		i.putExtra("useLocation", useLocation);
		startActivity(i);
	}
	
	@SuppressLint("ValidFragment")
	public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

		private boolean fired = false;
		
	    public void resetFired(){
	        fired = false;
	    }
		
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			setRetainInstance(true);
			// Use the current time as the default values for the picker
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			
			// Create a new instance of TimePickerDialog and return it
			TimePickerDialog tpd = new TimePickerDialog(getActivity(), this, hour, minute,DateFormat.is24HourFormat(getActivity()));
			tpd.setTitle("Set time (using local time)");
			return tpd;
		}
		
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			if (fired == true) { return; } 
	        fired = true;//first time fired
	        // Do something with the time chosen by the user
			entryTime.set(entryTime.get(Calendar.YEAR), entryTime.get(Calendar.MONTH), entryTime.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
			pickType((Calendar) entryTime.clone());
		}
	}
	
	public void showTimePickerDialog(View v) {
	    DialogFragment newFragment = new TimePickerFragment();
	    newFragment.show(getSupportFragmentManager(), "timePicker");
	}
	
	private void pickType(final Calendar time) {
		AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
		helpBuilder.setTitle("Select type");
//		helpBuilder.setMessage("Select type in message");
		helpBuilder.setPositiveButton("Off Duty", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				addEntry(time, "Off Duty");
			}
		});

		helpBuilder.setNegativeButton("Driving", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) { 
				addEntry(time, "Driving");
			}
		});
		 
		helpBuilder.setNeutralButton("Not Driving", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) { 
				addEntry(time, "Not Driving"); 
			}
		});

		// Remember, create doesn't show the dialog
		AlertDialog helpDialog = helpBuilder.create();
		helpDialog.show();
	}
	
	class customComparator implements Comparator<TimeEntry> {
	    public int compare(TimeEntry t1, TimeEntry t2) {
	    	Calendar c1 = t1.time();
	    	Calendar c2 = t2.time();
	    	return c1.compareTo(c2);
	    }
	}
	
	public void updateTimes(SharedPreferences.Editor editor){
		String toDisplay = "";
		for(int i=0; i< driverLogEntries.size(); i++){
			toDisplay += driverLogEntries.get(i).vegasString(useLocation) + "\n";
			editor.putString("" + i, driverLogEntries.get(i).toString());
			editor.commit();
		}
		editor.commit();
   	 	TextView timestamp = (TextView) findViewById(R.id.timeStamps);
   	 	timestamp.setText(toDisplay);
	}
	
	public void addEntry(final Calendar time, final String type){	
		if(useLocation){
			final String[] options = new String[]{"Las Vegas", "Choose from GC tour",
					"Choose from Bryce tour", "Choose from Sedona tour", 
					"Input new location", "Use GPS coordinates"};
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
		    builder.setTitle("Choose location");
		    builder.setItems(options, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int item) {
		        	if(options[item].equals("Las Vegas")){
		        		addEntryWithLocation(time, type, "Las Vegas");
		        	}
		        	else if(options[item].equals("Use GPS coordinates")){
		        		addEntryWithLocation(time, type, "GPS coordinates");
		        	}
		        	else if(options[item].equals("Input new location")){
		        		customLocationInput(time, type);
		        	}
		        	else if(options[item].equals("Choose from GC tour")){
		        		chooseFromTourList(time, type, "GC");
		        	}
		        	else if(options[item].equals("Choose from Sedona tour")){
		        		chooseFromTourList(time, type, "Sedona");
		        	}
		        	else if(options[item].equals("Choose from Bryce tour")){
		        		chooseFromTourList(time, type, "Bryce");
		        	}
		        }
		    });
		    AlertDialog alert = builder.create();
		    alert.show();
		}
		else{
			addEntryWithLocation(time, type, "");
		}
	}
	
	public void addEntryWithLocation(Calendar time, String type, String location){
		driverLogEntries.add(new TimeEntry(time, type, location));
		Collections.sort(driverLogEntries, new customComparator());
	    SharedPreferences.Editor editor = settings.edit();
	    updateTimes(editor);
	}
	
	public void chooseFromTourList(final Calendar time, final String type, String tour){
		final String[] options;
		String tourTitle = tour + " tour locations";
		if(tour.equals("GC")){
			options = new String[]{"St. George, UT", "Hurricane, UT", "Kanab, UT", 
					"Glen Canyon Dam, AZ", "Page, AZ", "Kayenta, AZ", "Monument Valley, UT",
					"Cameron, AZ", "Grand Canyon, AZ", "Tusayan, AZ", "Williams, AZ", 
					"Seligman, AZ", "Kingman, AZ", "Hoover Dam, NV", "Boulder City, NV"};
		}
		else if(tour.equals("Sedona")){
			options = new String[]{"Kanab, UT", "Mt. Carmel, UT", "Orderville, UT",
					"Glendale, UT", "Red Canyon, UT", "Ruby's Inn, UT", "Bryce Canyon NP, UT",
					"Sunrise Point, BCNP, UT", "Sunset Point, BCNP, UT", "Bryce Point, BCNP, UT",
					"Inspiration Point, BCNP, UT"};
		}
		else if(tour.equals("Bryce")){
			options = new String[]{"Williams, AZ", "Flagstaff, AZ", "Slide Rock SP, AZ",
					"Sedona, AZ", "Chapel of the Holy Cross, Sedona, AZ", 
					"Crescent Moon Ranch SP, AZ", "Bell Rock, Sedona, AZ"};
		}
		else{
			options = new String[0];
		}
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle(tourTitle);
	    builder.setItems(options, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int item) {
	        	addEntryWithLocation(time, type, options[item]);
	        }
	    });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
	
	public void customLocationInput(final Calendar time, final String type){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Input location");
	    
	    final EditText input = new EditText(this);
	    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
	            LinearLayout.LayoutParams.FILL_PARENT,
	            LinearLayout.LayoutParams.FILL_PARENT);
	    input.setLayoutParams(lp);
	    builder.setView(input);

	    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	        	addEntryWithLocation(time, type, input.getText().toString());
	        }
	    });
	    
	    AlertDialog alert = builder.create();
	    alert.show();
	    alert.getWindow().setSoftInputMode (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
	}
	
	public void deleteSelection(View v){
		if(driverLogEntries.size() == 0){
			Toast.makeText(this, "No timestamp to delete!", Toast.LENGTH_SHORT).show();
			return;
		}
		String[] entrystrings = new String[driverLogEntries.size()];
		for(int i=0; i<driverLogEntries.size(); i++){
			TimeEntry te = driverLogEntries.get(i);
			entrystrings[i] = te.vegasString(false);
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Delete which entry?");
	    builder.setItems(entrystrings, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int item) {
	             deleteAt(item);
	        }
	    });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
	
	public void deleteAt(int i){
		SharedPreferences.Editor editor = settings.edit();
	   	driverLogEntries.remove(i);
	    editor.clear();
	    editor.commit();
	    updateTimes(editor);
	}
	
	public void deleteAll(final View v){
		if(driverLogEntries.size() == 0){
			Toast.makeText(this, "No timestamp to delete!", Toast.LENGTH_SHORT).show();
			return;
		}
		AlertDialog.Builder confirmation = new AlertDialog.Builder(this);
		confirmation.setTitle("Delete All");
		confirmation.setMessage("Are you sure?");
		confirmation.setPositiveButton("Delete All", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				driverLogEntries.clear();
				SharedPreferences.Editor editor = settings.edit();
				editor.clear();
				editor.commit();
				updateTimes(editor);
			}
		});

		confirmation.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) { }
		});

		// Remember, create doesn't show the dialog
		AlertDialog confirmationDialog = confirmation.create();
		confirmationDialog.show();
	}
	
	public void addOffDuty(View v){
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		addEntry(c, "Off Duty");
	}
	
	public void addDriving(View v){
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		addEntry(c, "Driving");
	}
	
	public void addNotDriving(View v){
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		addEntry(c, "Not Driving");
	}
	
	public static class AboutFragment extends DialogFragment {
	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	    	setRetainInstance(true);
	        // Use the Builder class for convenient dialog construction
	        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	        TextView myMsg = new TextView(getActivity());
	        myMsg.setText(R.string.about);
	        myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
	        builder.setView(myMsg);
	        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {}
	               });
	        // Create the AlertDialog object and return it
	        return builder.create();
	    }
	}

}
