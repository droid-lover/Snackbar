package com.myjarvis.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//property of jarvis

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mainActivityToolbar;

    @Bind(R.id.button1)
    Button simpleSnackbarButton;

    @Bind(R.id.button2)
    Button customSnackbarButton;

    @Bind(R.id.button3)
    Button perfomActionWithSnackbarButton;

    @Bind(R.id.mainActivityParentLinearLayout)
    LinearLayout mainActivityParentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mainActivityToolbar);


    }

    @OnClick(R.id.button1)
    public void simpleSnackbarButtonClicked() {
        Snackbar snackbar = Snackbar.make(mainActivityParentLinearLayout, "Simplest snackbar example friends !", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @OnClick(R.id.button2)
    public void customSnackbarButtonClicked() {
        Snackbar customSnackbar = Snackbar.make(mainActivityParentLinearLayout, "Hello! I am custom Snackbar friends!", Snackbar.LENGTH_LONG);

        View viewOfSnackbarView = customSnackbar.getView();
        TextView textView = (TextView) viewOfSnackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        customSnackbar.show();

    }

    @OnClick(R.id.button3)
    public void perfomActionWithSnackbarButtonClicked() {
        Snackbar actionPerformingSnackbar = Snackbar.make(mainActivityParentLinearLayout,
                "Action Happened ",
                Snackbar.LENGTH_LONG).
                setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(mainActivityParentLinearLayout, "Stae before Action!", Snackbar.LENGTH_SHORT).show();
                    }
                });
    }


}
