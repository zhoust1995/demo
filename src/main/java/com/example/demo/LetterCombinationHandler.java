package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/9
 */
@Component
public class LetterCombinationHandler implements Handler {

    class Button {
        private Character number;
        private String letters;

        public Button() {
        }

        public Button(Character number, String letters) {
            this.number = number;
            this.letters = letters;
        }

        public Character getNumber() {
            return number;
        }

        public String getLetters() {
            return letters;
        }
    }

    @Override
    public List<String> execute(String inputs) {
        List<String> result = new ArrayList<>();
        if (inputs == null || inputs.isEmpty()) {
            return result;
        }

        List<Button> buttons = initButtons();
        Map<Character, String> buttonMap = buttons.stream()
                .collect(Collectors.toMap(x -> x.getNumber(), x -> x.getLetters()));
        StringBuilder stringBuilder = new StringBuilder();
        letterCombination(inputs, 0, buttonMap, result, stringBuilder);
        String firstString = buttonMap.get(inputs.charAt(0));
        //过滤出第一个按键开始的组合
        return result.stream()
                .filter(x -> firstString.contains(String.valueOf(x.charAt(0))))
                .collect(Collectors.toList());
    }

    private void letterCombination(String inputs,
                                   int index,
                                   Map<Character, String> buttonsMap,
                                   List<String> result,
                                   StringBuilder stringBuilder) {
        if (stringBuilder.length() == inputs.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        char[] inputChars = inputs.toCharArray();
        for (int i = index; i < inputChars.length; i++) {
            String hitStr = buttonsMap.get(inputChars[i]);
            for (int j = 0; j < hitStr.length(); j++) {
                stringBuilder.append(hitStr.charAt(j));
                letterCombination(inputs, index + 1, buttonsMap, result, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    private List<Button> initButtons() {
        List<Button> buttonList = new ArrayList<>(0);
        Button two = new Button('2',"abc");
        Button three = new Button('3',"def");
        Button four = new Button('4',"ghi");
        Button five = new Button('5',"jkl");
        Button six = new Button('6',"mno");
        Button seven = new Button('7',"pqrs");
        Button eight = new Button('8',"tuv");
        Button nine = new Button('9',"wxyz");
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
