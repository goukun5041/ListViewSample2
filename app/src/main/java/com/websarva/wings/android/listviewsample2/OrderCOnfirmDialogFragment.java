package com.websarva.wings.android.listviewsample2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by uwan on 2018/05/31.
 */

public class OrderCOnfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //ダイアログビルダー生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログタイトル設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログメッセージ設定
        builder.setMessage(R.string.dialog_msg);
        //positive button設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //Negative button設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        //Neutral button設定
        builder.setNeutralButton(R.string.dialog_btn_nu, new DialogButtonClickListener());
        //ダイアログオブジェクトを生成して、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }
    /**
     * ダイアログのアクションボタンがタップされた時の処理が記述されたメンバクラス
     */
    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface  dialog, int which){
            //トーストメッセージ用文字列変数の用意
            String msg = "";
            //タップされたアクションボタンで分岐
            switch (which) {
                //positeveなら
                case DialogInterface.BUTTON_POSITIVE:
                    //注文用のメッセージ格納
                    msg = getString(R.string.dialog_ok_toast);
                    break;
                //negativeなら
                case DialogInterface.BUTTON_NEGATIVE:
                    //キャンセルメッセージ格納
                    msg = getString(R.string.dialog_ng_toast);
                    break;
                //neutralなら
                case DialogInterface.BUTTON_NEUTRAL:
                    //問い合わせメッセージ格納
                    msg = getString(R.string.dialog_nu_toast);
                    break;
            }
            //トーストの表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}