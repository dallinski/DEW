package com.dallinc.dewguides;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.LayoutParams;

public class BryceCanyon extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	static SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bryce_display);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
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
		
		String tabname = getIntent().getStringExtra("tabname");
		if(tabname.equals("Kanab"))
			actionBar.setSelectedNavigationItem(0);
		else if(tabname.equals("Kanab Canyon"))
			actionBar.setSelectedNavigationItem(1);
		else if(tabname.equals("Best Friends Animal Shelter"))
			actionBar.setSelectedNavigationItem(2);
		else if(tabname.equals("Mt. Carmel"))
			actionBar.setSelectedNavigationItem(3);
		else if(tabname.equals("Maynard Dixon"))
			actionBar.setSelectedNavigationItem(4);
		else if(tabname.equals("Orderville"))
			actionBar.setSelectedNavigationItem(5);
		else if(tabname.equals("Glendale"))
			actionBar.setSelectedNavigationItem(6);
		else if(tabname.equals("Red Canyon"))
			actionBar.setSelectedNavigationItem(7);
		else if(tabname.equals("Ruby's Inn"))
			actionBar.setSelectedNavigationItem(8);
		else if(tabname.equals("Bryce Canyon National Park"))
			actionBar.setSelectedNavigationItem(9);
		else if(tabname.equals("Geology"))
			actionBar.setSelectedNavigationItem(10);
		else if(tabname.equals("Sunrise Point"))
			actionBar.setSelectedNavigationItem(11);
		else if(tabname.equals("Sunset Point"))
			actionBar.setSelectedNavigationItem(12);
		else if(tabname.equals("Inspiration Point"))
			actionBar.setSelectedNavigationItem(13);
		else if(tabname.equals("Bryce Point"))
			actionBar.setSelectedNavigationItem(14);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bryce_display, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
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
			return 15;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.kanab);
			case 1:
				return getString(R.string.kanab_canyon);
			case 2:
				return getString(R.string.best_friends_animal_shelter);
			case 3:
				return getString(R.string.mt_carmel);
			case 4:
				return getString(R.string.maynard_dixon);
			case 5:
				return getString(R.string.orderville);
			case 6:
				return getString(R.string.glendale);
			case 7:
				return getString(R.string.red_canyon);
			case 8:
				return getString(R.string.ruby_s_inn);
			case 9:
				return getString(R.string.bryce_canyon_national_park);
			case 10:
				return getString(R.string.geology);
			case 11:
				return getString(R.string.sunrise_point);
			case 12:
				return getString(R.string.sunset_point);
			case 13:
				return getString(R.string.inspiration_point);
			case 14:
				return getString(R.string.bryce_point);
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
		
		public final String KANAB = "In the Southern Paiute Language Kanab means Willow or basket woven from willows.  The first non-natives to settle were Mormon pioneers who arrived in the 1850s.  A fort was built in 1864 in response to the gBlackhawk War.h  Hostilities continued and the area was abandoned in 1866. \n\n In 1870 Brigham Young called for a new settlement in the area and the town of Kanab was established.  In 1911 Kanab elect the first all woman town council in the United States (this was of course before women were even allowed to vote.)  In the 1920fs Tom Mix came to Kanab and made the first western movie here.   \n\n Kanab became a famous location for movies and in the 50fs and 60fs, during the heyday of gwesternsh, Kanab was known as gLittle Hollywood.h";
		public final String KANABCANYON = "No info yet";
		public final String BESTFRIENDS = "No info yet";
		public final String MTCARMEL = "After you pass Mt Carmel JCT. at the intersection of HWY 89 and UT 9 (also known as the Mt Carmel HWY) is the town of Mt Carmel.  Mt. Carmel is named after an area in Palestine.  The name means gGarden Land.h   \n\n The town was originally called Windsor  but was abandoned because of conflict with the glocal Indiansh.  When the people returned after the conflict ended they changed the name. \n\n The main Landmark in the town is the old rock Church/School which was built in 1890 after public education was mandated in the Utah territory.  Currently the building is a visitorfs center. ";
		public final String MAYNARD = "Mt Carmel was the part time home and Studio of the famous modernist artist Maynard Dixon.  His home and Studio can be seen on the west side of the HWY.  Maynard ";
		public final String ORDERVILLE = "Orderville is named after a practice among the Mormons known as the United Order.  In the 1870s 190 people moved to Orderville and agreed to combine all of their worldly goods and share all things in common.  They turned over all of their property and money.  Workers were all compensated for their labor equally, regardless of the type of work they did.  Within two years the town had more than 800 residents.  The United Order was abandoned in the 1880fs a few years after Brigham Youngfs death. ";
		public final String GLENDALE = "Glendale was named after a town in Scotland, which was the hometown of the first Bishop of Glendale UT.  It was settled as a ranching community but it also has fruit orchards.";
		public final String REDCANYON = "Red Canyon is on UT12 between HWY 89 and Bryce Canyon.  The canyon is part of the same Claron Formation that makes up the gHoodoosh in Bryce Canyon.  The two most famous Hoodoos are called eSalt and Pepper.h  Because Red Canyon is not part of the National Park regulations regarding activities and recreation are less stringent.";
		public final String RUBYS = "Ruben Syrett settled near Bryce Canyon he began ranching.  Soon he was introduced to Bryce.   He thought it was spectacular.  He began promoting Bryce Canyon and introducing it to others.  Soon this became his main business.  He built primitive accommodations near what is now Sunset Point and called it gTourist Resth. \n\n When Bryce became a National Monument in the 1920fs the Park Service no longer allowed Ruby to run his business (they NPS had concession contracts with another company).  Ruby was forced to move his business to his ranch (the area where Rubyfs Inn now stands).  Rubyfs descendants own all of they businesses between the park and Hwy 12.  The area that was Rubyfs ranch is now called gBryce Canyon Cityh.   It is the largest employer in the County.  In the summer Rubyfs Inn employs 600 people.";
		public final String BCNP = "Bryce is one of the few National parks named after a person.  Ebeneezer Bryce was a Mormon pioneer who lived in the area in the 1870s.  Bryce was an immigrant from Scotland who had some experience building ships in his youth.  When Brigham Young was gathering groups to settle wilderness areas, skills like building, blacksmithing, etc were in high demand.  Bryce was often sent to establish new communities.  He was only in this area for 5 years.  Of Bryce canyon he is rumored to have described it as ga hell of a place to lose a cow.h \n\n Bryce was sent here as an early settler.  The church house Bryce built in Cannonville, is said to be the oldest Mormon building still standing.  Bryce built his cabin and Ranch just below Bryce Canyon in the area where the town of Tropic now stands.  People from the neighboring area would pass through Brycefs land on their way to cut wood in Bryce Canyon.  They would say gwe are going to Brycefs to cut wood g gradually the name became Bryce Canyon. \n\n Bryce is known for its diverse wildlife.  Although the most common animals seen are the mule deer and the wild turkey, Bryce is also home to Prairie Dogs, Cougars, badgers, weasels, ring tails and even a bear or two. \n\n The Flora is equally diverse in spite of the high elevation.  Plants range from the evening primrose and Manzanita, to ponderosa and even Bristlecone Pines. \n\n Bryce is also famous for its night sky.  Because Bryce is at a high elevation (2500m) and it is far from any major cities, the night sky is extremely clear and dark.  This provides for some of the best star gazing opportunities in the United States.  The gDark Rangersh frequently have night sky programs and star parties ant the visitors center.";
		public final String GEOLOGY = "No info yet";
		public final String SUNRISE = "No info yet";
		public final String SUNSET = "No info yet";
		public final String INSPIRATION = "No info yet";
		public final String BRYCEP = "No info yet";		

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.LEFT);
			LayoutParams lpLeft = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT,1.0f);
			LayoutParams lpRight = lpLeft;
			lpLeft.setMargins(10,0,10,0);
			textView.setLayoutParams(lpLeft);
			final int tabNum = getArguments().getInt(ARG_SECTION_NUMBER);
			Button wikiButton = new Button(getActivity());
			wikiButton.setText("More info from Wikipedia");
			wikiButton.setLayoutParams(new LinearLayout.LayoutParams(340,LinearLayout.LayoutParams.FILL_PARENT,1.0f));
			wikiButton.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 CharSequence temp = mSectionsPagerAdapter.getPageTitle(tabNum-1);
	            	 String wiki = "https://en.m.wikipedia.org/w/index.php?title=";
	            	 wiki += temp;
	            	 Intent i = new Intent(Intent.ACTION_VIEW);
	            	 i.setData(Uri.parse(wiki));
	            	 startActivity(i);
	             }
	         });
			
			if(tabNum == 1){ textView.setText(KANAB); }
			else if(tabNum == 2){ textView.setText(KANABCANYON); }
			else if(tabNum == 3){ textView.setText(BESTFRIENDS); }
			else if(tabNum == 4){ textView.setText(MTCARMEL); }
			else if(tabNum == 5){ textView.setText(MAYNARD); }
			else if(tabNum == 6){ textView.setText(ORDERVILLE); }
			else if(tabNum == 7){ textView.setText(GLENDALE); }
			else if(tabNum == 8){ textView.setText(REDCANYON); }
			else if(tabNum == 9){ textView.setText(RUBYS); }
			else if(tabNum == 10){ textView.setText(BCNP); }
			else if(tabNum == 11){ textView.setText(GEOLOGY); }
			else if(tabNum == 12){ textView.setText(SUNRISE); }
			else if(tabNum == 13){ textView.setText(SUNSET); }
			else if(tabNum == 14){ textView.setText(INSPIRATION); }
			else if(tabNum == 15){ textView.setText(BRYCEP); }
			else textView.setText("An error occurred!");
			
			LinearLayout bigView = new LinearLayout(getActivity());
			bigView.setOrientation(LinearLayout.VERTICAL);
			bigView.setLayoutParams(lpRight);
			bigView.addView(textView);
			bigView.addView(wikiButton);
			bigView.setGravity(Gravity.CENTER);
			ScrollView scroll = new ScrollView(getActivity());
			scroll.addView(bigView);
			return scroll;
		}
	}

}
