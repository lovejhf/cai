package com.ntcai.ntcc.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.FragmentTabAdapter;
import com.ntcai.ntcc.ui.fragment.HomeFragment;
import com.ntcai.ntcc.ui.fragment.MineFragment;
import com.ntcai.ntcc.ui.fragment.ShopTypeFragment;
import com.ntcai.ntcc.ui.fragment.ShoppingCartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks,
        EasyPermissions.RationaleCallbacks{
    @BindView(R.id.FrameAct_FragmentGroup)
    FrameLayout FrameActFragmentGroup;
    @BindView(R.id.tab_home)
    RadioButton tabHome;
    @BindView(R.id.tab_find)
    RadioButton tabFind;
    @BindView(R.id.tab_cart)
    RadioButton tabCommunity;
    @BindView(R.id.tab_mine)
    RadioButton tabMine;
    @BindView(R.id.RadioG_Bottem)
    RadioGroup RadioGBottem;
    private List<Fragment> list = new ArrayList<>();
    public FragmentTabAdapter tabAdapter;
    private static final String[] LOCATION_AND_CONTACTS =
            {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA};
    private static final int RC_LOCATION_CONTACTS_PERM = 124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list.add(new HomeFragment());
        list.add(new ShopTypeFragment());
        list.add(new ShoppingCartFragment());
        list.add(new MineFragment());
        tabAdapter = new FragmentTabAdapter(this, list, R.id.FrameAct_FragmentGroup, RadioGBottem);
        for (int i = 0; i < RadioGBottem.getChildCount(); i++) {
            if (RadioGBottem.getChildAt(i) instanceof RadioButton) {
                final RadioButton radioButton = (RadioButton) RadioGBottem.getChildAt(i);
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            if (buttonView.getText().toString().trim().equals("首页")||buttonView.getText().toString().trim().equals("购物车")) {
                                setAnimal(buttonView);
                            } else {
                                setAnimalY(buttonView);
                            }
                        }


                    }
                });
            }
        }
        locationAndContactsTask();

    }

    private void setAnimalY(View imageView) {
        android.animation.AnimatorSet set = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator icon_anim = android.animation.ObjectAnimator.ofFloat(imageView, "rotationY", 0.0F, 359.0F);
        set.playTogether(icon_anim);
        set.setDuration(800);
        set.start();
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
    @AfterPermissionGranted(RC_LOCATION_CONTACTS_PERM)
    public void locationAndContactsTask() {
        if (hasLocationAndContactsPermissions()) {
            // Have permissions, do the thing!
//            Toast.makeText(this, "TODO: Location and Contacts things", Toast.LENGTH_LONG).show();
        } else {
            // Ask for both permissions
            EasyPermissions.requestPermissions(
                    this,
                    "当前app需要获取您的定位和相机权限",
                    RC_LOCATION_CONTACTS_PERM,
                    LOCATION_AND_CONTACTS);
        }
    }
    private boolean hasLocationAndContactsPermissions() {
        return EasyPermissions.hasPermissions(this, LOCATION_AND_CONTACTS);
    }
    private void setAnimal(View view) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "scaleX", 0.75f, 1.3f, 1f, 1.2f, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleY", 0.75f, 1.3f, 1f, 1.2f, 1f);
        set.playTogether(animator1, animator2);
        set.setDuration(800);
        set.start();
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Log.d("----", "onPermissionsGranted:" + requestCode + ":" + perms.size());
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onRationaleAccepted(int requestCode) {
        Log.d("----", "onRationaleAccepted:" + requestCode);
    }

    @Override
    public void onRationaleDenied(int requestCode) {
        Log.d("-----", "onRationaleDenied:" + requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
