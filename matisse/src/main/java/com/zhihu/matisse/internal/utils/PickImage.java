package com.zhihu.matisse.internal.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zhihu.matisse.listener.IPickImageIntentRequest;
import com.zhihu.matisse.ui.MatisseActivity;

public class PickImage extends ActivityResultContract<Integer, ActivityResult> {
    public final static int PICK_GALLERY_IMAGE = 105;
    private int requestCode = 0;
    private Context context;
    private IPickImageIntentRequest iPickImageIntentRequest;
    public PickImage(Context context) {
        this.context = context;
    }
    public PickImage(Context context,IPickImageIntentRequest iPickImageIntentRequest) {
        this.context = context;
        this.iPickImageIntentRequest = iPickImageIntentRequest;
    }

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, @NonNull Integer pickType) {
        this.requestCode=pickType;
        return (iPickImageIntentRequest == null) ? new Intent(context, MatisseActivity.class) : iPickImageIntentRequest.createIntent(context,pickType);
    }

    @Override
    public ActivityResult parseResult(int resultCode, @Nullable Intent result) {
        return new ActivityResult(resultCode,result);
    }


}