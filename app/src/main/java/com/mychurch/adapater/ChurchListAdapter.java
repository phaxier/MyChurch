package com.mychurch.adapater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mychurch.models.Church;
import com.mychurch.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChurchListAdapter extends RecyclerView.Adapter<ChurchListAdapter.ChurchViewHolder> {
    private ArrayList<Church>mChurch = new ArrayList<>();

    private Context mContext;

    public ChurchListAdapter(Context context,ArrayList<Church> churches){
        mContext = context;
        mChurch = churches;
    }


    @Override
    public ChurchListAdapter.ChurchViewHolder onCreateViewHolder(ViewGroup parent, int viewGroup) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.church_list_item, parent, false);
        ChurchViewHolder viewHolder = new ChurchViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChurchListAdapter.ChurchViewHolder holder, int position) {
holder.bindChurch(mChurch.get(position));
    }

    @Override
    public int getItemCount() {
        return mChurch.size();
    }

    public class ChurchViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.bookNameEditText)
        ImageView mBookNameEditView;
        @BindView(R.id.verseFromTextview)
        TextView mVerseFromTextView;
        @BindView(R.id.verseToTextView)TextView mVerseToTextView;
        @BindView(R.id.chapterTextView) TextView mChapterTextView;

        private Context mContext;

        public ChurchViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindChurch(Church church) {
            Picasso.get().load(church.getHolyBook()).into(mBookNameEditView);
            mChapterTextView.setText(church.getBookChapter());
            mVerseFromTextView.setText(church.getBookVerseFrom());
            mVerseToTextView.setText(church.getBookVerseTo());
        }
    }
}
