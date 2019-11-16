package hou.kot.dictionary.cmd;


import hou.kot.dictionary.formatter.Formatter;
import hou.kot.dictionary.formatter.WeChatFormatter;
import hou.kot.dictionary.parser.HTMLParser;
import hou.kot.dictionary.parser.Parser;
import hou.kot.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CmdLineUi implements CommandLineRunner {

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public void run(String... args) throws Exception {

    }
}
