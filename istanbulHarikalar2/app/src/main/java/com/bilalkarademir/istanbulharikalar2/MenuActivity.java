package com.bilalkarademir.istanbulharikalar2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    Context context = this;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        ArrayList<String> menuItem = new ArrayList<>();
        menuItem.add("AnaSayfam");
        menuItem.add("Hakkımızda");
        menuItem.add("Çıkış");

        for(String item : menuItem){
            MenuItem menuItem1 = menu.add(item);
            menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    if(item.getTitle().equals("AnaSayfam")){

                        Intent intent = new Intent(context,MainActivity.class);
                        startActivity(intent);
                        return true;
                    }
                    if(item.getTitle().equals("Hakkımızda")){

                        Intent intent = new Intent(context,HakkimizdaActivity.class);
                        startActivity(intent);

                        return true;
                    }
                    if(item.getTitle().equals("Çıkış")){

                        finish();

                        return true;
                    }
                    return true;
                }
            });
        }

        return super.onCreateOptionsMenu(menu);
    }

}
