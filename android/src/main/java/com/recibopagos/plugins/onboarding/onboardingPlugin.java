package com.recibopagos.plugins.onboarding;

import android.content.Intent;
import android.content.ComponentName;
import android.os.Bundle;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "onboarding")
public class OnboardingPlugin extends Plugin {

    private static final int REQUEST_CODE = 12345;
    private PluginCall savedCall;

    @PluginMethod
    public void startActivityForResult(PluginCall call) {
        String packageName = call.getString("package");
        String className = call.getString("class");
        JSObject value = call.getObject("value", new JSObject());

        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, className));

        java.util.Iterator<String> keys = value.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            try {
                Object val = value.get(key);
                if (val instanceof String) {
                    intent.putExtra(key, (String) val);
                } else if (val instanceof Integer) {
                    intent.putExtra(key, (Integer) val);
                } else if (val instanceof Boolean) {
                    intent.putExtra(key, (Boolean) val);
                } else if (val instanceof Double) {
                    intent.putExtra(key, ((Double) val).doubleValue());
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                // Optionally, handle the error (e.g., skip this key or notify the JS side)
            }
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        savedCall = call;
        startActivityForResult(call, intent, REQUEST_CODE);
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && savedCall != null) {
            JSObject result = new JSObject();
            result.put("resultCode", resultCode);

            if (data != null && data.getExtras() != null) {
                Bundle extras = data.getExtras();
                JSObject extrasObj = new JSObject();
                for (String key : extras.keySet()) {
                    Object val = extras.get(key);
                    extrasObj.put(key, val != null ? val.toString() : null);
                }
                result.put("extras", extrasObj);
            }

            savedCall.resolve(result);
            savedCall = null;
        }
    }
}
