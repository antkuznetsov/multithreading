package ru.iteco.task2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MyBigInteger implements Sequence {

    private final AtomicReference<BigInteger> data = new AtomicReference<>();

    public MyBigInteger() {
        data.set(BigInteger.ZERO);
    }

    @Override
    public synchronized BigInteger next() {
        return data.getAndSet(data.get().add(BigInteger.ONE));
    }

    @Override
    public BigInteger curval() {
        return data.get();
    }
}