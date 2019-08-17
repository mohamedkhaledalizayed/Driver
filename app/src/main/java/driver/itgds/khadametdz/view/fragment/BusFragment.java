package driver.itgds.khadametdz.view.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.FragmentBusBinding;
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

        binding.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TripDetailsActivity.class);
                intent.putExtra("status",1);
                startActivity(intent);
            }
        });

        binding.card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TripDetailsActivity.class);
                intent.putExtra("status",2);
                startActivity(intent);
            }
        });

        binding.card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TripDetailsActivity.class);
                intent.putExtra("status",3);
                startActivity(intent);
            }
        });

        binding.card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TripDetailsActivity.class);
                intent.putExtra("status",4);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }



}
