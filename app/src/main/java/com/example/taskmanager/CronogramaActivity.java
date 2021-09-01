package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CronogramaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma);
        final EditText msg = (EditText) findViewById(R.id.editTexto);
        Button enviar = (Button) findViewById(R.id.button8);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CronogramaActivity.this, NotificationActivity.class);
                intent.putExtra("mensagem", msg.getText().toString());
                int id = (int) (Math.random() * 1000);
                PendingIntent pi = PendingIntent.getActivity(getBaseContext(), id,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);
                Notification notification = new Notification.Builder(getBaseContext())
                        .setContentTitle("De: Escola Mário Brasil:")
                        .setContentText(msg.getText()).setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pi).build();
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                notificationManager.notify(id, notification);

            }
        });

    }
}