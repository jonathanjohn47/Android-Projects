@Override
                public void onClick(View v) {
                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            String ampm = "AM";
                            int twelvehourHour = selectedHour%12;
                            if (selectedHour > 12){
                                ampm = "PM";
                            }
                            if (selectedMinute<10){
                                textView.setText( twelvehourHour + ":0" + selectedMinute + " " +ampm);
                            }
                            else {
                                textView.setText(twelvehourHour + ":" + selectedMinute + " " +ampm);
                            }
                        }
                    }, hour, minute, false);//Yes 24 hour time
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
                }
