package co.edu.unipiloto.mymessenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMessageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    //Call onSendMessage() when the button is clicked
    public void onSendMessage(View view){
        EditText locationView=(EditText) findViewById(R.id.location);
        String locationText=locationView.getText().toString();
        EditText destinationView=(EditText) findViewById(R.id.destination);
        String destinationText=destinationView.getText().toString();
        if(locationText.equals("")||destinationText.equals("")){
            Toast.makeText(getApplicationContext(),"Complete los campos, por favor",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent=new Intent(this,ReceiveMessageActivity.class);
            intent.putExtra("message","Ubicacion: "+locationText+" Destino: "+destinationText );
            startActivity(intent);
        }


    }
    public void onGetMaps(View view){
        EditText locationView=(EditText) findViewById(R.id.location);
        String locationText=locationView.getText().toString();
        EditText destinationView=(EditText) findViewById(R.id.destination);
        String destinationText=destinationView.getText().toString();
        if(locationText.equals("")||destinationText.equals("")){
            Toast.makeText(getApplicationContext(),"Complete los campos, por favor",Toast.LENGTH_SHORT).show();
        }else{
            try {
                Uri uri= Uri.parse("https://www.google.co.in/maps/dir/"+locationText+"/"+destinationText);
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps" );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }catch (ActivityNotFoundException e){
                Uri uri= Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps"+locationText+"/"+destinationText);
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }

    }
}
