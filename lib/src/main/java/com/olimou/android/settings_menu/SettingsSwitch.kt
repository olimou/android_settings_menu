package com.olimou.android.settings_menu

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.SwitchCompat
import android.util.AttributeSet
import android.view.View
import android.widget.CompoundButton

class SettingsSwitch @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private lateinit var btnSwitch: SwitchCompat
    private var listener: CompoundButton.OnCheckedChangeListener? = null
    private lateinit var txtContent: AppCompatTextView
    private lateinit var txtTitle: AppCompatTextView

    init {
        View.inflate(this.context, R.layout.component_settings_switch, this)

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
            val typedArray = this.context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.SettingsSwitch,
                    0,
                    0
            )

            txtTitle.text = typedArray.getString(R.styleable.SettingsSwitch_title)

            txtContent.text = typedArray.getString(R.styleable.SettingsSwitch_text)
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
