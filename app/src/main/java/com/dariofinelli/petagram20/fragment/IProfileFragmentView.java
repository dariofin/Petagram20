package com.dariofinelli.petagram20.fragment;

import com.dariofinelli.petagram20.adapter.ProfileAdapter;
import com.dariofinelli.petagram20.pojo.BioItem;
import com.dariofinelli.petagram20.pojo.ProfileItem;

import java.util.ArrayList;

public interface IProfileFragmentView {

    void generateGridLayout();

    ProfileAdapter createAdapter(ArrayList<ProfileItem> profileItems);

    void initializeAdapter(ProfileAdapter profileAdapter);

    void showProfile(BioItem bioItem);
}
