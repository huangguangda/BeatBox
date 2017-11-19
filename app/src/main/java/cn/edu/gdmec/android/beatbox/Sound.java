package cn.edu.gdmec.android.beatbox;

/**
 * Created by Jack on 2017/11/19.
 * 自动生成获取方法
 * 管理资源文件名
 */

public class Sound {
    private String mAssetPath;
    private String mName;

    public Sound(String assetPath){
        mAssetPath = assetPath;
        String[] components = assetPath.split ( "/" );
        String filename = components[components.length - 1];
        mName = filename.replace ( ".wav", "" );
    }
    public String getAssetPath(){
        return mAssetPath;
    }
    public String getName(){
        return mName;
    }
}
