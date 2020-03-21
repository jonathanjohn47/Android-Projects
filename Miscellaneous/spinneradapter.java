ArrayAdapter<String> madapter = new ArrayAdapter<String>(context,
                            android.R.layout.simple_spinner_item, allsubjects);
                    madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectSubject.setAdapter(madapter);
