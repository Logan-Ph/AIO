import org.junit.Test;
import org.junit.Assert;
import org.junit.Assume;

public class myFirstTest {
    @Test
    void groupAssertions(){
        int[] numbers = {0,1,2,3,4};
        Assume.assumeTrue(5>1);
        Assert.assertEquals(5+2,7);
    }
}







