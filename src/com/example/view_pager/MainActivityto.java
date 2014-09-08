package com.example.view_pager;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
//import android.support.v7.app.ActionBar.Tab;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.tabswipe.TabsPagerAdapter;


public class MainActivityto extends FragmentActivity implements ActionBar.TabListener
{
	
	
	private ViewPager viewpager;
	private TabsPagerAdapter adapter;
	private ActionBar actionbar;
	
	private String[] tabs={"NEW","TRENDING","MALLY'S CHOICE"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_main_activityto);
		viewpager = (ViewPager) findViewById(R.id.pager);
		actionbar = getActionBar();
		adapter = new TabsPagerAdapter(getSupportFragmentManager());
		viewpager.setAdapter(adapter);
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for(String tabs_name:tabs )
		{
			actionbar.addTab(actionbar.newTab().setText(tabs_name).setTabListener(this));
		}
		
		viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			 
		    @Override
		    public void onPageSelected(int position) {
		        // on changing the page
		        // make respected tab selected
		        actionbar.setSelectedNavigationItem(position);
		    }
		 
		    @Override
		    public void onPageScrolled(int arg0, float arg1, int arg2) {
		    }
		 
		    @Override
		    public void onPageScrollStateChanged(int arg0) {
		    }
		});
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewpager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab,FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
