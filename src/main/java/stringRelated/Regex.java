package stringRelated;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Regex {
    public void method () {
        String s = "'He is a very very good boy, isn't he?";

        String[] arrayS = s.split("\\s*[^a-zA-Z]+\\s*");

        List<String> list = Arrays.asList(arrayS);
        list = list.stream().filter(ar -> null != ar || (!"".equals(ar)) || !ar.trim().equals("")).collect(Collectors.toList());
        System.out.println(list.size());
        list.forEach(le -> System.out.println(le));
        for(int i = 0; i < arrayS.length; i++) {
            System.out.println(arrayS[i]);
        }
    }
}
