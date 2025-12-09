package com.recibopagos.plugins.onboarding;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.LifecycleOwner;

import android.content.Intent;
import android.content.ComponentName;
import android.util.Log;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.JSObject;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "onboarding")
public class OnboardingPlugin extends Plugin {

    private static final String TAG = "OnboardingPlugin";

    private ActivityResultLauncher<Intent> activityResultLauncher;
    private PluginCall savedCall;

    @Override
    public void load() {
        super.load();

        ActivityResultRegistry registry = getActivity().getActivityResultRegistry();

        LifecycleOwner lifecycleOwner = (LifecycleOwner) getActivity();

        activityResultLauncher = registry.register(
                "onboarding_plugin_key",
                lifecycleOwner,
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                handleActivityResult(result);
            }
        }
        );
    }

    @PluginMethod
    public void sendIntent(PluginCall call) {
        savedCall = call;
        saveCall(call);

        int monto = call.getInt("monto", 0);
        String orden_id = call.getString("orden_id", "");
        String st = call.getString("st", "");
        String channel = call.getString("channel", "");
        String tipo = call.getString("tipo", "");

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.recibopagos.pos", "com.recibopagos.pos.view.activity.ActivitySplash"));
        intent.setAction("com.recibopagos.pos.sibus-payment");
        intent.putExtra("sibus_monto", monto);
        intent.putExtra("sibus_payment_method", method);
        intent.putExtra("sibus_tips", tips);

        activityResultLauncher.launch(intent);
        Log.d(TAG, "Launched activity for result");
    }

    private void handleActivityResult(ActivityResult result) {

        if (savedCall == null) {
            Log.w(TAG, "No saved PluginCall to resolve");
            return;
        }

        int resultCode = result.getResultCode();
        Intent data = result.getData();

        if (resultCode == -1 && data != null) {
            String order_id = data.getStringExtra("order_id");
            String status_paid = data.getStringExtra("status_paid");

            JSObject ret = new JSObject();
            ret.put("order_id", order_id);
            ret.put("status_paid", status_paid);

            savedCall.resolve(ret);
        } else if (resultCode == getActivity().RESULT_CANCELED) {
            savedCall.reject("User canceled the operation");
        } else {
            savedCall.reject("Unknown result from activity");
        }

        savedCall = null;
    }
}
