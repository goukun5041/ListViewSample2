package com.websarva.wings.android.listviewsample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewSample2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sample2);
        //ListViewオブジェクト取得
        ListView lvMenu = (ListView)findViewById(R.id.lvMenu);
        //リストビューに表示するリストデータ用Listオブジェクト作成
        List<String> menuList = new ArrayList<>();
        menuList.add("唐揚げ");
        menuList.add("ハンバーグ");
        menuList.add("生姜焼き");
        menuList.add("ステーキ");
        menuList.add("野菜炒め");
        menuList.add("トンカツ");

        //アダプタオブジェクト生成
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewSample2Activity.this,android.R.layout.simple_list_item_1,menuList);
        //リストメニューにアダプタオブジェクト設定
        lvMenu.setAdapter(adapter);
        //リストビューにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }
    /**
     * リストがタップされた時の処理が記述されたメンバクラス
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            //注文確認ダイアログフラグメントオブジェクト生成
            OrderCOnfirmDialogFragment dialogFragment = new OrderCOnfirmDialogFragment();
            //ダイアログ表示daiaroguhyouji
            dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
        }
    }
}
