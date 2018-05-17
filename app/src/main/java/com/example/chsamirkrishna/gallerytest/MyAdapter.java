package com.example.chsamirkrishna.gallerytest;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.VideoView;

import java.io.File;
import java.util.zip.Inflater;

public class MyAdapter extends BaseAdapter {

    String path;
    File f;
    File[] files;
    MainActivity mActivity;

    MyAdapter(MainActivity mActivity){
        path="storage/sdcard0/WhatsApp/Media/WhatsApp Video/";
        f =new File(path);
        if(!f.exists()){
            path="storage/emulated/0/WhatsApp/Media/WhatsApp Video/";
            f =new File(path);
        }
        files=f.listFiles();
        this.mActivity=mActivity;
    }



    @Override
    public int getCount() {
        return files.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= LayoutInflater.from(mActivity);
        View v =inflater.inflate(R.layout.indiview,null);

        final VideoView vview =v.findViewById(R.id.vview1);
        CheckBox cb=v.findViewById(R.id.cb1);

        File f1=files[position];
        vview.setVideoURI(Uri.fromFile(f1));

        cb.setText(f1.getName());
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    vview.start();

                }else {
                    vview.pause();
                }
            }
        });
        return v;
    }
}
