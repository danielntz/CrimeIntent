package com.example.testFragment;

import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testmenu.R;

public class CrimeFragment  extends Fragment implements android.view.View.OnClickListener  { 
       
	    private static final String DIALOG_DATE = "date";
		private   Button   buttondate;
	    private   Date  mDate;   
	 
	    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
        View   view  =  inflater.inflate(R.layout.crime, container, false);
          buttondate =(Button) view.findViewById(R.id.crime_date);
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
