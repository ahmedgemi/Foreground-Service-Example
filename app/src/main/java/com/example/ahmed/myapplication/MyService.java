package com.example.ahmed.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;


/**
 * Created by ahmed on 15/03/17.
 */

public class MyService extends Service {


    Task task = new Task();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        Toast.makeText(getApplicationContext(),"Service Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {

        Toast.makeText(getApplicationContext(),"Service Destroyed",Toast.LENGTH_SHORT).show();

        task.cancel(true);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        task.execute();


        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Title");
        builder.setContentText("ay 7aga");
        builder.setSmallIcon(R.drawable.ic_launcher);


        startForeground(111,builder.build());


        return START_STICKY;
    }


    private class Task extends AsyncTask<Void,Integer,Void> {


        @Override
        protected Void doInBackground(Void... params) {

            try{

                int i=0;

                while (true){

                    publishProgress(i);

                    Thread.sleep(2500);

                    i++;


                }


            }
            catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            Toast.makeText(getApplicationContext(),String.valueOf(values[0]),Toast.LENGTH_SHORT).show();
        }
    }
}
