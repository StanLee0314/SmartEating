package com.example.steven.smarteating;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.steven.smarteating.activity.CommunityMapsActivity;
import com.example.steven.smarteating.activity.MapsActivity;
import com.example.steven.smarteating.activity.PlantingSuggestion;
import com.example.steven.smarteating.activity.QuizActivity;
import com.example.steven.smarteating.fragment.HomeFragment;
import com.example.steven.smarteating.fragment.NutritionSearchFragment;
import com.example.steven.smarteating.fragment.ReplacementFragment;
import com.example.steven.smarteating.fragment.UndernutritionFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven on 8/21/2018.
 * The menu for the application which contains five fragments and one activity to the account profile.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewPagers);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabsLayout);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {

        } else {

            mAuth.signInAnonymously();
        }
    }

    //tab
    public void setupViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), getResources().getString(R.string.Home));
        adapter.addFrag(new NutritionSearchFragment(), getResources().getString(R.string.NutritionSearch));
        adapter.addFrag(new ReplacementFragment(), "Replacements");
        adapter.addFrag(new UndernutritionFragment(), "Micronutrients");
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(adapter);
    }

    //initial
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> stringList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        public int getCount() {
            return fragmentList.size();
        }

        void addFrag(Fragment fragment, String title) {
            fragmentList.add(fragment);
            stringList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
    }
    //tab


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.nutritionFacts) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.nutritionReplacement) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.overcomeUndernutrition) {
            viewPager.setCurrentItem(3);
        } else if (id == R.id.planting) {
            Intent intent = new Intent(this, PlantingSuggestion.class);
            startActivity(intent);
        } else if (id == R.id.nutritionQuiz) {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        } else if (id == R.id.nearbyMarket) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        } else if (id == R.id.communityGargen) {
            Intent intent = new Intent(this, CommunityMapsActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


