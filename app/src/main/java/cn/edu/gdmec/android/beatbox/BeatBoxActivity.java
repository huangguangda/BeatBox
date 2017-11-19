package cn.edu.gdmec.android.beatbox;

import android.support.v4.app.Fragment;

public class BeatBoxActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return BeatBoxFragment.newInstance ();
    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.fragment_beat_box );
    }*/
}
