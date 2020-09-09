package com.example.newsapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import java.util.List;

public class ArticleAsyncTaskLoader extends AsyncTaskLoader<List<Article>> {

    private String mUrl;

    public ArticleAsyncTaskLoader(@NonNull Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<Article> result = QueryUtils.fetchArticleData(mUrl);

        return result;
    }
}
