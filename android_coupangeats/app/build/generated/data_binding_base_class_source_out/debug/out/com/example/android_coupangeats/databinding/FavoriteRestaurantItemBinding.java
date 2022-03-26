// Generated by view binder compiler. Do not edit!
package com.example.android_coupangeats.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.android_coupangeats.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FavoriteRestaurantItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageView chita;

  @NonNull
  public final AppCompatImageView img1Big;

  @NonNull
  public final AppCompatImageView imgStar;

  @NonNull
  public final TextView txtDelivertyPrice;

  @NonNull
  public final TextView txtDistance;

  @NonNull
  public final TextView txtMin;

  @NonNull
  public final TextView txtNameRestaurant;

  @NonNull
  public final TextView txtOut;

  @NonNull
  public final TextView txtPoint1;

  @NonNull
  public final TextView txtPoint2;

  @NonNull
  public final TextView txtReviewNum;

  @NonNull
  public final TextView txtStar;

  private FavoriteRestaurantItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageView chita, @NonNull AppCompatImageView img1Big,
      @NonNull AppCompatImageView imgStar, @NonNull TextView txtDelivertyPrice,
      @NonNull TextView txtDistance, @NonNull TextView txtMin, @NonNull TextView txtNameRestaurant,
      @NonNull TextView txtOut, @NonNull TextView txtPoint1, @NonNull TextView txtPoint2,
      @NonNull TextView txtReviewNum, @NonNull TextView txtStar) {
    this.rootView = rootView;
    this.chita = chita;
    this.img1Big = img1Big;
    this.imgStar = imgStar;
    this.txtDelivertyPrice = txtDelivertyPrice;
    this.txtDistance = txtDistance;
    this.txtMin = txtMin;
    this.txtNameRestaurant = txtNameRestaurant;
    this.txtOut = txtOut;
    this.txtPoint1 = txtPoint1;
    this.txtPoint2 = txtPoint2;
    this.txtReviewNum = txtReviewNum;
    this.txtStar = txtStar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FavoriteRestaurantItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FavoriteRestaurantItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.favorite_restaurant_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FavoriteRestaurantItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.chita;
      AppCompatImageView chita = ViewBindings.findChildViewById(rootView, id);
      if (chita == null) {
        break missingId;
      }

      id = R.id.img_1_big;
      AppCompatImageView img1Big = ViewBindings.findChildViewById(rootView, id);
      if (img1Big == null) {
        break missingId;
      }

      id = R.id.img_star;
      AppCompatImageView imgStar = ViewBindings.findChildViewById(rootView, id);
      if (imgStar == null) {
        break missingId;
      }

      id = R.id.txt_deliverty_price;
      TextView txtDelivertyPrice = ViewBindings.findChildViewById(rootView, id);
      if (txtDelivertyPrice == null) {
        break missingId;
      }

      id = R.id.txt_distance;
      TextView txtDistance = ViewBindings.findChildViewById(rootView, id);
      if (txtDistance == null) {
        break missingId;
      }

      id = R.id.txt_min;
      TextView txtMin = ViewBindings.findChildViewById(rootView, id);
      if (txtMin == null) {
        break missingId;
      }

      id = R.id.txt_name_restaurant;
      TextView txtNameRestaurant = ViewBindings.findChildViewById(rootView, id);
      if (txtNameRestaurant == null) {
        break missingId;
      }

      id = R.id.txt_out;
      TextView txtOut = ViewBindings.findChildViewById(rootView, id);
      if (txtOut == null) {
        break missingId;
      }

      id = R.id.txt_point_1;
      TextView txtPoint1 = ViewBindings.findChildViewById(rootView, id);
      if (txtPoint1 == null) {
        break missingId;
      }

      id = R.id.txt_point_2;
      TextView txtPoint2 = ViewBindings.findChildViewById(rootView, id);
      if (txtPoint2 == null) {
        break missingId;
      }

      id = R.id.txt_review_num;
      TextView txtReviewNum = ViewBindings.findChildViewById(rootView, id);
      if (txtReviewNum == null) {
        break missingId;
      }

      id = R.id.txt_star;
      TextView txtStar = ViewBindings.findChildViewById(rootView, id);
      if (txtStar == null) {
        break missingId;
      }

      return new FavoriteRestaurantItemBinding((ConstraintLayout) rootView, chita, img1Big, imgStar,
          txtDelivertyPrice, txtDistance, txtMin, txtNameRestaurant, txtOut, txtPoint1, txtPoint2,
          txtReviewNum, txtStar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
