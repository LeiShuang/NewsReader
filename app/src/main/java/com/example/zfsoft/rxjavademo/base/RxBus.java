package com.example.zfsoft.rxjavademo.base;

import com.example.zfsoft.rxjavademo.utils.RxUtil;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * 创建日期：2018/7/11 on 11:05
 * 描述:基于Rx的类似EventBus，用于组件之间的通讯，避免了接口的书写
 * 作者:Ls
 */
public class RxBus {
    private final FlowableProcessor<Object> mBus;

    public RxBus() {
        mBus = PublishProcessor.create().toSerialized();
    }

    public  static RxBus getDefault(){
        return  RxBusHolder.sInstance;
    }

    private static class RxBusHolder{
        private static final RxBus sInstance = new RxBus();
    }
    //提供一个新的事件
    public  void post(Object object){
        mBus.onNext(object);
    }

    //根据传递的evenType 类型 返回evenType 类型的 被观察者
    public <T>Flowable<T> toFlowable(Class<T> eventType){
        return mBus.ofType(eventType);
    }

    //封装默认订阅
    public <T>Disposable toDefaultFlowable(Class<T> evenType,Consumer<T> act){
        return mBus.ofType(evenType).compose(RxUtil.<T>rxSchedulerHelper()).subscribe(act);
    }
}
