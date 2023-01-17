package com.toutav.movie.core.basic.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * ===============================================
 * 对于 Fragment 进行本地化的扩展&封装
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/1/16 16:58
 */
abstract class BasicFragment<VB: ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
): Fragment() {
    /**
     * view binding refs.
     */
    private var _binding: VB? = null
    protected val binding: VB = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 创建内容视图
        return inflate(inflater, container, false).also { _binding = it }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // 销毁 binding refs.
        _binding = null
    }
}