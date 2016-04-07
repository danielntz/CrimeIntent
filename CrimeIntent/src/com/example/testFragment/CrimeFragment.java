package com.example.testFragment;

import java.util.Date;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.info.Crime;
import com.example.info.CrimeGet;
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
	    private   Crime  crimeselect;
	    private   CheckBox  box;
	    private   EditText  title;
	 
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
          title = (EditText)view.findViewById(R.id.crime_name);
          box = (CheckBox)view.findViewById(R.id.crime_solve);
          //获得点击列表项的UUID
          UUID crimeid = (UUID)getArguments().getSerializable("Crime_Id");
        //获得当前点击列表项上的Crime信息
          for(int i= 0 ; i < CrimeGet.getCrimeget().size();i++) {
        	if(CrimeGet.getCrimeget().get(i).getmId().equals(crimeid)){
        		  crimeselect = CrimeGet.getCrimeget().get(i);
        		  break;
        	}
         }
          title.setText(crimeselect.getMmTitle());
          box.setChecked(crimeselect.ismSolved());
          buttondate.setText(crimeselect.getmDate().toString().replace("格林尼治标准时间", ""));
          //对编辑框编辑后，Crime集合要进行更改，根据UUID唯一标示符
          crimeselect.setMmTitle(title.getText().toString());   
          crimeselect.setmDate(new Date());
          crimeselect.setmSolved(box.isChecked());
          CrimeGet.setCrimeget(CrimeGet.getCrimeget());
          buttondate.setOnClickListener(this);
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

	 
	
	
}
