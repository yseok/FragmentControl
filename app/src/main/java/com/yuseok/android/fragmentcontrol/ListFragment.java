package com.yuseok.android.fragmentcontrol;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ListFragment extends Fragment {

    MainActivity activity;

    public void setActivity(MainActivity activity){
        this.activity = activity;
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Button btn = (Button) view.findViewById(R.id.btnDetail);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.goDetail();
            }
        });

        return view;
    }

}


//
//public class ListFragment extends Fragment {
//
//    RecyclerView recyclerView;
//
//    private Listener mListener;
//
//    String[] datas;
//
//
//    public ListFragment() {
//        // Required empty public constructor
//    }
//
//    // 프래그먼트가 Activity에 호출되는 순간, 호출한 Activiy 의 context가 넘어온다.
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        // 넘어온 context(Activity)가 OnFragment리스너의 구현체인지를 확인
//        // instanceof : 타입 체크
////        if (context instanceof OnFragmentInteractionListener) { // 메인 액티비티의 타입. OnFragmentInteractionListener을 MainActivity로 써도 된다.
////            mListener = (OnFragmentInteractionListener) context;
////        } else {
////            throw new RuntimeException(context.toString()
////                    + " must implement OnFragmentInteractionListener");
////        }
//
//        // 넘어온 Activity를 Listener로 캐스팅해서 mListener 변수에 담아둔다.
//
//        // 3. 사용하는 사용자측에서 인터페이스 필터링
//
//        mListener = (Listener) context;
//        datas = mListener.getData();
//    }
//
//    // 1. 인터페이스 정의
//    // 나를 호출하는 activity에서 구현해야되는 인터페이스
//    public interface Listener {
//        // TODO: Update argument type and name
//        String[] getData();
//        void goDetail(int position);
//        // ArrayList<Music> getData();
//    }
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_blank, container, false);
//        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//
//        // 2. 아답터 생성
//       ListAdapter adapter = new ListAdapter();// Fragment에서는 this가 넘어가지 않는다.
//
//        // 3. 뷰에 아답터 셋팅
//        recyclerView.setAdapter(adapter);
//
//        // 4. 레이아웃 매니저 셋팅
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext() ));
//
//
//
//        return view;
//    }
////
////    // TODO: Rename method, update argument and hook method into UI event
////    public void onButtonPressed(Uri uri) {
////        if (mListener != null) {
////            mListener.onFragmentInteraction(uri);
////        }
////    }
////
//
//
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//
//    // 리사이클러뷰 아답터 생성.
//    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {
//
//        String datas[] = {"월","화","수","목","금","토","일"}; // 액티비티에서 생성해야 하는것. 왠만해서는 프래그먼트에 생성하지 않는다
//
//        @Override
//        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
//
//            return new Holder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(ListAdapter.Holder holder, int position) {
//
//            String item = datas[position];
//            holder.title.setText(item);
//        }
//
//        @Override
//        public int getItemCount() {
//            return datas.length;
//        }
//
//
//        class Holder extends RecyclerView.ViewHolder{
//
//            TextView title;
//            LinearLayout item;
//
//            public Holder(View itemView) {
//                super(itemView);
//
//                title = (TextView) itemView.findViewById(R.id.title);
//                item = (LinearLayout) itemView.findViewById(R.id.item);
//
//                item.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mListener.goDetail(0);
//                    }
//                });
//            }
//        }
//    }
//}
