package driver.itgds.khadametdz.view.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.FragmentScheduleBinding;
import driver.itgds.khadametdz.utils.Utilities;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {


    private FragmentScheduleBinding binding;
    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_schedule, container, false);
        Utilities.setHtmlText(R.string.accept,binding.accept1);
        Utilities.setHtmlText(R.string.accept,binding.accept1);

        Utilities.setHtmlText(R.string.reject,binding.reject1);
        Utilities.setHtmlText(R.string.reject,binding.rejec2);
        return binding.getRoot();
    }

}
