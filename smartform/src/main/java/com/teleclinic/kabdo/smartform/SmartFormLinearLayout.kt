package com.teleclinic.kabdo.smartform

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.pawegio.kandroid.views
import com.teleclinic.kabdo.smartmaterialedittext.CustomViews.SmartEditText

/**
 * Created by karimabdo on 12/22/17.
 */
class SmartFormLinearLayout : LinearLayout {

    constructor(context: Context) : super(context) {
        init(context, null, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, null)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int?) {
    }

    fun check(): Boolean {
        var flag = true
        var firstError: View? = null
        views.forEach {
            when (it) {
                is SmartCheckBox -> flag = it.check() && flag
                is SmartEditText -> flag = it.check() && flag
                else -> {
                }
            }
            if (!flag && firstError == null) {
                firstError = it
            }
        }
        firstError?.requestFocus()
        return flag
    }
}