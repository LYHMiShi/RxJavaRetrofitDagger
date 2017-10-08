package jiyun.com.rxjavaretrofitdagger.manager;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.rxjavaretrofitdagger.app.App;
import jiyun.com.rxjavaretrofitdagger.base.BaseFragment;

public class FragmentBuilder {
    public static BaseFragment lastFragment;
    private static Map<String,Integer> containerMap = new HashMap<>();
    public static BaseFragment changeFragment(Class<? extends BaseFragment> fragmentClass, int containerId, boolean isHidden, Bundle bundle,boolean isBack){
        FragmentManager manager = App.context.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        获取类名  当 tag
        String name = fragmentClass.getName();
//        根据tag 来查找 当前 fragment 如果不为null  证明已经加载过了
        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(name);
        if(currentFragment == null) {
            try {
                currentFragment = fragmentClass.newInstance();
                transaction.add(containerId, currentFragment,name);
                containerMap.put(name,containerId);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }else {
            if(containerId != containerMap.get(name)) {
                currentFragment = null;
                try {
                    currentFragment = fragmentClass.newInstance();
                    transaction.add(containerId,currentFragment,name);
                    containerMap.put(name,containerId);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    
        if(isHidden) {
            if(lastFragment != null && isBack) {
                transaction.hide(lastFragment);
            }
            transaction.show(lastFragment);
        }else {
            transaction.replace(containerId,currentFragment,name);
        }
        
        if(isBack) {
            transaction.addToBackStack(name);
            lastFragment = currentFragment;
        }
        transaction.commit();
        return lastFragment;
    }
}
