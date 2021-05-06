import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName b
 * @Author Liucz
 * @Description 测试
 * @Date 2021/4/19 14:00
 **/
@SpringBootTest
public class b extends a{
    public b(){
        System.out.println("this's b");
    }

    public void method(){
        System.out.println("this's methodB");
    }


    @Test
    public void test() {
        b b = new b();
        b.method();

        System.out.println("***************************");

        a a = new b();
        a.method();
    }


}
