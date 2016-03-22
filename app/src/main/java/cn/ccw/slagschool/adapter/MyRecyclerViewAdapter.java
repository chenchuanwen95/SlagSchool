package cn.ccw.slagschool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.vo.SchoolInfo;
import cn.ccw.slagschool.weight.MyImageView;

/**
 * Created by 陈传稳_95 on 2016/3/21.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Context context ;
    private List<SchoolInfo> lists ;
    public MyRecyclerViewAdapter(Context context ,List<SchoolInfo> lists ){
        this.context = context ;
        this.lists = lists ;
    }
    //创建新的View视图
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false) ;
        MyViewHolder vh = new MyViewHolder(contentView) ;
        return vh;
    }
    //将数据与界面进行绑定
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.schoolName.setText(lists.get(position).getSchoolName()+"");
        holder.address.setText(lists.get(position).getAddress()+"");
        holder.isNotional.setText(lists.get(position).getIsNotional()+"");
        holder.isDegree.setText(lists.get(position).getIsDegree()+"");
        holder.score.setText("分数线: "+lists.get(position).getScore());
        holder.prepareNumber.setText("预招: "+lists.get(position).getPrepareNumber());
        holder.remainNumber.setText(lists.get(position).getRemainNumber()+" :剩余");
        holder.cutTime.setText("截止报名时间: "+lists.get(position).getCutTime());
        holder.foundedTime.setText("建校日期:"+lists.get(position).getFoundedTime());
    }
    //一次返回数据的条数
    @Override
    public int getItemCount() {
        return lists.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        public MyImageView schoolTitle ;  //学校校标
        public ImageView isRenZheng ;   //是否已认证
        public TextView schoolName ;   //学校名称
        public TextView address ;     //学校地址
        public TextView isNotional ;  //是国办还是民办的
        public TextView isDegree ;   //专科还是本科
        public TextView score ;      //分数
        public TextView prepareNumber ; // 准备招多少人
        public TextView remainNumber ;  //剩下多少名额
        public TextView cutTime ;      // 报名截止时间
        public TextView foundedTime ;  //学校创办时间
        public MyViewHolder(View itemView) {
            super(itemView);
            schoolTitle = (MyImageView) itemView.findViewById(R.id.myImageView);
            isRenZheng = (ImageView) itemView.findViewById(R.id.isRenzheng);
            schoolName = (TextView) itemView.findViewById(R.id.xiaoming);
            address = (TextView) itemView.findViewById(R.id.dizhi);
            isNotional = (TextView) itemView.findViewById(R.id.isguoban);
            isDegree = (TextView) itemView.findViewById(R.id.xuexiaoxingzhi) ;
            score = (TextView) itemView.findViewById(R.id.fenshuxian);
            prepareNumber = (TextView) itemView.findViewById(R.id.zhaorennum);
            remainNumber = (TextView) itemView.findViewById(R.id.shengrennum);
            cutTime = (TextView) itemView.findViewById(R.id.jiezhitime) ;
            foundedTime = (TextView) itemView.findViewById(R.id.jianxiaotime) ;
        }
    }
}
