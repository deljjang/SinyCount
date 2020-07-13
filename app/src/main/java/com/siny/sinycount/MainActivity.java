package com.siny.sinycount;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

	public int iDisplay = 0; //카운트 변수
    public int iDefaultColor; //기본색상 저장용 - 메뉴에서 색상처리시 사용

	//private  AdView adView;
	private static final String AD_UNIT_ID = "ca-app-pub-2974448175712096/9223994162";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

// adView를 만듭니다.
        
        //adView = new AdView(this);
        //adView = (AdView)this.findViewById(R.id.adView);
/*
        //adView.setAdSize(AdSize.BANNER);
        //adView.setAdUnitId(AD_UNIT_ID); //광고 단위 ID: ca-app-pub-2974448175712096/9223994162

        // 레이아웃에 adView를 추가합니다.        
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        //mainLayout.addView(adView,0);
        mainLayout.addView(adView);
*/
        // 기본 요청을 시작합니다.
        //AdRequest adRequest = new AdRequest.Builder()
        //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        //.addTestDevice(AD_UNIT_ID)        
        //.build();
                
        // 광고 요청으로 adView를 로드합니다.
        //adView.loadAd(adRequest);
		
		 //SharedPreferences 사용
        {
         //읽기
         SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
         iDisplay = p.getInt("iDisplay", 0);
         //iColor = p.getInt("iColor", iDefaultColor);
         
         //Log.d("Siny", "iColor="+iColor);
         Log.d("Siny", "iDisplay="+iDisplay);

         //초기값 처리
         TextView view =(TextView)findViewById(R.id.lb_text);
         view.setText(""+iDisplay);
         //view.setTextColor(iColor);
        }
        
		//버튼 이벤트 연결 - btn_reset
        final Button btn_reset=(Button)findViewById(R.id.btn_reset);
        registerForContextMenu(btn_reset); //컨텍스트(Context) 메뉴 사용을 위해등록
        btn_reset.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v) { 
             TextView view =(TextView)findViewById(R.id.lb_text);
             iDisplay = 0;
                view.setText(""+iDisplay);
            } 
        }); 

        //버튼 이벤트 연결 - btn_minus
        final Button btn_minus=(Button)findViewById(R.id.btn_minus);
        registerForContextMenu(btn_minus); //컨텍스트(Context) 메뉴 사용을 위해등록
        btn_minus.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v) { 
             TextView view =(TextView)findViewById(R.id.lb_text);
             iDisplay = iDisplay - 1;
                view.setText(""+iDisplay);
            } 
        }); 

        //버튼 이벤트 연결 - btn_plus
        final Button btn_plus=(Button)findViewById(R.id.btn_plus);
        registerForContextMenu(btn_minus); //컨텍스트(Context) 메뉴 사용을 위해등록
        btn_plus.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v) { 
             TextView view =(TextView)findViewById(R.id.lb_text);
             iDisplay = iDisplay + 1;
                view.setText(""+iDisplay);
            } 
        }); 
	}

	@Override 
    public void onDestroy() {
        //SharedPreferences 사용
        //변수 저장
		SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor e = p.edit();
        e.putInt("iDisplay", iDisplay);
        //e.putInt("iColor", iColor);
        e.commit();
        
        //Log.d("Siny", "iColor="+iColor);
        Log.d("Siny", "iDisplay="+iDisplay);
        Log.d("Siny", "onDestroy");

       	//adView.destroy();
        
        super.onDestroy();
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
