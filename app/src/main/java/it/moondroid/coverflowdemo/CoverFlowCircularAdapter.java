package it.moondroid.coverflowdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CoverFlowCircularAdapter extends BaseAdapter {

    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private Context mContext;

    public CoverFlowCircularAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<GameEntity> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int pos) {
        return mData.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_circular_coverflow, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            viewHolder.circularImageView = (com.github.siyamed.shapeimageview.CircularImageView) rowView
                    .findViewById(R.id.image);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

        holder.circularImageView.setImageResource(mData.get(position).imageResId);
        holder.text.setText(mData.get(position).titleResId);

        return rowView;
    }


    static class ViewHolder {
        public TextView text;
        public com.github.siyamed.shapeimageview.CircularImageView circularImageView;
    }
}
