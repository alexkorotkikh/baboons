package ua.com.sourceit.words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCount {
    public Map<String, Integer> count(File file) throws IOException {
        String text = readFromFile(file);
        Collection<String> normalizedWords = normalize(text);
        return mapOfWords(normalizedWords);
    }

    private String readFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }

    private Collection<String> normalize(String text) {
        String[] words = text.replaceAll("\n", " ").split(" ");
        ArrayList<String> normalizedWords = new ArrayList<String>();
        for (String word : words) {
            if (word.length() > 0) {
                char lastChar = word.charAt(word.length() - 1);
                if (!Character.isAlphabetic(lastChar)) {
                    word = word.substring(0, word.length() - 1);
                }
                normalizedWords.add(word.toLowerCase());
            }
        }
        return normalizedWords;
    }

    Map<String, Integer> mapOfWords(Collection<String> normalizedWords) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String word : normalizedWords) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/crime_and_punishment.txt");
        WordCount wordCount = new WordCount();
        try {
            Map<String, Integer> map = wordCount.count(file);

            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
            list.addAll(map.entrySet());

            Collections.sort(list, new Comp());

            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}


class Comp implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (o1.getValue() < o2.getValue()) {
            return 1;
        } else if (o1.getValue() > o2.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}
