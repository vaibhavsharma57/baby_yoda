package com.example.baby_yoda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;


/**
 * A simple {@link Fragment} subclass.
 */
public class positive_quotes extends Fragment {
ViewFlipper image_flipper;

    public positive_quotes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_positive_quotes, container, false);
        int images[] = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10};
        image_flipper = v.findViewById(R.id.image_flipper);
        for(int i=0;i<images.length;i++){
            flipperimages(images[i]);
        }


        return v;
    }
    public void flipperimages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        image_flipper.addView(imageView);
        image_flipper.setFlipInterval(4000);
        image_flipper.setAutoStart(true);
        image_flipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        image_flipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);

    }
}
