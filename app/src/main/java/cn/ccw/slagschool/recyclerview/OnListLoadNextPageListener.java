package cn.ccw.slagschool.recyclerview;

import android.view.View;

/**
 *
 * 陈传稳
 *
 * RecyclerView/ListView/GridView 滑动加载下一页时的回调接口
 */
public interface OnListLoadNextPageListener {

    /**
     * 开始加载下一页
     *
     * @param view 当前RecyclerView/ListView/GridView
     */
    public void onLoadNextPage(View view);
}
