package fr.rhoekath.filemanager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.rhoekath.filemanager.drawer.DrawerAdapter;
import fr.rhoekath.filemanager.drawer.DrawerItem;
import fr.rhoekath.filemanager.fragment.ImageFragment;
import fr.rhoekath.filemanager.fragment.TextFragment;
import fr.rhoekath.filemanager.fragment.VideoFragment;

public class MainActivity extends Activity {

    private List<DrawerItem> lDrawerItems;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private ActionBarDrawerToggle mDrawerToggle;

    private Drawable iconPage;
    private Drawable iconHome;
    private CharSequence titlePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconHome = getResources().getDrawable(R.drawable.home_icon);
        setIcon(iconHome);

        lDrawerItems = new ArrayList<DrawerItem>();
        lDrawerItems.add(new DrawerItem(getResources().getDrawable(R.drawable.image_icon), getResources().getString(R.string.menu1)));
        lDrawerItems.add(new DrawerItem(getResources().getDrawable(R.drawable.text_icon), getResources().getString(R.string.menu2)));
        lDrawerItems.add(new DrawerItem(getResources().getDrawable(R.drawable.movie_icon), getResources().getString(R.string.menu3)));

        titlePage = getResources().getString(R.string.app_name);

        getActionBar().setTitle(titlePage);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerListView = (ListView) findViewById(R.id.left_drawer);
        mDrawerListView.setAdapter(new DrawerAdapter(this, lDrawerItems));
        mDrawerListView.setOnItemClickListener(new DrawerListListener());
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                setTitle(titlePage);
                getActionBar().setIcon(iconPage);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setIcon(iconHome);
                getActionBar().setTitle(getResources().getString(R.string.drawer_open));
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public class DrawerListListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new ImageFragment();
                iconPage = getResources().getDrawable(R.drawable.image_icon);
                break;
            case 1:
                fragment = new TextFragment();
                iconPage = getResources().getDrawable(R.drawable.text_icon);
                break;
            case 2:
                fragment = new VideoFragment();
                iconPage = getResources().getDrawable(R.drawable.movie_icon);
                break;
            default:
                fragment = new ImageFragment();
                iconPage = getResources().getDrawable(R.drawable.image_icon);
                break;
        }

        setIcon(iconPage);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        mDrawerListView.setItemChecked(position, true);
        getActionBar().setTitle(lDrawerItems.get(position).getTextView());
        mDrawerLayout.closeDrawer(mDrawerListView);
    }

    private void setIcon(Drawable drawable)
    {
        getActionBar().setIcon(drawable);
    }
}
