package kr.block.retrofitopenapi.global

import android.app.Application
import kr.block.retrofitopenapi.utils.DisplayUtils
import timber.log.Timber

class RoaApplication : Application() {
    init {
        Timber.plant(Timber.DebugTree())
        DisplayUtils.getInstance(this)
    }
}
