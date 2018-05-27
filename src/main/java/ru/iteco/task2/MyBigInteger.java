package ru.iteco.task2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MyBigInteger implements Sequence {

    private final AtomicReference<BigInteger> data = new AtomicReference<>();

    public MyBigInteger() {
        data.set(BigInteger.ZERO);
    }

    public MyBigInteger(String num) {
        data.set(new BigInteger(num));
    }

    @Override
    public BigInteger next() {
        while (true) {
            BigInteger current = data.get();
            BigInteger next = current.add(BigInteger.ONE);
            if (data.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public BigInteger curval() {
        return data.get();
    }
}