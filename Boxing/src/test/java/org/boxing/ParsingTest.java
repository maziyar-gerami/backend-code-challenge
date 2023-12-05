package org.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParsingTest {
    Parsing parsing;

    @Test
    public void parseInputTest_ShouldParseCorrectly() {
        // Arrange
        parsing = new Parsing();
        Product expected = new Product(1, 15.30, 34);
        expected.setPrice(34);

        // Act & Assert
        Assertions.assertEquals(expected, parsing.parseOneParentheses("(1,15.30,$34)"), 
        "The one OneParentheses string should be split and convert to Product object, correcly");
    }

    @Test
    public void splitByParentheses_ShouldSplitCorrectly() {
        // Arrange
        String input = "(1,15.3,$34) (2,30.3,$14)";
        parsing = new Parsing();

        // Act
        String[] result = parsing.splitByParentheses(input);

        // Assert
        Assertions.assertEquals("(1,15.3,$34)", result[0], "The entire string should be split correctly");
        Assertions.assertEquals("(2,30.3,$14)", result[1],"The entire string should be split correctly");
    }
}
