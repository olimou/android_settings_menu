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

    fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.component_settings_switch, this)

        btnSwitch = findViewById(R.id.btn_switch)
        btnSwitch.isClickable = false
        txtTitle = findViewById(R.id.txt_title)
        txtContent = findViewById(R.id.txt_content)

        if (!isInEditMode) {
            setOnClickListener {
                btnSwitch.isChecked = !btnSwitch.isChecked
                listener?.onCheckedChanged(btnSwitch, btnSwitch.isChecked)
            }
        }

        if (attrs != null) {
            val a = context.theme
                    .obtainStyledAttributes(attrs, R.styleable.SettingsSwitch, 0, 0)

            txtTitle.text = a.getString(R.styleable.SettingsSwitch_SB_title)

            txtContent.text = a.getString(R.styleable.SettingsSwitch_SB_content)
        }
    }

    fun invert() {
        checked = !checked
    }

    var checked: Boolean
        get() = btnSwitch.isChecked
        set(checked) {
            btnSwitch.isChecked = checked
        }

    fun setOnCheckedChangeListener(checkedChangeListener: CompoundButton.OnCheckedChangeListener) {
        listener = checkedChangeListener
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        (0 until this.childCount).forEach {
            getChildAt(it)?.isEnabled = enabled
        }
    }
}
