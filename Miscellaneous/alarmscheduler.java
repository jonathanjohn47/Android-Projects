Intent intent = new Intent(getApplicationContext(), LocationService.class);
                        PendingIntent pendingIntentStart = PendingIntent.getService(getApplicationContext(), 0, intent, 0);
                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, currentStarttime, TimeUnit.DAYS.toMillis(1), pendingIntentStart);
