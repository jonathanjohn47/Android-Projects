@Override
public void onClick(View view) {
    DatePickerDialog datePickerDialog = new DatePickerDialog(StudentsLeaveRequests.this);
    datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            String date_s = i + "-" + (i1+1) + "-" + i2;
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-M-d");
            Date date;
            try {
                date = dt.parse(date_s);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy"); //Replace your own date format here
                mSelectDate.setText(dt1.format(date));
            } catch (ParseException e) {
                Log.e("error", e+"");
            }

        }
    });
    datePickerDialog.show();
}
