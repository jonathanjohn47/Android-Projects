public ArrayList<String> getDatesBetween() throws ParseException {
        Date startDate=new SimpleDateFormat("dd-MMM-yyyy").parse(txtFrom.getText().toString());
        ArrayList<Date> datesInRange = new ArrayList<>();
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDate);

        Date endDate = new SimpleDateFormat("dd-MMM-yyyy").parse(txtUpto.getText().toString());

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);
        endCalendar.add(Calendar.DAY_OF_YEAR, 1);

        while (startCalendar.before(endCalendar)) {
            Date result = startCalendar.getTime();
            datesInRange.add(result);
            startCalendar.add(Calendar.DATE, 1);
        }
        ArrayList<String> returnDates = new ArrayList<>();
        for(Date d: datesInRange){
            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String date = df.format(d);
            returnDates.add(date);
        }
        return returnDates;
    }
