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

    @Override
    public List<String> execute(String inputs) {
        List<String> result = new ArrayList<>();
        if (inputs == null || inputs.isEmpty()) {
            return result;
        }

        Map<Character, String> buttons = initButtons();
        StringBuilder stringBuilder = new StringBuilder();
        letterCombination(inputs, 0, buttons, result, stringBuilder);
        String firstString = buttons.get(inputs.charAt(0));
        return result.stream()
                .filter(x -> firstString.contains(String.valueOf(x.charAt(0))))
                .collect(Collectors.toList());
    }

    private void letterCombination(String inputs,
                                   int index,
                                   Map<Character, String> buttons,
                                   List<String> result,
                                   StringBuilder stringBuilder) {
        if (stringBuilder.length() == inputs.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        char[] inputChars = inputs.toCharArray();
        for (int i = index; i < inputChars.length; i++) {
            String hitStr = buttons.get(inputChars[i]);
            for (int j = 0; j < hitStr.length(); j++) {
                stringBuilder.append(hitStr.charAt(j));
                letterCombination(inputs, index + 1, buttons, result, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    private Map<Character, String> initButtons() {
        Map<Character, String> buttonMap = new HashMap<>();
        buttonMap.put('2', "abc");
        buttonMap.put('3', "def");
        buttonMap.put('4', "ghi");
        buttonMap.put('5', "jkl");
        buttonMap.put('6', "mno");
        buttonMap.put('7', "pqrs");
        buttonMap.put('8', "tuv");
        buttonMap.put('9', "wxyz");
        return buttonMap;
    }


}
