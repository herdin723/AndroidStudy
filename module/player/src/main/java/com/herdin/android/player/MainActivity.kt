package com.herdin.android.player

import androidx.media2.player.MediaPlayer
import androidx.media2.widget.VideoView
import com.herdin.android.base.activty.BaseActivity
import com.herdin.android.base.vm.BaseViewModel
import com.herdin.android.player.databinding.PlayerActivityMainBinding
import com.herdin.android.player.widget.control.DanmakuControlView
import com.herdin.android.player.widget.control.NormalControlView
import com.herdin.android.player.widget.control.PlayerControlView
import com.herdin.android.player.widget.control.StandardControlView

class MainActivity : BaseActivity<PlayerActivityMainBinding, BaseViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.player_activity_main
    }

    override fun initView() {
        var videoView = VideoView(this)
        videoView.setMediaController(MediaController())
        val player = MediaPlayer(this)
        var mutableListOf = mutableListOf<MediaItem>()
        var mediaItem = MediaItem.Builder()
        player.setPlaylist(mutableListOf,null)
        player.play()
        var mediaController = MediaController()
        mBinding.videoView.setMediaController(mediaController)
        mBinding.videoView.setPlayer(player)
        mBinding.playerView.setControlView(
            StandardControlView(this)
        )
    }

    override fun initData() {

    }

    override fun initObservable() {

    }

//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        Log.d("PlayerControlView", "activity onTouchEvent: "+event.action)
//        return super.onTouchEvent(event)
//    }
}