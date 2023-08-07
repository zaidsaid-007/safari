package com.example.safariguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.safariguide.Adapter.OnboardingAdapter;
import com.example.safariguide.Module.OnboardingItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class Welcome extends AppCompatActivity {
    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private MaterialButton buttonOnboardingAction;
    private List<OnboardingItem> OnboardingItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnBoardingAction);

        setOnboardingItems();
        ViewPager2 onboardingViewPager = findViewById(R.id.OnboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingindicators();
        setCurrentOnboardingIndicator(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });
        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem()+ 1 <onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+ 1);
                }else {
                    startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
                    finish();
                }
            }
        });

    }

    private void setupOnboardingindicators() {
        // Add your implementation for setting up onboarding indicators here
    }

    private void setOnboardingItems() {
        OnboardingItems = new ArrayList<>(); // Initialize the list

        OnboardingItem itemPayOnline = new OnboardingItem();
        itemPayOnline.setTitle("To travel is to live");
        itemPayOnline.setDescription("The real voyage of discovery consists not in seeking new landscapes, but in having new eyes.");
        itemPayOnline.setImage(R.drawable.illustration);

        OnboardingItem itemOnTheWay = new OnboardingItem();
        itemOnTheWay.setTitle("I'm in a hurry to slow down");
        itemOnTheWay.setDescription("Traveling is like flirting with life. It's like saying, 'I would stay and love you, but I have to go; this is my station.");
        itemOnTheWay.setImage(R.drawable.lk);

        OnboardingItem ItemEatTogether = new OnboardingItem();
        ItemEatTogether.setTitle("Adventure awaits");
        ItemEatTogether.setDescription("The worst part of travel is the three seconds between when you see the landmark and when you take out your camera.");
        ItemEatTogether.setImage(R.drawable.shrt);

        OnboardingItems.add(itemPayOnline);
        OnboardingItems.add(itemOnTheWay);
        OnboardingItems.add(ItemEatTogether);

        onboardingAdapter = new OnboardingAdapter(OnboardingItems);
    }

    private void setLayoutOnboardingIndicator() {
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        //[]
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i<indicators.length;i++){
            indicators[ i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[ i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }
    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
        for (int i = 0; i<childCount;i++){
            ImageView imageView = (ImageView)layoutOnboardingIndicators.getChildAt(i);
            if (i==index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                );
            }else{
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if (index == onboardingAdapter.getItemCount()-1){
            buttonOnboardingAction.setText("Start");
        }else{
            buttonOnboardingAction.setText("Next");
        }
    }
}