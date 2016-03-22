package cn.ccw.slagschool.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 陈传稳_95 on 2016/3/9.
 */
public abstract class BaseFragment extends Fragment {
    private View fragment ;
    public View findViewById(int id){
        return getView().findViewById(id) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(fragment == null){
            fragment = initFragment(inflater) ;
        }
        return fragment;
    }
    public abstract View initFragment(LayoutInflater inflater) ;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) fragment.getParent()).removeView(fragment);
    }
}
