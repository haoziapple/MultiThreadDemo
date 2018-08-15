package com.haozi.demo.multithread.rxjava;

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 开始使用rxjava
 * 参考：https://www.jianshu.com/p/5e93c9101dc5
 *
 * @author wanghao
 */
public class FirstBegin {
    Observable<String> senderCreate = Observable.create(
            subscriber -> subscriber.onNext("Hello, WangHao!")
    );

    Observable<String> senderJust = Observable.just("just1", "just2");

    Observable<String> senderFrom = Observable.from(new ArrayList<String>() {
        {
            add("from1");
            add("from2");
            add("from3");
        }
    });

    Observable<Long> senderInterval = Observable.interval(1, TimeUnit.SECONDS);

    /**
     * 2秒后发射一个0L
     */
    Observable<Long> senderTimer = Observable.timer(2, TimeUnit.SECONDS);

    Observer<Object> receiver = new Observer<Object>() {
        @Override
        public void onCompleted() {
            //数据接收完成时调用
            System.out.println("Completed!");
        }

        @Override
        public void onError(Throwable e) {
            //发生错误调用
            System.out.println("Error!" + e.getMessage());
            e.printStackTrace();
        }

        @Override
        public void onNext(Object s) {
            //正常接收数据调用
            System.out.println(s.toString());
        }
    };

    public static void main(String[] args) {
        FirstBegin begin = new FirstBegin();
        begin.senderCreate.subscribe(begin.receiver);
        begin.senderJust.subscribe(begin.receiver);
        begin.senderFrom.subscribe(begin.receiver);

        begin.senderInterval.subscribe(begin.receiver);
        begin.senderTimer.subscribe(begin.receiver);

        begin.senderFrom.subscribe(begin.receiver);
    }
}
