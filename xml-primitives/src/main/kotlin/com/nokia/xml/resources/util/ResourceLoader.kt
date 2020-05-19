package com.nokia.xml.resources.util

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

interface ResourceLoader<T, out R: Any> {

    fun <T> load(source: T): R
}

class DefaultResourceLoader<T, R: InputStream>: ResourceLoader<T, InputStream> {

    override inline fun <T> load(source: T): InputStream {
        return when(source) {
            is Path -> {
                FileInputStream(source.toFile())
            }
            is String -> {
                FileInputStream(Paths.get(source).toFile())
            }
            is File -> {
                FileInputStream(Paths.get(source.toURI()).toFile())
            }
            else -> {
                throw RuntimeException()
            }
        }
    }
}
