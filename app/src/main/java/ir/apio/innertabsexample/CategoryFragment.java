package ir.apio.innertabsexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by Amir on 8/20/2016 AD
 * Project : InnerTabsExample
 * GitHub  : @AmirHadifar
 * Twitter : @AmirHadifar
 */
public class CategoryFragment extends Fragment {
    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        initViews(rootView);

        return rootView;
    }

    private void initViews(View rootView) {

        ViewPager mPager = (ViewPager) rootView.findViewById(R.id.vp_pager);
        mPager.setOffscreenPageLimit(4);
        CategoryAdapter mAdapter = new CategoryAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);

        PagerSlidingTabStrip mIndicator = (PagerSlidingTabStrip) rootView.findViewById(R.id.vp_indicator);
        mIndicator.setViewPager(mPager);
        
        
        //// TODO: 8/20/2016 AD implement buttons here
    }

    private class CategoryAdapter extends FragmentPagerAdapter {

        public CategoryAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return SimpleFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Inner tabs" + position;
        }
    }

    public static class SimpleFragment extends Fragment {

        public static SimpleFragment newInstance(int pos) {

            Bundle args = new Bundle();
            args.putInt("TEST", pos);
            SimpleFragment fragment = new SimpleFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.framgent_simple, container, false);
            int pos = getArguments().getInt("TEST");

            ((TextView) rootView.findViewById(R.id.txt_view)).setText("Im fragment number" + pos);
            return rootView;
        }
    }
}
