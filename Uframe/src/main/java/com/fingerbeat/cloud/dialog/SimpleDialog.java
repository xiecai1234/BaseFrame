package com.fingerbeat.cloud.dialog;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.fingerbeat.cloud.R;
import com.fingerbeat.cloud.base.BaseDialog;

public class SimpleDialog extends BaseDialog {
    private String mTitle;
    private String mContent;
    private String mBtnText;
    public SimpleDialog(Activity context, int theme, String title, String content, String btnText) {
        super(context, theme);
        this.mTitle = title;
        this.mContent = content;
        this.mBtnText = btnText;
    }

    protected void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.dialog_simple, null);
        TextView tvTitle = dialogView.findViewById(R.id.tv_title);
        TextView tvContent = dialogView.findViewById(R.id.tv_content);
        ViewTreeObserver vto = tvContent.getViewTreeObserver();
        //一行就居中，超过一行就左对齐
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tvContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                tvContent.getHeight();
                double w0 = tvContent.getWidth();//控件宽度
                double w1 = tvContent.getPaint().measureText(tvContent.getText().toString());//文本宽度
                if (w1 >= w0) {
                    tvContent.setGravity(Gravity.START);
                }
            }
        });

        TextView tvConfirm = dialogView.findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(mTitle)) {
            tvTitle.setText(mTitle);
        }
        if (!TextUtils.isEmpty(mContent)) {
            tvContent.setText(mContent);

        }
        if (!TextUtils.isEmpty(mBtnText)) {
            tvConfirm.setText(mBtnText);
        }
        dialogView.findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onConfirmListener) {
                    onConfirmListener.onClick();
                }
                dismiss();
            }
        });

        setContentView(dialogView);
    }
}




