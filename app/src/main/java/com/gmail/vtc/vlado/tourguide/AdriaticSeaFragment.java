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

/**
 * Created by user on 26.3.2018..
 */

public class AdriaticSeaFragment extends Fragment {

    private final ArrayList<Data> data = new ArrayList<>();

    public AdriaticSeaFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dataList();

        View rootView = inflater.inflate(R.layout.content_main, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(new DataAdapter(data));

        return rootView;
    }

    public void dataList() {

        data.add(new Data(R.drawable.blue_cave, getString(R.string.name_blue_cave), getString(R.string.description_blue_cave), getString(R.string.wiki_blue_cave), getString(R.string.location_blue_cave)));
        data.add(new Data(R.drawable.blue_lagoon, getString(R.string.name_blue_lagoon), getString(R.string.description_blue_lagoon), getString(R.string.wiki_blue_lagoon), getString(R.string.location_blue_lagoon)));
        data.add(new Data(R.drawable.hvar, getString(R.string.name_hvar), getString(R.string.description_hvar), getString(R.string.wiki_hvar), getString(R.string.location_hvar)));
        data.add(new Data(R.drawable.dubrovnik, getString(R.string.name_dubrovnik), getString(R.string.description_dubrovnik), getString(R.string.wiki_dubrovnik), getString(R.string.location_dubrovnik)));

    }

}
