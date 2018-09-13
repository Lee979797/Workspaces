package com.lhq.prj.bms.core;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;

import org.apache.ws.security.WSPasswordCallback;

public class PasswordHandler implements CallbackHandler {

	private static final Map<String, String> pwMockDB = new HashMap<String, String>();
	static {
		pwMockDB.put("client", "clientpass");
		pwMockDB.put("server", "serverpass");
		pwMockDB.put("tom", "123456");
	}

	public void handle(Callback[] callbacks) {
		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
		String id = callback.getIdentifer();
		callback.setPassword((String) pwMockDB.get(id));
	}
}
