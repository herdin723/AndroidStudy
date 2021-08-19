package com.herdin.android.base.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/


//通过属性委托的方式创建，这样只要是Context中就能用到
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data")

object DataStoreUtil {
    /**
     * 保存数据
     * */
    suspend fun <T : Any> put(context: Context, key: String, value: T) {
        context.dataStore.edit { setting ->
            when (value) {
                is Int -> setting[intPreferencesKey(key)] = value
                is Long -> setting[longPreferencesKey(key)] = value
                is Double -> setting[doublePreferencesKey(key)] = value
                is Float -> setting[floatPreferencesKey(key)] = value
                is Boolean -> setting[booleanPreferencesKey(key)] = value
                is String -> setting[stringPreferencesKey(key)] = value
                else -> throw IllegalArgumentException("This type can be saved into DataStore")
            }
        }
    }
    /**
     * 获取数据
     * */
    suspend inline fun < reified T : Any> get(context: Context, key: String): T {
        return  when (T::class) {
            Int::class -> {
                context.dataStore.data.map { setting ->
                    setting[intPreferencesKey(key)] ?: 0
                }.first() as T
            }
            Long::class -> {
                context.dataStore.data.map { setting ->
                    setting[longPreferencesKey(key)] ?: 0L
                }.first() as T
            }
            Double::class -> {
                context.dataStore.data.map { setting ->
                    setting[doublePreferencesKey(key)] ?:0.0
                }.first() as T
            }
            Float::class -> {
                context.dataStore.data.map { setting ->
                    setting[floatPreferencesKey(key)] ?:0f
                }.first() as T
            }
            Boolean::class -> {
                context.dataStore.data.map { setting ->
                    setting[booleanPreferencesKey(key)]?:false
                }.first() as T
            }
            String::class -> {
                context.dataStore.data.map { setting ->
                    setting[stringPreferencesKey(key)] ?: ""
                }.first() as T
            }
            else -> {
                throw IllegalArgumentException("This type can be get into DataStore")
            }
        }
    }
}