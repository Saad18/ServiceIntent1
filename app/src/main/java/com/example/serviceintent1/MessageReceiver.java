package com.example.serviceintent1;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class MessageReceiver extends ResultReceiver {

    private final MainActivity.Message message;

    public MessageReceiver(MainActivity.Message message) {
        super(new Handler());

        this.message = message;
    }

    protected void onReceiveResult(int resultCode, Bundle resultData){
        message.displayMessage(resultCode, resultData);
    }
}
