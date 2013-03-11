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

public class Sedona extends FragmentActivity implements ActionBar.TabListener {

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
		setContentView(R.layout.sedona_display);

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
		if(tabname.equals("Williams"))
			actionBar.setSelectedNavigationItem(0);
		else if(tabname.equals("Flagstaff"))
			actionBar.setSelectedNavigationItem(1);
		else if(tabname.equals("Oak Creek Canyon"))
			actionBar.setSelectedNavigationItem(2);
		else if(tabname.equals("Slide Rock State Park"))
			actionBar.setSelectedNavigationItem(3);
		else if(tabname.equals("Grasshopper Point"))
			actionBar.setSelectedNavigationItem(4);
		else if(tabname.equals("Sedona"))
			actionBar.setSelectedNavigationItem(5);
		else if(tabname.equals("Uptown"))
			actionBar.setSelectedNavigationItem(6);
		else if(tabname.equals("Tlaquepaque"))
			actionBar.setSelectedNavigationItem(7);
		else if(tabname.equals("Chapel of the Holy Cross"))
			actionBar.setSelectedNavigationItem(8);
		else if(tabname.equals("Crescent Moon Ranch State Park"))
			actionBar.setSelectedNavigationItem(9);
		else if(tabname.equals("Bell Rock"))
			actionBar.setSelectedNavigationItem(10);
		else if(tabname.equals("Coffee Pot Rock"))
			actionBar.setSelectedNavigationItem(11);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sedona_display, menu);
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
			return 12;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.williams);
			case 1:
				return getString(R.string.flagstaff);
			case 2:
				return getString(R.string.oak_creek_canyon);
			case 3:
				return getString(R.string.slide_rock_state_park);
			case 4:
				return getString(R.string.grasshopper_point);
			case 5:
				return getString(R.string.sedona);
			case 6:
				return getString(R.string.uptown);
			case 7:
				return getString(R.string.tlaquepaque);
			case 8:
				return getString(R.string.chapel_of_the_holy_cross);
			case 9:
				return getString(R.string.crescent_moon_ranch_state_park);
			case 10:
				return getString(R.string.bell_rock);
			case 11:
				return getString(R.string.coffee_pot_rock);
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
		
		public final String WILLIAMS = "Williams AZ is named after Bill Williams, mountain man extrordinaire , gthe greatest trapper of them all.h  He was definitely one of the most colorful of them all.  Williams was a tall skinny red head with a high squeaky voice.  He was battle scarred and weather beaten.   He rode with short stirrups so his knees rode up near his chest.  He seemed crazy and eccentric, which may have kept him safe on his long ventures into gIndian Country so hostile no other would dare to go there.h  His drunken spree at Taos set the standard of drunken debauchery that no other could match.  When he fired gkicking Betsyh he used a technique called the gdouble wobbleh because he could not hold the gun steady for long.  However his wobbly aim was accurate.  He bet at shooting matches and never lost.   \n\n Williams wandered from Oregon to Mexico and from the Mississippi to the Pacific.  They said he had more lives that a cat.  In 1849 his luck finally ran out and he was killed by a band of hostile Utes in Southern Colorado. \n\n The town of Williams holds a Rendevous in his honor every October.  As a tribute to Billfs legendary stamina one of the events is a 100 mile footrace. \n\n Williams has been know as the gGateway to the Grand Canyonh since the Sante Fe Railroad completed the spur to the canyon in 1901.  The train (now owned by  Xanterra, the park concessioner) now runs once to the Grand Canyon once a day every day except on Christmas. \n\n Williams was also one of the main towns on old Route 66, which followed the E-W running railroad route.  In the 1880s and 90fs Williams was a wild RR town.  The E-W HWY that follows the tracks passes by buildings that were brothels and saloons at the turn of the last century.  Some of them still have bullet holes in the walls and bars.";
		public final String FLAGSTAFF = "Flagstaff was named after a celebration of the Centennial of the US in 1876.   A local rancher reportedly flew a flag on top of a tall Ponderosa pine.  In the 1880s timber and Cattle were the mainstays of the Arizona economy and a railroad was need to ship the products.  Large government land grants enabled the railroads to lay tracks.  When the RR was completed the rail companies recouped their money by dividing grant lands and selling off lots to settlers. \n\n John W Young, son of Brigham Young, founded the Mormon Cattle Company, and stocked the range around Flagstaff on large scale for the first time.  The operation later became known as the Arizona cattle Company.  Mormon Lake south of Flagstaff was named after Youngfs group.  Young was followed by cattle barons, timber barons, and by the Babbits, who were in many enterprises including dry goods.  The Babitt name is still very prominent in AZ. ";
		public final String OAKCREEK = "Oak Creek Canyon is accessed by HWY 89A south of Flagstaff or north of Sedona.   The Canyon is about 12 mi long and ranges from 240 to 600 m deep. The west rim of the canyon is 200m higher than the east. Oak Creek, a tributary of the Verde River, carved the modern Oak Creek Canyon.  Oak Creek is one of the few perrnnial streams in the region and has long been used as a refuge from the hot dry climate. \n\n The first to seek refuge here came about 10,000 years ago.  These were the Nomadic-Paleo Indians.  Around Ad 700 the Hohokam (the vanished ones) were drawn here by the water and began to farm in the canyon. The Hohokam were followed by the Sinagua.  These groups mysteriously disappeared around 1300 AD.  The Apache and Yavapai were also drawn here by water and refuge from heat as were the settlers who came at the turn of the 20th Century. \n\n Zane Grey wrote his Novel the Call of the Canyon in Oak Creek.  In 1923 he convinced producer Jessy Lasky to film a movie based on the novel at the same site.  It was the first of Many Movies and Commercials that were filmed in Oak Creek Canyon.";
		public final String SLIDEROCK = "In the early 1900fs the Pendely Family operated a large farm and orchard in the area that is now SLSP. In 1982 they decided to sell the property, Governor Babbit suggested that the State buy the property for a park.  He worked with the Nature Conservancy, and they created The Arizona Parklands Foundation.  The final purchase price was around million. \n\n The famous feature of Course is the Natural sandstone water slid that drops into a pool of Oak Creek.  In the summer hundreds gather on the rocks to swim, sunbathe and beat the heat.  Slide rock is visible from the HWY if you look closely.";
		public final String GRASSHOPPER = "Grasshopper is one of the most famous swimming holes in AZ.  The swimming hole is cool and shaded and there is a steep slope where swimmers can slide/jump into the water.  The area is beautiful and has excellent day use trails.  It si popular with photographers and is especially beautiful with fall foliage from mid Oct to early Nov. ";
		public final String SEDONA = "The First Anglo settler moved in to Oak Creek canyon in 1876, Just after the Yavapai and Apache Tribes had been forcibly removed.  The early settlers were farmers and ranchers who homesteaded along Oak Creek.  In 1902 when the post office was established there were only 55 residents. \n\n Sedona is named after Sedona Schnebly the wife of an early settler Carl Schnebly, who was also the first postmaster in the area.  The name came about when Carl was tired of having to travel long distance to get his mail.  He decided to apply to have a post office.  The name he first submitted was Schnebly Station.  It was promptly rejected as was the second proposal.  The names were too long to fit on the cancellation stamp used for letters.  A neighbor said why not your wifefs name gSedona.h  The post master general accepted the name and it has been the townfs name ever since.  The Schneblys left after their daughter was killed in a riding accident. \n\n Sedonafs history is short but interesting.  In the 50fs there were still less thatn 200 people in Sedona.  In the 60fs it became an art colony that also accommodated the occasional hippie.  In the 1970fs it exploded with retirees as an area warm but not as hot as Phoenix.  In the early 80fs Page Bryant, a famous psychic, claimed to have divined four metaphysical Vortices in the red rocks around Sedona.  Spiritualists and those seeking  the power of the vortex came to Sedona in droves.  In 1987 the Harmonic Convergence drew 5000 participants willing to pay $75 dollars to sit on Bell Rock the moment it was to depart for the Andromeda galaxy.  Since that time Sedona has been a New Age Mecca. \n\n Art still remains as Sedonafs prime industry (besides tourism).  There are well over 400 professional artists that live in Sedona, and many more if you include the surrounding area and the town of Jerome. \n\n Recently Sedona has become well know to people in Japan after the Celebrity Amuro Namie had a not so secret tryst with her lover, Jun Tamura (London Boots  no Jun) at LfAberge. \n\n Sedona has also been featured in Many movies, especially westerns.  Stars like john Wayne, James Stewart, Robert Mitchum, Elvis Presley and Joan Crawford frequented the town from the 1930 to the 70fs.";
		public final String UPTOWN = "Uptown has grown into the main shopping and dining district in Sedona.  There are many boutiques and gift shops as well as places where you can get your fortune told, photos of your auora, buy power stones, and get a chakra reading.  There are also a few galleries.  There are signs, which explain about movie filmed in the area, and even a few concrete hand prints of movie stars. ";
		public final String TLAQUEPAQUE= "One of the best places for galleries and shopping in Sedona is Tlaquepaque.  It was built to resemble an 18th century Villa in Spain.  The builders actually built the structures around the groves of Sycamore trees so it a shaded lush area.  There are numerous courtyards and fountains and it even contains a small chapel.";
		public final String CHAPEL = "Built by Marguerite Brunswick Staude, a student of Frank Lloyd Wright, The Chapel of The Holy Cross is one of the most famous modern style churches.  Staude buit the chapel nestled into the red rocks at a location with outstanding views of Cathedral Rocks, Bell Rock, and Courthouse Butte, as well as a commanding view of the east rim of Sedona. \n\n The Chapel was completed in 1956 and is often included in architecture textbooks. It is open from 9-5 and admission is free.  There ";
		public final String CRESCENT = "Most Photographed spots in Arizona is the view of Cathedral Rocks (a vortex point) from Crescent Moon Ranch and Red Rock Crossing.  People also come her to swim fish and picnic in the State Park.  The location has also been used in the filming of numerous movies.  \n\n Although the CMR is a state park, it is managed by a private entity that does not allow large buses to enter.  The entrance fee is $9 for smaller vehicles.";
		public final String BELLROCK = "No info yet";
		public final String COFFEEPOT = "No info yet";		

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
			
			if(tabNum == 1){ textView.setText(WILLIAMS); }
			else if(tabNum == 2){ textView.setText(FLAGSTAFF); }
			else if(tabNum == 3){ textView.setText(OAKCREEK); }
			else if(tabNum == 4){ textView.setText(SLIDEROCK); }
			else if(tabNum == 5){ textView.setText(GRASSHOPPER); }
			else if(tabNum == 6){ textView.setText(SEDONA); }
			else if(tabNum == 7){ textView.setText(UPTOWN); }
			else if(tabNum == 8){ textView.setText(TLAQUEPAQUE); }
			else if(tabNum == 9){ textView.setText(CHAPEL); }
			else if(tabNum == 10){ textView.setText(CRESCENT); }
			else if(tabNum == 11){ textView.setText(BELLROCK); }
			else if(tabNum == 12){ textView.setText(COFFEEPOT); }
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
