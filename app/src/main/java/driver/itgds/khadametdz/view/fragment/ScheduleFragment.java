package driver.itgds.khadametdz.view.fragment;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.FragmentScheduleBinding;
import driver.itgds.khadametdz.utils.Utilities;
import driver.itgds.khadametdz.view.activity.TripRejectionActivity;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private Calendar calendar;
    private DatePickerDialog picker;
    private ArrayList<String> items=new ArrayList<>();
    private SpinnerDialog spinnerDialog;
    private Date currentDate;
    private String date;
    DateFormat format2;

    private FragmentScheduleBinding binding;
    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_schedule, container, false);

        calendar = Calendar.getInstance();

        DateFormat format = new SimpleDateFormat("yyyy", new Locale("en"));
        format2 = new SimpleDateFormat("EEEE dd MMMM yyyy", new Locale("en"));
        currentDate = new Date();
        date = format.format(currentDate);

        binding.date.setText(format2.format(currentDate));

        Utilities.setHtmlText(R.string.accept,binding.accept1);
        Utilities.setHtmlText(R.string.accept,binding.accept2);

        Utilities.setHtmlText(R.string.reject,binding.reject1);
        Utilities.setHtmlText(R.string.reject,binding.rejec2);

        binding.reject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TripRejectionActivity.class));
            }
        });

        binding.rejec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TripRejectionActivity.class));
            }
        });

        binding.daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.date.setText(format2.format(currentDate));
                binding.daily.setBackgroundResource(R.drawable.seat_bg_booked);
                binding.weekly.setBackgroundResource(R.drawable.seat_bg_selected);
                binding.monthly.setBackgroundResource(R.drawable.seat_bg_selected);
            }
        });

        binding.weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weekly();
            }
        });

        binding.monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monthly();
            }
        });
        return binding.getRoot();
    }

    public void weekly() {
        binding.weekly.setBackgroundResource(R.drawable.seat_bg_booked);
        binding.monthly.setBackgroundResource(R.drawable.seat_bg_selected);
        binding.daily.setBackgroundResource(R.drawable.seat_bg_selected);
        items.clear();

        for (int i = 1 ; i <= 52 ; i++ ){
            items.add(getString(R.string.week)+i);
        }
        spinnerDialog=new SpinnerDialog(getActivity(),items,getString(R.string.select_week),R.style.DialogAnimations_SmileWindow,getString(R.string.close));// With 	Animation
        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default


        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                binding.date.setText(item +" : "+date);
            }
        });
        spinnerDialog.showSpinerDialog();
    }

    public void monthly() {
        binding.weekly.setBackgroundResource(R.drawable.seat_bg_selected);
        binding.monthly.setBackgroundResource(R.drawable.seat_bg_booked);
        binding.daily.setBackgroundResource(R.drawable.seat_bg_selected);
        items.clear();

        items.addAll(Arrays.asList(getResources().getStringArray(R.array.array_months)));

        spinnerDialog=new SpinnerDialog(getActivity(),items,getString(R.string.select_month),R.style.DialogAnimations_SmileWindow,getString(R.string.close));// With 	Animation
        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                binding.date.setText(item +" : "+date);
            }
        });
        spinnerDialog.showSpinerDialog();
    }

}
