package com.toutav.movie.core.basic.pages

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import androidx.viewbinding.ViewBinding

/**
 * ===============================================
 * 对于 AppCompatDialog 进行本地化的扩展&封装
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/1/16 17:16
 */
abstract class BasicDialog<VB: ViewBinding>(
    context: Context, theme: Int,
    private val inflate: (LayoutInflater) -> VB
): AppCompatDialog(context, theme) {

    /**
     * view binding refs.
     */
    protected lateinit var binding: VB

    constructor(context: Context, inflate: (LayoutInflater) -> VB) : this(context, 0, inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置内容视图
        setContentView(inflate(layoutInflater).also { binding = it }.root)
    }
}