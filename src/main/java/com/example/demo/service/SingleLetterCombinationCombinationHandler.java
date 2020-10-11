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
public class SingleLetterCombinationCombinationHandler extends AbstractLetterCombinationCombinationHandler {

    @Override
    public CombinationTypeEnum assignType() {
        return CombinationTypeEnum.SINGLE;
    }

    @Override
    public List<String> execute(String inputs) {
        List<String> result = new ArrayList<>();
        if (!validate(inputs)) {
            return result;
        }
        List<String> inputNumberList = filter(inputs);
        Integer resultLength = getResultLength(inputNumberList);
        List<Button> buttons = initButtons();
        Map<String, List<String>> buttonMap = buttons.stream()
                .collect(Collectors.toMap(x -> x.getNumber(), x -> x.getLetters()));
        StringBuilder stringBuilder = new StringBuilder();
        letterCombination(resultLength, inputNumberList, 0, buttonMap, result, stringBuilder);
        return result;
    }


}
