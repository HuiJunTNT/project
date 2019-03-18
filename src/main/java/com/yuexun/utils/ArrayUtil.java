package com.yuexun.utils;

import java.util.ArrayList;


/**
 * @author wangjinshui
 */
public class ArrayUtil {
	/**
	 * 判断数组的长度是否一致，用于校验接口参数的数量一致性
	 * @param objArray
	 * @return
	 */
	public static boolean isSameLength(Object... objArray) {
		if (objArray == null || objArray.length < 2)
			return false;
		
		ArrayList<Integer> lenList = new ArrayList<>();
		for (Object each : objArray) {
			if (each == null) {
				lenList.add(new Integer(0));
			} else if (each.getClass().isArray()) {
				lenList.add(new Integer(((Object[])each).length));
			} else {
				return false;
			}
		}
		
		for (int i = 1, baseLen = lenList.get(0).intValue(), size = lenList.size(); i < size; i++) {
			if (baseLen != lenList.get(i).intValue()) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static boolean isNotSameLength(Object... objArray) {
		return !isSameLength(objArray);
	}
}
