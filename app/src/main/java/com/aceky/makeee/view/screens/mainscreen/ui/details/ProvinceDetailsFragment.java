package com.aceky.makeee.view.screens.mainscreen.ui.details;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aceky.makeee.data.repository.DestinationRepository;
import com.aceky.makeee.databinding.FragmentProvinceDetailsBinding;
import com.aceky.makeee.model.destination.Province;
import com.aceky.makeee.util.ApiResponseCallback;
import com.bumptech.glide.Glide;

import java.util.Objects;

public class ProvinceDetailsFragment extends Fragment {

    private FragmentProvinceDetailsBinding binding;
    private ProvinceDetailsViewModel mViewModel;
    private String itemName;

    public static ProvinceDetailsFragment newInstance() {
        return new ProvinceDetailsFragment();
    }

    public Province province;
    DestinationRepository repository = new DestinationRepository();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProvinceDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.provinceName.setText(itemName);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            itemName = getArguments().getString("provinceName");
            repository.handleFindProvince(itemName, new ApiResponseCallback<Province>() {
                @Override
                public void onSuccess(Province response) {
                    province = new Province(response.getName(), response.getDescription());
                    binding.provinceDescription.setText(province.getDescription());
                    Glide.with(requireActivity())
                            .load("https://picsum.photos/200")
                            .into(binding.provincePreview);
                }
                @Override
                public void onError(String errorMessage) {
                }
            });
        }
    }
}