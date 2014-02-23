package com.example.tabswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.view_pager.*;

public class TabsPagerAdapter extends FragmentPagerAdapter{
	public TabsPagerAdapter(android.support.v4.app.FragmentManager fragmentManager)
	{
		super(fragmentManager);
	}

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		switch(index)	
		{
			case 0:
				return new NewOffer();
			case 1:
				return new Trending(); 
			case 2: 
				return new MallyChoice();
				
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	
	

}
