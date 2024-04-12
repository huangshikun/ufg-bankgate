package com.hundsun.ufg.bankgate.cmbc.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcResponse;

/**
 * @author huangsk20406
 * @create 2019-09-03 15:50
 */
public class SyncWriteMap {

	public static Map<String, WriteFuture<CmbcResponse>> SYNCKEY = new ConcurrentHashMap<>();

}
