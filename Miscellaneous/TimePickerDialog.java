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
            int twelvehourHour = 0;
            if (selectedHour > 12){
                ampm = "PM";
                twelvehourHour = selectedHour-12;
            }
            else{
                if (selectedHour == 12){
                    ampm = "PM";
                }
                twelvehourHour = selectedHour;
            }
            textView.setText(doubleDigit(twelvehourHour) +":"+ doubleDigit(selectedMinute) + " " + ampm);
        }
    }, hour, minute, false);//Yes 24 hour time
    mTimePicker.setTitle("Select Time");
    mTimePicker.show();
}

private String doubleDigit(int integer) {
    if (integer<10){
        return "0" + integer;
    }
    else{
        return ""+integer;
    }
}
