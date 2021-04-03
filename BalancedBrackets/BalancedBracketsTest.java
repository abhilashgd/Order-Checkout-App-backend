package Tests;

import Brackets.BalancedBrackets;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BalancedBracketsTest {
    BalancedBrackets bb = new BalancedBrackets();

    @Test
    public void isBalancedTest1(){
        String Test1 = "()()()()";
        assertEquals("true",bb.isBalanced(Test1));

    }

    @Test
    public void isBalancedTest2(){
        String Test2 ="[(])";
        assertEquals("true",bb.isBalanced(Test2));

    }
    @Test
    public void isBalancedTest3(){

        String Test3="(())){}[][][]";
        assertEquals("false",bb.isBalanced(Test3));

}

    @Test
    public void isBalancedTest4(){

        String Test3="(()){}[][][]()()(){}{}{}{}{}[][][][][][]";
        assertEquals("true",bb.isBalanced(Test3));

    }
}
