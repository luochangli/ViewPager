package cn.bingoogol.viewpager.util;

import java.util.List;

import cn.bingoogol.viewpager.App;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

public class ServiceStatusUtils {
	private ServiceStatusUtils() {
	}

	/**
	 * 检测服务的运行状态
	 * 
	 * @param serviceName
	 *            服务的完整类名
	 * @return
	 */
	public static boolean isServiceRunning(String serviceName) {
		ActivityManager activityManager = (ActivityManager) App.getInstance().getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> infos = activityManager.getRunningServices(100);
		for (RunningServiceInfo info : infos) {
			if (serviceName.equals(info.service.getClassName())) {
				return true;
			}
		}
		return false;
	}
}