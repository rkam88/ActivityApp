package net.rusnet.sb.activityapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class Catalog extends AppCompatActivity {

    private static final String SAVED_PARCEL = "PARCEL TO SAVE";
    private static final String TAG = "TEST_TAG";

    private TextView mAccountText;

    private TestModel myTM;

    private TextView mStringText1;
    private TextView mStringText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mAccountText = findViewById(R.id.account_text);
        mAccountText.setText( Html.fromHtml("<a href='" + getString(R.string.account_test_link) +
                "'>" + getString(R.string.text_account_test_link) + "</a>"));
        mAccountText.setMovementMethod(LinkMovementMethod.getInstance());
        mAccountText.setLinksClickable(true);

        myTM = new TestModel();

        mStringText1 = findViewById(R.id.text_string_1);
        mStringText2 = findViewById(R.id.text_string_2);
        updateTextViews(myTM);

        Log.d(TAG, " \nNEW TaskModel from onCreate");
        Log.d(TAG, myTM.toString());
    }

    private void updateTextViews(TestModel testModel) {
        mStringText1.setText(testModel.getStringOne());
        mStringText2.setText(testModel.getStringTwo());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_PARCEL, myTM);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        myTM = savedInstanceState.getParcelable(SAVED_PARCEL);
        updateTextViews(myTM);
        Log.d(TAG, " \nOLD TaskModel from onRestoreInstanceState");
        Log.d(TAG, myTM.toString());
    }
}
