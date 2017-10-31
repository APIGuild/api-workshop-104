#### RxJava Practice

- Try to hit the endpoint in Postman: [http://localhost:8080/order-service/orders/1234567890](http://localhost:8080/order-service/orders/1234567890). How long does it take?

- Add RxJava dependencies
```
compile('io.reactivex.rxjava2:rxjava:2.1.6')
```

- Define the AsyncResult to receive the stream result
```
public final class AsyncResult<V> {
    private final V value;
    private final Exception exception;

    private AsyncResult(V value, Exception exception) {
        this.value = value;
        this.exception = exception;
    }

    public static <V> AsyncResult<V> success(V value) {
        return new AsyncResult<>(value, null);
    }

    public static <V> AsyncResult<V> failed(Exception exception) {
        return new AsyncResult<>(null, exception);
    }

    public V getValue() throws Exception {
        if (exception != null) {
            throw exception;
        }
        return value;
    }

    public Exception getException() {
        return exception;
    }

    public boolean hasException() {
        return exception != null;
    }
}
```

- Create an Observable stream for User, Logistics and Product service
```
private Observable<AsyncResult<UserModel>> getUserAsyncStream(String userId) {
    return Observable.create((ObservableOnSubscribe<AsyncResult<UserModel>>) emitter -> {
        try {
            UserModel user = userDao.getUser(userId);
            emitter.onNext(AsyncResult.success(user));
        } catch (Exception exception) {
            emitter.onNext(AsyncResult.failed(exception));
        }
        emitter.onComplete();
    }).subscribeOn(Schedulers.io());
}
```

- Try to zip with all three services into one stream. This require to build an Assembler
```
Observable<OrderContainer> orderContainer = Observable.just(new OrderContainer())
                .zipWith(userStream, new UserAssembler())
                .zipWith(logisticsStream, new LogisticsAssembler())
                .zipWith(productStream, new ProductAssembler())
                .subscribeOn(Schedulers.io());
                
return orderContainer.blockingGet(); // Get the value of order container
```

- UserAssembler Example
```
public class UserAssembler implements BiFunction<OrderContainer, AsyncResult<UserModel>, OrderContainer> {
    @Override
    public OrderContainer apply(OrderContainer orderContainer, AsyncResult<UserModel> userModel) throws Exception {
        if (userModel.hasException()) {
            orderContainer.addErrors(ErrorBuilder.buildServiceError(userModel.getException().getMessage()));
        } else {
            orderContainer.setUser(userModel.getValue());
        }
        return orderContainer;
    }
}
```

- Try to hit the same order endpoint and to see how long does it take again?

- Refactor the Observable and provide the AsyncTemplate and use it for the three services.
```
public final class AsyncTemplate {
    public static <T> Single<AsyncResult<T>> async(Callable<T> callable) {
        return Single.create((SingleEmitter<AsyncResult<T>> singleEmitter) -> {
            AsyncResult<T> asyncResult;
            try {
                T syncResult = callable.call();
                asyncResult = AsyncResult.success(syncResult);
            } catch (Exception exception) {
                asyncResult = AsyncResult.failed(exception);
            }
            singleEmitter.onSuccess(asyncResult);
        }).subscribeOn(Schedulers.io());
    }
}
```

- Try to hit the same order endpoint and to see how long does it take again?
