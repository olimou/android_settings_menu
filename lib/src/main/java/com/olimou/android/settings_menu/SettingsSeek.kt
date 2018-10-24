package com.olimou.android.settings_menu

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import android.widget.SeekBar

/**
 * Created by EmersonMoura on 9/6/16.
 */

class SettingsSeek : ConstraintLayout {
    private lateinit var seekBar: SeekBar
    private var changeListener: SeekBar.OnSeekBarChangeListener? = null
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
        View.inflate(context, R.layout.component_settings_seek, this)

        seekBar = findViewById(R.id.seekBar)
        txtTitle = findViewById(R.id.txt_title)
        txtContent = findViewById(R.id.txt_content)

        if (_attrs != null) {
            val a = context.theme
                    .obtainStyledAttributes(_attrs, R.styleable.SettingsSeek, 0, 0)

            txtTitle.text = a.getString(R.styleable.SettingsSeek_title)

            txtContent.text = a.getString(R.styleable.SettingsSeek_text)
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
