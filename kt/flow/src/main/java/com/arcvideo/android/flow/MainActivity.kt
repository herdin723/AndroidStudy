package com.arcvideo.android.flow

import android.app.Dialog
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.arcvideo.android.flow.databinding.FlowActivityMainBinding
import com.herdin.android.base.RouterPage
import com.herdin.android.base.activty.BaseActivity
import com.herdin.android.base.showToast
import com.herdin.android.base.vm.BaseViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

@Route(path = RouterPage.FLOW_MAIN)
class MainActivity : BaseActivity<FlowActivityMainBinding, BaseViewModel>() {


    private val TAG = "Flow" + MainActivity::class.java.simpleName


    private val mList = arrayListOf("1", "2", "3", "4", "5")

    override fun getLayoutId(): Int {
        return R.layout.flow_activity_main
    }

    override fun initView() {

    }

    override fun initData() {
        flowData12()
        flowData12()

    }

    override fun initObservable() {

    }
    /**
     * flowOn 线程切换 Dispatchers.IO 只有在flow里面的是IO线程
     */
    private fun flowOnData() {
        lifecycleScope.launch {
            Log.e(TAG, "flow:${Thread.currentThread()}")
            flow {
                Log.e(TAG, "emit start:${Thread.currentThread()}")
                emit("1")
                Log.e(TAG, "emit 1:${Thread.currentThread()}")
                emit("2")
                Log.e(TAG, "emit 2:${Thread.currentThread()}")
                emit("3")
                Log.e(TAG, "emit 3:${Thread.currentThread()}")
                emit("4")
                Log.e(TAG, "emit 4:${Thread.currentThread()}")
                emit("5")
                Log.e(TAG, "emit 5:${Thread.currentThread()}")
                emit("6")
                Log.e(TAG, "emit 6:${Thread.currentThread()}")
            }
                .flowOn(Dispatchers.IO)
                .onStart {
                    Log.e(TAG, "onStart:${Thread.currentThread()}")
                    showToast("开始")
                }
                .filter {
                    Log.e(TAG, "filter:${Thread.currentThread()}")
                    it != "2"
                }
                .map {
                    Log.e(TAG, "map:${Thread.currentThread()}")
                    "转换$it"
                }
                .transform<String,Int>{
                    Log.e(TAG, "transform1:${Thread.currentThread()}")
                    emit(  it.length)
                    Log.e(TAG, "transform2:${Thread.currentThread()}")
                }
//                .zip(f1) { a, b ->
//                    Log.e(TAG, "zip:${Thread.currentThread()}")
//                    "本流$a:其他流$b"
//                }

                .onCompletion {
                    Log.e(TAG, "onCompletion:${Thread.currentThread()}")
                    showToast("结束")
                }
                .catch {
                    Log.e(TAG, "catch:${Thread.currentThread()}")
                    showToast("异常")
                }
                .collect {
                    Log.e(TAG, "collect:${Thread.currentThread()}")
                    Log.e(TAG, "collect:${it}")

                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * 取消请求
     */
    private fun cancelData() {
        val job = lifecycleScope.launch {

            Log.e(TAG, "flow:${Thread.currentThread()}")
            flow {
                Log.e(TAG, "emit start:${Thread.currentThread()}")
                emit("1")
                Log.e(TAG, "emit 1:${Thread.currentThread()}")
                emit("2")
                Log.e(TAG, "emit 2:${Thread.currentThread()}")
                emit("3")
                Log.e(TAG, "emit 3:${Thread.currentThread()}")
                emit("4")
                Log.e(TAG, "emit 4:${Thread.currentThread()}")
                emit("5")
                Log.e(TAG, "emit 5:${Thread.currentThread()}")
                emit("6")
                Log.e(TAG, "emit 6:${Thread.currentThread()}")
            }
                .flowOn(Dispatchers.IO)
                .onStart {
                    Log.e(TAG, "onStart:${Thread.currentThread()}")
                    showToast("开始")
                }
                .onCompletion {
                    Log.e(TAG, "onCompletion:${Thread.currentThread()}")
                    showToast("结束")
                }
                .catch {
                    Log.e(TAG, "catch:${Thread.currentThread()}")
                    showToast("异常")
                }
                .collect {
                    Log.e(TAG, "collect:${Thread.currentThread()}")
                    Log.e(TAG, "collect:${it}")

                    mBinding.textView.text = it.toString()
                }
        }
        job.cancel()
    }
    /**
     * flow
     *  Flow 特性
     *  1. 冷流 (懒加载) 只有collect的时候 数据才会进行发射 创建时不会进行数据操作
     *  2. 有序 自上而下顺序传递
     *  3. 可取消
     */
    private fun flowData() {
        lifecycleScope.launch {
            //TODO Flow是冷数据，不消费则不生产，只有调用collect()函数时才会发射数据
            //SharedFlow则是热流，会立即发射数据
            //StateFlow是SharedFlow的一个特殊变种，SharedFlow是Flow的一种特殊类型
            //StateFlow与LiveData比较接近，都有stateFlow.value=value
            //StateFlow必须传入一个默认值，可以有多个观察者
            flow {
                //TODO 上游发射数据
                Log.e(TAG, "emit1: start")
                emit(1)

                Log.e(TAG, "emit2: start")
                emit(2)

                Log.e(TAG, "emit3: start")
                emit(3)

                Log.e(TAG, "emit: all end")
            }.onEach {
                delay(2000)
                Log.e(TAG, "onEach:$it ")
            }.collect {
                //TODO 下游接收数据
                Log.e(TAG, "collect: $it")
                mBinding.textView.text = "接收数据为：$it"
            }

//            TODO  末端操作符
//            集合类型转换操作:包括 toList、toSet 等。
//            聚合操作:包括将 Flow 规约到单值的 reduce、fold 等操作，
//                    以及获得单个元素的操作包括 single、singleOrNull、first 等。
//              toList 转List集合
//              toSet 转Set集合
//              first 取第一个值
//              single 确保流发射单个值
//              reduce 如果发射的是int 最终会得到一个int 可以累加操作
//              fold reduce拓展 可以自定义返回类
        }
    }

    /**
     * flowOf
     */
    private fun flowData1() {
        lifecycleScope.launch {
            //TODO 自动向下游发送数据 内部封装的还是原先的emit函数
            flowOf("1", "2", "3", "4", "5")
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = "接收数据为：$it"
                }
        }
    }

    /**
     * STATE
     * onStart         eg:显示对话框
     * catch           eg:显示错误UI
     * onCompletion    eg:隐藏对话框
     */
    private fun flowData2() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")

                    //catch
                    throw NullPointerException()
                }
                .onStart {
                    Log.e(TAG, "onStart: ")
                    showLoading("loading...")
                }
                .onCompletion {
                    Log.e(TAG, "onCompletion: ")
                    dismissLoading()
                }
                .catch {
                    Log.e(TAG, "catch: ")
                    mBinding.textView.text = "数据出错"
                }

                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = "接收数据为：$it"
                }
        }
    }

    /**
     * filter
     */
    private fun flowData3() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                .filter {
                    //TODO 数据过滤操作符
                    //只发送能被2整除的数据
                    Log.e(TAG, "filter: $it")
                    it.toInt() % 2 == 0
                }
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it
                }
        }
    }

    /**
     * filterNot
     */
    private fun flowData4() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                .filterNot {
                    //TODO 数据过滤操作符
                    //只发送不能被2整除的数据
                    Log.e(TAG, "filterNot: $it")
                    it.toInt() % 2 == 0
                }
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it
                }
        }
    }

    /**
     * transform 需主动发送数据
     */
    private fun flowData5() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
//            mList.asFlow()
            flow {
                //TODO 上游发射数据
                Log.e(TAG, "emit1: start")
                emit("1")

                Log.e(TAG, "emit2: start")
                emit("2")

                Log.e(TAG, "emit3: start")
                emit("3")

                Log.e(TAG, "emit: all end")
            }
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                .transform<String, Int> {
                    //TODO 转化操作符 转化完成后需主动发送数据
                    Log.e(TAG, "transform: $it")
                    val value = it.toInt() + 100
                    emit(value)
                }
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * map
     */
    private fun flowData6() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                .map {
                    //TODO 数据类型转换操作 内部实现transform
                    Log.e(TAG, "map: $it")
                    it.toInt() + 100
                }
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * take
     */
    private fun flowData7() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                //TODO 截取操作符，截取N位发射数据
                .take(2)
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * buffer
     */
    private fun flowData8() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            flow {
                //TODO 上游发射数据
                Log.e(TAG, "emit1: start")
                emit(1)

                Log.e(TAG, "emit2: start")
                emit(2)

                Log.e(TAG, "emit3: start")
                emit(3)

                Log.e(TAG, "emit: all end")
            }
                .onEach {
//                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                //TODO 背压：.buffer() 先emit all 再collect
//                .buffer()
                //TODO 背压：.buffer(0) 先emit 1和2 -> collect 1和2  再emit 3 -> collect 3
                .buffer(0)
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * conflate
     */
    private fun flowData9() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            flow {
                //TODO 上游发射数据
                for(i in 1..30) {
                    delay(100)
                    emit(i)
                }
            }
                //TODO 仅保留最新的值，无论上游发射多少数据，下游只会接收最新值
                .conflate()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }

                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * zip
     */
    private fun flowData10() {
        val flowOther = (101..110).asFlow()
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                //TODO 合并其他流，本流发射数 < 其他流的发射数时，合并完的次数为本流的次数
                .zip(flowOther){a,b->
                    "本流$a:其他流$b"
                }
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * combine
     */
    private fun flowData11() {
        val flowOther = (101..110).asFlow()
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                //TODO 组合流---  组合有点不规律
                .combine(flowOther){a,b->
                    "本流$a:其他流$b"
                }
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }


    /**
     *
     */
    private fun flowData12() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                //TODO  避免在单位时间内，快输入造成大量的请求
                .debounce(100)
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     * retry
     */
    private fun flowData13() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                .retry(100)
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

    /**
     *
     */
    private fun flowData14() {
        lifecycleScope.launch {
            //TODO List 转成 Flow
            mList.asFlow()
                .onEach {
                    delay(2000)
                    Log.e(TAG, "onEach: $it")
                }
                //  避免重复的搜索请求。假设正在搜索 dhl，用户删除了 l  然后输入 l。最后的结果还是 dhl。它就不会再执行搜索查询 dhl
                // distinctUntilChanged 对于 StateFlow 任何实例是没有效果的
                .distinctUntilChanged()
                .collect {
                    Log.e(TAG, "collect: $it")
                    mBinding.textView.text = it.toString()
                }
        }
    }

}