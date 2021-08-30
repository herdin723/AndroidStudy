package com.herdin.android.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media2.common.MediaItem
import androidx.media2.common.MediaMetadata
import androidx.media2.common.SessionPlayer
import androidx.media2.player.MediaPlayer
import androidx.media2.session.MediaController
import com.herdin.android.base.activty.BaseActivity
import com.herdin.android.base.vm.BaseViewModel
import com.herdin.android.player.databinding.PlayerActivityMainBinding

class MainActivity : BaseActivity<PlayerActivityMainBinding, BaseViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.player_activity_main
    }

    override fun initView() {
//        val player = MediaPlayer(this)
//        var mutableListOf = mutableListOf<MediaItem>()
//        var mediaItem = MediaItem.Builder()
//        player.setPlaylist(mutableListOf,null)
//        player.play()
////        var mediaController = MediaController()
////        mBinding.videoView.setMediaController(mediaController)
//        mBinding.videoView.setPlayer(player)
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