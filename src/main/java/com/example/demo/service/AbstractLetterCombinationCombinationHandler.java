package com.example.demo.service;

import com.example.demo.enums.CombinationTypeEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/11
 */
@Service
public abstract class AbstractLetterCombinationCombinationHandler implements CombinationHandler<String, String> {

    class Button {
        private String number;
        private List<String> letters;

        public Button() {
        }

        public Button(String number, List<String> letters) {
            this.number = number;
            this.letters = letters;
        }

        public String getNumber() {
            return number;
        }

        public List<String> getLetters() {
            return letters;
        }
    }

    protected String INPUT_SEPARATOR = ",";

    @Override
    public abstract CombinationTypeEnum assignType();

    @Override
    public abstract List<String> execute(String inputs);

    //校验输入
    protected boolean validate(String inputs) {
        return !(inputs == null || inputs.isEmpty() || "0".equals(inputs) || "1".equals(inputs));
    }

    //过滤0和1
    protected List<String> filter(String inputs) {
        return Arrays.stream(inputs.split(INPUT_SEPARATOR))
                .filter(x -> !"0".equals(x) && !"1".equals(x))
                .collect(Collectors.toList());
    }

    //获取结果的长度
    protected int getResultLength(List<String> inputNumberList) {
        int resultLength = 0;
        for (String oneInput : inputNumberList) {
            resultLength = resultLength + oneInput.length();
        }
        return resultLength;
    }

    /**
     * @param resultLength    返回结果的长度
     * @param inputNumberList
     * @param index           遍历的inputNumberList的下标
     * @param buttonsMap      数字对应字符串数组的map
     * @param result          返回的结果集
     * @param stringBuilder   用于拼接
     */
    protected void letterCombination(int resultLength,
                                     List<String> inputNumberList,
                                     int index,
                                     Map<String, List<String>> buttonsMap,
                                     List<String> result,
                                     StringBuilder stringBuilder) {
        if (stringBuilder.length() == resultLength &&
                !result.contains(stringBuilder.toString())) {
            List<String> firstStringList = buttonsMap.get(inputNumberList.get(0));
            for (String itemString : firstStringList) {
                //判断是否以第一个输入的开头
                if (String.valueOf(stringBuilder).startsWith(itemString)) {
                    result.add(stringBuilder.toString());
                }
            }
            return;
        }
        for (int i = index; i < inputNumberList.size(); i++) {
            List<String> hitStrList = buttonsMap.get(inputNumberList.get(i));
            //遍历每个数字对应的所有字符
            for (int j = 0; j < hitStrList.size(); j++) {
                int startLength = stringBuilder.length();
                stringBuilder.append(hitStrList.get(j));
                letterCombination(resultLength, inputNumberList, index + 1, buttonsMap, result, stringBuilder);
                stringBuilder.delete(startLength, stringBuilder.length());
            }
        }
    }

    protected List<Button> initButtons() {
        List<Button> buttonList = new ArrayList<>(0);
        Button two = new Button("2", Stream.of("a", "b", "c").collect(Collectors.toList()));
        Button three = new Button("3", Stream.of("d", "e", "f").collect(Collectors.toList()));
        Button four = new Button("4", Stream.of("g", "h", "i").collect(Collectors.toList()));
        Button five = new Button("5", Stream.of("j", "k", "l").collect(Collectors.toList()));
        Button six = new Button("6", Stream.of("m", "n", "o").collect(Collectors.toList()));
        Button seven = new Button("7", Stream.of("p", "q", "r", "s").collect(Collectors.toList()));
        Button eight = new Button("8", Stream.of("t", "u", "v").collect(Collectors.toList()));
        Button nine = new Button("9", Stream.of("w", "x", "y", "z").collect(Collectors.toList()));
        buttonList.add(two);
        buttonList.add(three);
        buttonList.add(four);
        buttonList.add(five);
        buttonList.add(six);
        buttonList.add(seven);
        buttonList.add(eight);
        buttonList.add(nine);
        return buttonList;
    }
}
