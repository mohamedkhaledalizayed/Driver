package driver.itgds.khadametdz.view.dialog;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.FragmentAlertBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertFragment extends DialogFragment {


    private FragmentAlertBinding binding;
    public AlertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_alert,container,false);

        return binding.getRoot();
    }

}
