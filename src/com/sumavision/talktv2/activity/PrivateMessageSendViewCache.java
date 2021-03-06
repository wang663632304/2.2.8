package com.sumavision.talktv2.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sumavision.talktv2.R;

/**
 * 
 * @author 郭鹏
 * 
 */
public class PrivateMessageSendViewCache {

	private View baseView;
	private TextView textView;
	private TextView time;
	private ImageView imageView;
	private ImageView pic;
	private ProgressBar pb;

	public PrivateMessageSendViewCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextView() {
		if (textView == null) {
			textView = (TextView) baseView.findViewById(R.id.pm_send_content);
		}
		return textView;
	}

	public TextView getTime() {
		if (time == null) {
			time = (TextView) baseView.findViewById(R.id.pm_send_time);
		}
		return time;
	}

	public ImageView getImageView() {
		if (imageView == null) {
			imageView = (ImageView) baseView.findViewById(R.id.pm_send_icon);
		}
		return imageView;
	}

	public ImageView getPic() {
		if (pic == null) {
			pic = (ImageView) baseView.findViewById(R.id.pm_send_pic);
		}
		return pic;
	}

	public ProgressBar getPb() {
		if (pb == null) {
			pb = (ProgressBar) baseView.findViewById(R.id.pm_send_progress);
		}
		return pb;
	}
}
