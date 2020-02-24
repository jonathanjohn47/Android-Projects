public class CallReceiver extends BroadcastReceiver {

    Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("BroadcastReceiver", intent.getAction());
        /*if (intent.getAction().equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String phonenumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
            Log.e("Ph.No", phonenumber);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.e("Phone Number", number);
            Toast.makeText(context, number,Toast.LENGTH_SHORT).show();
        }*/

        mContext = context;
        // TELEPHONY MANAGER class object to register one listner
        TelephonyManager tmgr = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        //Create Listner
        MyPhoneStateListener PhoneListener = new MyPhoneStateListener();

        // Register listener for LISTEN_CALL_STATE
        tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    private class MyPhoneStateListener extends PhoneStateListener {

        public void onCallStateChanged(int state, String incomingNumber) {
            if (state == TelephonyManager.CALL_STATE_RINGING){
                Log.e("State", state+"");
                Log.e("Phone Number", incomingNumber);

                if (incomingNumber.equals("+919494692189")){
                    //TODO: Do something with this number
                }
            }
        }
    }
}
