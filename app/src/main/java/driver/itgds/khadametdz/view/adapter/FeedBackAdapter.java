package driver.itgds.khadametdz.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.FeedBackItemBinding;

public class FeedBackAdapter  extends RecyclerView.Adapter<FeedBackAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;

    public FeedBackAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
    }

    @Override
    public FeedBackAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        FeedBackItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.feed_back_item, parent, false);


        return new FeedBackAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final FeedBackAdapter.MyViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        FeedBackItemBinding binding;
        public MyViewHolder(FeedBackItemBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }

}