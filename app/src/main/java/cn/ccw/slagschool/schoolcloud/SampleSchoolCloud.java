package cn.ccw.slagschool.schoolcloud;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class SampleSchoolCloud extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Step0: 得到一个全屏视图:
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		//Step1: 得到屏幕分辨率
		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();

		//Step2: 创建所需的标记列表:
		//注意: 所有标签必须有独特的文本字段
		//如果没有,只有第一次出现将被添加,其余的将被忽略
		List<Tag> myTagList= createTags();

		//Step3: 创建TagCloudview MainActivity并将它设置为内容
		mTagCloudView = new TagCloudView(this, width, height, myTagList ); //通过当前上下文
		setContentView(mTagCloudView);
		mTagCloudView.requestFocus();
		mTagCloudView.setFocusableInTouchMode(true);

		//Step4: (可选择) 添加一个新的标签,整个3 d TagCloud重置
		//您还可以添加个人标签:
		//mTagCloudView.addTag(new Tag("AAA", 5, "http://www.aaa.com"));
		// .... (可以添加其他几个tasg相似 )
		//如果旧标签不动indivual标记将被放置在前面的 因此,在添加许多个人标签 后，TagCloud代码可能不是均匀分布的。reset()re-positions所有标签
		//mTagCloudView.reset();

		//Step5: (可选择) 替换之前的标签之一,用一个新的标签，你一定要创建一个新的标签并且把他们放一起通过现有的文本标签，你想取代的
		//Tag newTag=new Tag("Illinois", 9, "http://www.illinois.com");
		//为了用Google去替代以前的标签
		//boolean result=mTagCloudView.Replace(newTag, "google");
		//如果Google被发现并且替换了将返回true，否则为false
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onPause() {
		super.onPause();
	}

	private List<Tag> createTags(){
		//创建的列表标记人气值和相关的url
		List<Tag> tempList = new ArrayList<Tag>();

		tempList.add(new Tag("北京大学", 7, "北京大学"));  //1,4,7,... 假定受欢迎的值
		tempList.add(new Tag("清华大学", 3, "清华大学"));
		tempList.add(new Tag("中国人民大学", 4, "中国人民大学"));
		tempList.add(new Tag("中央财经大学", 5, "中央财经大学"));
		tempList.add(new Tag("北京语言大学", 5, "北京语言大学"));
		tempList.add(new Tag("南开大学", 7, "南开大学"));
		tempList.add(new Tag("天津大学", 3, "天津大学"));
		tempList.add(new Tag("河北大学", 5, "河北大学"));
		tempList.add(new Tag("河北师范大学", 3, "河北师范大学"));
		tempList.add(new Tag("中北大学", 8, "中北大学"));
		tempList.add(new Tag("山西大学", 5, "山西大学"));
		tempList.add(new Tag("东北大学", 1, "东北大学"));
		tempList.add(new Tag("吉林大学", 3, "吉林大学"));
		tempList.add(new Tag("北华大学", 7, "北华大学"));
		tempList.add(new Tag("东北农业大学", 5, "东北农业大学"));
		tempList.add(new Tag("河海大学", 7, "河海大学"));
		tempList.add(new Tag("南通大学", 3, "南通大学"));
		tempList.add(new Tag("温州大学", 1, "温州大学"));
		tempList.add(new Tag("厦门大学", 5, "厦门大学"));
		tempList.add(new Tag("福州大学", 5, "福州大学"));
		tempList.add(new Tag("华侨大学", 7, "华侨大学"));
		tempList.add(new Tag("南昌大学", 2, "南昌大学"));
		tempList.add(new Tag("山东大学", 4, "山东大学"));
		tempList.add(new Tag("济南大学", 1, "济南大学"));
		tempList.add(new Tag("青岛科技大学", 8, "青岛科技大学"));
		tempList.add(new Tag("聊城大学", 8, "聊城大学"));
		tempList.add(new Tag("济宁学院", 5, "济宁学院"));
		tempList.add(new Tag("河南科技大学", 3, "河南科技大学"));
		tempList.add(new Tag("长江大学", 5, "长江大学"));
		return tempList;
	}

	private TagCloudView mTagCloudView;
}