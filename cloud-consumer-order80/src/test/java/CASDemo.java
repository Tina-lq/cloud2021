import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liucz
 * @create 2021-04-15 14:23
 *
 * 1、CAS是什么？  -->compareAndSet
 * 比较并交换
 */
@SpringBootTest
public class CASDemo {

    @Test
    public void test() {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2019) +"\t current datta:" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet( 5,1024) +"\t current datta:" + atomicInteger.get());

        System.out.println(atomicInteger.getAndIncrement() );

    }
}
