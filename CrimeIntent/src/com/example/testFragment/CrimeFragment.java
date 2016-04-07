package com.example.testFragment;

import java.util.Date;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testmenu.R;
/**
 * 罪行编辑框
 * @author lenovo
 *
 */
public class CrimeFragment  extends Fragment implements android.view.View.OnClickListener  { 
       
	    private static final String DIALOG_DATE = "date";
		private static final String TAG = null;
		private   Button   buttondate;
	    private   Date  mDate;   
	 
	    public   static CrimeFragment newInstance(UUID crimeid){
	    	 Bundle bundle  = new Bundle();
	    	 bundle.putSerializable("Crime_Id", crimeid);
	    	 CrimeFragment fragment = new CrimeFragment();
	    	 fragment.setArguments(bundle);
	    	 return fragment;
	    }
	    
	    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
        View   view  =  inflater.inflate(R.layout.crime, container, false);
          buttondate =(Button) view.findViewById(R.id.crime_date);
          //获得点击列表项的UUID
          UUID crimeid = (UUID)getArguments().getSerializable("Crime_Id");
          Log.i(TAG, crimeid+"");
          buttondate.setOnClickListener( this);
      return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		  switch (v.getId()) {
		case R.id.crime_date:
			          FragmentManager fm = getActivity().getSupportFragmentManager();
			          DatePickerFragment   dialgo = new DatePickerFragment();
			          dialgo.show(fm, DIALOG_DATE);
		       	break;

		default:
			break;
		}
	}

	@Override
	public void onPause() {
	// TODO Auto-generated method stub
	
		
		super.onPause();
	
	}
	
	
}
