package net.rusnet.sb.activityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    private TextView mCatalogText;
    private TextView mMainWebsiteText;
    private TextView mMapText;
    private TextView mSearchText;

    private static final String SAVED_PARCEL = "PARCEL TO SAVE";
    private static final String TAG = "TEST_TAG";

    private TestModel myTM;

    private TextView mStringText1;
    private TextView mStringText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mCatalogText = findViewById(R.id.catalog_text);
        mCatalogText.setText( Html.fromHtml("<a href='" + getString(R.string.catalog_test_link) +
                "'>" + getString(R.string.text_catalog_test_link) + "</a>"));
        mCatalogText.setMovementMethod(LinkMovementMethod.getInstance());
        mCatalogText.setLinksClickable(true);

        mMainWebsiteText = findViewById(R.id.main_website_text);
        mMainWebsiteText.setText( Html.fromHtml("<a href='" + getString(R.string.main_website_test_link) +
                "'>" + getString(R.string.text_main_website_test_link) + "</a>"));
        mMainWebsiteText.setMovementMethod(LinkMovementMethod.getInstance());
        mMainWebsiteText.setLinksClickable(true);

        mMapText = findViewById(R.id.map_text);
        mMapText.setText( Html.fromHtml("<a href='" + getString(R.string.map_test_link) +
                "'>" + getString(R.string.text_map_test_link) + "</a>"));
        mMapText.setMovementMethod(LinkMovementMethod.getInstance());
        mMapText.setLinksClickable(true);

        mSearchText = findViewById(R.id.search_text);
        mSearchText.setText( Html.fromHtml("<a href='" + getString(R.string.search_test_link) +
                "'>" + getString(R.string.text_search_test_link) + "</a>"));
        mSearchText.setMovementMethod(LinkMovementMethod.getInstance());
        mSearchText.setLinksClickable(true);

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
