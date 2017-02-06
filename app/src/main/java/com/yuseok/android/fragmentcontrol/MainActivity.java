package com.yuseok.android.fragmentcontrol;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    // 1. 사용할 프래그먼트 선언
    ListFragment list;
    DetailFragment detail;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 프래그먼트 생성
        list = new ListFragment();
        detail = new DetailFragment();
        // 리스트 프래그먼트에 나자신을 넘겨준다.
        list.setActivity(this);
        detail.setActivity(this);

        // 3. 프래그먼트 매니저 가져오기
        manager = getSupportFragmentManager();


        setList();
    }

    // Activity 에 처음 목록이 세팅될때
    public void setList(){
        // 1. 프래그먼트를 실행하기위한 트랜잭션 시작
        FragmentTransaction transaction = manager.beginTransaction();
        // 2. 프래그먼트를 레이아웃에 add 한다
        transaction.add(R.id.fragment, list);
        // 최초 호출되는 프래그먼트는 addToBackStack 을 사용하지 않는다
        //transaction.addToBackStack(null);
        // 3. git 의 commit 과 같은 기능
        transaction.commit();
    }

    // 리스트에서 상세로 이동할때
    public void goDetail(){
        // 1. 프래그먼트를 실행하기위한 트랜잭션 시작
        FragmentTransaction transaction = manager.beginTransaction();
        // 2. 프래그먼트를 레이아웃에 add 한다
        transaction.add(R.id.fragment, detail);
        // 3. 커밋전에 트랜잭션 전체를 stack 에 저장을 합니다. 뒤로가기시 스택관리를 할 수 있습니다.
        transaction.addToBackStack(null);
        // 4. git 의 commit 과 같은 기능
        transaction.commit();
    }

    // Detail 프래그먼트에서 List 로 돌아갈때
    public void backToList(){
        // 뒤로가기로 스택을 빼내면 된다 - popBackStack 에 해당하는 함수이다.
        super.onBackPressed();
//        // 1. 프래그먼트를 실행하기위한 트랜잭션 시작
//        FragmentTransaction transaction = manager.beginTransaction();
//        // 2. detail 프래그먼트를 스택에서 제거한다
//        transaction.remove(detail);
//        // 3. 커밋
//        transaction.commit();
    }


}



//public class MainActivity extends AppCompatActivity implements ListFragment.Listener, DetailFragment.OnDetailListener{
//
//    // data변수를 MainActivity에 정의
//    String datas[] = {"월","화","수","목","금","토","일"};
//    ListFragment list;
//    DetailFragment detail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//       // 1. 프래그먼트 생성
//            list = new ListFragment();
//            detail = new DetailFragment();
////
////        // 2. 프래그먼트 매니저 가져오기
////        // getFragmentManager(); //  앱 호환성이 없는 함수 // 타겟 버전 외의 다른 버전에서는 정상 동작이 안될 확률이 있다.
////        FragmentManager manager = getSupportFragmentManager(); // 앱 호환성이 있는 매니저 함수
////
////        // Transaction = 초기화 가능한 작업단위
////        // 3. 프래그먼트를를 실행하기 위한 트랜잭션 시작
////        FragmentTransaction transaction = manager.beginTransaction();
////        // 4. 프래그먼트를 레이아웃에 add한다
////        transaction.add(R.id.fragment/*위젯 id값*/ , fragment/* 위에서 생성한 프래그먼트*/);
////
////        // commit이 되면 뒤로 돌릴 수 없고, commit되기 전이면 되돌릴 수 있다.
////        // 5. git의 commit과 같은 기능
////        transaction.commit();
//    }
//
//    // 2. 인터페이스 구현
//    @Override
//    public String[] getData() {
//        return datas;
//    }
//
//    public void goDetail(int position) {
//
//          // 2. 프래그먼트 매니저 가져오기
//        // getFragmentManager(); //  앱 호환성이 없는 함수 // 타겟 버전 외의 다른 버전에서는 정상 동작이 안될 확률이 있다.
//        FragmentManager manager = getSupportFragmentManager(); // 앱 호환성이 있는 매니저 함수
//
//        // Transaction = 초기화 가능한 작업단위
//        // 3. 프래그먼트를를 실행하기 위한 트랜잭션 시작
//        FragmentTransaction transaction = manager.beginTransaction();
//        // 4. 프래그먼트를 레이아웃에 add한다
//        transaction.add(R.id.fragment/*위젯 id값*/ , detail/* 위에서 생성한 프래그먼트*/);
//
//        // commit이 되면 뒤로 돌릴 수 없고, commit되기 전이면 되돌릴 수 있다.
//        // 5. git의 commit과 같은 기능
//        transaction.commit();
//
//    }
//
//    @Override
//    public void goList() {
//        FragmentManager manager = getSupportFragmentManager(); // 앱 호환성이 있는 매니저 함수
//
//        // Transaction = 초기화 가능한 작업단위
//        // 3. 프래그먼트를를 실행하기 위한 트랜잭션 시작
//        FragmentTransaction transaction = manager.beginTransaction();
//        // 4. Detail프래그먼트 하나를 떼어낸다.
//        transaction.detach(detail);
//
//        // commit이 되면 뒤로 돌릴 수 없고, commit되기 전이면 되돌릴 수 있다.
//        // 5. git의 commit과 같은 기능
//        transaction.commit();
//    }
//}
