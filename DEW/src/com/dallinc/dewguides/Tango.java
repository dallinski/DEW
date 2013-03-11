package com.dallinc.dewguides;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.LayoutParams;

public class Tango extends FragmentActivity implements ActionBar.TabListener {

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
		setContentView(R.layout.tango_display);

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
		if(tabname.equals("Geology"))
			actionBar.setSelectedNavigationItem(0);
		else if(tabname.equals("Birds"))
			actionBar.setSelectedNavigationItem(1);
		else if(tabname.equals("Plants/Trees"))
			actionBar.setSelectedNavigationItem(2);
		else if(tabname.equals("Flowers"))
			actionBar.setSelectedNavigationItem(3);
		else if(tabname.equals("Business"))
			actionBar.setSelectedNavigationItem(4);
		else if(tabname.equals("Anthropology"))
			actionBar.setSelectedNavigationItem(5);
		else if(tabname.equals("Vehicle"))
			actionBar.setSelectedNavigationItem(6);
		else if(tabname.equals("Agriculture"))
			actionBar.setSelectedNavigationItem(7);
		else if(tabname.equals("Geography"))
			actionBar.setSelectedNavigationItem(8);
		else if(tabname.equals("Fish"))
			actionBar.setSelectedNavigationItem(9);
		else if(tabname.equals("Cactus"))
			actionBar.setSelectedNavigationItem(10);
		else if(tabname.equals("Wildlife"))
			actionBar.setSelectedNavigationItem(11);
		else if(tabname.equals("History"))
			actionBar.setSelectedNavigationItem(12);
		else if(tabname.equals("Miscellaneous"))
			actionBar.setSelectedNavigationItem(13);
		else if(tabname.equals("Government"))
			actionBar.setSelectedNavigationItem(14);
		else if(tabname.equals("Parks"))
			actionBar.setSelectedNavigationItem(15);
		else if(tabname.equals("Industry/Energy/Vocation"))
			actionBar.setSelectedNavigationItem(16);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tango_display, menu);
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
			return 17;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.geology);
			case 1:
				return getString(R.string.birds);
			case 2:
				return getString(R.string.plants_trees);
			case 3:
				return getString(R.string.flowers);
			case 4:
				return getString(R.string.business);
			case 5:
				return getString(R.string.anthropology);
			case 6:
				return getString(R.string.vehicle);
			case 7:
				return getString(R.string.agriculture);
			case 8:
				return getString(R.string.geography);
			case 9:
				return getString(R.string.fish);
			case 10:
				return getString(R.string.cactus);
			case 11:
				return getString(R.string.wildlife);
			case 12:
				return getString(R.string.history);
			case 13:
				return getString(R.string.miscellaneous);
			case 14:
				return getString(R.string.government);
			case 15:
				return getString(R.string.parks);
			case 16:
				return getString(R.string.industry_energy_vocation);
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
		public final String GEOLOGY = "Geology\nabsorb\nactive\nadhesive\nagate\nAtlantic\nbasalt\nbed of the river\nbottom of ocean\nboulder\nbuckle\ncalcium carbonate\ncoal\ncontinental drift\ncore sample(rock)\ncoastal plains\ncracks\ncrust\ncrystal\ndike\ndormant\nerosion\nfault\nfossil\ngneiss\ngranite\ngravel\nigneous\niron\nlava flow\nlayer\nlimestone\nmarble\nmetamorphic\nmine\nminers\nNorth America\nobsidian\noceanic plate\noxidation\nPacific\npebble\npetrified\nplate\nplate tectonics\npumice\nrock\nrock fall\nrust\nsand\nsand dunes\nsandstone\nschist\nsedimentary\nshale\nsilicates\nslate\nstratum\nsubducted\ntuff\nuplift\nuranium\nvolcanism\nvolcano";
		public final String BIRDS = "Birds\ncondor\neagle\nfinch\nhawk\njay\nkite\nnigtlerfale\nrobin\nstarling\nswallow\nvulture";
		public final String TREES = "Plants/Trees\nash tree\naspen\nblack brush\nbox elder\nconifer\ncottonwood\ndeciduous\ndendrology\njuniper(western)\nmaple\noak\npine\nsage brush\nsycamore\nwild grape\nwild rhubarb";
		public final String FLOWERS = "Flowers\naster\nbluebell\ncolumbine\ndafodil\ndaisy\ndandilion\nforget-me-not\ngentian\ngilia\nlilly\npenstemon";
		public final String BUSINESS = "Business\nbarter\nbuy\neconomy\nincome tax\ninheritance tax\ninventory\nsales tax\nsell\ntake inventory\ntaxes\ntradingpost";
		public final String ANTHROPOLOGY = "Anthropology\narchaeologists\nbow\nceremonial chamber\ndeerskin bags\nfireplace\ngame\ngathering\nhunt\nnative\npictographs\nreservation\nsquash";
		public final String VEHICLE = "Vehicle\n4 cylinder\n6 cylinder\naxle\ncarwash\nfuel\nhorsepower\ninternal-combustion engine\npermit\nrun out of gas\ntire\nwindshield";
		public final String AGRICULTURE = "Agriculture\nephedrine\nharvest\nnozzle\nrows of（ grapes）";
		public final String GEOGRAPHY = "Geography\nalpine\narea(sqkm)\nbog\ncanyon\ncave\ncistern\ndepth\ndesert\nelevation\nequator\nlatitude\nlength\nlife zone\nmeadows\nmountain\nnatural resources\nnomadic\npeninsula\nplateau\npopulation\nreservation\nreservoir\nshoreline\nspring\nswamp\ntemperature\ntribe\ntropical\nvalley\nwidth";
		public final String FISH = "Fish\nbass\nbluegill\ncarp\ncatfish\ncrappie\nhatclery\nspawn\ntrout";
		public final String CACTUS = "Cactus\ncholla\nclarets cup\npickley pear\nyacca";
		public final String WILDLIFE = "Wildlife\namphibian\nantelope\nbeaver\nbobcat\ncougar\ncoyote\ndeer\nelk\nfisher\nfox\ngestation period\nhibernate\nlynx\nmammal\nmating season\nmoose\nnocturnal\npimemarten\npoisonous\nporcupine\nracoon\nraptor\nrat\nreptile\nrut\nskunk\nsnake\nspecies\nsquirrel\nwaterfowl";
		public final String HISTORY = "History\ncalvary\nclemeney\ncodes\ndeclassified\nexplorers\nfort\njail\nlynch\nperiods\nration ticket\nrations(ration system)\nshortage\nsolve code\nthe depression\ntrappers\nwestern movie";
		public final String MISCELLANEOUS = "Miscellaneous\nauthority\ncommercials\ndependable\ndesigned\nprocessed\nrecording\nresearchers\nreserch\nsingle file\nsphere\nstuntman\ntechniques";
		public final String GOVERNMENT = "Government\nchapter\ncommunism\ncongress\ncouncil\ncourt\ndemocracy\nfederal government\njudge\npresident\nsenator\nsocialism\nstate government\nstatute\nsupreme court";
		public final String PARKS = "Parks\nconservation\nconserve\necology\nenvironmentalist\nenvironment\nland grant\nnational forest\nnational monument\nnational park\nnatural wonder of the world\npreserve\npropose\npublic lands\nratify\nwilderness\nworld heritage site";
		public final String INDUSTRY = "Industry\nEnergy\nVocation\nagrarian\nagriculture\ncattle\nclear cut\ncrafts\ncrops\nfolk art\nfactory\ngenerators\ngeothermal energy\nhydro electric\nindustry\nlivestock\nlogging\nlumber\nmining\nnuclear power\noutput\npower breakdown\npower plant\nranch\nsolor power\nsteam engine\nsurveyor\ntimber\nwindmill\nwind power";
		public final String JGEOLOGY = "地質学\n吸収する\n現に活動中の\n粘着性の\nめのう\n大西洋\n玄武岩\n川床\n海底\n岩\n潜る/歪む\n炭酸カルシウム\n石炭\n大陸移動\nコア試料\n海岸平野\n割れ目/ひび\n地殻\n水晶\n岩脈\n休止状態の\n侵食\n断層\n化石\n片麻岩\n花崗岩\n砂利\n火成の\n鉄\n溶岩流\n地層\n石灰岩\n大理石\n変成岩\n鉱山\n鉱夫\n北米\n黒曜石\n海洋プレート\n酸化\n太平洋\n小石\n石化した\nプレート\nプレートテクトニクス\n軽石\n石\n落石\nさび\n砂\n砂丘\n砂岩\n片岩\n沈殿の\n頁岩/泥版岩\nケイ酸塩\nスレート/粘板岩\n地層\n下に潜り込む\n凝灰岩\n隆起\nウラン\n火山活動/火山現象\n火山";
		public final String JBIRDS = "鳥類\nコンドル\n鷲\nアトリ科の小鳥の総称\n鷹\nカケス\n鳶\n\nヒバリ\nムクドリ\nツバメ\n禿鷹";
		public final String JTREES = "植物/木\nトネリコ\nヨーロッパヤマナラシ\n\nネグンドカエデ\n針葉樹\nハコヤナギ\n広葉樹\n樹木学\nセイブビャクシン\n楓\n樫\n松\nヤマヨモギ\n西洋かえで\nヤマブドウ\nダイオウ";
		public final String JFLOWERS = "花\nアスター\nツリガネスイセン\nオダマキ\n水仙\nひな菊\nタンポポ\nわすれな草\nリンドウ\nギリア\nユリ\nペンステモン";
		public final String JBUSINESS = "ビジネス\n物々交換\n買う\n経済\n所得税\n相続税\n棚卸し\n消費税\n売る\n棚卸しをする\n税金\n交易所";
		public final String JANTHROPOLOGY = "人類学\n考古学者\n弓\n儀式場\n鹿革製の袋\n暖炉\n獲物\n集会\n狩り／狩る\n先住民／その土地の\n絵文字\n居留地\n瓜／カボチャ";
		public final String JVEHICLE = "乗り物\n４気筒\n６気筒（エンジン）\n車軸\n洗車\nガソリン\n馬力\n内燃機関\n許可書\nガス欠\nタイヤ\nフロントグラス";
		public final String JAGRICULTURE = "農業\nエフェドリン\n収穫\nノズル\n畝";
		public final String JGEOGRAPHY = "地理(学)\n高山の\n面積（平方キロメートル）\n湿原／沼地\n峡谷\n洞窟\n貯水池\n深さ\n砂漠\n標高\n赤道\n緯度\n長さ\n生物分布帯\n牧草地\n山\n天然資源\n遊牧の\n半島\n高原／台地\n人口\n居留地／居住区\n貯水池\n湖岸線／海岸線\n泉\n低湿地\n温度\n部族／種族／民族\n熱帯の\n谷\n幅";
		public final String JFISH = "魚/魚類\nバス（鱸の類）\nブルーギル\n鯉\nナマズ\nクラッピー\n\n\n鱒";
		public final String JCACTUS = "サボテン\nチョーヤサボテン\n\nウチワサボテン\nユッカ";
		public final String JWILDLIFE = "野生動物\n両生類\nカモシカ／アンテロープ\nビーバー\n山猫\nピューマ\nコヨーテ\n鹿\n大鹿\nフィッシャー\n狐\n懐胎期間\n冬眠\nリンクス\nほ乳類\n繁殖期\nヘラ鹿\n夜行性\n\n有毒な\nハリネズミ\nアライグマ\n猛禽類\nねずみ\nは虫類\nさかり／発情（期）\nスカンク\n蛇\n種類\nリス\n水鳥";
		public final String JHISTORY = "歴史\n騎兵隊\n恩赦\n暗号\n機密情報のリストから外れる\n探検家\n砦\n拘置所／刑務所\nリンチ\n時代\n配給券\n一定配給量（配給制）\n不足\n暗号解読\n大恐慌\n猟師\n西部劇";
		public final String JMISCELLANEOUS = "その他\n権利\nCM／コマーシャル\n頼りになる\n設計された\n処理された\n記録\n研究者\n調査\n一列\n球／範囲\nスタントマン\n技術";
		public final String JGOVERNMENT = "政府\n支部\n共産主義\n議会／国会\n評議会\n裁判所\n民主主義\n（アメリカ）連邦政府\n裁判官\n大統領\n上院議員\n社会主義\n州政府\n法令／制定法\n最高裁判所";
		public final String JPARKS = "公園\n節約／維持／保護\n節約する\n生態（学）\n環境保全主義者\n環境\n土地の払い下げ\n国有林\n国定公園\n国立公園\n世界の自然の不思議\n保存する／保護する\n提案する\n公有地\n批准する\nウィルダネス／荒れ野\n世界遺産";
		public final String JINDUSTRY = "産業\nエネルギー\n職種\n農業の\n農業\n牛／畜牛\n皆伐\n工芸品\n収穫物／作物\n民芸品\n工場\n発電機\n地熱エネルギー\n水力発電の\n産業／工業／勤勉\n家畜\n材木切り出し（業）\n材木\n鉱業\n原子力\n発電量\n電力量\n発電所\n大牧場\n太陽エネルギー\n蒸気機関（車）\n測量士\n材木／立木\n風車\n風力";
		public final String HGEOLOGY = "ちしつがく\nきゅうしゅうする\nげんにかつどうちゅうの\nねんちゃくせいの\nめのう\nたいせいよう\nげんぶがん\nかわどこ\nかいてい\nいわ\nもぐる/ゆがむ\nたんさんカルシウム\nせきたん\nたいりくいどう\nコアしりょう\nかいがんへいや\nわれめ/ひび\nちかく\nすいしょう\nがんみゃく\nきゅうしじょうたいの\nしんしょく\nだんそう\nかせき\nへんまがん\nかこうがん\nじゃり\nかせいの\nてつ\nようがんりゅう\nちそう\nせっかいがん\nだいりせき\nへんせいがん\nこうざん\nこうふ\nほくべい\nこくようせき\nかいようプレート\nさんか\nたいへいよう\nこいし\nせきかした\nプレート\nプレートテクトニクス\nかるいし\nいし\nらくせき\nさび\nすな\nさきゅう\nさがん\nへんがん\nちんでんの\nけつがん/でいばんがん\nケイさんえん\nスレート/げんばんがん\nちそう\nしたにもぐりこむ\nぎょうかいがん\nりゅうき\nウラン\nかざんかつどう/かざんげんしょう\nかざん";
		public final String HBIRDS = "ちょうるい\nコンドル\nわし\nアトリかのことりのそうしょう\nたか\nカケス\nとんび\n\nヒバリ\nムクドリ\nツバメ\nはげたか";
		public final String HTREES = "しょくぶつ/き\nトネリコ\nヨーロッパヤマナラシ\n\nネグンドカエデ\nしにょうじゅ\nハコヤナギ\nこうようじゅ\nじゅもくがく\nセイブビャクシン\nかえで\nかし\nまつ\nヤマヨモギ\nせいようかえで\nヤマブドウ\nダイオウ";
		public final String HFLOWERS = "はな\nアスター\nツリガネスイセン\nオダマキ\nすいせん\nひなぎく\nタンポポ\nわすれなぐさ\nリンドウ\nギリア\nユリ\nペンステモン";
		public final String HBUSINESS = "ビジネス\nぶつぶつこうかん\nかう\nけいざい\nしょとくぜい\nそうぞくぜい\nたなおろし\nしょうひぜい\nうる\nたなおろしをする\nぜいきん\nこうえきじょ";
		public final String HANTHROPOLOGY = "じんるいがく\nこうこがくしゃ\nゆみ\nぎしきじょう\nしかかわせいのふくろ\nだんろ\nえもの\nしゅうかい\nかり／かる\nせんじゅうみん／そのとちの\nえもじ\nきょりゅうち\nうり／カボチャ";
		public final String HVEHICLE = "のりもの\n４きとう\n６きとう（エンジン）\nしゃじゅく\nせんしゃ\nガソリン\nばりき\nないえんきかん\nきょかしょ\nガスけつ\nタイヤ\nフロントグラス";
		public final String HAGRICULTURE = "のうぎょう\nエフェドリン\nしゅうかく\nノズル\nうね";
		public final String HGEOGRAPHY = "ちり(がく)\nこうざんの\nめんせき（へいほうキロメートル）\nしつげん／ぬまち\nきょうこく\nどうくつ\nちょすいち\nふかさ\nさばく\nひょうこう\nせきどう\nいど\nながさ\nせいぶつぶんぷたい\nぼくそうち\nやま\nてんねんしげん\nゆうぼくの\nはんとう\nこうげん／でいち\nじんこう\nきょりゅうち／きょじゅうく\nちょすいち\nこがんせん／かいがんせん\nいずみ\nていしっち\nしつど\nぶぞく／しゅぞく／みんぞく\nねったいの\nたに\nはば";
		public final String HFISH = "さかな/ぎょるい\nバス（すずきのるい）\nブルーギル\nこい\nナマズ\nクラッピー\n\n\nます";
		public final String HCACTUS = "サボテン\nチョーヤサボテン\n\nウチワサボテン\nユッカ";
		public final String HWILDLIFE = "やせいどうぶつ\nりょうせいりゅう\nカモシカ／アンテロープ\nビーバー\nやまねこ\nピューマ\nコヨーテ\nしか\nおおじか\nフィッシャー\nきつね\nかいたいきかん\nとうみん\nリンクス\nほにゅうるい\nはんしょくき\nヘラじか\nやこうせい\n\nゆうどくな\nハリネズミ\nアライグマ\nもうきんるい\nねずみ\nはちゅうるい\nさかり／はつじょう（き）\nスカンク\nへび\nしゅるい\nリス\nみずどり";
		public final String HHISTORY = "れきし\nきへいたい\nおんしゃ\nあんごう\nきみつじょうほうのリストからはずれる\nたんけんか\nとりで\nこうちしょ／けいむしょ\nリンチ\nじだい\nはいきゅうけん\nいっていはいきゅうりょう（はいきゅうせい）\nふそく\nあんごうかいどく\nだいきょうこう\nりょうし\nせいぶげき";
		public final String HMISCELLANEOUS = "そのた\nけんり\nシイ・エム／コマーシャル\nたよりになる\nせっかいされた\nしょりされた\nきろく\nけんきゅうしゃ\nちょうさ\nいちれつ\nきゅう／はんい\nスタントマン\nぎじゅつ";
		public final String HGOVERNMENT = "せいふ\nしぶ\nきょうさんしゅぎ\nぎかい／こっかい\nひょうぎかい\nさいばんしょ\nみんしゅしゅぎ\n（アメリカ）れんぽうせいふ\nさいばんかん\nだいとうりょう\nじょういんぎいん\nしゃかいしゅぎ\nしゅうせいふ\nほうれい／せいていほう\nさいこうさいばんしょ";
		public final String HPARKS = "こうえん\nせつやく／いじ／ほご\nせつやくする\nせいたい（がく）\nかんきょうほぜんしゅぎしゃ\nかんきょう\nとちのはらいさげ\nこくゆうりん\nこくていこうえん\nこくりつこうえん\nせかいのしぜんのふしぎ\nほぞんする／ほごする\nていあんする\nこうゆうち\nひじゅんする\nウィルダネス／あれの\nせかいいさん";
		public final String HINDUSTRY = "さんぎょう\nエネルギー\nしょくしゅ\nのぎょうの\nのぎょう\nうし／ちくぎゅう\nかいばつ\nこうげいひん\nしゅうかくぶつ／さくもつ\nみんげいひん\nこうじょう\nはつでんき\nちねつエネルギー\nすいりょくはつでんの\nさんぎょう／こうぎょう／きんべん\nかちく\nざいもくきりだし（ぎょう）\nざいもく\nこうぎょう\nげんしりょく\nはつでんりょう\nでんりょくりょう\nはつでんしょ\nだいぼくじょう\nたいようエネルギー\nじょうききかん（しゃ）\nそくろうし\nざいもく／たちき\nふうしゃ\nふうりょく";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			TextView textViewLeft = new TextView(getActivity());
			textViewLeft.setGravity(Gravity.LEFT);
			LayoutParams lpLeft = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.FILL_PARENT,1.0f);
			LayoutParams lpRight = lpLeft;
			lpLeft.setMargins(5,0,0,0);
			textViewLeft.setLayoutParams(lpLeft);
			int tabNum = getArguments().getInt(ARG_SECTION_NUMBER);
			TextView textViewHiragana = new TextView(getActivity());
			textViewHiragana.setGravity(Gravity.LEFT);
			textViewHiragana.setLayoutParams(lpRight);
			TextView textViewRight = new TextView(getActivity());
			textViewRight.setGravity(Gravity.LEFT);
			textViewRight.setLayoutParams(lpRight);
			
			if(tabNum == 1){ textViewLeft.setText(GEOLOGY); textViewRight.setText(JGEOLOGY); textViewHiragana.setText(HGEOLOGY); }
			else if(tabNum == 2){ textViewLeft.setText(BIRDS); textViewRight.setText(JBIRDS); textViewHiragana.setText(HBIRDS); }
			else if(tabNum == 3){ textViewLeft.setText(TREES); textViewRight.setText(JTREES); textViewHiragana.setText(HTREES); }
			else if(tabNum == 4){ textViewLeft.setText(FLOWERS); textViewRight.setText(JFLOWERS); textViewHiragana.setText(HFLOWERS); }
			else if(tabNum == 5){ textViewLeft.setText(BUSINESS); textViewRight.setText(JBUSINESS); textViewHiragana.setText(HBUSINESS); }
			else if(tabNum == 6){ textViewLeft.setText(ANTHROPOLOGY); textViewRight.setText(JANTHROPOLOGY); textViewHiragana.setText(HANTHROPOLOGY); }
			else if(tabNum == 7){ textViewLeft.setText(VEHICLE); textViewRight.setText(JVEHICLE); textViewHiragana.setText(HVEHICLE); }
			else if(tabNum == 8){ textViewLeft.setText(AGRICULTURE); textViewRight.setText(JAGRICULTURE); textViewHiragana.setText(HAGRICULTURE); }
			else if(tabNum == 9){ textViewLeft.setText(GEOGRAPHY); textViewRight.setText(JGEOGRAPHY); textViewHiragana.setText(HGEOGRAPHY); }
			else if(tabNum == 10){ textViewLeft.setText(FISH); textViewRight.setText(JFISH); textViewHiragana.setText(HFISH); }
			else if(tabNum == 11){ textViewLeft.setText(CACTUS); textViewRight.setText(JCACTUS); textViewHiragana.setText(HCACTUS); }
			else if(tabNum == 12){ textViewLeft.setText(WILDLIFE); textViewRight.setText(JWILDLIFE); textViewHiragana.setText(HWILDLIFE); }
			else if(tabNum == 13){ textViewLeft.setText(HISTORY); textViewRight.setText(JHISTORY); textViewHiragana.setText(HHISTORY); }
			else if(tabNum == 14){ textViewLeft.setText(MISCELLANEOUS); textViewRight.setText(JMISCELLANEOUS); textViewHiragana.setText(HMISCELLANEOUS); }
			else if(tabNum == 15){ textViewLeft.setText(GOVERNMENT); textViewRight.setText(JGOVERNMENT); textViewHiragana.setText(HGOVERNMENT); }
			else if(tabNum == 16){ textViewLeft.setText(PARKS); textViewRight.setText(JPARKS); textViewHiragana.setText(HPARKS); }
			else if(tabNum == 17){ textViewLeft.setText(INDUSTRY); textViewRight.setText(JINDUSTRY); textViewHiragana.setText(HINDUSTRY); }
			else textViewLeft.setText("An error occurred!");
			
			LinearLayout bigView = new LinearLayout(getActivity());
			bigView.setOrientation(LinearLayout.HORIZONTAL);
			bigView.setLayoutParams(lpRight);
			bigView.addView(textViewLeft);
			bigView.addView(textViewHiragana);
			if(getRotation(getActivity()).equals("landscape") || getRotation(getActivity()).equals("reverse landscape")){
				bigView.addView(textViewRight);
			}
			ScrollView scroll = new ScrollView(getActivity());
			scroll.addView(bigView);
			return scroll;
		}
	}
	
	public static String getRotation(Context context){
	    final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
	       switch (rotation) {
	        case Surface.ROTATION_0:
	            return "portrait";
	        case Surface.ROTATION_90:
	            return "landscape";
	        case Surface.ROTATION_180:
	            return "reverse portrait";
	        default:
	            return "reverse landscape";
        }
    }

}
