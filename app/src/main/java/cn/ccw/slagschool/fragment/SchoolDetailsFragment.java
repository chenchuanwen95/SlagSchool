package cn.ccw.slagschool.fragment;


import android.view.LayoutInflater;
import android.view.View;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.base.BaseFragment;

/**
 * 这里是学校的详情页
 */
public class SchoolDetailsFragment extends BaseFragment {


    @Override
    public View initFragment(LayoutInflater inflater) {
        return inflater.inflate(R.layout.school_fragment_details, null);
    }

}
