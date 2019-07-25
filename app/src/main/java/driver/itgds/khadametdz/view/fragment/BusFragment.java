package driver.itgds.khadametdz.view.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.FragmentBusBinding;
import driver.itgds.khadametdz.utils.Utilities;
import driver.itgds.khadametdz.view.activity.TripDetailsActivity;


public class BusFragment extends Fragment {


    private FragmentBusBinding binding;
    public BusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_bus, container, false);
        Utilities.setHtmlText(R.string.trip_details,binding.idTripDetails);

        binding.idTripDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TripDetailsActivity.class));
            }
        });
        return binding.getRoot();
    }



}
