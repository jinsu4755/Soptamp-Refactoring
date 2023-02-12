package org.sopt.android.presentation

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import okio.use

class ContentUri constructor(
    context: Context,
    private val uri: Uri
) {
    val contentResolver: ContentResolver = context.contentResolver
    private var fileName: String = ""
    private var size: Long = -1L

    init {
        contentResolver.query(
            uri,
            arrayOf(MediaStore.Images.Media.SIZE, MediaStore.Images.Media.DISPLAY_NAME),
            null,
            null,
            null
        )?.use { cursor ->
            if (cursor.moveToFirst()) {
                size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE))
                fileName =
                    cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME))
            }
        }
    }

    fun getFileName() = fileName

    fun contentLength() = size

    fun contentTypeString() = contentResolver.getType(uri)
}
