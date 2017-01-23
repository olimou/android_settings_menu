package com.olimou.android.settings_menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import static com.olimou.android.settings_menu.R.styleable.SettingsButton_action_icon;
import static com.olimou.android.settings_menu.R.styleable.SettingsButton_icon;
import static com.olimou.android.settings_menu.R.styleable.SettingsButton_title;

/**
 * Created by EmersonMoura on 9/6/16.
 */

public class SettingsButton extends FrameLayout {
	private View mView;

	public SettingsButton(Context context) {
		super(context);

		init(null);
	}

	public SettingsButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(attrs);
	}

	public SettingsButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		init(attrs);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingsButton(Context context,
	                      AttributeSet attrs,
	                      int defStyleAttr,
	                      int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);

		init(attrs);
	}

	public void init(AttributeSet _attrs) {
		mView = inflate(getContext(), R.layout.component_settings_button, this);

		if (_attrs != null) {
			TypedArray a = getContext().getTheme()
					.obtainStyledAttributes(_attrs, R.styleable.SettingsButton, 0, 0);

			((AppCompatTextView) findViewById(R.id.txt_content))
					.setText(a.getString(SettingsButton_title));

			AppCompatImageView lImgViewIcon = (AppCompatImageView) findViewById(R.id.img_icon);

			lImgViewIcon.setImageResource(a.getResourceId(SettingsButton_icon,
					R.drawable.ic_android_black_24dp));

			AppCompatImageView lImgViewIconAction = (AppCompatImageView) findViewById(
					R.id.img_icon_action);

			lImgViewIconAction.setImageResource(a.getResourceId(SettingsButton_action_icon,
					R.drawable.ic_chevron_right_black_24dp));
		}
	}
}
