package com.zhihu.matisse.listener;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public interface IPickImageIntentRequest{
    Intent createIntent(@NonNull Context context, @NonNull Integer pickType);
}