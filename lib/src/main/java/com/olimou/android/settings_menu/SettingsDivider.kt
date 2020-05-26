package com.olimou.android.settings_menu

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class SettingsDivider @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    init {
        View.inflate(this.context, R.layout.component_settings_divider, this)
    }
}