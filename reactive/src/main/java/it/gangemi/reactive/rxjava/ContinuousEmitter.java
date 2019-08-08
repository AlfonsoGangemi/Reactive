package it.gangemi.reactive.rxjava;

import io.reactivex.Observable;

public class ContinuousEmitter {

    public static void main(String[] args) {
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 1000 == 0) {
                    emitter.onError(new IllegalStateException("Zero milliseconds!"));
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);
    }

}
