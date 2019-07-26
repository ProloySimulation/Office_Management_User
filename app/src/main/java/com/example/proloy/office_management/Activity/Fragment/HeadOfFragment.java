package com.example.proloy.office_management.Activity.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proloy.office_management.Activity.Numbers.HeadOfMarketing;
import com.example.proloy.office_management.R;

/**
 * Created by Proloy on 5/7/2017.
 */
public class HeadOfFragment extends Fragment {

    TextView tvMarketHead;
    TextView tvTreasure ;
    TextView tvIT ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_head, container, false);

        tvMarketHead=(TextView)rootView.findViewById(R.id.market);
        tvTreasure = (TextView)rootView.findViewById(R.id.treasure);
        tvIT = (TextView)rootView.findViewById(R.id.IT);

        tvMarketHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HeadOfMarketing.class));
            }
        });

        tvTreasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HeadOfMarketing.class));
            }
        });

        tvIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HeadOfMarketing.class));
            }
        });

        return rootView;
    }



}