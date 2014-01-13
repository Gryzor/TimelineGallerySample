package com.neutobo.timelinesample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * A special {@link android.widget.ImageView} that doesn't do anything during requestLayout
 * (source/credit: http://stackoverflow.com/a/6773241/2684)
 * This is needed for the com.neutobo.timelinesample.view.TimelineGallery so it doesn't request a layout when the image is loaded.
 */
public class TimelineImageView extends ImageView {
	public TimelineImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	public TimelineImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public TimelineImageView(Context context) {
		super(context);
	}
	@Override
	public void requestLayout() {
		// do nothing - for this to work well this image view should have its dims set explicitly
	}
}

