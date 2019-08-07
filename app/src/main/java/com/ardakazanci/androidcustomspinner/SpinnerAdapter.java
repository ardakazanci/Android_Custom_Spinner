package com.ardakazanci.androidcustomspinner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

	private Activity activity;
	private List<String> spinnerItemList;
	private LayoutInflater layoutInflater;

	/**
	 *
	 * @param activity : Context
	 * @param spinnerItemList : Spinner Item Data
	 */
	public SpinnerAdapter(Activity activity, List<String> spinnerItemList) {
		this.activity = activity;
		this.spinnerItemList = spinnerItemList;
		this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/**
	 *
	 * @return Item size
	 */
	@Override
	public int getCount() {
		return spinnerItemList.size();
	}

	/**
	 *
	 * @param position : Item position
	 * @return : Item
	 */
	@Override
	public Object getItem(int position) {
		return position;
	}

	/**
	 *
	 * @param position : Spinner Item Id
	 * @return : Spinner Item position.
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}


	// View görünümü şişiriliyor.
	// Şişirilen view görünümüne ilgili pozisyonda ki veri aktarılıyor.
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (convertView == null)
			view = layoutInflater.inflate(R.layout.spinner_item, null);
		TextView textView = view.findViewById(R.id.spinner_item);
		textView.setText(spinnerItemList.get(position));
		return view;
	}

	 /*
		Spinner 'ın tasarım konsepti ele alınıyor.
	 */
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		//return super.getDropDownView(position, convertView, parent);
		View view = super.getDropDownView(position, convertView, parent);
		LinearLayout ly = (LinearLayout) view;
		TextView tv = view.findViewById(R.id.spinner_item);
		tv.setGravity(Gravity.LEFT);
		tv.setTextColor(Color.parseColor("#333639"));
		tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		return view;

	}
}
