package hiking.com.piechartdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinkedHashMap<String, Integer> kindsMap = new LinkedHashMap<>();
    private ArrayList<Integer> colors= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChatView pieChatView = (PieChatView) findViewById(R.id.pie);
        kindsMap.put("记录仪", 10);
        kindsMap.put("有线", 30);
        kindsMap.put("摄像头", 10);
        kindsMap.put("无线", 30);
        kindsMap.put("视频", 10);
        kindsMap.put("OBO",30);
        for (int i = 1; i <= 40; i++){
            int r= (new Random().nextInt(100)+10)*i;
            int g= (new Random().nextInt(100)+10)*3*i;
            int b= (new Random().nextInt(100)+10)*2*i;
            int color = Color.rgb(r,g,b);
            if(Math.abs(r-g)>10&&Math.abs(r-b)>10&&Math.abs(b-g)>10){
                colors.add(color);
            }
        }
        pieChatView.setCenterTitle("总安装设备数");
        pieChatView.setDataMap(kindsMap);
        pieChatView.setColors(colors);
        pieChatView.setMinAngle(50);
        pieChatView.startDraw();
    }
}
