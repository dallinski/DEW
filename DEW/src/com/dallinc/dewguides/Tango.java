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
		public final String AGRICULTURE = "Agriculture\nephedrine\nharvest\nnozzle\nrows of�i grapes�j";
		public final String GEOGRAPHY = "Geography\nalpine\narea(sqkm)\nbog\ncanyon\ncave\ncistern\ndepth\ndesert\nelevation\nequator\nlatitude\nlength\nlife zone\nmeadows\nmountain\nnatural resources\nnomadic\npeninsula\nplateau\npopulation\nreservation\nreservoir\nshoreline\nspring\nswamp\ntemperature\ntribe\ntropical\nvalley\nwidth";
		public final String FISH = "Fish\nbass\nbluegill\ncarp\ncatfish\ncrappie\nhatclery\nspawn\ntrout";
		public final String CACTUS = "Cactus\ncholla\nclarets cup\npickley pear\nyacca";
		public final String WILDLIFE = "Wildlife\namphibian\nantelope\nbeaver\nbobcat\ncougar\ncoyote\ndeer\nelk\nfisher\nfox\ngestation period\nhibernate\nlynx\nmammal\nmating season\nmoose\nnocturnal\npimemarten\npoisonous\nporcupine\nracoon\nraptor\nrat\nreptile\nrut\nskunk\nsnake\nspecies\nsquirrel\nwaterfowl";
		public final String HISTORY = "History\ncalvary\nclemeney\ncodes\ndeclassified\nexplorers\nfort\njail\nlynch\nperiods\nration ticket\nrations(ration system)\nshortage\nsolve code\nthe depression\ntrappers\nwestern movie";
		public final String MISCELLANEOUS = "Miscellaneous\nauthority\ncommercials\ndependable\ndesigned\nprocessed\nrecording\nresearchers\nreserch\nsingle file\nsphere\nstuntman\ntechniques";
		public final String GOVERNMENT = "Government\nchapter\ncommunism\ncongress\ncouncil\ncourt\ndemocracy\nfederal government\njudge\npresident\nsenator\nsocialism\nstate government\nstatute\nsupreme court";
		public final String PARKS = "Parks\nconservation\nconserve\necology\nenvironmentalist\nenvironment\nland grant\nnational forest\nnational monument\nnational park\nnatural wonder of the world\npreserve\npropose\npublic lands\nratify\nwilderness\nworld heritage site";
		public final String INDUSTRY = "Industry\nEnergy\nVocation\nagrarian\nagriculture\ncattle\nclear cut\ncrafts\ncrops\nfolk art\nfactory\ngenerators\ngeothermal energy\nhydro electric\nindustry\nlivestock\nlogging\nlumber\nmining\nnuclear power\noutput\npower breakdown\npower plant\nranch\nsolor power\nsteam engine\nsurveyor\ntimber\nwindmill\nwind power";
		public final String JGEOLOGY = "�n���w\n�z������\n���Ɋ�������\n�S������\n�߂̂�\n�吼�m\n������\n�쏰\n�C��\n��\n����/�c��\n�Y�_�J���V�E��\n�ΒY\n�嗤�ړ�\n�R�A����\n�C�ݕ���\n�����/�Ђ�\n�n�k\n����\n�▬\n�x�~��Ԃ�\n�N�H\n�f�w\n����\n�Ж���\n�ԛ���\n����\n�ΐ���\n�S\n�n�◬\n�n�w\n�ΊD��\n�嗝��\n�ϐ���\n�z�R\n�z�v\n�k��\n���j��\n�C�m�v���[�g\n�_��\n�����m\n����\n�Ή�����\n�v���[�g\n�v���[�g�e�N�g�j�N�X\n�y��\n��\n����\n����\n��\n���u\n����\n�Њ�\n���a��\n�Ŋ�/�D�Ŋ�\n�P�C�_��\n�X���[�g/�S��\n�n�w\n���ɐ��荞��\n�ÊD��\n���N\n�E����\n�ΎR����/�ΎR����\n�ΎR";
		public final String JBIRDS = "����\n�R���h��\n�h\n�A�g���Ȃ̏����̑���\n��\n�J�P�X\n��\n\n�q�o��\n���N�h��\n�c�o��\n�Ñ�";
		public final String JTREES = "�A��/��\n�g�l���R\n���[���b�p���}�i���V\n\n�l�O���h�J�G�f\n�j�t��\n�n�R���i�M\n�L�t��\n���؊w\n�Z�C�u�r���N�V��\n��\n�~\n��\n���}�����M\n���m������\n���}�u�h�E\n�_�C�I�E";
		public final String JFLOWERS = "��\n�A�X�^�[\n�c���K�l�X�C�Z��\n�I�_�}�L\n����\n�Ђȋe\n�^���|�|\n�킷��ȑ�\n�����h�E\n�M���A\n����\n�y���X�e����";
		public final String JBUSINESS = "�r�W�l�X\n���X����\n����\n�o��\n������\n������\n�I����\n�����\n����\n�I����������\n�ŋ�\n���Տ�";
		public final String JANTHROPOLOGY = "�l�ފw\n�l�Êw��\n�|\n�V����\n���v���̑�\n�g�F\n�l��\n�W��\n���^���\n��Z���^���̓y�n��\n�G����\n�����n\n�Z�^�J�{�`��";
		public final String JVEHICLE = "��蕨\n�S�C��\n�U�C���i�G���W���j\n�Ԏ�\n���\n�K�\����\n�n��\n���R�@��\n����\n�K�X��\n�^�C��\n�t�����g�O���X";
		public final String JAGRICULTURE = "�_��\n�G�t�F�h����\n���n\n�m�Y��\n��";
		public final String JGEOGRAPHY = "�n��(�w)\n���R��\n�ʐρi�����L�����[�g���j\n�����^���n\n���J\n���A\n�����r\n�[��\n����\n�W��\n�ԓ�\n�ܓx\n����\n�������z��\n�q���n\n�R\n�V�R����\n�V�q��\n����\n�����^��n\n�l��\n�����n�^���Z��\n�����r\n�Ίݐ��^�C�ݐ�\n��\n�Ꮌ�n\n���x\n�����^�푰�^����\n�M�т�\n�J\n��";
		public final String JFISH = "��/����\n�o�X�i��̗ށj\n�u���[�M��\n��\n�i�}�Y\n�N���b�s�[\n\n\n��";
		public final String JCACTUS = "�T�{�e��\n�`���[���T�{�e��\n\n�E�`���T�{�e��\n���b�J";
		public final String JWILDLIFE = "�쐶����\n������\n�J���V�J�^�A���e���[�v\n�r�[�o�[\n�R�L\n�s���[�}\n�R���[�e\n��\n�厭\n�t�B�b�V���[\n��\n���ي���\n�~��\n�����N�X\n�ٓ���\n�ɐB��\n�w����\n��s��\n\n�L�ł�\n�n���l�Y�~\n�A���C�O�}\n�ҋח�\n�˂���\n�͒���\n������^����i���j\n�X�J���N\n��\n���\n���X\n����";
		public final String JHISTORY = "���j\n�R����\n����\n�Í�\n�@�����̃��X�g����O���\n�T����\n��\n�S�u���^�Y����\n�����`\n����\n�z����\n���z���ʁi�z�����j\n�s��\n�Í����\n�勰�Q\n�t\n������";
		public final String JMISCELLANEOUS = "���̑�\n����\nCM�^�R�}�[�V����\n����ɂȂ�\n�݌v���ꂽ\n�������ꂽ\n�L�^\n������\n����\n���\n���^�͈�\n�X�^���g�}��\n�Z�p";
		public final String JGOVERNMENT = "���{\n�x��\n���Y��`\n�c��^����\n�]�c��\n�ٔ���\n�����`\n�i�A�����J�j�A�M���{\n�ٔ���\n�哝��\n��@�c��\n�Љ��`\n�B���{\n�@�߁^����@\n�ō��ٔ���";
		public final String JPARKS = "����\n�ߖ�^�ێ��^�ی�\n�ߖ񂷂�\n���ԁi�w�j\n���ۑS��`��\n��\n�y�n�̕�������\n���L��\n�������\n��������\n���E�̎��R�̕s�v�c\n�ۑ�����^�ی삷��\n��Ă���\n���L�n\n��y����\n�E�B���_�l�X�^�r���\n���E��Y";
		public final String JINDUSTRY = "�Y��\n�G�l���M�[\n�E��\n�_�Ƃ�\n�_��\n���^�{��\n�F��\n�H�|�i\n���n���^�앨\n���|�i\n�H��\n���d�@\n�n�M�G�l���M�[\n���͔��d��\n�Y�Ɓ^�H�Ɓ^�Ε�\n�ƒ{\n�ޖؐ؂�o���i�Ɓj\n�ޖ�\n�z��\n���q��\n���d��\n�d�͗�\n���d��\n��q��\n���z�G�l���M�[\n���C�@�ցi�ԁj\n���ʎm\n�ޖ؁^����\n����\n����";
		public final String HGEOLOGY = "��������\n���イ���イ����\n����ɂ��ǂ����イ��\n�˂񂿂Ⴍ������\n�߂̂�\n���������悤\n����Ԃ���\n����ǂ�\n�����Ă�\n����\n������/�䂪��\n���񂳂�J���V�E��\n��������\n�����肭���ǂ�\n�R�A����傤\n��������ւ���\n����/�Ђ�\n������\n�������傤\n����݂Ⴍ\n���イ�����傤������\n���񂵂傭\n���񂻂�\n������\n�ւ�܂���\n����������\n�����\n��������\n�Ă�\n�悤�����イ\n������\n������������\n�����肹��\n�ւ񂹂�����\n��������\n������\n�ق��ׂ�\n�����悤����\n�����悤�v���[�g\n����\n�����ւ��悤\n������\n����������\n�v���[�g\n�v���[�g�e�N�g�j�N�X\n���邢��\n����\n�炭����\n����\n����\n�����イ\n������\n�ւ񂪂�\n����ł��\n������/�ł��΂񂪂�\n�P�C���񂦂�\n�X���[�g/����΂񂪂�\n������\n�����ɂ����肱��\n���傤��������\n��イ��\n�E����\n�����񂩂ǂ�/�����񂰂񂵂傤\n������";
		public final String HBIRDS = "���傤�邢\n�R���h��\n�킵\n�A�g�����̂��Ƃ�̂������傤\n����\n�J�P�X\n�Ƃ��\n\n�q�o��\n���N�h��\n�c�o��\n�͂�����";
		public final String HTREES = "���傭�Ԃ�/��\n�g�l���R\n���[���b�p���}�i���V\n\n�l�O���h�J�G�f\n���ɂ傤����\n�n�R���i�M\n�����悤����\n�����������\n�Z�C�u�r���N�V��\n������\n����\n�܂�\n���}�����M\n�����悤������\n���}�u�h�E\n�_�C�I�E";
		public final String HFLOWERS = "�͂�\n�A�X�^�[\n�c���K�l�X�C�Z��\n�I�_�}�L\n��������\n�ЂȂ���\n�^���|�|\n�킷��Ȃ���\n�����h�E\n�M���A\n����\n�y���X�e����";
		public final String HBUSINESS = "�r�W�l�X\n�ԂԂ�������\n����\n��������\n����Ƃ�����\n������������\n���Ȃ��낵\n���傤�Ђ���\n����\n���Ȃ��낵������\n��������\n������������";
		public final String HANTHROPOLOGY = "����邢����\n��������������\n���\n���������傤\n�������킹���̂ӂ���\n�����\n������\n���イ����\n����^����\n���񂶂イ�݂�^���̂Ƃ���\n������\n�����イ��\n����^�J�{�`��";
		public final String HVEHICLE = "�̂����\n�S���Ƃ�\n�U���Ƃ��i�G���W���j\n���Ⴖ�キ\n���񂵂�\n�K�\����\n�΂肫\n�Ȃ����񂫂���\n���傩����\n�K�X����\n�^�C��\n�t�����g�O���X";
		public final String HAGRICULTURE = "�̂����傤\n�G�t�F�h����\n���イ����\n�m�Y��\n����";
		public final String HGEOGRAPHY = "����(����)\n���������\n�߂񂹂��i�ւ��ق��L�����[�g���j\n������^�ʂ܂�\n���傤����\n�ǂ�����\n���傷����\n�ӂ���\n���΂�\n�Ђ傤����\n�����ǂ�\n����\n�Ȃ���\n�����ԂԂ�Ղ���\n�ڂ�������\n���\n�Ă�˂񂵂���\n�䂤�ڂ���\n�͂�Ƃ�\n��������^�ł���\n���񂱂�\n�����イ���^���傶�イ��\n���傷����\n�����񂹂�^�������񂹂�\n������\n�Ă�������\n����\n�Ԃ����^���ゼ���^�݂񂼂�\n�˂�������\n����\n�͂�";
		public final String HFISH = "������/����邢\n�o�X�i�������̂邢�j\n�u���[�M��\n����\n�i�}�Y\n�N���b�s�[\n\n\n�܂�";
		public final String HCACTUS = "�T�{�e��\n�`���[���T�{�e��\n\n�E�`���T�{�e��\n���b�J";
		public final String HWILDLIFE = "�₹���ǂ��Ԃ�\n��傤������イ\n�J���V�J�^�A���e���[�v\n�r�[�o�[\n��܂˂�\n�s���[�}\n�R���[�e\n����\n��������\n�t�B�b�V���[\n����\n��������������\n�Ƃ��݂�\n�����N�X\n�قɂイ�邢\n�͂񂵂傭��\n�w������\n�₱������\n\n�䂤�ǂ���\n�n���l�Y�~\n�A���C�O�}\n��������邢\n�˂���\n�͂��イ�邢\n������^�͂��傤�i���j\n�X�J���N\n�ւ�\n����邢\n���X\n�݂��ǂ�";
		public final String HHISTORY = "�ꂫ��\n���ւ�����\n���񂵂�\n���񂲂�\n���݂��傤�ق��̃��X�g����͂����\n���񂯂�\n�Ƃ��\n����������^�����ނ���\n�����`\n������\n�͂����イ����\n�����Ă��͂����イ��傤�i�͂����イ�����j\n�ӂ���\n���񂲂������ǂ�\n�������傤����\n��傤��\n�����Ԃ���";
		public final String HMISCELLANEOUS = "���̂�\n�����\n�V�C�E�G���^�R�}�[�V����\n�����ɂȂ�\n�����������ꂽ\n����肳�ꂽ\n���낭\n���񂫂イ����\n���傤��\n�������\n���イ�^�͂�\n�X�^���g�}��\n�������";
		public final String HGOVERNMENT = "������\n����\n���傤���񂵂ガ\n�������^��������\n�Ђ傤������\n�����΂񂵂�\n�݂񂵂サ�ガ\n�i�A�����J�j���ۂ�������\n�����΂񂩂�\n�����Ƃ���傤\n���傤���񂬂���\n���Ⴉ�����ガ\n���イ������\n�ق��ꂢ�^�����Ă��ق�\n�������������΂񂵂�";
		public final String HPARKS = "��������\n���₭�^�����^�ق�\n���₭����\n���������i�����j\n���񂫂傤�ق��񂵂ガ����\n���񂫂傤\n�Ƃ��̂͂炢����\n�����䂤���\n�����Ă���������\n�������������\n�������̂�����̂ӂ���\n�ق��񂷂�^�ق�����\n�Ă����񂷂�\n�����䂤��\n�Ђ���񂷂�\n�E�B���_�l�X�^�����\n������������";
		public final String HINDUSTRY = "���񂬂傤\n�G�l���M�[\n���傭����\n�̂��傤��\n�̂��傤\n�����^�������イ\n�����΂�\n���������Ђ�\n���イ�����Ԃ^��������\n�݂񂰂��Ђ�\n�������傤\n�͂ł�\n���˂G�l���M�[\n������傭�͂ł��\n���񂬂傤�^�������傤�^����ׂ�\n������\n�����������肾���i���傤�j\n��������\n�������傤\n���񂵂�傭\n�͂ł��傤\n�ł��傭��傤\n�͂ł񂵂�\n�����ڂ����傤\n�����悤�G�l���M�[\n���傤��������i����j\n�����낤��\n���������^������\n�ӂ�����\n�ӂ���傭";

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
