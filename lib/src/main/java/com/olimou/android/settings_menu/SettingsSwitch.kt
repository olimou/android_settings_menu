package com.olimou.android.settings_menu

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.SwitchCompat
import android.util.AttributeSet
import android.view.View
import android.widget.CompoundButton

/**
 * Created by EmersonMoura on 9/6/16.
 */

class SettingsSwitch : ConstraintLayout {

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

    fun init(_attrs: AttributeSet?) {
        View.inflate(context, R.layout.component_settings_switch, this)

        btnSwitch = findViewById(R.id.btn_switch)
        txtTitle = findViewById(R.id.txt_title)
        txtContent = findViewById(R.id.txt_content)

        if (!isInEditMode) {
            setOnClickListener { btnSwitch.isChecked = !btnSwitch.isChecked }
        }

        if (_attrs != null) {
            val a = context.theme
                    .obtainStyledAttributes(_attrs, R.styleable.SettingsSwitch, 0, 0)

            txtTitle.text = a.getString(R.styleable.SettingsSwitch_title)

            txtContent.text = a.getString(R.styleable.SettingsSwitch_text)
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

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        (0 until this.childCount).forEach {
            getChildAt(it)?.isEnabled = enabled
        }
    }
}
