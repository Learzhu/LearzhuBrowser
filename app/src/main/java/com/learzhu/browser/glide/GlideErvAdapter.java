package com.learzhu.browser.glide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.learzhu.browser.R;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


/**
 * GlideErvAdapter.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-04-24 15:42
 * @update Learzhu 2019-04-24 15:42
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class GlideErvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Context mContext;

    public GlideErvAdapter(int layoutResId, @Nullable List<String> data, Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        Glide.with(mContext).load(item).transform(new RoundedCorners(40)).into((ImageView) helper.getView(R.id.img_content));
        Glide.with(mContext).load(item)
                .apply(bitmapTransform(new RoundedCornersTransformation(45, 0, RoundedCornersTransformation.CornerType.ALL)))
                .into((ImageView) helper.getView(R.id.img_content));

//        Glide.with(mContext).load(item).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().placeholder(R.drawable.img_loading).error(R.drawable.img_loading)
//                .apply(bitmapTransform(new RoundedCornersTransformation(40, 0, RoundedCornersTransformation.CornerType.ALL)))
//                .into((ImageView) helper.getView(R.id.img_content));

//        GlideCircleTransform glideCircleTransform = new GlideCircleTransform(mContext, -1, 30);
//
//        RequestOptions options = new RequestOptions().transform(new GlideCircleTransform(mContext, mContext.getResources().getColor(R.color.colorAccent), 20));
//        Glide.with(mContext).load(item).apply(options).into((ImageView) helper.getView(R.id.img_content));

//        glideCircleTransform.setExceptCorner(true, true, true, true);
//        Glide.with(mContext).load(item).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().placeholder(R.drawable.img_loading).error(R.drawable.img_loading)
//                .transform(glideCircleTransform)
//                .into((ImageView) helper.getView(R.id.img_content));
    }
}
