package com.toutav.movie.sup.cache

import com.blankj.utilcode.util.SPUtils

/**
 * ===============================================
 * <p> 首选项控制器 </p>
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/1/11 17:19
 */
object PreferenceControl {

    //region int action
    fun putInt(key: String, value: Int) {
        getPreferenceInstance().put(key, value)
    }

    fun putInt(model: String, key: String, value: Int) {
        getPreferenceInstance(model).put(key, value)
    }

    fun getInt(key: String, defaultValue: Int = -1): Int {
        return getPreferenceInstance().getInt(key, defaultValue)
    }

    fun getInt(model: String, key: String, defaultValue: Int = -1): Int {
        return getPreferenceInstance(model).getInt(key, defaultValue)
    }
    //endregion

    //region string action
    fun putString(key: String, value: String) {
        getPreferenceInstance().put(key, value)
    }

    fun putString(model: String, key: String, value: String) {
        getPreferenceInstance(model).put(key, value)
    }

    fun getString(key: String, defaultValue: String = ""): String {
        return getPreferenceInstance().getString(key, defaultValue)
    }

    fun getString(model: String, key: String, defaultValue: String = ""): String {
        return getPreferenceInstance(model).getString(key, defaultValue)
    }
    //endregion

    //region boolean action
    fun putBoolean(key: String, value: Boolean) {
        getPreferenceInstance().put(key, value)
    }

    fun putBoolean(model: String, key: String, value: Boolean) {
        getPreferenceInstance(model).put(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return getPreferenceInstance().getBoolean(key, defaultValue)
    }

    fun getBoolean(model: String, key: String, defaultValue: Boolean = false): Boolean {
        return getPreferenceInstance(model).getBoolean(key, defaultValue)
    }
    //endregion

    //region string set action
    fun putStringSet(key: String, value: Set<String>) {
        getPreferenceInstance().put(key, value)
    }

    fun putStringSet(model: String, key: String, value: Set<String>) {
        getPreferenceInstance(model).put(key, value)
    }

    fun getStringSet(key: String, defaultValue: Set<String> = HashSet()): Set<String> {
        return getPreferenceInstance().getStringSet(key, defaultValue)
    }

    fun getStringSet(model: String, key: String, defaultValue: Set<String> = HashSet()): Set<String> {
        return getPreferenceInstance(model).getStringSet(key, defaultValue)
    }
    //endregion

    //region float action
    fun putFloat(key: String, value: Float) {
        getPreferenceInstance().put(key, value)
    }

    fun putFloat(model: String, key: String, value: Float) {
        getPreferenceInstance(model).put(key, value)
    }

    fun getFloat(key: String, defaultValue: Float = -1.0f): Float {
        return getPreferenceInstance().getFloat(key, defaultValue)
    }

    fun getFloat(model: String, key: String, defaultValue: Float = -1.0f): Float {
        return getPreferenceInstance(model).getFloat(key, defaultValue)
    }
    //endregion

    /**
     * 缓存中全部的key值列表
     * @return key array...
     */
    fun clear(model: String? = null){
        getPreferenceInstance(model).clear()
    }

    fun removeValueForKey(key: String){
        getPreferenceInstance().remove(key)
    }

    fun removeValueForKey(model: String, key: String){
        getPreferenceInstance(model).remove(key)
    }

    /**
     * 获取首选项实例
     * @param model 首选项分类名称
     * @return 首选项操作实例
     */
    private fun getPreferenceInstance(model: String? = null): SPUtils {
        return if (model == null) SPUtils.getInstance() else SPUtils.getInstance(model)
    }
}