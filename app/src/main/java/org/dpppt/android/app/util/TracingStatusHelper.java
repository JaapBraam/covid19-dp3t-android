/*
 * Created by Ubique Innovation AG
 * https://www.ubique.ch
 * Copyright (c) 2020. All rights reserved.
 */

package org.dpppt.android.app.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import org.dpppt.android.app.R;

public class TracingStatusHelper {

    public static void updateStatusView(View statusView, State state, @StringRes int title, @StringRes int text) {
        Context context = statusView.getContext();

        ImageView iconView = statusView.findViewById(R.id.status_icon);
        TextView titleView = statusView.findViewById(R.id.status_title);
        TextView textView = statusView.findViewById(R.id.status_text);

        titleView.setText(title);
        titleView.setTextColor(context.getColor(state.titleColor));
        textView.setText(text);
        textView.setTextColor(context.getColor(state.textColor));
        iconView.setImageResource(state.iconResource);
    }

    public enum State {
        OK(R.color.regular_main, R.color.regular_main, R.drawable.ic_green_check),
        INFO(R.color.regular_main, R.color.regular_main, R.drawable.ic_info),
        WARNING(R.color.regular_main, R.color.regular_main, R.drawable.ic_warning);

        private final int titleColor;
        private final int textColor;
        private final int iconResource;

        State(@ColorRes int titleColor, @ColorRes int textColor, @DrawableRes int iconResource) {
            this.titleColor = titleColor;
            this.textColor = textColor;
            this.iconResource = iconResource;
        }
    }

}
