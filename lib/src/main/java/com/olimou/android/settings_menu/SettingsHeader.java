package com.olimou.android.settings_menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import static com.olimou.android.settings_menu.R.styleable.SettingsHeader_title;

/**
 * Created by EmersonMoura on 9/6/16.
 */

public class SettingsHeader extends FrameLayout {

	private View mView;

	public SettingsHeader(Context context) {
		super(context);

		init(null);
	}

	public SettingsHeader(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(attrs);
	}

	public SettingsHeader(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		init(attrs);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingsHeader(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);

		init(attrs);
	}

	public void init(AttributeSet _attrs) {
		mView = inflate(getContext(), R.layout.component_settings_header, this);

		if (_attrs != null) {
			TypedArray a = getContext().getTheme()
					.obtainStyledAttributes(_attrs, R.styleable.SettingsHeader, 0, 0);

			AppCompatTextView lTxtTitle = (AppCompatTextView) findViewById(R.id.txt_title);

			lTxtTitle.setText(a.getString(SettingsHeader_title));
		}
	}
}
