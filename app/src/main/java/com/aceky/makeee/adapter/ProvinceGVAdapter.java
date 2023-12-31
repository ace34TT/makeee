package com.aceky.makeee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aceky.makeee.R;
import com.aceky.makeee.model.destination.ProvinceCard;

import java.util.ArrayList;

public class ProvinceGVAdapter extends ArrayAdapter<ProvinceCard> {
    public ProvinceGVAdapter(@NonNull Context context, ArrayList<ProvinceCard> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.cardview, parent, false);
        }

        ProvinceCard provinceCard = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.CardLabel);
        ImageView courseIV = listitemView.findViewById(R.id.CardImageView);

        courseTV.setText(provinceCard.getName());
        courseIV.setImageResource(provinceCard.getImgId());
        return listitemView;
    }
}
