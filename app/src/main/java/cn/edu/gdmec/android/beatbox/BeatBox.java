package cn.edu.gdmec.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
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

    //访问assets需要用到assetmanager类
    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<> (  );

    public BeatBox(Context context){
        mAssets = context.getAssets ();
        loadSounds();
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
        for (String filename : soundNames){
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound ( assetPath );
            mSounds.add ( sound );
        }
    }
    public List<Sound> getSounds(){
        return mSounds;
    }
}
