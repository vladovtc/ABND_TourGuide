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

public class CastlesFragment extends Fragment {

    public CastlesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(R.drawable.castle_durdevac, getString(R.string.name_durdevac), getString(R.string.description_durdevac), getString(R.string.wiki_durdevac), getString(R.string.location_durdevac)));
        data.add(new Data(R.drawable.castle_eltz, getString(R.string.name_eltz), getString(R.string.description_eltz), getString(R.string.wiki_eltz), getString(R.string.location_eltz)));
        data.add(new Data(R.drawable.castle_ilok, getString(R.string.name_ilok), getString(R.string.ilok), getString(R.string.wiki_ilok), getString(R.string.location_ilok)));
        data.add(new Data(R.drawable.castle_kastilac, getString(R.string.name_kastilac), getString(R.string.description_kastilac), getString(R.string.wiki_kastilac), getString(R.string.location_kastilac)));
        data.add(new Data(R.drawable.castle_pejacevic, getString(R.string.name_pejacevic), getString(R.string.description_pejacevic), getString(R.string.wiki_pejacevic), getString(R.string.location_pejacevic)));


        View rootView = inflater.inflate(R.layout.content_main, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(new DataAdapter(data));

        return rootView;
    }
}
