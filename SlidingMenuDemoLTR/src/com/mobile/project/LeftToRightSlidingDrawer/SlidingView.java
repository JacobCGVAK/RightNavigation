package com.mobile.project.LeftToRightSlidingDrawer;

import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mobile.project.LeftToRightSlidingDrawer.MyHorizontalScrollView.SizeCallback;



/**
 * This demo uses a custom HorizontalScrollView that ignores touch events, and therefore does NOT allow manual scrolling.
 * 
 * The only scrolling allowed is scrolling in code triggered by the menu button.
 * 
 * When the button is pressed, both the menu and the app will scroll. So the menu isn't revealed from beneath the app, it
 * adjoins the app and moves with the app.
 */
public class SlidingView extends Activity {
    MyHorizontalScrollView scrollView;
    View menu;
    View app;
    View menu1;
    ImageView btnSlide;
    LinearLayout mRightNavigation;
    
    static LinearLayout mHome,mZpay,mGiftcards,mMyFavourites,mMyFriends,mChat,mRewards,mSettings,mLogout;
    //Button btnSlide,mUnknown,mBtn1,mBtn2,mBtn3,mBtn4,mBtn5;
    boolean menuOut = false;
    //Handler handler = new Handler();
    int btnWidth;
    public static String TAG = "SlidingView";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = LayoutInflater.from(this);
        scrollView = (MyHorizontalScrollView) inflater.inflate(R.layout.horz_scroll_with_list_menu, null);
        setContentView(scrollView);

        menu = inflater.inflate(R.layout.horz_scroll_menu, null);
        menu1 = inflater.inflate(R.layout.horz_scroll_menu, null);
        app = inflater.inflate(R.layout.horz_scroll_app, null);
        ViewGroup tabBar = (ViewGroup) app.findViewById(R.id.tabBar);
        ViewGroup menuItems = (ViewGroup) menu.findViewById(R.id.menuitems);
        
        btnSlide = (ImageView) tabBar.findViewById(R.id.BtnSlide);
        btnSlide.setOnClickListener(new ClickListenerForScrolling(scrollView, menu, menu1, 1));
        
        mRightNavigation=(LinearLayout) app.findViewById(R.id.rightnavigation);
        mRightNavigation.setOnClickListener(new ClickListenerForScrolling(scrollView, menu, menu1, 2));
        
        final View[] children = new View[] { menu, app, menu1 };
        
        // Scroll to app (view[1]) when layout finished.
        int scrollToViewIdx = 1;
        scrollView.initViews(children, scrollToViewIdx, new SizeCallbackForMenu(btnSlide));
        
        mHome = (LinearLayout) menuItems.findViewById(R.id.home1);
        mZpay = (LinearLayout) menuItems.findViewById(R.id.zpay1);
        mGiftcards = (LinearLayout) menuItems.findViewById(R.id.giftcards1);
        mMyFavourites = (LinearLayout) menuItems.findViewById(R.id.myfavourites1);
        mMyFriends = (LinearLayout) menuItems.findViewById(R.id.myfriends1);
        mChat = (LinearLayout) menuItems.findViewById(R.id.talktous1);
        mRewards = (LinearLayout) menuItems.findViewById(R.id.rewards1);
        mSettings = (LinearLayout) menuItems.findViewById(R.id.settings1);
        mLogout = (LinearLayout) menuItems.findViewById(R.id.logout1);
        
        mHome.setOnClickListener(new MenuItemClickListener(menu,getApplicationContext()));
        

    }

    /**
     * Helper for examples with a HSV that should be scrolled by a menu View's width.
     */
    static class ClickListenerForScrolling implements OnClickListener {
        HorizontalScrollView scrollView;
        View menu,menu1;
        int navigationFlag;
        /**
         * Menu must NOT be out/shown to start with.
         */
        boolean menuOut = false;

        public ClickListenerForScrolling(HorizontalScrollView scrollView, View menu, View menu1,int navigationflag) {
            super();
            this.scrollView = scrollView;
            this.menu = menu;
            this.menu1 = menu1;
            this.navigationFlag=navigationflag;
        }

        @Override
        public void onClick(View v) {
            Context context = menu.getContext();
            String msg = "Slide " + new Date();
            //Toast.makeText(context, msg, 1000).show();
            System.out.println(msg);

            int menuWidth = menu.getMeasuredWidth();
            Log.i(TAG,"Menu Width : "+ menuWidth);

            // Ensure menu is visible
            menu.setVisibility(View.VISIBLE);

            if (!menuOut) {
            	int left = 0;
                // Scroll to 0 to reveal menu
            	Log.i(TAG,"1");
            	if(navigationFlag==1){
            		left = 0;
            	}else if(navigationFlag==2){
            		left = menuWidth+150;
            	}
                
                scrollView.smoothScrollTo(left, 0);
                
                mHome.setBackgroundResource(R.drawable.gradient_bg);
                mZpay.setBackgroundResource(R.drawable.gradient_bg);
				mGiftcards.setBackgroundResource(R.drawable.gradient_bg);
				mMyFavourites.setBackgroundResource(R.drawable.gradient_bg);
				mMyFriends.setBackgroundResource(R.drawable.gradient_bg);
				mChat.setBackgroundResource(R.drawable.gradient_bg);
				mRewards.setBackgroundResource(R.drawable.gradient_bg);
				mSettings.setBackgroundResource(R.drawable.gradient_bg);
				mLogout.setBackgroundResource(R.drawable.gradient_bg);
            } else {
                // Scroll to menuWidth so menu isn't on screen.
            	Log.i(TAG,"2");
                int left = menuWidth;
                scrollView.smoothScrollTo(left, 0);
                
                mHome.setBackgroundResource(R.drawable.gradient_bg);
                mZpay.setBackgroundResource(R.drawable.gradient_bg);
				mGiftcards.setBackgroundResource(R.drawable.gradient_bg);
				mMyFavourites.setBackgroundResource(R.drawable.gradient_bg);
				mMyFriends.setBackgroundResource(R.drawable.gradient_bg);
				mChat.setBackgroundResource(R.drawable.gradient_bg);
				mRewards.setBackgroundResource(R.drawable.gradient_bg);
				mSettings.setBackgroundResource(R.drawable.gradient_bg);
				mLogout.setBackgroundResource(R.drawable.gradient_bg);
            }
            menuOut = !menuOut;
            
            
        }
    }

    /**
     * Helper that remembers the width of the 'slide' button, so that the 'slide' button remains in view, even when the menu is
     * showing.
     */
    static class SizeCallbackForMenu implements SizeCallback {
        int btnWidth;
        View btnSlide;

        public SizeCallbackForMenu(View btnSlide) {
            super();
            this.btnSlide = btnSlide;
        }

        @Override
        public void onGlobalLayout() {
            //btnWidth = (int) (btnSlide.getMeasuredWidth()+15);
            btnWidth = (int) (btnSlide.getMeasuredWidth()-10);
            System.out.println("btnWidth=" + btnWidth);
        }

        @Override
        public void getViewSize(int idx, int w, int h, int[] dims) {
            dims[0] = w;
            dims[1] = h;
            final int menuIdx = 0;
            if (idx == menuIdx) {
                dims[0] = w - btnWidth;
            }
        }
    }
}