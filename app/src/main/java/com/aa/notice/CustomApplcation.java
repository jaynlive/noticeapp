package com.aa.notice;


import com.aa.notice.network.OkHttpManager;
import com.aa.notice.utils.CrashHandler;
import com.aa.notice.utils.LogToFile;

import android.app.Application;
import android.content.Context;
//挂在模块
public class CustomApplcation extends Application {

	public static CustomApplcation mInstance;
	private static Context context;
	public static String  socketLoginIp="0.0.0.0";//默认是 0.0.0.0

	public static final  String CHANNEL_ID          = "aa_px_pay";
	public static final  String CHANNEL_Front          = "aa_px_pay_front";
	public static boolean PlaySounds = false;
	public static int Battery=0;
	public static final String IntentAction = "com.aa.Notification";

	//AA
        public static String base_url = "http://socket.baidu.com/";
        public static String base_socketurl = "ws://socket.baidu.com:9092/";
        public static String base_common = "";

	public static String authorization_url = base_common + "api/authorization";


	public static String login_url = base_common + "api/login";

	public static boolean isStart = false;
	@Override
	public void onCreate() {
		super.onCreate();
		OkHttpManager.init(getApplicationContext());
		// 崩溃记录
		context = getApplicationContext();
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(context);
		LogToFile.init(context);
		mInstance = this;
		OkHttpManager.init(getApplicationContext());
	}

	public static CustomApplcation getInstance() {
		return mInstance;
	}

	public static Context getContext() {
		return context;
	}
}
