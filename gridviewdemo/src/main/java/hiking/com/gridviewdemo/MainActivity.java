package hiking.com.gridviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gv);

        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<8;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", R.mipmap.ic_launcher);//添加图像资源的ID
            map.put("count", R.mipmap.ic_launcher);//添加图像资源的ID
            map.put("danwei", R.mipmap.ic_launcher);//添加图像资源的ID
            map.put("color", "NO."+String.valueOf(i));//按序号做ItemText

            lstImageItem.add(map);
        }
        //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
//        SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释

//                lstImageItem,//数据来源
//                R.layout.sp_item,//night_item的XML实现
//
//                //动态数组与ImageItem对应的子项
//                new String[] {"ItemText"},
//
//                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
//                new int[] {R.id.im_tv_text});

        //
        List<ItemData> data = new ArrayList();
        ItemData i1 = new ItemData("新装拆除",35,"辆", Color.BLUE);
        ItemData i2 = new ItemData("有线",68,"辆", Color.BLACK);
        ItemData i3 = new ItemData("独立无线",3,"辆", Color.RED);
        ItemData i4 = new ItemData("组合无线",164,"辆", Color.YELLOW);
        ItemData i5 = new ItemData("售后",37,"辆", Color.GRAY);
        ItemData i6 = new ItemData("领取",10,"辆", Color.GREEN);
        ItemData i7 = new ItemData("剩余",1400,"辆", Color.YELLOW);
        ItemData i8 = new ItemData("剩余",1400,"辆", Color.YELLOW);
        data.add(i1);
        data.add(i2);
        data.add(i3);
        data.add(i4);
        data.add(i5);
        data.add(i6);
        data.add(i7);
        data.add(i8);
        for (ItemData d:

                data) {
            System.out.println(d.toString());
        }

        MyAdapter myAdapter = new MyAdapter(this,data);
        //添加并且显示
        gridview.setAdapter(myAdapter);
        //添加消息处理
//        gridview.setOnItemClickListener((AdapterView.OnItemClickListener) new ItemClickListener());
    }

    //当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class  ItemClickListener implements AdapterView.OnItemClickListener
    {
        public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened
                                View arg1,//The view within the AdapterView that was clicked
                                int arg2,//The position of the view in the adapter
                                long arg3//The row id of the item that was clicked
        ) {
            //在本例中arg2=arg3
            HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);
            //显示所选Item的ItemText
            setTitle((String)item.get("ItemText"));
        }

    }

    public class MyAdapter extends BaseAdapter {
        private List list = new ArrayList();
        protected LayoutInflater inflater;
        Context context;

        public MyAdapter(Context context, List list) {
            this.context = context;
            this.list = list;
            this.inflater = LayoutInflater.from(context);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewGroup view = (ViewGroup) inflater.inflate(R.layout.sp_item,null);


            ItemData data = (ItemData) list.get(position);

            TextView name = (TextView) view.findViewById(R.id.tv_name);
            TextView count = (TextView) view.findViewById(R.id.tv_count);
            TextView danwei = (TextView) view.findViewById(R.id.tv_danwei);
            View color = (View) view.findViewById(R.id.v_color);

            if (position==list.size()-1){
                name.setVisibility(View.GONE);
                count.setVisibility(View.GONE);
                danwei.setVisibility(View.GONE);
                color.setVisibility(View.GONE);
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.mipmap.ic_launcher);
                view.addView(imageView);
            }


            name.setText(data.getName());
            count.setText(data.getCount()+"");
            danwei.setText(data.getDanwei());
//            color.setBackground(data.getColor());



            return view;

        }

        /*
         * 功能：获得当前选项的ID
         *
         * @see android.widget.Adapter#getItemId(int)
         */
        @Override
        public long getItemId(int position) {
            //System.out.println("getItemId = " + position);
            return position;
        }

        /*
         * 功能：获得当前选项
         *
         * @see android.widget.Adapter#getItem(int)
         */
        @Override
        public Object getItem(int position) {
            return position;
        }

        /*
         * 获得数量
         *
         * @see android.widget.Adapter#getCount()
         */
        @Override
        public int getCount() {
            return list.size();
        }
    }


}
