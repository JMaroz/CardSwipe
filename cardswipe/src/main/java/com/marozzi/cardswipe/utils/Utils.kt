package com.marozzi.requestactions.utils

import android.content.ContentResolver
import android.content.res.Resources
import android.net.Uri
import android.text.TextUtils
import android.view.View
import android.view.ViewTreeObserver

/**
 * Created by amarozzi on 10/01/18.
 */
class Utils {

    companion object {

        fun isLocalResource(uriString: String?): Boolean {
            return !TextUtils.isEmpty(uriString) && uriString!!.contains("android.resource://")
        }

        fun getResourceUri(res: Resources, resId: Int): Uri {
            return Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(res.getResourcePackageName(resId))
                    .appendPath(res.getResourceTypeName(resId))
                    .appendPath(res.getResourceEntryName(resId))
                    .build()
        }
    }
}