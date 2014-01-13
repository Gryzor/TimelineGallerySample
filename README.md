Timeline Gallery Sample
============================================

This Gallery is based upon EcoGallery which is in turn based upon the original Google's Gallery.
As such, it's not really a good idea to use this.

This version should crash less, should recycle views (thanks to [EcoGallery](https://github.com/falnatsheh/EcoGallery)) and can smoothly scroll around.

Take a look at the sample, there isn't really anything fancy going on here. 

As a Perk I have added two dependencies that I use very often.

* [Picasso](https://github.com/square/picasso): To load Images the right way.

* [PullToRefresh](https://github.com/chrisbanes/ActionBar-PullToRefresh): to scroll back to the beginning.

The app has been created in Android Studio using Gradle so adding the dependencies was just "a one liner". 

Use at your own risk, in fact I wouldn't really use Android Gallery, it's too buggy.

## Usage

If you want to use the gallery, you need to copy four files to your project, these files are located in the view package:

[com.neutobo.timelinesample.view](https://github.com/Gryzor/TimelineGallerySample/tree/master/TimelineSample/src/main/java/com/neutobo/timelinesample/view)

And the [Fragment layout](https://github.com/Gryzor/TimelineGallerySample/blob/master/TimelineSample/src/main/res/layout/fragment_main.xml) looks like this:

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                  xmlns:tools="http://schemas.android.com/tools"
                  android:layout_width="match_parent"
                  android:layout_height="match_parent"
                  android:paddingLeft="@dimen/activity_horizontal_margin"
                  android:paddingRight="@dimen/activity_horizontal_margin"
                  android:paddingTop="@dimen/activity_vertical_margin"
                  android:orientation="vertical"
                  android:paddingBottom="@dimen/activity_vertical_margin"
                  tools:context="com.neutobo.timelinesample.activities.MainActivity$PlaceholderFragment">
      <uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.PullToRefreshLayout
          android:id="@+id/ptr_layout"
          android:layout_width="match_parent"
          android:layout_height="match_parent">
        <ScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent">
          <RelativeLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:paddingLeft="@dimen/activity_horizontal_margin"
              android:paddingRight="@dimen/activity_horizontal_margin"
              android:paddingTop="@dimen/activity_vertical_margin"
              android:paddingBottom="@dimen/activity_vertical_margin">
            <com.neutobo.timelinesample.view.TimelineGallery
                android:id="@+id/timeline_gallery"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
            <TextView
                android:id="@+id/timeline_title_tv"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textAllCaps="true"
                android:singleLine="true"
                android:ellipsize="end"
                android:layout_centerHorizontal="true"
                android:textSize="16sp"
                android:textStyle="bold"
                android:layout_below="@id/timeline_gallery"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:layout_marginTop="15dp" />
          </RelativeLayout>
        </ScrollView>
      </uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.PullToRefreshLayout>
    </LinearLayout>


## License

    Copyright 2013 Martin Marconcini

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    
    
##Contact: 
Martin Marconcini - marconcini@gmail.com


