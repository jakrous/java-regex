package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String pattern = "gray|grey";
        String testString = "there is a grey fox in the gray building";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(testString);

        JSONArray matchesArray = new JSONArray();

        boolean matchesFound = false;

        while (matcher.find()) {
            matchesFound = true;
            String matchedText = matcher.group();
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            JSONObject matchedObject = new JSONObject();
            matchedObject.put("matchedText", matchedText);
            matchedObject.put("startIndex", startIndex);
            matchedObject.put("endIndex", endIndex);

            matchesArray.put(matchedObject);
        }

        JSONObject matchesObject = new JSONObject();
        matchesObject.put("pattern", pattern);
        matchesObject.put("testString", testString);
        matchesObject.put("matchesFound", matchesFound);
        matchesObject.put("matches", matchesArray);

        System.out.println(matchesObject.toString(2));
    }
}
