package com.neutobo.timelinesample;

import android.app.Application;

public class TimelineApp extends Application {
	private static TimelineApp  sInstance;
	public TimelineApp() {
		super();
		sInstance = this;
	}
	public static TimelineApp getInstance() {
		return sInstance;
	}

}
