package com.olimou.android.settings_menu

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import android.widget.SeekBar

class SettingsSeek @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var seekBar: SeekBar
    private var changeListener: SeekBar.OnSeekBarChangeListener? = null
    private var txtContent: AppCompatTextView
    private var txtTitle: AppCompatTextView

    init {
        View.inflate(this.context, R.layout.component_settings_seek, this)

        seekBar = findViewById(R.id.seekBar)
        txtTitle = findViewById(R.id.txt_title)
        txtContent = findViewById(R.id.txt_content)

        if (attrs != null) {
            val typedArray = this.context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.SettingsSeek,
                    0,
                    0
            )

            txtTitle.text = typedArray.getString(R.styleable.SettingsSeek_title)

            txtContent.text = typedArray.getString(R.styleable.SettingsSeek_text)
        }
    }

    var seekProgress: Int
        get() = seekBar.progress
        set(progress) {
            seekBar.setOnSeekBarChangeListener(null)
            seekBar.progress = progress
            seekBar.setOnSeekBarChangeListener(changeListener)
        }

    fun setOnProgressChangeListener(_change: SeekBar.OnSeekBarChangeListener) {
        seekBar.setOnSeekBarChangeListener(_change)
        changeListener = _change
    }
}
