package com.example.safariguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.safariguide.Adapter.VideoAdapter;
import com.example.safariguide.Module.Video;

import java.util.ArrayList;
import java.util.List;

public class ReelsFragment extends Fragment {

    private ViewPager2 viewPager2;
    private List<Video> videoList;
    private VideoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reels, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        videoList = new ArrayList<>();
        viewPager2 = view.findViewById(R.id.viewPager2);

        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl1, "Maria Kim", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.dianib, "Yugis Han", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.masaimara, "Muli Ken", "Masai Mara didn't live up to the hype for us"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.nakurulk, "Dat jik", "A perfect day trip destination with easily accessible viewpoints and picnic spots"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd1, "John Michle", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl2, "Abdi Yusuf", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl3, "Faiz Munj", "A breathtaking summit experience with stunning views all around."));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd3, "Denis Kim", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl4, "John You", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl5, "Kim Sert", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl6, "Dennis Goy", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.lknakuru, "Lake Nakuru", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl7, "Sert jiko", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl8, "Halima Yussuf", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl9, "Yuud Thiol", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl10, "Rebbeca Riok", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl10, "Youk Hiko", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl11, "Weekll Kioko", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl12, "Yujji Oppl", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl13, "Mandela Lusaka", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vdl14, "Jikl Yoll", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd1, "Abdi Hassan", "I always wonder why birds stay in the same place when they can fly anywhere on the earth. Then I ask myself the same question."));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd2, "Yunis Yupi", "I always wonder why birds stay in the same place when they can fly anywhere on the earth."));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd3, "Alianda John", "I always wonder why birds  the same question."));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd4, "Kim lopi", "Then I ask myself the same question."));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd5, "Lrt reco", " Ask myself the same question."));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd6, "Yrt Pomkl", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vd7, "Walii Yusuf", "I can fly anywhere on the earth"));
        videoList.add(new Video("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.mtkenya, "Mount Kenya", "A sense of accomplishment after reaching the summit, an amazing journey"));

        adapter = new VideoAdapter(videoList);
        viewPager2.setAdapter(adapter);
    }
}