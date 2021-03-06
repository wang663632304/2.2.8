package com.sumavision.talktv2.task;

import android.content.Context;
import android.os.AsyncTask;

import com.sumavision.talktv2.net.NetConnectionListener;
import com.sumavision.talktv2.net.NetUtil;
import com.sumavision.talktv2.net.RecommendVodProgramListParser;
import com.sumavision.talktv2.net.RecommendVodProgramListRequest;

public class RecommendVodProgramTask extends AsyncTask<Object, Void, String> {

	private NetConnectionListener listener;
	private final String method = "hotVodProgramList";

	@Override
	protected String doInBackground(Object... params) {
		Context context;
		RecommendVodProgramListRequest request;
		RecommendVodProgramListParser parser;
		String data;
		context = (Context) params[0];
		listener = (NetConnectionListener) params[1];
		request = (RecommendVodProgramListRequest) params[2];
		parser = (RecommendVodProgramListParser) params[3];
		data = request.make();
		listener.onNetBegin(method);
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
