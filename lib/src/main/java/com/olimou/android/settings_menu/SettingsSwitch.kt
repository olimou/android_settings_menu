package com.olimou.android.settings_menu

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.SwitchCompat
import android.util.AttributeSet
import android.view.View
import android.widget.CompoundButton
import android.widget.FrameLayout
import com.olimou.android.settings_menu.R.styleable.SettingsSwitch_content
import com.olimou.android.settings_menu.R.styleable.SettingsSwitch_title

/**
 * Created by EmersonMoura on 9/6/16.
 */

class SettingsSwitch : FrameLayout {

    private lateinit var btnSwitch: SwitchCompat
    private var listener: CompoundButton.OnCheckedChangeListener? = null
    private lateinit var txtContent: AppCompatTextView
    private lateinit var txtTitle: AppCompatTextView

    constructor(context: Context) : super(context) {

        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
            defStyleAttr) {

        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
            context, attrs, defStyleAttr, defStyleRes) {

        init(attrs)
    }

    fun init(_attrs: AttributeSet?) {
        View.inflate(context, R.layout.component_settings_switch, this)

        btnSwitch = findViewById(R.id.btn_switch) as SwitchCompat
        txtTitle = findViewById(R.id.txt_title) as AppCompatTextView
        txtContent = findViewById(R.id.txt_content) as AppCompatTextView

        if (!isInEditMode) {
            setOnClickListener { btnSwitch.isChecked = !btnSwitch.isChecked }
        }

        if (_attrs != null) {
            val a = context.theme
                    .obtainStyledAttributes(_attrs, R.styleable.SettingsSwitch, 0, 0)

            txtTitle.text = a.getString(SettingsSwitch_title)

            txtContent.text = a.getString(SettingsSwitch_content)
        }
    }

    fun invert() {
        checked = !checked
    }

    var checked: Boolean
        get() = btnSwitch.isChecked
        set(_checked) {
            btnSwitch.setOnCheckedChangeListener(null)
            btnSwitch.isChecked = _checked
            btnSwitch.setOnCheckedChangeListener(listener)
        }

    fun setOnCheckedChangeListener(_change: CompoundButton.OnCheckedChangeListener) {
        listener = _change
        btnSwitch.setOnCheckedChangeListener(_change)
    }
}
