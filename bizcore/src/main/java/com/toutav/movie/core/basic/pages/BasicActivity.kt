package com.toutav.movie.core.basic.pages

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * ===============================================
 * 对于 AppCompatActivity 进行本地化的扩展&封装
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/1/16 16:44
 */
abstract class BasicActivity<VB: ViewBinding>(
    private val inflate: (LayoutInflater) -> VB
): AppCompatActivity() {

    /**
     * view binding refs.
     */
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置内容视图.
        setContentView(inflate(layoutInflater).also { binding = it }.root)
    }
}