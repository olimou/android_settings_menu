package com.olimou.android.settings_menu

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class SettingsHeader @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    init {
        View.inflate(this.context, R.layout.component_settings_header, this)

        if (attrs != null) {
            val typedArray = this.context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.SettingsHeader,
                    0,
                    0
            )

            val txtTitle: AppCompatTextView = findViewById(R.id.txt_title)
            txtTitle.text = typedArray.getString(R.styleable.SettingsHeader_title)
        }
    }
}