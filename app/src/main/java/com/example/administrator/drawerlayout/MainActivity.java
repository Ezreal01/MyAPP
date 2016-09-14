package com.example.administrator.drawerlayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btn;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        btn= (Button) findViewById(R.id.btn);
        listView= (ListView) findViewById(R.id.listview);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,drawerLayout,R.string.open,R.string.close
        );
        //设置抽屉监听
        drawerLayout.setDrawerListener(toggle);
        //重要:同步ActionBar上抽屉开关不同状态
        toggle.syncState();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list =new ArrayList<String>();
                for (int i = 0; i <10 ; i++) {
                    list.add("====="+i+"======");
                }
                listView.setAdapter(new ArrayAdapter<String>(
                       MainActivity.this,android.R.layout.simple_list_item_1,list
                ));
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //左边的抽屉是否打开
                if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
                    //打开状态,要关闭
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
