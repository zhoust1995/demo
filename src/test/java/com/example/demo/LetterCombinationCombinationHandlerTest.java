package com.example.demo;

import com.example.demo.enums.CombinationTypeEnum;
import com.example.demo.service.CombinationHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/9
 */
@SpringBootTest
public class LetterCombinationCombinationHandlerTest {

    @Autowired
    private List<CombinationHandler> combinationHandlers;

    private CombinationHandler filterCombinationHandler(List<CombinationHandler> combinationHandlers, String inputs) {
        List<String> inputNumberList = Arrays.stream(inputs.split(",")).collect(Collectors.toList());
        for (String inputNumber : inputNumberList) {
            if (inputNumber != null && inputNumber.length() >= 2) {
                return combinationHandlers.stream().filter(x -> CombinationTypeEnum.MULTI.equals(x.assignType())).findFirst().get();
            }
        }
        return combinationHandlers.stream().filter(x -> CombinationTypeEnum.SINGLE.equals(x.assignType())).findFirst().get();
    }

    @Test
    public void testLetterCombination23() {
        String inputs = "2,3";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("ad ae af bd be bf cd ce cf".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }


    @Test
    public void testLetterCombination9() {
        String inputs = "9";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("w x y z".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testLetterCombination2() {
        String inputs = "2";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("a b c".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testLetterCombinationWhenInputNull() {
        String inputs = "";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute("");
        Assert.isTrue(CollectionUtils.isEmpty(results), "算法出错");
    }

    @Test
    public void testLetterCombination0() {
        String inputs = "0";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.isTrue(CollectionUtils.isEmpty(results), "算法出错");
    }

    @Test
    public void testLetterCombination1() {
        String inputs = "1";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.isTrue(CollectionUtils.isEmpty(results), "算法出错");

    }

    @Test
    public void testLetterCombination20() {
        String inputs = "2,0";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("a b c".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testLetterCombination02() {
        String inputs = "0,2";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("a b c".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testLetterCombination31() {
        String inputs = "3,1";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("d e f".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testLetterCombination13() {
        String inputs = "1,3";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("d e f".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testLetterCombination55() {
        String inputs = "5,5";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("jj jk jl kj kk kl lj lk ll".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testLetterCombination99() {
        String inputs = "9,9";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + " ");
        }
        Assert.isTrue("ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz".equals(stringBuilder.substring(0, stringBuilder.length() - 1)), "算法出错");
    }

    @Test
    public void testMulti1() {
        String inputs = "23,45";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        Assert.isTrue(results.size() == 9 * 9, "返回错误");
        String result23 = "ad ae af bd be bf cd ce cf";
        String result45 = "gj gk gl hj hk hl ij ik il";
        List<String> startList23 = Arrays.stream(result23.split(" ")).collect(Collectors.toList());
        List<String> startList45 = Arrays.stream(result45.split(" ")).collect(Collectors.toList());
        for (String result : results) {
            Assert.isTrue(result.length() == 4, "返回错误");
            Assert.isTrue(startList23.contains(result.substring(0, 2)), "返回错误");
            Assert.isTrue(startList45.contains(result.substring(2, 4)), "返回错误");
        }
    }

    @Test
    public void testMulti2() {
        String inputs = "23,4";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        Assert.isTrue(results.size() == 9 * 3, "返回错误");
        String result23 = "ad ae af bd be bf cd ce cf";
        List<String> startList23 = Arrays.stream(result23.split(" ")).collect(Collectors.toList());
        for (String result : results) {
            Assert.isTrue(result.length() == 3, "返回错误");
            Assert.isTrue(startList23.contains(result.substring(0, 2)), "返回错误");
        }
    }

    @Test
    public void testMulti3() {
        String inputs = "4,23";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        Assert.isTrue(results.size() == 3 * 9, "返回错误");
        String result4 = "g h i";
        List<String> startList4 = Arrays.stream(result4.split(" ")).collect(Collectors.toList());
        for (String result : results) {
            Assert.isTrue(result.length() == 3, "返回错误");
            Assert.isTrue(startList4.contains(result.substring(0, 1)), "返回错误");
        }
    }

    @Test
    public void testMulti4() {
        String inputs = "23,4,55";
        CombinationHandler combinationHandler = filterCombinationHandler(combinationHandlers, inputs);
        List<String> results = combinationHandler.execute(inputs);
        Assert.notEmpty(results, "返回错误");
        Assert.isTrue(results.size() == 9 * 3 * 9, "返回错误");
        String result23 = "ad ae af bd be bf cd ce cf";
        String result4 = "g h i";
        String result55 = "jj jk jl kj kk kl lj lk ll";
        List<String> startList23 = Arrays.stream(result23.split(" ")).collect(Collectors.toList());
        List<String> startList4 = Arrays.stream(result4.split(" ")).collect(Collectors.toList());
        List<String> startList55 = Arrays.stream(result55.split(" ")).collect(Collectors.toList());
        for (String result : results) {
            Assert.isTrue(result.length() == 5, "返回错误");
            Assert.isTrue(startList23.contains(result.substring(0, 2)), "返回错误");
            Assert.isTrue(startList4.contains(result.substring(2, 3)), "返回错误");
            Assert.isTrue(startList55.contains(result.substring(3, 5)), "返回错误");
        }
    }
}
