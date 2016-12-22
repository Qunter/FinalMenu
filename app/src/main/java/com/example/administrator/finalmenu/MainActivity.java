package com.example.administrator.finalmenu;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //新建菜单显示类对象
    private MenuShow mMenuShow;
    //定义菜单按钮控件
    private RelativeLayout menuBtn;
    //定义菜单列表中的四个Item的名称以及资源
    private MenuItem qiwei,qipao, haoyou, shezhi;
    private String[] MenuItemName = {"气味","气泡","好友","设置"};
    private int[] MenuItemIcon = {R.drawable.ic_speaker_notes_white_36dp,R.drawable.ic_star_border_white_36dp,R.drawable.ic_timeline_white_36dp,R.drawable.ic_security_white_36dp};
    private int[] MenuItemIconChange = {R.drawable.ic_speaker_notes_blue_500_36dp,R.drawable.ic_star_border_blue_500_36dp,R.drawable.ic_timeline_blue_500_36dp,R.drawable.ic_security_blue_500_36dp};
    //定义文字颜色的两种变换，未按下是白色，按下是蓝色
    private int textColor = Color.parseColor("#ffffff");
    private int textColorChange = Color.parseColor("#2196f3");
    //定义菜单MSG的信息，按下哪个发送哪条
    private final int QIWEI=0x00,QIPAO=0x01,HAOYOU=0x02,SHEZHI=0x03;
    //定义菜单按钮MSG
    private final int MENU=0x10;
    //菜单列表的布局
    private RelativeLayout menuList;
    //用于恢复被点击按钮的颜色
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                //菜单按钮
                case MENU:
                    mMenuShow.showList();
                    break;
                //一级菜单
                case QIWEI:
                    qiwei.setImageViewImg(MenuItemIcon[0]);
                    qiwei.setTextViewColor(textColor);
                    break;
                case QIPAO:
                    qipao.setImageViewImg(MenuItemIcon[1]);
                    qipao.setTextViewColor(textColor);
                    break;
                case HAOYOU:
                    haoyou.setImageViewImg(MenuItemIcon[2]);
                    haoyou.setTextViewColor(textColor);
                    break;
                case SHEZHI:
                    shezhi.setImageViewImg(MenuItemIcon[3]);
                    shezhi.setTextViewColor(textColor);
                    break;
            }
            super.handleMessage(msg);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    //初始化组件
    private void initView() {
        menuBtn = (RelativeLayout) findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(this);
        menuList = (RelativeLayout) findViewById(R.id.menulist);
        //传递菜单列表的对象
        mMenuShow = new MenuShow(menuList);
        menuList.setVisibility(View.INVISIBLE);//先将列表隐藏
        initMenuItem();
    }
    //初始化菜单项
    private void initMenuItem(){
        qiwei = (MenuItem) findViewById(R.id.qiwei);
        qiwei.setImageViewImg(MenuItemIcon[0]);
        qiwei.setTextViewText(MenuItemName[0]);
        qiwei.setOnClickListener(this);

        qipao = (MenuItem) findViewById(R.id.qipao);
        qipao.setImageViewImg(MenuItemIcon[1]);
        qipao.setTextViewText(MenuItemName[1]);
        qipao.setOnClickListener(this);

        haoyou = (MenuItem) findViewById(R.id.haoyou);
        haoyou.setImageViewImg(MenuItemIcon[2]);
        haoyou.setTextViewText(MenuItemName[2]);
        haoyou.setOnClickListener(this);

        shezhi = (MenuItem) findViewById(R.id.shezhi);
        shezhi.setImageViewImg(MenuItemIcon[3]);
        shezhi.setTextViewText(MenuItemName[3]);
        shezhi.setOnClickListener(this);
    }
    /**
     * 点击事件
     * 点击后改变颜色
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menuBtn:
                mHandler.sendEmptyMessage(MENU);
                Toast.makeText(getApplicationContext(),"点击获取成功",Toast.LENGTH_SHORT);
                break;
            case R.id.qiwei:
                qiwei.setImageViewImg(MenuItemIconChange[0]);
                qiwei.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(QIWEI,300);
                break;
            case R.id.qipao:
                qipao.setImageViewImg(MenuItemIconChange[1]);
                qipao.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(QIPAO,300);
                break;
            case R.id.haoyou:
                haoyou.setImageViewImg(MenuItemIconChange[2]);
                haoyou.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(HAOYOU,300);
                break;
            case R.id.shezhi:
                shezhi.setImageViewImg(MenuItemIconChange[3]);
                shezhi.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(SHEZHI,300);
                break;
        }
    }
}
