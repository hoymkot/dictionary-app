package hou.kot.dictionary.parser;

import hou.kot.dictionary.formatter.Formatter;
import hou.kot.dictionary.formatter.WeChatFormatter;

/**
 * fetch translation text for saving and manipulation
 */
public class HTMLParser implements Parser {
    static String TARGET_TAG = "<div class=\"trans-container\">";
    static String TARGET_END_TAG = "</div>";
    @Override
    public String parse(String s) {

        s = s.substring(s.indexOf(TARGET_TAG));
        s = s.substring(0, s.indexOf(TARGET_END_TAG)+TARGET_END_TAG.length());

        return s;
    }
}
