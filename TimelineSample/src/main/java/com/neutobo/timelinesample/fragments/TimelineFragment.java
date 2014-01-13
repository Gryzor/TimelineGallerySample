package com.neutobo.timelinesample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.neutobo.timelinesample.R;
import com.neutobo.timelinesample.TimelineApp;
import com.neutobo.timelinesample.adapter.TimelineSimpleAdapter;
import com.neutobo.timelinesample.view.TimelineGallery;
import com.neutobo.timelinesample.view.TimelineGalleryAdapterView;
import uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.DefaultHeaderTransformer;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * Just a sample Fragment demonstrating the usage of the TimelineGallery,
 * Perks:
 * - Picasso (https://github.com/square/picasso )
 * - PullToRefresh (https://github.com/chrisbanes/ActionBar-PullToRefresh)
 */
public class TimelineFragment extends Fragment implements OnRefreshListener {
	private static Context sContext;
	private TimelineSimpleAdapter mAdapter;
	private TextView mText;
	private PullToRefreshLayout mPullToRefreshLayout;
	private TimelineGallery mTimelineGallery;
	public static TimelineFragment newInstance(Context context) {
		if (context != null) {
			sContext = context.getApplicationContext();
		} else {
			sContext = TimelineApp.getInstance().getApplicationContext();
		}
		return new TimelineFragment();
	}
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}
	@Override
	public void onResume() {
		super.onResume();
		init();
		mAdapter.setContext(getActivity());
	}
	@Override
	public void onPause() {
		super.onPause();
		//don't leak
		mAdapter.setContext(null);
	}
	private void init() {
		if (mAdapter == null) {
			mAdapter = new TimelineSimpleAdapter(getActivity());
		}
	}
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container, false);
	}
	@Override
	public void onViewCreated(final View view, final Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		// PullToRefreshLayout Setup (https://github.com/chrisbanes/ActionBar-PullToRefresh/wiki/QuickStart-ABC)
		mPullToRefreshLayout = (PullToRefreshLayout) view.findViewById(R.id.ptr_layout);
		ActionBarPullToRefresh.from(getActivity())
				.allChildrenArePullable()
				.listener(this)
				.setup(mPullToRefreshLayout);
		((DefaultHeaderTransformer) mPullToRefreshLayout.getHeaderTransformer()).setPullText(getText(R.string.go_to_beginning));
		((DefaultHeaderTransformer) mPullToRefreshLayout.getHeaderTransformer()).setRefreshingText(getText(R.string.go_to_beginning));
		((DefaultHeaderTransformer) mPullToRefreshLayout.getHeaderTransformer()).setReleaseText(getText(R.string.go_to_beginning));
		//Gallery!
		mTimelineGallery = (TimelineGallery) view.findViewById(R.id.timeline_gallery);
		//configure some values for the LOLZ
		mTimelineGallery.setUnselectedAlpha(1F);
		mTimelineGallery.setSpacing(50);
		mTimelineGallery.setCallbackDuringFling(true);//default value
		mTimelineGallery.setCallbackOnUnselectedItemClick(false);
		mTimelineGallery.setOnItemClickListener(new TimelineGalleryAdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(final TimelineGalleryAdapterView<?> parent, final View view, final int position, final long id) {
				Toast.makeText(sContext, String.format(getString(R.string.you_tapped), mAdapter.getItem(position)), Toast.LENGTH_SHORT).show();
			}
		});
		mText = (TextView) view.findViewById(R.id.timeline_title_tv);
		mTimelineGallery.setOnItemSelectedListener(new TimelineGalleryAdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(final TimelineGalleryAdapterView<?> parent, final View view, final int position, final long id) {
				mText.setText(mAdapter.getItem(position).toString());
			}
			@Override
			public void onNothingSelected(final TimelineGalleryAdapterView<?> parent) {
			}
		});
		mTimelineGallery.setAdapter(mAdapter);
	}
	@Override
	public void onRefreshStarted(final View view) {
		// When pull to refresh is executed, go to position 0, smoooootthhhllyyy :)
		// WARNING: under some conditions, this may crash the gallery, I have yet to find a way to catch this.
		// The best move is to NOT use this Gallery and just use a ViewPager.
		mTimelineGallery.smoothScrollTo(0);
		mPullToRefreshLayout.setRefreshComplete();
	}
}
