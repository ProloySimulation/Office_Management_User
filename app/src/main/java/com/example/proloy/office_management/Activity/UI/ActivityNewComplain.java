package com.example.proloy.office_management.Activity.UI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proloy.office_management.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;

/**
 * Created by Proloy on 4/9/2017.
 */
public class ActivityNewComplain extends AppCompatActivity {


    private EditText etTitle;
    private EditText etDetail;
    private TextView ivImage;
    private Button btnSubmit;
    private static final int PICK_PHOTO_FOR_AVATAR = 1;
    private static final int SELECT_FILE = 2;
    private StorageReference mStorage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_complain);

        mStorage = FirebaseStorage.getInstance().getReference();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etTitle = (EditText)findViewById(R.id.et_sendcomplain);
        etDetail = (EditText)findViewById(R.id.et_sendcomplain_detail);
        ivImage = (TextView) findViewById(R.id.iv_complain_photo);
        // btnSubmit = (Button) findViewById(R.id.btn_sendcomplain_submit);

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final CharSequence[] items = {"Take Photo", "Choose from Gallery",
                        "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityNewComplain.this);
                builder.setTitle("Add Photo!");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Take Photo")) {

                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);

                        } else if (items[item].equals("Choose from Gallery")) {
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_GET_CONTENT);//
                            startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
                        } else if (items[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
                //startActivity(new Intent(ActivityComplainDetailsView.this,TakePhoto.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_FILE && resultCode == RESULT_OK)
        {
            Uri uri = data.getData();
            StorageReference file = mStorage.child("Images").child(uri.getLastPathSegment());
            Toast.makeText(ActivityNewComplain.this,"Uploading....",Toast.LENGTH_SHORT).show();
            file.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(ActivityNewComplain.this,"Upload Done",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
