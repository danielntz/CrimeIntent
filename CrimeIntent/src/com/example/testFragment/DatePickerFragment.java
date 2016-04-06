package com.example.testFragment;

import com.example.testmenu.R;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import android.view.View;
//碎片日期界面
public class DatePickerFragment   extends DialogFragment{
   
	 //采用AlertDialog.Builder类来弹出日期对话框
	
	        @Override
	        public Dialog onCreateDialog(Bundle savedInstanceState) {
	        	// TODO Auto-generated method stub
	        	View  v = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);
	        	return new android.app.AlertDialog.Builder(getActivity()).setView(v).setTitle("Date of time").setPositiveButton("OK	", null).create();
	        	
	        }	
	   
	
	
}
