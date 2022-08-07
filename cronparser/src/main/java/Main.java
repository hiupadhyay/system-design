import java.util.Arrays;
import java.util.List;

import com.parser.driver.Parser;
import com.parser.service.ParserService;

public class Main {

    public static void main(String[] args) {
        List<String> cronExpressions =
                Arrays.asList(new String[]{"*/15 0 1,15 * Mon-Fri /usr/bin/find"});
        final Parser parser = new Parser(new ParserService());
        cronExpressions.forEach(cronExpression -> {
            System.out.println(":::::::::::::::STARTED PARSING:::::::::::::::::::::::::::");
            parser.parse(cronExpression).forEach((K, V) -> System.out.println(K + " " + V));
            System.out.println(":::::::::::::::FINISHED PARSING:::::::::::::::::::::::::::");
        });
    }
}

