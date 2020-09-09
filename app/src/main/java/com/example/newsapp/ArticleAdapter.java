package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private List<Article> mArticles;
    private ItemClickListener mItemClickListener;

    public ArticleAdapter(List<Article> articles, ItemClickListener itemClickListener) {
        this.mArticles = articles;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, final int position) {
        holder.bind(mArticles.get(position));
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public void clearAdapter() {
        mArticles.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Article> articles) {
        this.mArticles = articles;
        notifyDataSetChanged();
    }

    public Article getItem(int id) {
        return mArticles.get(id);
    }

    interface ItemClickListener {
        void onClick(int id);
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ConstraintLayout container;
        RoundedImageView articleImage;
        TextView articleTitle;
        TextView articleSection;
        TextView articlePublicationDate;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.listItemContainer);
            articleImage = itemView.findViewById(R.id.articleImage);
            articleTitle = itemView.findViewById(R.id.articleTitle);
            articleSection = itemView.findViewById(R.id.articleSection);
            articlePublicationDate = itemView.findViewById(R.id.articlePublicationDate);
            container.setOnClickListener(this);
        }

        public void bind(Article article) {
            if (article.getmArticleImage().equals("")) {
                Glide.with(itemView.getContext()).load(R.drawable.news).into(articleImage);
            } else {
                Glide.with(itemView.getContext()).load(article.getmArticleImage()).into(articleImage);
            }
            articleTitle.setText(article.getmArticleTitle());
            articleSection.setText(article.getmArticleSection());

            String formattedPublicationDate = dateTimeFormatter(article.getmArticlePublicationDate());

            articlePublicationDate.setText(formattedPublicationDate);

        }

        /**
         * Return the formatted date and time string (i.e. "22 August 2019").
         */
        private String dateTimeFormatter(String articlePublicationDate) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
            Date date = null;
            try {
                date = dateFormat.parse(articlePublicationDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            DateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            return formatter.format(date);
        }

        @Override
        public void onClick(View v) {
            mItemClickListener.onClick(getAdapterPosition());
        }
    }
}
