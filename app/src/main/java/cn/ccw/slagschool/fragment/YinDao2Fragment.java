package cn.ccw.slagschool.fragment;

import android.view.LayoutInflater;
import android.view.View;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.base.BaseFragment;


public class YinDao2Fragment extends BaseFragment{

    @Override
    public View initFragment(LayoutInflater inflater) {
        return inflater.inflate(R.layout.yin2,null);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
