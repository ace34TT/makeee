package com.aceky.makeee.view.screens.mainscreen.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.aceky.makeee.R;
import com.aceky.makeee.data.repository.DestinationRepository;
import com.aceky.makeee.databinding.FragmentDashboardBinding;
import com.aceky.makeee.model.destination.Hotel;
import com.aceky.makeee.util.ApiResponseCallback;
import com.aceky.makeee.view.screens.auth.LoginActivity;
import com.aceky.makeee.view.screens.auth.SignUpActivity;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DestinationRepository repository  = new DestinationRepository();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("search" , "start from view");
                repository.handleFindHotel(binding.searchField.getText().toString(), new ApiResponseCallback<ArrayList<Hotel>>() {
                    @Override
                    public void onSuccess(ArrayList<Hotel> response) {
                        String[] hotelNames = response.stream()
                                .map(Hotel::getName)
                                .toArray(String[]::new);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                                android.R.layout.simple_list_item_1,
                                hotelNames);
                        binding.searchResult.setAdapter(adapter);
                        CharSequence text = "Search performed";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(view.getContext() , text, duration);
                        toast.show();
                    }

                    @Override
                    public void onError(String errorMessage) {

                    }
                });
            }
        });
/*        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}