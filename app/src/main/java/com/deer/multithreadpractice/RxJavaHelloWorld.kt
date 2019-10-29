package com.deer.multithreadpractice

import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class RxJavaHelloWorld {

    companion object {
        fun tryThis() {
            Flowable.just("Hello world").subscribe(System.out::println)
        }
    }

    /**
     *  Subject ------------> Observer
     *      ^                     ^
     *      |                     |
     * ConcreteSubject -----> ConcreteObserver
     *
     *  observable == Subject (Can be subscribe)
     *  LambdaObserver == ConcreteObserver
     */
    fun simpleVersion() {
        var observable: Observable<String> = object: Observable<String>() {
            override fun subscribeActual(observer: Observer<in String>?) {
                System.out.println(Thread.currentThread())
                observer?.onNext("Hello! Joy!")
            }
        }

        val observer = object : Observer<String> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                System.out.println(Thread.currentThread())
                System.out.println("Simple: I accepted $t")
            }

            override fun onError(e: Throwable) {
            }
        }

        observable = observable.subscribeOn(Schedulers.computation())
        observable = observable.observeOn(Schedulers.io())
        observable.subscribe(observer)
    }

    fun main() {
        val disposable =
            Observable.create<String>(object : ObservableOnSubscribe<String> {
                    override fun subscribe(emitter: ObservableEmitter<String>) {
                        System.out.println(Thread.currentThread())
                        emitter.onNext("Hello! Eve!")
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(object : Consumer<String> {
                    override fun accept(t: String?) {
                        System.out.println(Thread.currentThread())
                        System.out.println("I accepted $t")
                    }
                })
    }
}