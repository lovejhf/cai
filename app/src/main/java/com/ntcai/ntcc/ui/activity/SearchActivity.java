package com.ntcai.ntcc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aries.ui.view.radius.RadiusEditText;
import com.gyf.barlibrary.ImmersionBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.HistoryAdapter;
import com.ntcai.ntcc.db.DataBaseManager;
import com.ntcai.ntcc.db.SearchHistory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.search)
    RadiusEditText searchEdit;
    @BindView(R.id.search_view)
    LinearLayout searchView;
    @BindView(R.id.result)
    RecyclerView result;
    @BindView(R.id.cancel)
    TextView cancel;
    private DataBaseManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        manager = DataBaseManager.getInstance(this);
        result.setLayoutManager(new LinearLayoutManager(this));
        ImmersionBar.setTitleBar(this, searchView);
        searchEdit.setFocusable(true);
        searchEdit.setFocusableInTouchMode(true);
        searchEdit.requestFocus();
        searchEdit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        searchEdit.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        List<SearchHistory> list = manager.queryByWhere(SearchHistory.class,"crate_time");
        HistoryAdapter adapter = new HistoryAdapter(R.layout.item_search,list);
        result.setAdapter(adapter);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        searchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:
                            SearchHistory searchHistory = new SearchHistory();
                            searchHistory.setName(searchEdit.getText().toString().trim());
                            searchHistory.setCrate_time(System.currentTimeMillis());
                            manager.insert(searchHistory);
                            Intent intent = new Intent(SearchActivity.this, GoodsSerachListActivity.class);
                            startActivity(intent);
                            break;
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
