package com.olimou.android.settings_menu

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class SettingsButton @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    init {
        View.inflate(this.context, R.layout.component_settings_button, this)

        if (attrs != null) {
            val typedArray = this.context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.SettingsButton,
                    0,
                    0
            )

            val txtContent = findViewById<View>(R.id.txt_content) as AppCompatTextView
            txtContent.text = typedArray.getString(R.styleable.SettingsButton_title)

            val imgIcon: AppCompatImageView = findViewById(R.id.img_icon)
            imgIcon.setImageResource(typedArray.getResourceId(
                    R.styleable.SettingsButton_icon,
                    R.drawable.ic_android_black_24dp
            ))

            val imgIconAction: AppCompatImageView = findViewById(R.id.img_icon_action)
            imgIconAction.setImageResource(typedArray.getResourceId(
                    R.styleable.SettingsButton_action_icon,
                    R.drawable.ic_chevron_right_black_24dp
            ))
        }
    }
}