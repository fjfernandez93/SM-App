package com.example.paco.supermarketfinder;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    //Miembros utilizados para el settingcheckbox
    public static final String SETTING_CHECK_BOX = "SETTING_CHECK_BOX";
    private ArrayList< SettingCheckBox > settingList;

    private ImageButton b_mercadona;
    private ImageButton b_dia;
    private ImageButton b_supersol;
    private ImageButton b_carrefour;
    private ImageButton b_alcampo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crea el array para la configuracion
        settingList = new ArrayList < SettingCheckBox > ();
        settingList.add(new SettingCheckBox("Option A"));
        settingList.add(new SettingCheckBox("Option B"));
        if ( savedInstanceState != null ) {
            settingList = (ArrayList < SettingCheckBox >) savedInstanceState.getSerializable ( SETTING_CHECK_BOX );
        }

        b_mercadona = (ImageButton) findViewById(R.id.b_mercadona);
        b_dia = (ImageButton) findViewById(R.id.b_dia);
        b_supersol = (ImageButton) findViewById(R.id.b_supersol);
        b_carrefour = (ImageButton) findViewById(R.id.b_carrefour);
        b_alcampo = (ImageButton) findViewById(R.id.b_alcampo);

        b_mercadona.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Uri gmmIntentUri = Uri.parse("geo:0,0?q=mercadona");
               Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
               mapIntent.setPackage("com.google.android.apps.maps");
               if (mapIntent.resolveActivity(getPackageManager()) != null) {
                   startActivity(mapIntent);
               }
           }
        });

        b_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=supermercado+dia");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        b_supersol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=supersol");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        b_carrefour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=carrefour");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        b_alcampo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=alcampo");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.about:
                DialogFragment newFragment = new InformationDialog();
                newFragment.show(getSupportFragmentManager(),"nuse");
                return true;
            /*case R.id.select:
                Intent intent = new Intent ( this , MyActivity_Settings.class );
                intent.putExtra ( SETTING_CHECK_BOX , settingList );
                startActivityForResult ( intent , 0 );*/
            default:
                return super.onOptionsItemSelected(item);
        }

        //return super.onOptionsItemSelected(item);
    }


    public static class InformationDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle onSaveInstances) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Aplication developped by +S Apps")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });                    ;
            // Create the AlertDialog object and return it
            return builder.create();
        }

    }


    protected void onSaveInstanceState ( Bundle outState ) {
        super.onSaveInstanceState ( outState );
        outState.putSerializable ( SETTING_CHECK_BOX , settingList );
    }

    protected void onActivityResult ( int requestCode , int resultCode , Intent data ) {
        if (resultCode != RESULT_OK || data == null)
            return;
        settingList = (ArrayList<SettingCheckBox>) data.getSerializableExtra(SETTING_CHECK_BOX);
    }

    private void reDrawElements(){
       // for
    }
}
