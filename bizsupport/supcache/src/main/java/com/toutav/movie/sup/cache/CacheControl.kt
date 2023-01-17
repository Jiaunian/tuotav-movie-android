package com.toutav.movie.sup.cache

import com.tencent.mmkv.MMKV
import java.util.Collections

/**
 * ===============================================
 * <p> 缓存控制器 </p>
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/1/11 17:20
 */
object CacheControl {

    //region int action
    fun putInt(key: String, value: Int) {
        getCacheInstance().putInt(key, value)
    }

    fun putInt(model: String, key: String, value: Int) {
        getCacheInstance(model).putInt(key, value)
    }

    fun getInt(key: String, defaultValue: Int = -1): Int {
        return getCacheInstance().getInt(key, defaultValue)
    }

    fun getInt(model: String, key: String, defaultValue: Int = -1): Int {
        return getCacheInstance(model).getInt(key, defaultValue)
    }
    //endregion

    //region string action
    fun putString(key: String, value: String) {
        getCacheInstance().putString(key, value)
    }

    fun putString(model: String, key: String, value: String) {
        getCacheInstance(model).putString(key, value)
    }

    fun getString(key: String, defaultValue: String?): String? {
        return getCacheInstance().getString(key, defaultValue)
    }

    fun getString(model: String, key: String, defaultValue: String?): String? {
        return getCacheInstance(model).getString(key, defaultValue)
    }
    //endregion

    //region boolean action
    fun putBoolean(key: String, value: Boolean) {
        getCacheInstance().putBoolean(key, value)
    }

    fun putBoolean(model: String, key: String, value: Boolean) {
        getCacheInstance(model).putBoolean(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return getCacheInstance().getBoolean(key, defaultValue)
    }

    fun getBoolean(model: String, key: String, defaultValue: Boolean = false): Boolean {
        return getCacheInstance(model).getBoolean(key, defaultValue)
    }
    //endregion

    //region string set action
    fun putStringSet(key: String, value: Set<String>) {
        getCacheInstance().putStringSet(key, value)
    }

    fun putStringSet(model: String, key: String, value: Set<String>) {
        getCacheInstance(model).putStringSet(key, value)
    }

    fun getStringSet(key: String, defaultValue: Set<String>?): Set<String>? {
        return getCacheInstance().getStringSet(key, defaultValue)
    }

    fun getStringSet(model: String, key: String, defaultValue: Set<String>?): Set<String>? {
        return getCacheInstance(model).getStringSet(key, defaultValue)
    }
    //endregion

    //region float action
    fun putFloat(key: String, value: Float) {
        getCacheInstance().putFloat(key, value)
    }

    fun putFloat(model: String, key: String, value: Float) {
        getCacheInstance(model).putFloat(key, value)
    }

    fun getFloat(key: String, defaultValue: Float = -1.0f): Float {
        return getCacheInstance().getFloat(key, defaultValue)
    }

    fun getFloat(model: String, key: String, defaultValue: Float = -1.0f): Float {
        return getCacheInstance(model).getFloat(key, defaultValue)
    }
    //endregion

    fun removeValueForKey(key: String){
        getCacheInstance().removeValueForKey(key)
    }

    fun removeValueForKey(model: String, key: String){
        getCacheInstance(model).removeValueForKey(key)
    }

    fun removeValueForKeys(keys: Array<String>){
        getCacheInstance().removeValuesForKeys(keys)
    }

    fun removeValueForKeys(model: String, keys: Array<String>){
        getCacheInstance(model).removeValuesForKeys(keys)
    }

    /**
     * 缓存中全部的key值列表
     * @return key array...
     */
    fun allKeys(model: String? = null): Array<String>{
        return getCacheInstance(model).allKeys() ?: emptyArray()
    }

    /**
     * 缓存中全部的key值列表
     * @return key array...
     */
    fun getAll(model: String? = null): Map<String, *>{
        return getCacheInstance(model).all
    }

    /**
     * 缓存中全部的key值列表
     * @return key array...
     */
    fun clear(model: String? = null){
        getCacheInstance(model).clearAll()
    }

    /**
     * 获取缓存实例
     * @param model 缓存实例名称
     * @return 缓存实例
     */
    private fun getCacheInstance(model: String? = null): MMKV {
        return if (model == null) MMKV.defaultMMKV() else MMKV.mmkvWithID(model)
    }
}