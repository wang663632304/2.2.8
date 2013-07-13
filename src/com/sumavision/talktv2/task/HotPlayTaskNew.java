package com.sumavision.talktv2.task;

import android.content.Context;
import android.os.AsyncTask;

import com.sumavision.talktv2.net.HotPlayParser;
import com.sumavision.talktv2.net.HotPlayRequest;
import com.sumavision.talktv2.net.NetConnectionListenerNew;
import com.sumavision.talktv2.net.NetUtil;

public class HotPlayTaskNew extends AsyncTask<Object, Integer, String> {
	private final NetConnectionListenerNew listener;
	private final String method = "hotPlay";

	public HotPlayTaskNew(NetConnectionListenerNew listener) {
		this.listener = listener;
	}

	@Override
	protected void onPreExecute() {
		listener.onNetBegin(method, false);
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(Object... params) {
		Context context;
		HotPlayRequest request;
		HotPlayParser parser;
		String data;
		context = (Context) params[0];
		request = (HotPlayRequest) params[1];
		parser = (HotPlayParser) params[2];
		data = request.make();

		String s = NetUtil.execute(context, data, null);
		if (s != null) {
			String result = parser.parse(s);
			return result;
		} else {
			return null;
		}
	}

	@Override
	protected void onCancelled() {
		listener.onCancel(method);
		super.onCancelled();
	}

	@Override
	protected void onPostExecute(String result) {

		try {
			listener.onNetEnd(result, method);
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		super.onPostExecute(result);
	}
}
