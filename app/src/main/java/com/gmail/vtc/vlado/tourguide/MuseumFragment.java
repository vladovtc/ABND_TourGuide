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

public class MuseumFragment extends Fragment {

    public MuseumFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(R.drawable.museum_zagreb, getString(R.string.name_zagreb), getString(R.string.description_zagreb), getString(R.string.wiki_zagreb), getString(R.string.location_zagreb)));
        data.add(new Data(R.drawable.museum_osijek, getString(R.string.name_osijek), getString(R.string.description_osijek), getString(R.string.wiki_osijek), getString(R.string.location_osijek)));
        data.add(new Data(R.drawable.museum_mestrovic, getString(R.string.name_mestrovic), getString(R.string.description_mestrovic), getString(R.string.wiki_mestrovic), getString(R.string.location_mestrovic)));
        data.add(new Data(R.drawable.museum_croatian_natural, getString(R.string.name_croatian_natural), getString(R.string.description_croatian_natural), getString(R.string.wiki_croatian_natural), getString(R.string.location_croatian_natural)));

        View rootView = inflater.inflate(R.layout.content_main,container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(new DataAdapter(data));

        return rootView;
    }
}
