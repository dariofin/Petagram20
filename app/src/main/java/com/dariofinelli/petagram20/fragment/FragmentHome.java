package com.dariofinelli.petagram20.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dariofinelli.petagram20.R;
import com.dariofinelli.petagram20.adapter.PetAdapter;
import com.dariofinelli.petagram20.pojo.PetItem;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private final ArrayList<PetItem> petItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PetAdapter(petItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        petItems.add(new PetItem(R.drawable.cocker_spaniel, "Pichu", "0", "0"));
        petItems.add(new PetItem(R.drawable.lion, "Chacho", "1", "0"));
        petItems.add(new PetItem(R.drawable.monkey, "Morcilla", "2", "0"));
        petItems.add(new PetItem(R.drawable.owl, "Chuby", "3", "0"));
        petItems.add(new PetItem(R.drawable.fox, "Sultán", "4", "0"));
        petItems.add(new PetItem(R.drawable.cat, "Kaiser", "5", "0"));

        return view;
    }
}
