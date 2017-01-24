package com.olimou.android.settings_menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

import static com.olimou.android.settings_menu.R.styleable.SettingsSwitch_content;
import static com.olimou.android.settings_menu.R.styleable.SettingsSwitch_title;

/**
 * Created by EmersonMoura on 9/6/16.
 */

public class SettingsSwitch extends FrameLayout {

	private SwitchCompat      btnSwitch;
	private AppCompatTextView txtContent;
	private AppCompatTextView txtTitle;

	public SettingsSwitch(Context context) {
		super(context);

		init(null);
	}

	public SettingsSwitch(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(attrs);
	}

	public SettingsSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		init(attrs);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingsSwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);

		init(attrs);
	}

	public void init(AttributeSet _attrs) {
		inflate(getContext(), R.layout.component_settings_switch, this);

		btnSwitch = (SwitchCompat) findViewById(R.id.btn_switch);
		txtTitle = (AppCompatTextView) findViewById(R.id.txt_title);
		txtContent = (AppCompatTextView) findViewById(R.id.txt_content);

		if (!isInEditMode()) {
			setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					btnSwitch.setChecked(!btnSwitch.isChecked());
				}
			});
		}

		if (_attrs != null) {
			TypedArray a = getContext().getTheme()
					.obtainStyledAttributes(_attrs, R.styleable.SettingsSwitch, 0, 0);

			txtTitle.setText(a.getString(SettingsSwitch_title));

			txtContent.setText(a.getString(SettingsSwitch_content));
		}
	}

	public boolean isChecked() {
		return btnSwitch.isChecked();
	}

	public void setChecked(boolean _checked) {
		btnSwitch.setChecked(_checked);
	}

	public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener _change) {
		btnSwitch.setOnCheckedChangeListener(_change);
	}
}
