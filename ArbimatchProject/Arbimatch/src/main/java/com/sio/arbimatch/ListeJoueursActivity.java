package com.sio.arbimatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by jrinquepach on 06/12/13.
 */
public class ListeJoueursActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listejoueur);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListeJoueurs.versTableau());
        ListView list = (ListView)findViewById(R.id.liste_joueur);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getBaseContext() , DetailJoueurActivity.class);
                intent.putExtra("positionJoueur",position);
                startActivityForResult(intent,1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==1){
            if(resultCode == RESULT_OK){
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListeJoueurs.versTableau());
                ListView list = (ListView)findViewById(R.id.liste_joueur);
                list.setAdapter(adapter);
            }
        }

    }
}
