package com.example.view_pager;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
//import android.support.v7.app.ActionBar.Tab;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.example.tabswipe.TabsPagerAdapter;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
	
	
	private ViewPager viewpager;
	private TabsPagerAdapter adapter;
	private ActionBar actionbar;
	
	private String[] tabs={"NEW","TRENDING","MALLY'S CHOICE"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager = (ViewPager) findViewById(R.id.pager);
		actionbar = getActionBar();
		adapter = new TabsPagerAdapter(getSupportFragmentManager());
		viewpager.setAdapter(adapter);
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		
		for(String tabs_name:tabs )
		{
			actionbar.addTab(actionbar.newTab().setText(tabs_name).setTabListener(this));
		}
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

}
