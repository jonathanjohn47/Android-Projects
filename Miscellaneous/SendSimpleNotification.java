private void sendNotification() {
        Log.e("TAG", "Entered sendNotification() method");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("ALERT!!!");
        builder.setContentText("Some suspicious activity is detected. Please take quick action");
        builder.setPriority(NotificationManager.IMPORTANCE_HIGH);
        builder.setAutoCancel(true);

        //To open particular activity after user clicks on the notification
        Intent notificationIntent = new Intent(mContext, MainActivity.class);
        notificationIntent.putExtra("Alert", 1);
        PendingIntent contentIntent = PendingIntent.getActivity(mContext, 1, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        //-----------------------------------------------------------------

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "alert_node_mcu";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        notificationManager.notify(001, builder.build());
        Log.e("TAG", "Exiting sendNotification() method");
    }
