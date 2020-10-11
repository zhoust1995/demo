package com.example.demo.service;

import com.example.demo.enums.CombinationTypeEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zhoust
 * @Description:
 * @Date: 2020/10/11
 */
@Service
public class MultiLetterCombinationCombinationHandler extends SingleLetterCombinationCombinationHandler {

    @Override
    public CombinationTypeEnum assignType() {
        return CombinationTypeEnum.MULTI;
    }

    @Override
    public List<String> execute(String inputs) {
        List<String> result = new ArrayList<>();
        if (!validate(inputs)) {
            return result;
        }
        List<String> inputNumberList = filter(inputs);
        Integer resultLength = getResultLength(inputNumberList);
        List<Button> buttons = new ArrayList<>();
        for (String oneItem : inputNumberList) {
            char[] aChars = oneItem.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            //把{23,34}里面的23构造成2,3
            for (char aChar : aChars) {
                stringBuilder.append(String.valueOf(aChar));
                stringBuilder.append(",");
            }
            List<String> secondResult = super.execute(stringBuilder.substring(0, stringBuilder.length() - 1));
            //把23及其结果集构造成button
            buttons.add(new Button(oneItem, secondResult));
        }
        Map<String, List<String>> buttonMap = buttons.stream()
                .collect(Collectors.toMap(x -> x.getNumber(), x -> x.getLetters()));
        StringBuilder stringBuilder = new StringBuilder();
        letterCombination(resultLength, inputNumberList, 0, buttonMap, result, stringBuilder);
        return result;
    }
}
