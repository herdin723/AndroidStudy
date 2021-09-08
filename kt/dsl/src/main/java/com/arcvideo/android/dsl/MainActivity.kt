package com.arcvideo.android.dsl

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.arcvideo.android.dsl.databinding.DslActivityMainBinding
import com.arcvideo.android.dsl.html.html
import com.herdin.android.base.RouterPage
import com.herdin.android.base.activty.BaseActivity
import com.herdin.android.base.showToast
import com.herdin.android.base.vm.BaseViewModel
import java.io.File

@Route(path = RouterPage.DSL_MAIN)
class MainActivity : BaseActivity<DslActivityMainBinding, BaseViewModel>() {

    private fun createHtml() {
        val names = listOf("张志强", "邵森森", "泰森")

        val result =

            html {
                //head中转站
                head {
                    //title中转站
                    title {
                        +"使用Kotlin进行HTML编码"
                    }
                }
                //body中转站
                body {
                    //h1中转站
                    h1 {
                        -"标题"
                    }
                    //p中转站
                    p {
                        -"此格式可用作HTML的替代标记"
                    }
                    //a中转站
                    a(href = "http://www.baidu.com") {
                        -"百度"
                    }
                    //p中转站
                    p {
                        -"老师来了"
                        //b中转站
                        b {
                            -"老师是谁？"
                        }
                        -"文本。有关更多信息，请参阅"
                        a(href = "http://www.sogo.com") {
                            -"搜狗"
                        }
                        -"项目"
                    }
                    //p中转站
                    p {
                        -"一些文字"
                    }
                    //p中转站
                    p {
                        -"命令行参数是:"
                        //ul中转站
                        ul {
                            for (name in names) {
                                //li中转站
                                li { -name }
                            }
                        }
                    }
                }
            }

        println(result.toString())
        val path = filesDir.absolutePath + "/MyHtml.html"
        val file = File(path)
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        file.writeText(result.toString())

        mBinding.webView.settings.allowFileAccess = true;// 设置允许访问文件数据
        mBinding.webView.loadUrl("file://$path")
    }

    override fun getLayoutId(): Int {
        return R.layout.dsl_activity_main
    }

    override fun initView() {
        requestMyPermissions()
    }

    override fun initData() {

    }

    override fun initObservable() {

    }

    private fun requestMyPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            //没有授权，编写申请权限代码
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                1000
            )
        } else {
            createHtml()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            for (i in permissions.indices) {
                if (grantResults[i] == 0) {
                    showToast("权限获取成功")
                    createHtml()
                } else {
                    showToast("权限被用户拒绝")
                }
            }
        }
    }
}