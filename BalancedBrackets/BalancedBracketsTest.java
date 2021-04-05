package BalancedBrackets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BalancedBracketsTest {
    BalancedBrackets bb = new BalancedBrackets();

    @Test
    public void isBalancedTest1(){
        String Test1 = "()()()()";
        Assertions.assertEquals("true",bb.isBalanced(Test1));

    }

    @Test
    public void isBalancedTest2(){
        String Test2 ="[(])";
        Assertions.assertEquals("true",bb.isBalanced(Test2));

    }
    @Test
    public void isBalancedTest3(){

        String Test3="(())){}[][][]";
        Assertions.assertEquals("false",bb.isBalanced(Test3));

    }

    @Test
    public void isBalancedTest4(){

        String Test3="(()){}[][][]()()(){}{}{}{}{}[][][][][][]";
        Assertions.assertEquals("true",bb.isBalanced(Test3));

    }

    @Test
    public void isBalancedTest5(){

        String Test=")(";
        Assertions.assertEquals("false",bb.isBalanced(Test));

    }

}
