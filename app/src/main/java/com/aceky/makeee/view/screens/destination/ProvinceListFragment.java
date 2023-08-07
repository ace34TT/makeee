package com.aceky.makeee.view.screens.destination;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aceky.makeee.R;

public class ProvinceListFragment extends Fragment {
    public interface OnPaysClickListener {
        void onPaysSelected(String paysNom);
    }
    private OnPaysClickListener callback;
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (OnPaysClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " doit implémenter OnPaysClickListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_province_list, container, false);
        ListView listView = rootView.findViewById(R.id.provinces);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.provinces));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedPays = (String) adapterView.getItemAtPosition(position);
                callback.onPaysSelected(selectedPays);
            }
        });
        return rootView;
    }
}