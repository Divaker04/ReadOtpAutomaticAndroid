package com.example.readotpautomatic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OTP_RECEIVER extends BroadcastReceiver {
    private static EditText editText;
    public void setEditText(EditText editText){
        OTP_RECEIVER.editText=editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] smsMessages= Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage sms:smsMessages){
            String message=sms.getMessageBody();
//            String otp = message.split(": ")[0];
//            editText.setText(otp);
            Pattern otpPattern = Pattern.compile("(|^)\\d{6}");
         Matcher matcher=otpPattern.matcher(message);
            if (matcher.find()){
                editText.setText(matcher.group(0));
            }
        }
    }
}
