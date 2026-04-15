package Polymorphism;

import java.util.*;

class Document {
    int id;
    String text;

    public Document(int id, String text) {
        this.id = id;
        this.text = text;
    }

}

interface Tokenizer {
    List<String> tokens(String text);
}

class WhitespaceTokenizer implements Tokenizer {
    public List<String> tokens(String text) {
        if (text.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.asList(text.toLowerCase().trim().split("\\s+"));
    }
}

class AlphaOnlyTokenizer implements Tokenizer {
    public List<String> tokens(String text) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                cur.append(Character.toLowerCase(c));
            } else {
                if (cur.length() > 0) {
                    res.add(cur.toString());
                    cur.setLength(0);
                }
            }
        }
        if (cur.length() > 0) {
            res.add(cur.toString());
        }
        return res;
    }
}
public class LibraryEngine {
    static HashMap<String, ArrayList<Integer>> index = new HashMap<>();

    static void buildIndex(List<Document> docs, Tokenizer tokenizer) {
        for (Document doc : docs) {
            List<String> words = tokenizer.tokens(doc.text);
            HashSet<String> seen = new HashSet<>(words);
            for (String token : seen) {
                index.putIfAbsent(token, new ArrayList<>());
                index.get(token).add(doc.id);
            }
        }
        for (ArrayList<Integer> ids : index.values()) {
            Collections.sort(ids);
        }
    }

    static int query(String word) {
        word = word.toLowerCase();
        if (!index.containsKey(word)) {
            return 0;
        }
        return index.get(word).size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Document> docs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String text = sc.nextLine();
            docs.add(new Document(i, text));
        }
        Tokenizer tokenizer = new AlphaOnlyTokenizer();
        buildIndex(docs, tokenizer);
        int q = Integer.parseInt(sc.nextLine());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String word = sc.nextLine();
            out.append(query(word)).append("\n");
        }
        System.out.print(out);
    }
}
