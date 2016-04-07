package com.example.testmenu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.example.adapter.CrimeAdapter;
import com.example.info.Crime;
import com.example.info.CrimeGet;
import com.example.info.CrimeList;
//���沼�ֲ�һ����Ҫд��xml�����ļ��У��ô���ķ�ʽ������ͼ�㼶�ṹ,������Ҫһ����ԴID
public class CrimePagerActivity  extends FragmentActivity{
     
	  private static final String TAG = null;
	  private   ViewPager  mViewPager;
	  private   CrimeAdapter   adapter;
	  private   List<Crime> crime = new ArrayList<Crime>();
	   @Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		init();
		
	}


	public  void init() {
		// TODO Auto-generated method stub
		  //  crime = new CrimeList().CrimeList2();
		      crime = CrimeGet.getCrimeget();
		    adapter = new CrimeAdapter(getSupportFragmentManager(), crime);
		    mViewPager.setAdapter(adapter);
		    UUID crimeID = (UUID)getIntent().getSerializableExtra("Crime_Id");
		 // Toast.makeText(getApplicationContext(), crimeID+"", 0).show();
		    for(int i = 0 ; i < crime.size(); i++){
		    	if(crime.get(i).getmId().equals(crimeID)){
		    		Log.i(TAG, crimeID+""+ "���");
		    		mViewPager.setCurrentItem(i);
		    		break;
		    	}
		    }
	}
	
	
}
