package com.gmail.vtc.vlado.tourguide;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NationalParkFragment extends Fragment {

    public NationalParkFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(R.drawable.park_plitvice, getString(R.string.name_plitvice), getString(R.string.description_plitvice), getString(R.string.wiki_plitvice), getString(R.string.location_plitvice)));
        data.add(new Data(R.drawable.park_brijuni, getString(R.string.name_brijuni), getString(R.string.description_brijuni), getString(R.string.wiki_brijuni), getString(R.string.location_brijuni)));
        data.add(new Data(R.drawable.park_krka, getString(R.string.name_krka), getString(R.string.description_krka), getString(R.string.wiki_krka), getString(R.string.location_krka)));
        data.add(new Data(R.drawable.park_velebit, getString(R.string.name_velebit), getString(R.string.description_velebit), getString(R.string.wiki_velebit), getString(R.string.location_velebit)));

        View rootView = inflater.inflate(R.layout.content_main, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(new DataAdapter(data));

        return rootView;
    }
}
