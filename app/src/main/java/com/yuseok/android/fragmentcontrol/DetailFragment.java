package com.yuseok.android.fragmentcontrol;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */

// Detail뷰를 보일 프레그먼트
public class DetailFragment extends Fragment {

    // 프레그먼트가 포함된 activity선언
    MainActivity activity;

    // 프레그먼트가 보여질 액티비티 정의
    public void setActivity(MainActivity activity){
        this.activity = activity;
    }


    public DetailFragment() {
        // Required empty public constructor
    }

    // 뷰에 속한 위젯 정의
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflater를 통해 fragment_detail의 속성을 view로 받아온다
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        // Button 위젯 정의
        Button btn = (Button) view.findViewById(R.id.btnList);
        // setOnClickListener설정
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼을 클릭하면 이전으로 넘어간다.
                activity.backToList();
            }
        });
        return view;
    }

}


//
//public class DetailFragment extends Fragment {
//
//    private OnDetailListener mListener;
//
//    public DetailFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false);
//    }
////
////    // TODO: Rename method, update argument and hook method into UI event
////    public void onButtonPressed() {
////        if (mListener != null) {
////            mListener.goList();
////        }
////    }
//
//    @Override
//    public void onAttach(Context context) {
////        super.onAttach(context);
////        if (context instanceof OnDetailListener) {
////            mListener = (OnDetailListener) context;
////        } else {
////            throw new RuntimeException(context.toString()
////                    + " must implement OnFragmentInteractionListener");
////        }
//    }
//
//
//
//    public interface OnDetailListener {
//        // TODO: Update argument type and name
//        void goList();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//}
