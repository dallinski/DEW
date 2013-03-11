package com.dallinc.dewguides;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.LayoutParams;

public class GrandCircle extends FragmentActivity implements
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
		setContentView(R.layout.grand_display);

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
		if(tabname.equals("Nevada"))
			actionBar.setSelectedNavigationItem(0);
		else if(tabname.equals("Las Vegas"))
			actionBar.setSelectedNavigationItem(1);
		else if(tabname.equals("The Strip"))
			actionBar.setSelectedNavigationItem(2);
		else if(tabname.equals("Hotels"))
			actionBar.setSelectedNavigationItem(3);
		else if(tabname.equals("Movies"))
			actionBar.setSelectedNavigationItem(4);
		else if(tabname.equals("Nellis Air Force Base"))
			actionBar.setSelectedNavigationItem(5);
		else if(tabname.equals("Las Vegas Motor Speedway"))
			actionBar.setSelectedNavigationItem(6);
		else if(tabname.equals("Great Basin Highway"))
			actionBar.setSelectedNavigationItem(7);
		else if(tabname.equals("Mojave Desert"))
			actionBar.setSelectedNavigationItem(8);
		else if(tabname.equals("Mesquite"))
			actionBar.setSelectedNavigationItem(9);
		else if(tabname.equals("Virgin River Gorge"))
			actionBar.setSelectedNavigationItem(10);
		else if(tabname.equals("St. George"))
			actionBar.setSelectedNavigationItem(11);
		else if(tabname.equals("Hurricane"))
			actionBar.setSelectedNavigationItem(12);
		else if(tabname.equals("The Colorado Plateau"))
			actionBar.setSelectedNavigationItem(13);
		else if(tabname.equals("Colorado City"))
			actionBar.setSelectedNavigationItem(14);
		else if(tabname.equals("Arizona Strip"))
			actionBar.setSelectedNavigationItem(15);
		else if(tabname.equals("Fredonia"))
			actionBar.setSelectedNavigationItem(16);
		else if(tabname.equals("Kanab"))
			actionBar.setSelectedNavigationItem(17);
		else if(tabname.equals("Grand Staircase Escalante N.M."))
			actionBar.setSelectedNavigationItem(18);
		else if(tabname.equals("Lake Powell"))
			actionBar.setSelectedNavigationItem(19);
		else if(tabname.equals("Glen Canyon Dam"))
			actionBar.setSelectedNavigationItem(20);
		else if(tabname.equals("Power Plant"))
			actionBar.setSelectedNavigationItem(21);
		else if(tabname.equals("Glen Canyon Bridge"))
			actionBar.setSelectedNavigationItem(22);
		else if(tabname.equals("Page"))
			actionBar.setSelectedNavigationItem(23);
		else if(tabname.equals("Navajo Generating Station"))
			actionBar.setSelectedNavigationItem(24);
		else if(tabname.equals("Antelope Canyon"))
			actionBar.setSelectedNavigationItem(25);
		else if(tabname.equals("Horseshoe Bend"))
			actionBar.setSelectedNavigationItem(26);
		else if(tabname.equals("The Colorado River"))
			actionBar.setSelectedNavigationItem(27);
		else if(tabname.equals("Navajo Nation"))
			actionBar.setSelectedNavigationItem(28);
		else if(tabname.equals("Black Mesa"))
			actionBar.setSelectedNavigationItem(29);
		else if(tabname.equals("Kayenta"))
			actionBar.setSelectedNavigationItem(30);
		else if(tabname.equals("Monument Valley"))
			actionBar.setSelectedNavigationItem(31);
		else if(tabname.equals("Gouldings"))
			actionBar.setSelectedNavigationItem(32);
		else if(tabname.equals("Monument Valley Tribal Park"))
			actionBar.setSelectedNavigationItem(33);
		else if(tabname.equals("Tuba City"))
			actionBar.setSelectedNavigationItem(34);
		else if(tabname.equals("Painted Desert"))
			actionBar.setSelectedNavigationItem(35);
		else if(tabname.equals("Cameron"))
			actionBar.setSelectedNavigationItem(36);
		else if(tabname.equals("Grand Canyon"))
			actionBar.setSelectedNavigationItem(37);
		else if(tabname.equals("View Points"))
			actionBar.setSelectedNavigationItem(38);
		else if(tabname.equals("Tusayan"))
			actionBar.setSelectedNavigationItem(39);
		else if(tabname.equals("Valle"))
			actionBar.setSelectedNavigationItem(40);
		else if(tabname.equals("Williams"))
			actionBar.setSelectedNavigationItem(41);
		else if(tabname.equals("Seligman"))
			actionBar.setSelectedNavigationItem(42);
		else if(tabname.equals("Route 66"))
			actionBar.setSelectedNavigationItem(43);
		else if(tabname.equals("Kingman"))
			actionBar.setSelectedNavigationItem(44);
		else if(tabname.equals("Chloride"))
			actionBar.setSelectedNavigationItem(45);
		else if(tabname.equals("Hoover Dam"))
			actionBar.setSelectedNavigationItem(46);
		else if(tabname.equals("Lake Mead"))
			actionBar.setSelectedNavigationItem(47);
		else if(tabname.equals("Mike O'Callaghan-Pat Tillman Bridge"))
			actionBar.setSelectedNavigationItem(48);
		else if(tabname.equals("Boulder City"))
			actionBar.setSelectedNavigationItem(49);
		else if(tabname.equals("Railroad Pass"))
			actionBar.setSelectedNavigationItem(50);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grand_display, menu);
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
			return 51;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.nevada);
			case 1:
				return getString(R.string.las_vegas);
			case 2:
				return getString(R.string.the_strip);
			case 3:
				return getString(R.string.hotels);
			case 4:
				return getString(R.string.movies);
			case 5:
				return getString(R.string.nellis_air_force_base);
			case 6:
				return getString(R.string.las_vegas_motor_speedway);
			case 7:
				return getString(R.string.great_basin_highway);
			case 8:
				return getString(R.string.mojave_desert);
			case 9:
				return getString(R.string.mesquite);
			case 10:
				return getString(R.string.virgin_river_gorge);
			case 11:
				return getString(R.string.st_george);
			case 12:
				return getString(R.string.hurricane);
			case 13:
				return getString(R.string.the_colorado_plateau);
			case 14:
				return getString(R.string.colorado_city);
			case 15:
				return getString(R.string.arizona_strip);
			case 16:
				return getString(R.string.fredonia);
			case 17:
				return getString(R.string.kanab);
			case 18:
				return getString(R.string.grand_staircase_escalante_n_m_);
			case 19:
				return getString(R.string.lake_powell);
			case 20:
				return getString(R.string.glen_canyon_dam);
			case 21:
				return getString(R.string.power_plant);
			case 22:
				return getString(R.string.glen_canyon_bridge);
			case 23:
				return getString(R.string.page);
			case 24:
				return getString(R.string.navajo_generating_station);
			case 25:
				return getString(R.string.antelope_canyon);
			case 26:
				return getString(R.string.horseshoe_bend);
			case 27:
				return getString(R.string.the_colorado_river);
			case 28:
				return getString(R.string.navajo_nation);
			case 29:
				return getString(R.string.black_mesa);
			case 30:
				return getString(R.string.kayenta);
			case 31:
				return getString(R.string.monument_valley);
			case 32:
				return getString(R.string.gouldings);
			case 33:
				return getString(R.string.monument_valley_tribal_park);
			case 34:
				return getString(R.string.tuba_city);
			case 35:
				return getString(R.string.painted_desert);
			case 36:
				return getString(R.string.cameron);
			case 37:
				return getString(R.string.grand_canyon);
			case 38:
				return getString(R.string.view_points);
			case 39:
				return getString(R.string.tusayan);
			case 40:
				return getString(R.string.valle);
			case 41:
				return getString(R.string.williams);
			case 42:
				return getString(R.string.seligman);
			case 43:
				return getString(R.string.route_66);
			case 44:
				return getString(R.string.kingman);
			case 45:
				return getString(R.string.chloride);
			case 46:
				return getString(R.string.hoover_dam);
			case 47:
				return getString(R.string.lake_mead);
			case 48:
				return getString(R.string.mike_o_callaghan_pat_tillman_bridge);
			case 49:
				return getString(R.string.boulder_city);
			case 50:
				return getString(R.string.railroad_pass);
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
		
		public final String NEVADA = "The name Nevada means \"snow capped\" in Spanish. This may sound strange to visitors, who mostly think of Nevada as desert, however Nevada is also the most mountainous state, with 314 ranges. The state's elevation ranges from a low of 470 ft, near Laughlin, to 13,145 ft at Boundary Peak. \n\nNevada became a state in 1864 during the Civil War. The Union did not want riches from Nevada's mines going to aid the Confederacy. And so the \"Silver State\" was battle born.";	
		public final String LASVEGAS = "Las Vegas, Spanish for the Meadows was a green area around an artesian spring in the Mojave Desert.  Travelers, beginning with the nomadic Archaic People, for at least 10,000 years, have used this natural spring.  Las Vegas became a stop over point for the Spanish trail in the 1830fs.   In 1855 it became a Mormon settlement and a mission and fort were established.  The Mormons abandoned it a few years later due to the harsh conditions and extreme temperatures. \n\n Following the departure of the Mormons, the area was used for ranching.  The Gass family owned rancho Las Vegas until 1883, when they sold to Helen Stewart.  Helen Stewart ran the ranch by herself for 20 years after her husband was killed in a feud with a neighboring ranch.     \n\n The San Pedro, Los Angeles and Salt lake Railroad purchased the ranch from Stewart in 1903 for $50,000.  In 1905 a two-day auction of lots was held and 1200 town lots were sold for $265,000 and the town was established.  Soon, frame structures were built and the train began making stops here.  Hotels, saloons brothels, and gambling dens also sprang up.  Gambling was eventually outlawed in 1910. \n\n From 1910 until 1930 the town went into depression, with nothing to break up the monotony but the occasional train stop.  In 1931 the building of Hoover Dam in Black Canyon, 31 miles from Vegas, brought laborers, truckers, government officials and engineers by the hundreds.  In one year the population doubled from 5000 to over 10,000.  That same year gambling became legal again. \n\n In the 50fs there was also above ground nuclear testing in the desert north of Las Vegas.  Between 1951 and 1955 The US Government detonated 45 atomic devices at the Nevada Proving Grounds, now known as the Nevada Test Site.  At times, mushroom clouds were visible from downtown.  In the 60fs 70fs and 80fs, hundreds of nuclear tests were conducted underground.  Currently, nuclear tests are conducted at the sub-critical level.";
		public final String THESTRIP = "The first hotel to be built out of town on old Hwy 91 was the Pair O Dice built in 1931.  It was soon followed by the El Rancho, which is often referred to as the first built on the Strip.  In 1946 Benjamin gBugsyh Siegel went out into the desert far beyond the El Rancho and began to build an immense luxury hotel and Casino.\n\n It was a tremendous undertaking at a time when it was hard to get materials at the end of the war.  People said he was crazy.  Bugsyfs Pink Flamingo was also the first financed by the Mafia from back east. But it was the first in a long line of properties controlled by organized crime figures.  During the 50fs and 60fs, roughly the mafia controlled Ninety percent of Las Vegas casinos.  Las Vegas was gopen territoryh so any crime family was allowed to invest freely.  Money from the gMobh in Galveston, Cleveland, Chicago, Atlantic City, and St. Louis poured into Las Vegas. \n\n In the late 1960fs Kirk Kerkorian and Howard Hughes began buying properties.  Gradually the influence of the mafia waned, as regular business competition arrived. \n\n In 1989, Steve Wynnfs 3000 room Mirage opened, and with it a new era of Mega Resorts.  The mirage cost 610 million and required revenue of a million a day just to keep the lights on.  It was a huge financial success.  The 3000 rooms supplied thousands of patrons for the casino.  The building spree that followed left Las Vegas with 9 of the worlds 10 largest hotels.  In 1998 the Bellagio was built on the property that formerly had the Dunes on it, for a record breaking 2.3 billion. ";
		public final String HOTELS = "El Rancho \n In 1941 California entrepreneur, Thomas Hull built the first hotel on the Strip. \n\n Flamingo \n In 1946 gangster gBugsyh Siegel hired Del Webb to build the Flamingo, complete with escape tunnels leading from his apartments, in case of a mob hit. \n\n Desert Inn \n The DI built in 1950 was famous for Frank Sinatrafs part ownership as well as his $100,000 a week salary for performing.  \n\n Stardust \n 1958-2008 The Stardustfs history was the basis for the Film Casino, and it was the location for the movie Showgirls. \n\n Tropicana \n Built in 1958 for $10 million.  The 2011 renovation cost 50 million. \n\n Aladdin \n Built in 1966 it was the first strip hotel built since the Tropicana, 8 yrs earlier.  Elvis was married here in 1967. \n\n Caesars \n Caesars set a new standard for luxury when it was built in 1966.  It was the first gtheme g property.  Famous for its sporting events esp. Boxing.  Currently it is famous shopping.  The $250 million Forum Shops are also home of Vegasf first  (of many) celebrity chef owned restaurants, Wolfgang Puckfs SPAGO.   \n\n Las Vegas Hilton \n When International hotel opened in 1969 it replaced the Stardust as the worlds largest hotel.  Elvis made his Vegas debut, and began his comeback here the month after opening.   He played a total of 837 sold out shows until his death in 1977.  Today the Hilton is known for its 70 million Star Trek attraction.  3174 rooms. \n\n Circus Circus \n Originally a casino without a hotel, opened in 1968 Jay Sarnofs casino had elephants and trapeze acts but actually charged admission for gamblers.  In 1972 the hotel tower was built. \n\n Ballyfs \n The MGM Grand (now Ballyfs) Opened in 1973 with the worlds largest casino.  It, like the Hilton, was a Kirk Kerkorian property.  In 1980, it was the site of the second worst hotel fire in US history, in which 84 perished.  In 1985 it was purchased by Ballyfs who later sold it to Hilton, which divested its casino holdings to Park Place Entertainment.  Park Place currently owns Ballyfs, Paris, Flamingo, NY, NY, MGM, TI and Mirage. \n\n Mirage \n In 1989 the Mirage was the first resort built from scratch since 1973.  It was a 3049room, 650million dollar, mega-resort complete with a rainforest, pygmy sharks, Bengali Tigers and a 30 million dollar erupting volcano.  It completely changed the Vegas landscape and the resulting construction boom made the strip unrecognizable from the Vegas of Bugsyfs days. \n\n Excalibur \n When Completed in 1992 it was the largest hotel and largest casino in the world with 4039 rooms.  It has a medieval theme.  It is famous for its dinner and show with knights jousting in the Tournament of kings.  Excalibur also houses the cityfs largest buffet with 1049 seating capacity. \n\n Luxor \n When Luxor completed its 2000 room towers in 1993 it surpassed Excalibur as the largest hotel with 4500 rooms.  The spotlight that shines from the pyramidfs apex packs a 40 billion candle power punch.  It is rumored to be visible to pilots leaving LA. \n\n MGM \n Mere months after the Luxor was completed, it was surpassed by the new, largest hotel, the MGM with its 5005, (currently 5805) room count.  The MGM is currently the most popular venue for concerts and championship boxing bouts in the city. \n\n Monte Carlo \n Monte Carlo was the first property to be modeled after European Casinos.  Its Name and Decor are based on the Place du Casino in Monaco.  At completion it was the 7th largest Hotel with 3002 rooms. \n\n NY, NY \n Possibly the most authentic of the gthemeh properties, NY, NY houses famous restaurants and shops from the Big Apple, including Gallagherfs Steak House, and Nathans Famous. \n\n Bellagio \n When built in 1998 Bellagio was by far the most expensive property on the strip.  The Tuscan decor is extravagant even by Las Vegas standards.  The glass flowers that adorn the ceiling of the front lobby are actually individual glass sculptures created by Chihully. \n\n TI \n In 2003 TI got a huge makeover to change it from the family friendly, pirate themed resort, to an adult friendly place that makes money.  Gone are the huge arcade, skull and cross bones, and the pirate battle.  In their place, more gaming, more hip decor and a more adult friendly show gSirens of TI.h \n\n Paris \n Paris opened in September 1999, complete with a 1/2 size Eiffel Tower and Arc de Triomphe.  It has one of, if not the, best buffets in Las Vegas.  It is divided by region, Alsace, Brittany, Burgundy etc. \n\n Mandalay Bay \n Completed in 1999 with a tropical theme, Mandalay Bay has a 12000 seat sports and entertainment complex.  It also houses the completely separate Four Seasons hotel.  The pool is the best in Vegas with a river a beach and a wave pool with 3 ft swells.  3300 rooms. \n\n Venetian \n When the Venetian was completed (including Palazzo) it became the largest property in Vegas, with       Rooms.  The Venice theme with canals and gondolas, along with brand shops, and fabulous restaurants has endeared the Venetian to an exclusive clientele. 	 \n\n Planet Hollywood \n PH opened as the Aladdin in 2000.  It was an unsuccessful venture largely because of the small size and poor layout of the casino.  It was also late to the gtheme hotel partyh and seemed a bit too cheesy for the gaming business, even in Vegas.  It has been revamped into PH, which is very hip.  The Miracle Mile shops are also a great improvement.  The Casino still needs attention. \n\n City Center \n The Newest and biggest project yet is the City Center.  It includes 4 hotels Vdara, Cosmopolitan, Mandarin and Aria.  It also has an exclusive shopping area, Crystals, with brands like Louis Vitton and Prada.";
		public final String MOVIES = "There have been many famous movies filmed in Las Vegas here are some:  Oceanfs11 1960, Viva Las Vegas 1963, Diamonds are Forever 1971, Rain Man 1989, Bugsy 1991, Casino 1995, Leaving Las Vegas 1995, Swingers 1996, Oceanfs 11 2001, and g21h 2008, just to name a few. \n\n Gangster movies like the Godfather II and Casino are based on true events and it is obvious who the real characters are.  The Godfather II is the story of the Gambino Family with Hyman Roth (Meyer Lansky), Johnny Fontaine (Frank Sinatra), and Moe Green (Benny Siegel).  In Martin Scorsesefs Casino, Joe Pescifs character was really Tony gthe anth Spilotro, Robert De Nirofs was Frank gleftyh Rosenthal.  Casinofs story is mostly an accurate depiction of the menfs lives, including the part where De Nirofs car explodes and where Pesci is buried alive in a cornfield.";
		public final String NELLIS = "Nellis AFB gHome of the Fighter Piloth was established in 1941 as an Army Air Corps gunnery school for B-17s.  It has grown into one of the largest Air Force bases in the country. Nellisf focus is advanced combat aviation training.  Training is integrated with fighter, bomber and air-to-air refueling aircraft. Nellis is the also the home of the AF precision flying team, the gThunderbirds.h Tours are offered every Tue. and Thu. at 2pm.  Often, as you drive I-15 north you will see military aircraft north to the desert for training missions.";
		public final String SPEEDWAY = "This is the last thing you see as you leave Las Vegas and enter the Mojave Desert.  Begun in the 1970fs as the Las Vegas Speedrome drag strip LVMS reopened in 1996 after a $72 million renovation.  The Speedway has a dirt track oval, a drag strip and its famous 3/8mile NASCAR track called gthe Bull Ringh.  Currently there are more NASCAR fans than there are for any other sport.  In October 2011 the track was used for a Formula One (Indy car) race in which Dan Wheldon, a famous and popular driver, was killed in an accident.  Most blame the accident on the steep banks and short track combined with too many cars (the race had 27 instead of the usual 25).";
		public final String GREATBASIN = "This Hwy (US 93) runs from Kingman AZ to the Canadian border near Eureka Montana.  The section in Nevada is one of the most desolate routes in the country.  It is a close runner up For gthe Loneliest Hwy in Americah a title currently held by US 50 also in NV.   This route also intersects with 375 gthe ET Hwyh noted for its UFO sightings and Area 51 and S-4 near Rachael NV.   \n\n They call it the Ranch, Dreamland or Watertown.  It is part of the vast military reserve in central Nevada, where highly advanced and top secret aircraft have been tested since the 1950fs.  The CIA U-2 and later the SR-71 Blackbird were first tested at the long runway at Groom Lake before being based at Edwards.   Since 1989 it has rumored the area, and particularly the S-4 are the site where alien spacecraft is being reverse engineered.   Movies like the X-files and Independence Day have added to the hype of UFOfs.  That said there have been many sightings of UFOfs and other events that are difficult to explain.";
		public final String MOJAVE = "The Mojave Desert is one of the largest deserts in North America.  It gets less than 13 in of water annually and the portion near Las Vegas gets much less.  The highest point in the Mojave is Mt. Charleston at 3633m and the low point is Bad Water Basin at -86m.  The Mojave runs from just east of San Diego to Zion National Park.  There is a surprisingly wide variety of plant and animals that include the Desert tortoise, Cougars, bobcats, foxes and coyotes, as well as the more expected snakes and lizards.  The Joshua tree, and the Creosote bush typify the Mojave Desert.  It can thus easily be differentiated from the Sonora and Great Basin deserts.";
		public final String MESQUITE = "Mesquite lies on the border of Arizona and Utah.   Just like other towns on the Nevada border there are casinos for those who just canft wait to get to Vegas or donft want to drive the extra hour. \n\n Mesquite NV was first settled by Mormon pioneers, who were sent to farm along the Virgin River by Brigham young.   They planted alfalfa, corn, grapes cotton and vegetables.  There is still a large population of Mormons and in fact the only large buildings that are not casinos are churches.  Although Mormons do not gamble themselves, they have adopted a live and let live philosophy.  Currently, mesquite has a large population of retirees and gsnowbirds.h  In 2005 it was the fastest growing city in the US.";
		public final String VIRGIN = "Arizonafs portion of I-15, which passes through the Virgin River Gorge, is probably the most scenic portion of the interstate, which runs from San Diego to Canada.\n\n It was also the most expensive section to build at a cost of over 10 million dollars per mile (over 50m in todayfs dollars).  It was dubbed gthe Million Dollar highwayh.  One interesting fact is that the road does not access any communities in AZ.  It is a vital corridor between UT and NV.  If you are lucky you may see wild Desert Big Horn Sheep in the canyon.";
		public final String STGEORGE = "The city of St. George is the largest in Southern Utah with a city population of 73,000.   The metro area has 123,000.   St. George was settled by Mormon Pioneers as part of the eCotton Mission.h   In 1861 at the outbreak of the civil war Brigham young  gcalledh 300 families to move to southern Utah to grow cotton, tobacco and other crops that require a warm climate.  This became known as the cotton mission.  And because of the warm climate and crops typical to the American South they nicknamed the area gDixie,h a name still widely used. \n\n The pioneers planted mulberry trees to feed silkworms and produced silk as well as cotton.  They raised fruit and nuts also.  The city of ST. George was incorporated in 1862 and named after George A. Smith who was a prominent leader of the Mormon Church.   \n\n When the Civil war ended in 1865, and later when the Transcontinental Railroad was completed in 1869, silk, cotton and other materials became readily available.  The cotton mission was no longer necessary or competitive.  Many of the families returned to Salt Lake City, still others stayed on and many of their descendants are still in the area.  This is part of the reason St. George still has a population of Mormons that approaches 75%.  \n\n On May 19,1953 the 32 Kiloton, gDirty Harryh bomb was detonated at the Nevada Test Site.  Wind carried fallout 130 miles east to Utahfs Dixie.  The people in St. George reported a metallic taste in the air.  Howard Hughes was filming the movie gThe Conquerorh with john Wayne at the time.  Later many of the actors (including Wayne) contracted cancer.  Residents of the area experienced high rates of Leukemia, Brain tumors, bone cancer etc.  The government finally settled a suit with the gdown windersh in the 80fs.";
		public final String HURRICANE = "In the 1860fs when Erastus Snow and David Cannon were exploring the area, a strong gust of wind blew the roof off of their buggy.  They called the place Hurricane Hill.  The town, wash and canal all took this name.  The name is currently pronounced Hur-i-cun.   \n\n The town was finally established in 1904, when the canal and irrigation system was finished.  The area is an agricultural community famous for Pecans, fruit and sod.";
		public final String COLPLATEAU = "Just east of Hurricane we ascend a hill and enter what is known as the Colorado Plateau.  The geology of the plateau provides the spectacular scenery for much of the southwest, from Zion and Bryce on the west all the way past Monument Valley, and Arches to the Colorado monument and Mesa Verde on the east.    All of the parks we visit on this trip are within the plateau. \n\n The geology of the plateau dates back to Precambrian times.  The basement rocks of the plateau (only visible in the deepest canyons)  are the remnant of an ancient mountain range.  These metamorphic rocks range from 600 Million to almost 2 billion years old.   \n\n The plateau it self is only 20-30 million years old.  The rock layers are much older.  Over hundreds of millions of years the environment was in continual change.  \n\n There were inland seas, vast windblown deserts, swamps, qceans etc.  Sediment was deposited over millions of years.  The sedimentary layers of shale, limestone and sandstone were formed like a giant layer cake. \n\n 20 or 30 million years ago the pressure from the North American Plate colliding with the Pacific Plate (the same pressure that created the Rockies) caused the plateau to rise.  This uplift was unique because the Colorado plateau remained relatively stabile, (there was very little faulting and folding) compared to the mountain building to the north, and the stretching which created the basin and range province to the west.  The plateau retained its structural integrity as a single tectonic block. \n\n The block rose as much as 3000 meters.  As the land rose the streams and rivers cut deeper and deeper into the layers of the plateau, exposing the various layers that make up the plateaufs geology.  ";
		public final String COLCITY = "23 mi after Hurricane, Hwy 50 crosses into Arizona and becomes Hwy 389.  At the border it enters Colorado City.  gUnreconstructedh out to establish their own colony polygamists founded Colorado City in 1909, as Millennial City.  At the time Arizona was a territory, not a state.  Later the name was changed to Short Creek.  Following an infamous government raid in 1953, the name was changed again to Colorado City in 1958.";
		public final String AZSTRIP = "Highway 389 from Colorado City to Fredonia passes through an area known as the gArizona Strip,h The strip of land north of the Grand Canyon and south of the Utah border.  The gStriph is some of the most remote ghabitableh lane in the lower 48.  To go from the gstriph to any other community in AZ one must go through Utah or Nevada and essentially go around the Grand Canyon. ";
		public final String FREDONIA = "Four miles south of the Utah border, is another town created by polygamists to evade the law in Utah.  The town was established in 1885 and originally called gHardscrabble.h  Erastus Snow came up with the name gFredoniah a combination of Free and donia, which is Spanish for Mrs., indicating it was safe for plural wives. ";
		public final String KANAB = "Founded in 1870 by Mormon settlers, Kanab became a ranching community because of its lack of a dependable water source for large-scale agriculture.  In 1920s the Parry brothers began promoting the area as a location for Western Movies.  In 1924 Tom Mix filmed the first silent western film in Kanab, gDeadwood Coach.h  In the 50 years that followed over 100 films were shot in the Kanab area.  John Wayne, Marilyn Monroe, Frank Sinatra, Alan Ladd, Clint Eastwood, and even Ronald Regan all made films here at one time or another.  During the 50fs and 60fs (the heyday for TV westerns) there were constantly film crews in town.  In fact, the set from gGunsmokeh still stands in Johnson Canyon, just south of town.  In the lobby of the Parry lodge there signed photos of most of the stars that stayed in Kanab, Utahfs glittle Hollywood.h";
		public final String STAIRCASE = "This is the largest national monument in the US at 1.9 million acres.  It is larger than Zion, Bryce and Arches combined.  So large in fact, the National Park Service chose to have the BLM retain control of the land.   \n\n The monument has 3 areas; the Kaiparowits Plateau, the Grand Staircase and the Canyons of the Escalante.  President Clinton created the monument in 1996 using the authority of the Antiquities Act.";
		public final String POWELL = "Lake Powell is the second largest man made reservoir in the United States.  When full it holds approximately 2 years worth of the Colorado River.  It is second only to Lake Mead, but not by much, Lake Mead holds 1/28th more water.  Or Lake Powell is 27/28th the amount of water of Lake mead.  The lake is very long and narrow, its length is 280 km from dam to river and it has 3248 km of shoreline, longer than the west coast of the US.  The deepest part near the dam is 570ft (170 m). \n\n Lake Powell has been used in many movies: \n	The Greatest Story Ever told (1965) \n	The Planet of the Apes (1968) \n	The outlaw Josey Wales (1976) \n	Maverick  (1994) \n	Tall Tale  (1995) \n	Broken Arrow (1996) \n	Planet of the Apes  (2001)";
		public final String GCDAM = "The entire project of building the dam took 10 years 1956-1966.  This includes the construction of the highway (89), the bridge, the town of page and the dam.  The dam itself took 8 years to complete, although it took 17 years to fill the reservoir.  The height of the dam is 710 ft (216 m), its crest is 1560 ft (474 m) ";
		public final String POWER = "The power plantfs eight turbines when fully utilized have a maximum output of about 1300 megawatts, roughly enough to power an average city of 2 million people in the US.  The green you see below the dam on the roof of the power plant is grass, it helps keep the dust down.  Occasionally you will see workers gmowing the lawn.h";
		public final String GCBRIDGE = "The bridge straddles Glen Canyon 210m above the Colorado.  It is about 400m long.  It is the 2nd highest steel arch type bridge in the US.  It was first built and assembled in San Francisco then brought by truck in pieces to Page.  They built the bridge from both sides of the canyon and the engineers were so good that when it came together the joining bolts slid into the holes easily.";
		public final String PAGE = "The town of Page was named after John Chatfield Page, a US BLM commissioner.  Page sits on top of Manson Mesa, with Glen Canyon Recreation area to the north and the other sides surrounded by the Navajo Nation.  Prior to the construction of Glen Canyon Dam, all of the land on the page side of the Colorado was Navajo land.  The US government bought Manson Mesa to facilitate the building of the dam.  Page was built to house workers.  During the peak of construction the population was over 10000.  Currently the economy of Page depends on Lake Powell and the million plus tourists that come each year.";
		public final String GENSTATION = "This is a coal-fired plant that produces 2250 megawatts.  It was built in the 1970fs as alternative to building more large dams on the Colorado River.  The project included the construction of the BM & LP rail line that brings coal, water intakes from Lake Powell, and the Peabody Kayenta Mine at Black Mesa to supply coal.  There were also 800 miles of transmission lines built.  The smoke stacks were replaced in the late 90fs with a new wet scrubber technology.  The stacks are 236 m high; this places them among the tallest structures in AZ. ";
		public final String ANTELOPE = "Antelope is the most visited most photographed slot canyon in the American Southwest.  It is often referred to as gThe Crackh, gThe Corkscrewh etc.   It was formed by water erosion of the Navajo Sandstone, mostly by flash flooding.  It is divided into three sections, Upper Antelope Canyon, Lower Antelope Canyon, and the Powell inlet called Antelope Canyon that is only accessible by boat. \n\n Because Antelope canyon is prone to flash flooding in cases of inclement weather (especially up stream) the canyon is often closed and tours may be cancelled without notice. \n\n In August 1997 eleven tourists lost their lives in a flash flood in Lower Antelope.   At that time there was little rainfall in the area but an earlier storm had deposited lots of water in the drainage upstream. Seven French, two Swedes and two Americans perished. \n\n Antelope Canyon is a crack in the thick Navajo Sandstone layer of the Colorado Plateau.  When it rains this wash becomes a tributary of the Colorado River, although now it drains directly into Lake Powell. \n\n The Navajo layer is famous for its slot canyons.  The layer is hard enough that water cuts downward with very little of the side erosion that takes place in the softer layers.  Although Antelope is the most famous there are many spectacular slot canyons formed in  the Navajo layer, Buckskin gulch, Peek-a-boo, Canyon X, and Spooky gulch to name a few.  In reality there are hundreds. \n\n The lines on the canyon wall and in the surrounding formations often are at different angles to each other,  this phenomenon is called crossbedding.  In the Navajo layer crossbedding was caused by wind-blown sand being blown over dunes in a vast Jurassic desert about 170 million years ago.  As the water flows through Antelope, cutting downward, it polishes the sides of the canyon, making crossbedded layers appear as smooth lines.  The texture of the canyon walls combined with colors of oxidized iron and indirect sunlight create unique scenery and fantastic photo opportunities.";
		public final String HORSESHOE = "This meander of the Colorado River is a spectacular sight.  The emerald green water, which has been tamed by the dam, makes a wide horseshoe-shaped turn 1000ft below the overlook.   \n\n The red and orange Navajo Sandstone was laid down in a vast Jurassic desert as evidenced by the cross bedding.   It took 15 million years for the wind-blown sediment to pile up.  The orange and red colors are caused by the oxidation of iron and manganese in the rock.   \n\n Horseshoe Bend is best photographed between 9am and 12pm, depending on the time of year.  A wide-angle lens and a polarizing filter are recommended. \n\n There are no guardrails, and fatalities have occurred here.  Use caution near the edge and stay back at least 3 ft.   On July 24, 2010 a man fell to his death when a thin sandstone ledge he was standing on broke away.";
		public final String COLRIVER = "The Colorado is the primary river drainage in the American Southwest, it carries about 12% of the water of the lower 48 states.  The area the river drains, however, is about 25% of the country.  The headwaters are in Colorado in Rocky Mountain National Park.  It enters the ocean at the Gulf of California in Mexico.  Over its 1400 miles it loses about 9000 ft.   \n\n Seven states rely on the water from the Colorado, these are the members of the Colorado Compact,  Wyoming, Colorado, Utah, New Mexico, Arizona, Nevada and California.  Although water is the scarcest resource in the southwest, 80% of the water from the Colorado is used for agriculture, with CA getting lionfs share.  Often water disputes are settled in the courts.";
		public final String NAVNATION = "The Navajo Nation is a semi-sovereign area of 27,000sq miles (65000 sq Km) in the four corners region.  The land is mainly concentrated in Arizona but it extends into southern Utah and western New Mexico.  It is the largest reservation in the United States.  The gRezh is larger than the combined area of Rhode Island, Delaware, Connecticut, and Massachusetts.  It is about the same size and Switzerland.  It is roughly the same size as the island of Kyushu in Japan.";
		public final String BLACK = "Black mesa is a high mesa (Spanish for gtableh) located near Kayenta AZ.  The mesa is also called Black Mountain.  There are many reliable surface springs on the mesa and because of its elevation there is abundant timber that the Navajo use for building and for fuel.  Part of Black Mesa also lies on Hopi land.   \n\n Peabody Western Coal Company has operated 2 strip coal mine on the mesa since the 1960fs.  Much of the coal was transported through pipes in a water slurry.  The use of scarce groundwater for the operation was highly controversial.  Between 1968 and 2005 over 1billion gallons of water was used to transport the B.M. coal to the Mohave generating Station in Laughlin NV.  The water table has gone down by hundreds of feet, and there is some fear of possible contamination from the mine.  In 2005 the Mohave plant, which was unable to meet new EPA requirements, shut down. \n\n The second mine on the mesa is the Kayenta Mine.  The Black Mesa and Lake Powell Railroad also transports its coal from Black Mesa to a power plant near Page.  The electric train makes two round trips daily.  Power generated from the two coal mines has provided electricity for Los Angeles, Phoenix, Las Vegas and other communities in the west for three decades.  Royalties and taxes from the mining operations provided approximately 80 percent of the Hopi general operating budget  and 60 percent of the Navajo general fund.  The operations have also employed hundreds of locals. \n\n When the Mojave plant closed in 2005, it was the dirtiest power plant in the west, emitting 40,000 tons of sulfur dioxide per year.  In addition the impact of the mine on water resources and the environment, twelve thousand  Navajos have been removed from their land due to mining, the largest removal of Native Americans  since 1880.";
		public final String KAYENTA = "Kayenta (Kay-enta or Kay-entee, not Ka-yenta) is the gateway to Monument Valley.  The name is loosely derived from a Navajo word Teefinfdeeh meaning bog hole, as there were once shallow lakes here.  The area is covered with ruins and artifacts from the Ancestral Puebloan people.    \n\n Around 1910 John Wetherill established a trading post in the area.  In the 50fs and 60fs growth was spurred by Uranium mining, and later by tourism. \n\n Kayenta is the only town on the Navajo Reservation that operates with autonomy.   Kayenta is a municipal township governed by a 5 member elected board and a town manager. The other towns are under the jurisdiction of the BIA, the local Chapter, and the Navajo Nation.  Kayenta is also one of the few places on the reservation with a sales tax.";
		public final String MV = "Monument valley covers about 90,000 acres in Utah and Arizona.  The buttes and mesas have been made famous in countless films and commercials filmed therein.   Monument Valley Tribal Park is a smaller area contained in Monument Valley but it is the most scenic part.  The park was established in 1957 and is managed by the Navajo Nation. \n\n Most of the natural monuments are remnants of sandstone eroded by wind and water. Agathlan Peak and some lesser monoliths and hills, are the cores of ancient volcanoes.  Their dark basalts contrast to the red and orange of the surrounding sandstone.   \n\n The date the Navajo arrived to the Valley is unknown.  It is known that many Navajofs fleeing a US cavalry campaign against the Navajo, came here under the leadership of Hoskinini in the 1860fs.  However Monument Valley was not officially added to the Navajo Reservation until the 1930fs.";
		public final String GOULDINGS = "Harry Goulding and his young wife, Leone, arrived at Monument Valley in 1923.  They had purchased 1 sq. mile of land with the purpose of opening a trading post.  They first year they lived in a tent, from which they also ran their business.  In 1924, they built a more suitable structure for their home and trading post, the rock building which currently houses the museum.  It was Harry Goulding who first introduced the valley to director John Ford. \n\n When the Gouldings started their trading post business was good.  Many of the local Navajo would come to trade Weavings and Jewelry for the staples and sundries Goulding sold.  During the Great Depression, business suffered.  In an effort to boost the local economy Goulding came up with a plan to entice the movie to come to Monument Valley to film westerns, in hopes that the producers would hire locals as extras at good pay.  At that time most westerns were filmed on the Iverson Movie Ranch or other ranches in the hills near Hollywood.  Goulding though the buttes and mesas of Monument Valley would provide a dramatic backdrop and thought if the directors could only see the Valley it would sell it self.  \n\n Harry Goulding borrowed some photos taken by his friend, photographer Josef Muench, and together with his wife went to Hollywood.  When he tried to meet John Ford at United Artists studio he was told Ford was too busy.  So, while Harryfs wife waited in the car knitting, Harry went back to Fordfs office and despite protests of the receptionist spread his bedroll out and said he would wait there until Ford could meet him.  Ford finally met with Goulding, loved Monument Valley and the rest is history.  The first film gStagecoachh (1938) starring John Wayne, Claire Trevor, and Thomas Mitchell was a smash hit and was nominated for 7 academy awards, garnering 3.  Ford went on to make 7 movies in Monument Valley and hundreds of others have been filmed here.";
		public final String MVPARK = "The park is the Monument Valley made famous in the movies.  From the visitors center there is a 17mile drive that allows visitors to get up close and personal with the buttes and mesas. \n\n The valley was once covered with great sandstone layers of the Colorado Plateau, but erosion has left the valley in a wide flat plain with the monuments (remnants of previous layers) rising high in the air.  They range from 400 to about 1200 ft.  The Valley floor is Cutler siltstone, the bottom layer of the buttes is Organ Rock Shale.  The main layer is De Chelly sandstone.  The De Chelly is capped with the Moenkopi Shale.  Some of the tallest monoliths have a layer of Shinarump Siltstone on top of the Moenkopi, East Mitten is a good example of this.";
		public final String TUBA = "Tuba is the largest community on the Navajo Nation, slightly larger than Shiprock NM.  Tuba  is named after Tuuvi a Hopi leader who converted to Mormonism in 1870, and invited Mormons to settle in the area.  Tuba is located on Navajo land in the Painted Desert, but it is close to the Hopi reservation and some Hopi reside in Tuba along with the Navajo majority.";
		public final String PAINTED = "The Painted Desert is composed of mostly Triassic sediment that was deposited in an ancient sea.  It contains dinosaur fossils and petrified wood in abundance, although the area near Petrified Forrest National Monument is more famous that the area from tuba City to Cameron.  The area we travel is famous as the shooting location for the movie gEasy Riderh with Peter Fonda, Dennis Hopper, and Jack Nicholson.";
		public final String CAMERON = "Cameron is one of the Southwestfs historic trading posts.  It was established in 1916 by Hubert Richardson, not long after the 1 lane steel bridge was completed.  The bridge became the major crossing of the Little Colorado River, and guaranteed a steady flow of customers to the post.  The Trading Post was named after Senator Ralph Cameron, and currently has a large selection of crafts from Hopi, Navajo and Pueblo tribes. \n\n The trading posts played a vital role on the reservations.  They were a gathering place, a post office, a place to purchase goods, a bank, and the post operator served as an interpreter and go between for language and culture.";
		public final String GC = "Grand Canyon National park encompasses 1.2 million acres of Arizona.  The Canyon is 190mi (320 Km) long, over a mile deep (1700m) and contains 277(450) miles of the Colorado River. The North rim is about 8000 ft. (2400m) and the South Rim is about 7000 (2100m).  Rim to rim is about 10 mi (17km) as the crow flies but to drive it is 215 mi.  The canyon was carved by the Colorado River over a period of 5-million years. Human history of the canyon is about 10,000 yrs old.  It became a national park in 1919. \n\n The first non-native people to visit Grand Canyon were Spanish explorers led by Don Lopez de Cardenas, who was a captain of the Coronado Expedition of 1540.  The expedition was in search of the lost cities of gold known as gThe Seven Cities of Cibola.h   \n\n A Franciscan Priest, Francisco Tomas Garces, is credited with naming the Rio Colorado in 1776.  In 1821 When Mexico gained independence from Spain, G.C. became Mexican territory but there was little interest in this isolated area.  After the Treaty of Guadalupe-Hidalgo in 1848, the US gained ownership of the southwest including Grand Canyon.  Still there was little interest in the area.  All of that changed in 1869 with john Wesley Powellfs expedition down the Colorado River. \n\n John Wesley Powell was a one-armed Civil War Veteran and professor of geology who organized and led a 3 month, 3000 mile, expedition down the Colorado, from Green River Wyoming through the Grand Canyon.  He started with 10 men and 4 boats the journey ended with 6 men and 2 boats.  Because he charted the river and kept a detailed journal (that is still used by river runners today) the area became accessible to adventurers, miners and tourists.  It became a National park in 1919.";
		public final String VIEWPOINTS = "Desert View \n Desert View is the easternmost point on the south rim. It is also the highest at 2267M.  The point is named for its long view of the Painted Desert and the Colorado plateau.  On a clear day you can see the 3000m Navajo Mountain 154km to the northeast.  \n\n The most striking object at D.V. is the 70ft Watchtower, designed by Mary Jane Colter in 1932.  Mary Colter was a schoolteacher who became the head architect for the Fred Harvey Company.  She designed 5 buildings in GCNP.   Her style is famous for the way it blends into the natural surroundings.  She is also famous for her use of native motifs. \n\n Lipan Point \n Lipan Point is probably the best view on the east rim drive.  It has excellent views of the geologic strata known as the super group.  It also offers an outstanding view of the Colorado River and the Unkar Delta. \n\n Tusayan Ruin and Museum \n This is the site of an ancient Ancestral Puebloan (formerly Anasazai) village  that was here approx. 800 years ago.  The museum houses artifacts of the period and gives a good glimpse of the agrarian lives of the 30 or so people who lived here. \n\n Moran Point \n This point was named after Thomas Moran who was one of the most famous and influential landscape painters in American History.  His work was also important because it was introduced Americans to the grandeur and beauty that is found in the west.  His work was influential in the creation of several national parks, most notably, Yellowstone.  He participated in one of Powellfs expeditions and spent much time at G.C. \n\n Grandview Point \n Grandview offers excellent photo opportunities if descends a few yards down Grandview Trail.  The trail was created to access mining claims below, most notably Pete Berryfs Last Chance Mine on Horseshoe Mesa.  Eventually Berry sold the Mine and Built the Grandview Hotel.  It was very popular until the arrival of the railroad and creation of Grand Canyon Village just after the turn of the 20th century.  Berry sold the hotel to newspaper magnate William Randolph Hearst.  Later the hotel was condemned and the NPS forced Hearst to relinquish his rights to the property. \n\n Yaki Point \n Yaki Point offers excellent views of the canyon to both the west and northeast. It has excellent view at sunset as well.  You can also see hikers on South Kaibab Trail directly below to the west.  Yaki is only accessible by shuttle bus and by foot. \n\n Mather point \n Mather is the most popular viewpoint at GCNP.  It is the favorite spot for tour bus groups to view sunrise as well.  He point offers an excellent view of Plateau Point, Bright Angel Canyon (and campground area), South Kaibab Trail, Cedar Ridge etc.  If you look carefully you can even see the Watchtower at Desert View, nearly 25 mi away. \n\n At the main overlook at Mather there is a plaque commemorating the first director of the National Park Service, Stephen Tying Mather.  Mather was a wealthy industrialist who made his fortune in (20 mule team) Borax.  He gave up his career to direct the newly formed National Park Service in 1916.  Prior to 1916, the US Army Cavalry managed the National Parks.  Mather had a vision of gpreserving and maintaining the parks for the enjoyment of future generations.h  His foresight and influence is still evident today. \n\n Yavapai Point \n Yavapai is a Paiute word meaning gSun People.h The word refers to a tribe that formerly inhabited the area.  Many points along the canyon are named after indigenous tribes. \n\n At Yavapai there is a rock building dating from 1928.  It currently houses an excellent geology exhibit.  Also there are binoculars available for viewing the canyon and the geology.  You can see the Colorado and the suspension bridge as well as Bright Angel Canyon and Phantom Ranch.  Yavapai is a popular spot to view sunset. \n\n Grand Canyon Village \n The railroad arrived at Grand Canyon in 1901.  The all-day bone jarring stagecoach ride became a thing of the past.  Hotels, curio shops, photo studios and restaurants soon followed. \n\n\n Hermit Road and Points West \n\n Trailview \n Trail view consists of two overlooks, both offer great views of the descent of the Bright Angel Trail into the Canyon.  You also have a commanding view of Grand Canyon Village, because of the elevation gain from the village to Trailview. \n\n Maricopa \n Maricopa Point was the site of the Lost Orphan Mine, one of the most productive uranium mines in the US during the 1950fs.  It was on private lane and had originally been a copper mine in the late 1800fs.  At one time the mine site was also the site of a 20-cabin resort operated by Will Rogers. \n\n Powell \n Powell point is named for John Wesley Powell a one armed Civil War Vet who navigated the unknown Colorado river, and later became the head of the US Geologic Survey.  He and an intrepid crew traveled 3 months down the mighty Colorado and mapped its course.  There is a monument dedicated to his expeditions at this point. The point sticks out deep far into the canyon so Powell has one of the widest views on the South Rim.    \n\n Hopi \n Hopi is named for the Hopi people who have lived in the southwest for thousands of years.  Hopi Point is the most popular point at sunset.   It has sweeping wide views and an excellent view of the Colorado River.  \n\n Mohave \n The Mojave Tribe once lived along the Colorado River south of Grand Canyon.  Historically, Mojave was spelled with a gJh in California and an gHh in Arizona.  Below Mohave you can see Hermit Rapid.  Rapids are formed where debris from a side canyon narrows the river.  The water must travel faster to move the same volume through a narrower passage. \n\n Pima \n Named after an Arizona tribe that farmed the Phoenix Valley, Pima point has an excellent view of the Colorado.  In the 1920fs there was a campground below Pima on the Hermit Trail that included a blacksmith shop, telephones, stables and a dining hall. There was even a 6300 ft aerial tram (at the time the largest in the US) that connected Hermit Camp to Pima Point.  In 1930 the camp was removed.  \n\n Abyss \n At this overlook you get a jaw-dropping view into a steep narrow side canyon.  The plunge begins right at the rim of the overlook and drops an astounding 3000 ft all the way down to the Bright Angel shale of the Tonto Platform.  It is one of the deepest views of the canyon, thus the name. \n\n Hermitfs Rest \n Hermitfs rest is the end of the Hermit Road.  There is a stone building which houses a gift shop, and an enormous fireplace.  The building was designed by Mary Colter, and completed in 1914.  The gHermith was a prospector named Louis Boucher who lived in the canyon below Hermits Rest.  Boucher was friendly and actually liked people.  He prospected in the canyon for 20 years.";
		public final String TUSAYAN = "Tusayan is a small town (pop. 800) at the South Entrance of Grand Canyon National Park.  The name is a native meaning gplace of little waterh, very fitting for a town that up until the 1990fs had to truck in its water from Williams.  Currently the water is piped in from the North Rim.  Still, they are very conservative in their water use and all except culinary (and swimming pool) water is ggrey waterh which has been recycled. \n\n Despite its small year-round population, Tusayan boasts the third busiest airport in Arizona, behind Phoenix and Tucson.  The reason of course is all of the flights of people touring the Grand Canyon.";
		public final String VALLE = "Valle was originally a planned community of one-acre lots at the intersection of Hwy US180 and AZ64.  The community never came to fruition and is an unincorporated area.  It has a few gas stations a Flintstones-themed campground called gBedrock Cityh and most notably, the gPlanes of Fameh aircraft museum. \n\n Outside the Museum you can see an F4U Phantom gBlue Angelh and next to the highway is a Lockheed Constellation number 613 named gBataanh that was used by Douglass Mac Arthur during the Korean War. Lockheed built 10 Constellations for the Army.  They were first used for Kennedyfs Berlin Airlift.  After that they were retrofitted as VIP transports.  Mac Arthur named his gBataan.h  NASA used Bataan during the Apollo missions of the 60fs and 70fs.";
		public final String WILLIAMS = "Named after the famous tall, lanky redheaded mountain man, Bill Williams.  Williams explored the country from Oregon to Mexico and was eventually killed by Indians.  The mountain also bears his name.   \n\n Williams is the home of the Grand Canyon Railway.  The train makes one trip daily to and from GCNP every day except Christmas.";
		public final String SELIGMAN = "Seligman was originally an area inhabited by Apaches.  In the 1890fs the first settlers moved in.   The town started as a railroad camp called gPrescott junction.h  When the Peavine railroad was completed the town took the name Seligman after the financier brothers that made it possible. \n\n In the 1920fs when Rte. 66 was built it followed the Rail Route and went through Seligman.  The railroad and Hwy brought tourists who became the mainstay of Seligmanfs economy.  In the 1970fs when Interstate 40 was being it bypassed many of the towns along 66.  In 1978 the last stretch (Kingman- Ash Fork) was finished and Seligman was bypassed as well. \n\n Overnight Seligmanfs traffic went from 9000 cars per day to 50.  Eventually the train quit stopping too.  It seemed that Seligman was destined to fade away.  In 1988 the Barber in Seligman, Angel Delgadillo, called a meeting in Seligman and in a way kept Seligman on the map. \n\n Historic Route 66 \n Angel saw the world pass Seligman by and it made him mad.  He did not want to see his life long town become a ghost town.  At the meeting they discussed the importance of the old highway, not just as means of commerce for the town, but also as a reminder of the history of the west.  They started the Historic Route 66 Association of Arizona.  And began the movement that led to the eventual designation of RTE. 66 as an historic highway (the first designated as such).  Angelfs Barbershop has become the Route 66 Visitors Center and Gift Shop.  It is a Mecca for Route 66 enthusiasts worldwide.  Angel has been interview hundreds of times, received many awards and has been on TV in many countries.  He has been on Japanese TV 5 or 6 times, most recently with Yamashita Tomohisa (Yamapi).  Jan. 2012 Yamashitafs documentary Yamashita Tomohisa Route 66-Tatta Hitori no America";
		public final String RT66 = "RTE. 66 was established in 1926 as part of the US highway system.  It followed roughly, what had been called the National Old Trails Highway.  The highway went from Missouri to Santa Monica.  The route became the main artery for auto travelers going west from the 1930fs until the 1970fs.  It has been popularized in song and on film and is part of Americasf collective consciousness. \n\n The first travelers to utilize the new highway were the Dust Bowl refugees, Okies and Arkies on exodus to find a new gpromised landh in California.  Their experience is captured in John Steinbeckfs gthe Grapes of Wrathh which later became a John Ford film by the same title.  It tells the tale of the Joad family who lost their farm in Oklahoma and went to find work in California in the 1930fs.  Steinbeck grew up in Salinas and had seen the plight of the Dust Bowl refugees first hand.  These people had traveled 66 even before it was paved.  Paving was completed in 1938. \n\n Later after the War the 66 Highway was a major part of the post war boom.  Americans left the rust belt for the warm climate and growing economy out west.  The sights along the route became popular tourist attractions.   \n\n Route 66 became the inspiration for John Lassiterfs Pixar film gCarsh.  In fact the town Radiator Springs in the movie was based on Seligman AZ, according to Lassiter, who met and spent time with Angel and Juan Delgadillo. \n\n Now Route 66 carries the nostalgia of less hurried era gone by.  It is especially loved by those baby boomers that remember traveling west on 66 as youngsters, or they remember watching the TV show in the 60fs.";
		public final String KINGMAN = "In 1857 Lt. Edward Fitzgerald Beale was sent by the Army Corps of engineers to survey a wagon road across the 35th parallel.  He was also commissioned to test the feasibility for the use of camels as pack animals for the cavalry in the US southwest.  In 1859 the road was built.  In the 1870fs rich mining claims were established in the area.   Lewis Kingman came to survey a route for the railroad in 1880.  Eventually, Kingman was established in 1882 as a railroad town.   However, most of the growth in the early days was a result of the mining boom. In the first half of the 20th century Kingman grew in spurts, gold strikes, Hoover Dam, WW2 Airfield and gunnery school etc.   In 1939 Clark Gable and Carol Lombard were married in Kingmanfs St. Johns Church. Kingmanfs most famous son was the actor Andy Devine, and old Rte. 66 bears his name through Kingman.   \n\n Kingman is a famous stop on Rte. 66, and is one of the towns mentioned in Bobby Troupefs song gget your kicks on Rte. 66.h  The section of 66 from Kingman to Ash Fork is the longest remaining section of 66, and is host to the Annual 66 Fun Run the first weekend in May. \n\n In 1992 Pamela Anderson did one of her Playboy photo shoots in Kingman, and was brought in to the Police station for indecent exposure.  She was not charged, but was asked to write a letter of apology.  This incident occurred at 4th and Andy Devine.";
		public final String CHLORIDE = "In the 1840fs and 50fs silver and gold were discovered in the area.  The minerals were not mined in earnest until peace was made with the native Hualapai tribe 1862, when the town was founded.  The post office is the oldest operating post office in Arizona, it dates from 1862 as well.  The 1870fs were peak production for Chloride (named for silver chloride) with over 75 mines in operation and a population that exceeded 5000.  In the 1940fs silver mining was discouraged as unnecessary to the war effort.  In 1944 Chloride was down to less than 2000. \n\n As the mines closed down the town became a ghost town, although some of the people stayed on.  Now it is a eliving ghost townh with a population of 300 or so. Tourists, come for the gold Westh atmosphere.";
		public final String HOOVER = "Hoover was built as part of the Colorado Compact.  It was built between 1931 and 1935 during the Great depression.  It was completed almost 2 years early and under budget.  It is 221m high, 379m wide and has enough concrete to build a two -lane highway from San Francisco to New York.  The water behind the dam forms Lake Mead, the largest reservoir in the US. Even though the Dam was named after Herbert Hoover his political rival, FDR and his Secretary of the Interior, continually called it gBoulder Damh and because FDRfs presidency lasted over a decade the name gBoulder Damh became common.   \n\n During the construction period 112 people died in accidents, but contrary to rumor, none are entombed in the cement of the dam.  An additional number died from sickness, most notably 42 died of gpneumoniah which was most probably carbon monoxide poisoning. \n\n At the time of its completion Hoover Dam was the largest construction undertaking in the world.  It is still the tallest dam of its type in the US. \nHeight			221m \nLength			379m \nWidth				13.7m (top) \nPower output	 2100 Megawatts";
		public final String MEAD = "The water from the Colorado River contained behind Hoover Dam is called Lake Mead.  Mead is the largest man made reservoir in the US.  It was named after Elwood Mead who was the commissioner for the US bureau of Reclamation from 1924-1936.  After the completion of the Hoover Dam, Lake Mead (then Boulder Dam national Recreation Area) was established as the first national Recreation Area and is administered by the National Park Service. \n\n Several communities had to be evacuated as the water filled lake mead, St. Thomas and Overton are the most notable.  When the level of mead is low the ruins of St. Thomas become visible. \n\n Lake Mead Facts; \nShoreline		700mi \nLength			120mi \nDepth				489ft \nVolume (max)  	26 mil. Acre feet";
		public final String TILLMANBRIDGE = "The Bridge was created as a necessary bypass for the former Hwy that crossed Hoover Dam.  It is the second highest bridge in the US at 270m above the Colorado River.  It is 579m long.  Cost of construction was 240m.  It took over 5 years to complete.";
		public final String BOULDER = "Boulder city was established as the home of workers building the Hoover Dam.   It was a Federal Government city that was to house 5000. The place was intentionally placed at a distance to the canyon where the dam was built because of the excessive heat that was trapped in the rock walls of the canyon During the construction (1931-1936) of the dam, workers were paid roughly 5 times the rate of average laborers ($.10).  Because of the good wages and the harsh working conditions it was feared that the workers would gamble with their wages and not work.  As a result Gambling was made (and still is) illegal in boulder city.   Alcohol was outlawed until 1969.  The town has been self-governed since 1960. ";
		public final String RAILROAD = "Railroad Pass is named for the original rail line, a spur from Henderson to Boulder City that traversed it.  The most obvious landmark is the Railroad Pass Hotel and Casino.  Although, quaint looking compared to the Strip Casinos,  Railroad Pass operates  on Nevadafs oldest gambling license,  License #4.  #1and #2 were never issued and #3 was short lived.  For over 80 years machines have been paying out here. \n\n Railroad Pass Casino is now owned by MGM Resorts International, but it is very different from MGMfs other properties.  Half of the 300 machines still pay out in coins and tokens, and the 6 table games offer low limits 24 hrs. They even let you trade slot club points for cash. ";			
		
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
			
			if(tabNum == 1){ textView.setText(NEVADA); }
			else if(tabNum == 2){ textView.setText(LASVEGAS); }
			else if(tabNum == 3){ textView.setText(THESTRIP); }
			else if(tabNum == 4){ textView.setText(HOTELS); }
			else if(tabNum == 5){ textView.setText(MOVIES); }
			else if(tabNum == 6){ textView.setText(NELLIS); }
			else if(tabNum == 7){ textView.setText(SPEEDWAY); }
			else if(tabNum == 8){ textView.setText(GREATBASIN); }
			else if(tabNum == 9){ textView.setText(MOJAVE); }
			else if(tabNum == 10){ textView.setText(MESQUITE); }
			else if(tabNum == 11){ textView.setText(VIRGIN); }
			else if(tabNum == 12){ textView.setText(STGEORGE); }
			else if(tabNum == 13){ textView.setText(HURRICANE); }
			else if(tabNum == 14){ textView.setText(COLPLATEAU); }
			else if(tabNum == 15){ textView.setText(COLCITY); }
			else if(tabNum == 16){ textView.setText(AZSTRIP); }
			else if(tabNum == 17){ textView.setText(FREDONIA); }
			else if(tabNum == 18){ textView.setText(KANAB); }
			else if(tabNum == 19){ textView.setText(STAIRCASE); }
			else if(tabNum == 20){ textView.setText(POWELL); }
			else if(tabNum == 21){ textView.setText(GCDAM); }
			else if(tabNum == 22){ textView.setText(POWER); }
			else if(tabNum == 23){ textView.setText(GCBRIDGE); }
			else if(tabNum == 24){ textView.setText(PAGE); }
			else if(tabNum == 25){ textView.setText(GENSTATION); }
			else if(tabNum == 26){ textView.setText(ANTELOPE); }
			else if(tabNum == 27){ textView.setText(HORSESHOE); }
			else if(tabNum == 28){ textView.setText(COLRIVER); }
			else if(tabNum == 29){ textView.setText(NAVNATION); }
			else if(tabNum == 30){ textView.setText(BLACK); }
			else if(tabNum == 31){ textView.setText(KAYENTA); }
			else if(tabNum == 32){ textView.setText(MV); }
			else if(tabNum == 33){ textView.setText(GOULDINGS); }
			else if(tabNum == 34){ textView.setText(MVPARK); }
			else if(tabNum == 35){ textView.setText(TUBA); }
			else if(tabNum == 36){ textView.setText(PAINTED); }
			else if(tabNum == 37){ textView.setText(CAMERON); }
			else if(tabNum == 38){ textView.setText(GC); }
			else if(tabNum == 39){ textView.setText(VIEWPOINTS); }
			else if(tabNum == 40){ textView.setText(TUSAYAN); }
			else if(tabNum == 41){ textView.setText(VALLE); }
			else if(tabNum == 42){ textView.setText(WILLIAMS); }
			else if(tabNum == 43){ textView.setText(SELIGMAN); }
			else if(tabNum == 44){ textView.setText(RT66); }
			else if(tabNum == 45){ textView.setText(KINGMAN); }
			else if(tabNum == 46){ textView.setText(CHLORIDE); }
			else if(tabNum == 47){ textView.setText(HOOVER); }
			else if(tabNum == 48){ textView.setText(MEAD); }
			else if(tabNum == 49){ textView.setText(TILLMANBRIDGE); }
			else if(tabNum == 50){ textView.setText(BOULDER); }
			else if(tabNum == 51){ textView.setText(RAILROAD); }
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
