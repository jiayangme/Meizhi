package sample.xiangkai.com.meizhi;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by xiangkai on 2016/12/17.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    // TODO: 2016/12/17  
    //    子类实际的数据对象
    protected List<T> datas;
    private OnItemClickListener onItemClickListener;

    public void setDatas(List<T> datas) {  //避免了重写构造方法的复杂性
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView.ViewHolder holder, int position);
    }
}
