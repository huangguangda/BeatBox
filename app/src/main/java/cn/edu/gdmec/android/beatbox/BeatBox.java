package cn.edu.gdmec.android.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/11/19.
 */

public class BeatBox {
    //一个用于日志记录
    //一个用于存储声音资源文件目录名

    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    //创建播放文件SoundPool
    private static final int MAX_SOUNDS = 5;

    //访问assets需要用到assetmanager类
    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<> (  );
    //创建播放文件SoundPool
    private SoundPool mSoundPool;

    public BeatBox(Context context){
        mAssets = context.getAssets ();
        //创建播放文件SoundPool,new 实例化
        mSoundPool = new SoundPool ( MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0 );
        loadSounds();
    }

    //播放音频
    public void play(Sound sound){
        Integer soundId = sound.getSoundId ();
        if (soundId == null){
            return;
        }
        mSoundPool.play ( soundId, 1.0f, 1.0f, 1, 0, 1.0f );
    }

    //实现一个方法，调用它给出声音文件清单
    private void loadSounds(){
        String[] soundNames;
        try{
            soundNames = mAssets.list ( SOUNDS_FOLDER );
            Log.i (TAG, "Found" + soundNames.length + " sounds");
        }catch (IOException ioe){
            Log.e ( TAG, "Could not list assets", ioe );
            return;
        }
        //载入全部音频文件
        for (String filename : soundNames){
            try{
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound ( assetPath );
                load ( sound );
            mSounds.add ( sound );
        }catch (IOException ioe) {
                Log.e ( TAG, "Could not load sound " + filename, ioe );
            }
            }
    }

    //加载音频
    private void load(Sound sound) throws IOException{
        AssetFileDescriptor afd = mAssets.openFd ( sound.getAssetPath () );
        int soundId = mSoundPool.load ( afd, 1 );
        sound.setSoundId ( soundId );
    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
