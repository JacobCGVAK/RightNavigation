package com.mobile.project.LeftToRightSlidingDrawer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.Toast;

public class MenuItemClickListener implements OnClickListener{

	View menuItem;
	Context mActivityContext;
	
	public MenuItemClickListener(View items,Context context){
		super();
		this.menuItem=items;
		this.mActivityContext=context;
	}

	@Override
	public void onClick(View v) {
		Context context = menuItem.getContext();
		
		switch(v.getId()){
		case R.id.home1:
			Toast.makeText(context, "Home",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			Intent intent = new Intent().setClass(mActivityContext.getApplicationContext(),newclass.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mActivityContext.startActivity(intent);
			
			break;
		case R.id.zpay1:
			Toast.makeText(context, "Z Pay",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		case R.id.giftcards1:
			Toast.makeText(context, "GiftCards",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		case R.id.myfavourites1:
			Toast.makeText(context, "My Favourites",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		case R.id.myfriends1:
			Toast.makeText(context, "My Friends",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		case R.id.talktous1:
			Toast.makeText(context, "Talk to us",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		case R.id.rewards1:
			Toast.makeText(context, "Rewards",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		case R.id.settings1:
			Toast.makeText(context, "Settings",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		case R.id.logout1:
			Toast.makeText(context, "Logout",Toast.LENGTH_SHORT).show();
			v.setBackgroundResource(R.drawable.gradient_bg_hover);
			break;
		}
	}
	
	
}
