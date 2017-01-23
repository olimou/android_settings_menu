package com.olimou.android.settings_menu;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by EmersonMoura on 9/6/16.
 */

public class SettingsDivider extends FrameLayout {

	private View mView;

	public SettingsDivider(Context context) {
		super(context);

		init(null);
	}

	public SettingsDivider(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(attrs);
	}

	public SettingsDivider(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		init(attrs);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingsDivider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);

		init(attrs);
	}

	public void init(AttributeSet _attrs) {
		mView = inflate(getContext(), R.layout.component_settings_divider, this);
	}
}
