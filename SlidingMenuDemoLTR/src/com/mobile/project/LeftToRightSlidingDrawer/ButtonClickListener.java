package com.mobile.project.LeftToRightSlidingDrawer;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ButtonClickListener implements OnClickListener{
	View app;
	
	public ButtonClickListener(View app){
		super();
		this.app=app;
	}
	
	@Override
	public void onClick(View v) {
		Context context = app.getContext();
		switch(v.getId()){
		case R.id.show_popup_button:
			Toast.makeText(context, "Unknown",Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn1:
			Toast.makeText(context, "Button1",Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn2:
			Toast.makeText(context, "Button2",Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn3:
			Toast.makeText(context, "Button3",Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn4:
			Toast.makeText(context, "Button4",Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn5:
			Toast.makeText(context, "Button5",Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
