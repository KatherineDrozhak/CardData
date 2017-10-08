package com.example.katrindrozhak.carddata;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;

public class SpannableText {

    public static Spannable setupBoldText(String str, int start, int end) {
        Spannable text = new SpannableString(str);
        text.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return text;
    }
}
