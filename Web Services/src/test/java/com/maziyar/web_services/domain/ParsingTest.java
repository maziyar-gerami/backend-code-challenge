package com.maziyar.web_services.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.maziyar.web_services.domain.Parsing;
import com.maziyar.web_services.domain.Product;

public class ParsingTest {
    Parsing parsing;
    @Test
    public void parseInputTest(){
        parsing = new Parsing();
        Product expected = new Product( 1,15.30, 34);
        Assertions.assertEquals(expected, parsing.parseOneParentheses("(1,15.30,$34)"));
    }

    @Test
    public void splitByParentheses(){
        String input = "(1,15.3,$34) (2,30.3,$14)";
        parsing = new Parsing();
        String[] result = parsing.splitByParentheses(input);
        Assertions.assertEquals("(1,15.3,$34)", result[0]);
        Assertions.assertEquals("(2,30.3,$14)",result[1]);
    }
}
