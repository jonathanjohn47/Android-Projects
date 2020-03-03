
private DrawerLayout drawerLayout;
private NavigationView navigationView;
private ActionBarDrawerToggle actionBarDrawerToggle;

private void setupNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_change_prize:{
                        Log.e("TAG", "Change Prize");
                        startActivity(new Intent(MainActivity.this, ChangePrizeActivity.class));
                        break;
                    }
                    case R.id.nav_logout:{
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", "NULL");
                        editor.putString("password", "NULL");
                        editor.commit();
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                        break;
                    }
                    case R.id.change_password:{
                        changePassword = new ChangePassword(MainActivity.this);
                        changePassword.setCancelable(false);
                        changePassword.setOnChangePassword(new ChangePassword.onChangePassword() {
                            @Override
                            public void onSubmit(String oldpassword, String newpassword) {
                                if (checkIfOldPasswordIsCorrect(oldpassword)){
                                    changeThePassword(newpassword);
                                }
                                else{
                                    makeDialog("Error", "Could Not Update Password", false);
                                }
                            }

                            @Override
                            public void onCancel() {
                                changePassword.dismiss();
                            }
                        });
                        changePassword.show();
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
