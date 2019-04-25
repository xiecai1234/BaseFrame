package com.fingerbeat.cloud.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fingerbeat.cloud.R;
import com.fingerbeat.cloud.base.BaseDialog;

public class TwoButtonDialog extends BaseDialog {
    private String title;
    private String content;
    private String buttonFirstContent;
    private String buttonSecondContent;

    @Override
    protected void initView() {

    }

    public TwoButtonDialog(Activity activity, int theme, String title, String content, String buttonFirstContent, String buttonSecondContent) {
        super(activity, theme);
        this.content = content;
        this.buttonFirstContent = buttonFirstContent;
        this.buttonSecondContent = buttonSecondContent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.dialog_two_buttons, null);
        setContentView(dialogView);
        TextView contentTv = (TextView) findViewById(R.id.tv_content);
        TextView tvFirstButton = (TextView) findViewById(R.id.tv_first);
        TextView tvSeondButton = (TextView) findViewById(R.id.tv_second);
        contentTv.setText(content);
        tvFirstButton.setText(buttonFirstContent);
        tvSeondButton.setText(buttonSecondContent);
        findViewById(R.id.tv_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        findViewById(R.id.tv_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onConfirmListener) {
                    onConfirmListener.onClick();
                }
                dismiss();
            }
        });

    }

}
