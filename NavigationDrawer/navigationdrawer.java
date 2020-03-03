//implementation 'com.android.support:design:22.2.1'
private DrawerLayout drawerLayout;
private NavigationView navigationView;
private ActionBarDrawerToggle actionBarDrawerToggle;

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupNavigationDrawer();
}

private void setupNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.Item1:{
                        //TODO: action
                        break;
                    }
                    case R.id.item2:{
                        //TODO: action 
                        break;
                    }
                    case R.id.item3:{
                        //TODO: logout
                        break;
                    }
                }
                return false;
            }
        });
        setSupportActionBar(mToolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
