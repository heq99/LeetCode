package com.qiang.leetcode.utils;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest 
{
    @Test
    public void testPrintArray() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        String output = Utils.printArray(input);
        Assert.assertEquals("[1, 2, 3, 4, 5]", output);
    }

    @Test(expected = NullPointerException.class)
    public void testPrintArrayNullInput() {
        int[] array = null;
        String output = Utils.printArray(array);
        Assert.assertEquals("[]", output);
    }

    @Test
    public void testPrintArrayEmptyInput() {
        int[] input = new int[] {};
        String output = Utils.printArray(input);
        Assert.assertEquals("[]", output);
    }

    @Test
    public void testPrintArrayOneElement() {
        int[] input = new int[] {5};
        String output = Utils.printArray(input);
        Assert.assertEquals("[5]", output);
    }
}
