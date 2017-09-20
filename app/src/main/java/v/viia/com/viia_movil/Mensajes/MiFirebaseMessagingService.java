package v.viia.com.viia_movil.Mensajes;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import v.viia.com.viia_movil.R;
import v.viia.com.viia_movil.Task;

/**
 * Created by JuanValdemar on 19/09/2017.
 */

public class MiFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = "NOTICIAS";

    //Aqui llegarán los mensajes o notificaciones que nos manden
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG,"Mensaje recibido de: "+ from);

        if (remoteMessage.getNotification() !=null){
            Log.d(TAG, "Notificación; " + remoteMessage.getNotification().getBody());
            mostrarNotificacion("Legal Móvil UCV",
                    remoteMessage.getNotification().getBody());

        }
        if(remoteMessage.getData().size() > 0){
            Log.d(TAG,"Data: "+ remoteMessage.getData());

        }


    }
    private void mostrarNotificacion( String title, String body){


        Intent intent = new Intent (this, Task.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        NotificationCompat.Builder notificationBuilder = (android.support.v7.app.NotificationCompat.Builder)
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Legal Móvil")
                        .setContentText(body)
                        .setAutoCancel(true)
                        .setSound(soundUri)
                        .setContentIntent(pendingIntent);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }

}
