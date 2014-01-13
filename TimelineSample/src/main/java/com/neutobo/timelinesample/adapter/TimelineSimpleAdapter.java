package com.neutobo.timelinesample.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.neutobo.timelinesample.R;
import com.neutobo.timelinesample.view.TimelineImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link android.widget.BaseAdapter} that simulates data for the Gallery to work.
 * Uses ViewHolder pattern of course :)
 */
public class TimelineSimpleAdapter extends BaseAdapter {
	public static final int NUMBER_OF_GALLERY_ITEMS = 50;
	private List<String> mList;
	private Context mContext;
	public TimelineSimpleAdapter(final Context context) {
		mContext = context;
		Picasso.with(mContext).setDebugging(true);// to see where the images are coming from ;)
		simulateDataFill();
	}
	private void simulateDataFill() {
		if (mList == null) {
			mList = new ArrayList<String>();
		}
		for (int i = 0; i < NUMBER_OF_GALLERY_ITEMS; i++) {
			// Make sure these images work :p I randomly Googled android logo
			if (i % 2 == 0) {
				mList.add("http://digitizor.com/wp-content/uploads/2012/09/android-logo.jpg");
			} else {
				mList.add("http://blog.smartphoneslab.com/wp-content/uploads/2010/12/android-logo.png");
			}
		}
	}
	@Override
	public int getCount() {
		if (mList != null) {
			return mList.size();
		}
		return 0;
	}
	@Override
	public Object getItem(final int position) {
		if (mList != null) {
			return mList.get(position);
		} else {
			return 0;
		}
	}
	@Override
	public long getItemId(final int position) {
		//we only have strings so our "id" is their position.
		return position;
	}
	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			view = inflater.inflate(R.layout.timeline_item, null, false);
			holder = new ViewHolder();
			if (view != null) {
				holder.imageView = (TimelineImageView) view.findViewById(R.id.home_timeline_iv);
				view.setTag(holder);
			}
		} else {
			holder = (ViewHolder) view.getTag();
		}
		String string = mList.get(position);
		if (string != null) {
			Picasso.with(mContext.getApplicationContext()).load(string).fit().into(holder.imageView);
		}
		return view;
	}
	public void setContext(final Context context) {
		mContext = context;
	}
	class ViewHolder {
		TimelineImageView imageView;
	}
}
