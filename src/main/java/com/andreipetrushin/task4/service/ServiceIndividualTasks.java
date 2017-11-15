package com.andreipetrushin.task4.service;

import com.andreipetrushin.task4.entity.Component;
import java.util.*;

public class ServiceIndividualTasks {


    //INDIVIDUAL TASK №1
    public int countSentencesWithSameWords(Component component) {
        int counter = 0;
        List<String> words;
        List<Component> sentenceList = getSentenceListFromComponent(component);
        for (Component sentence : sentenceList) {
            List<Component> wordList = sentence.getAll();
            words = replaceAllPunctuations(wordList);
            for (int i = 0; i < words.size(); i++) {
                String valueTo = words.get(i);
                words.remove(valueTo);
                if (words.contains(valueTo)) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    //INDIVIDUAL TASK №2
    public void printSentencesOrderByCountOfLexemes(Component component) {
        List<Component> sentenceList = getSentenceListFromComponent(component);
        List<List<Component>> orderedList = new ArrayList<>();
        for (Component sentence : sentenceList) {
            orderedList.add(sentence.getAll());
        }
        Collections.sort(orderedList, new Comparator<List<Component>>() {
            @Override
            public int compare(List<Component> o1, List<Component> o2) {
                return o1.size() - o2.size();
            }
        });
        for (List<Component> sentence : orderedList) {
            for (Component lexeme : sentence) {
                System.out.print(lexeme.getValue() + " ");
            }
            System.out.print('\n');
        }

    }

    //INDIVIDUAL TASK №3
    public void changeFirstWordWithLast(Component component) {
        List<Component> sentenceList = getSentenceListFromComponent(component);
        for (Component sentence : sentenceList) {
            List<Component> words = sentence.getAll();
            int size = words.size() - 1;
            if (size < 2) {
                break;
            }
            Component lastElement = words.get(size);
            words.remove(lastElement);
            Component firstElement = words.get(0);
            words.set(0, lastElement);
            words.add(firstElement);
        }
        System.out.println(ServiceRestorer.restore(component));
    }

    //INDIVIDUAL TASK №4
    public void printLexemesOrderedByAlphabet(Component component) {
        List<Component> components = getSentenceListFromComponent(component);
        TreeSet<String> sortWords = new TreeSet<>();
        for (Component sentence : components) {
            List<Component> wordList = sentence.getAll();
            List<String> words = replaceAllPunctuations(wordList);
            sortWords.addAll(words);
        }

        Iterator<String> iterator = sortWords.iterator();
        String value = iterator.next();

        while (iterator.hasNext()) {
            String nextValue = iterator.next();
            char firstCharValue = value.charAt(0);
            char firstCharNextValue = nextValue.charAt(0);
            System.out.print(value + " ");
            if (firstCharNextValue != firstCharValue) {
                System.out.print('\n');
            }
            value = nextValue;
        }
        System.out.println(value);

    }

    //INDIVIDUAL TASK №5
    public void printWordsByNumberOfEntry(Component component, List<String> searchWords) {
        List<Component> sentenceList = getSentenceListFromComponent(component);
        List<String> wordList = new ArrayList<>();
        for (Component sentence : sentenceList) {
            List<Component> wordsFromSentence = sentence.getAll();
            wordList.addAll(replaceAllPunctuations(wordsFromSentence));
        }
        Map<String, Integer> mapOfWords = new HashMap<>();
        for (String searchWord : searchWords) {
            int counter = 0;
            for (String word : wordList) {
                if (searchWord.equalsIgnoreCase(word)) {
                    counter++;
                }
            }
            mapOfWords.put(searchWord, counter);
        }
        mapOfWords = sortByValue(mapOfWords);
        System.out.println(mapOfWords);

    }

    //INDIVIDUAL TASK №6
    public void deleteLexemesByCharAndSize(Component component, char firstChar, int size) {
        List<Component> sentenceList = getSentenceListFromComponent(component);
        for (Component sentence : sentenceList) {
            List<Component> wordList = sentence.getAll();
            for (int i = 0; i < wordList.size(); i++) {
                Component word = wordList.get(i);
                String value = word.getValue().replaceAll("\\pP","");
                char ch = value.charAt(0);
                if (value.length() == size && firstChar == ch) {
                    wordList.remove(word);
                }
            }
        }
        System.out.println(ServiceRestorer.restore(component));
    }

    //INDIVIDUAL TASK №7
    public void sortLexemesByEntryOfSymbol(Component component, char symbol) {
        List<Component> sentencesList = getSentenceListFromComponent(component);
        List<String> listWords = new ArrayList<>();
        for (Component sentence : sentencesList) {
            List<Component> wordList = sentence.getAll();
            List<String> words = replaceAllPunctuations(wordList);
            listWords.addAll(words);
        }
        Map<String, Integer> mapResults = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String value : listWords) {
            char[] array = value.toCharArray();
            int counter = 0;
            for (Character character : array) {
                if (character == symbol) {
                    counter++;
                }
            }
            mapResults.put(value, counter);
        }
        mapResults = sortByValueReverse(mapResults);
        System.out.println(mapResults);
    }




    private List<String> replaceAllPunctuations(List<Component> component) {
        List<String> words = new ArrayList<>();
        for (Component word : component) {
            String value = word.getValue();
            if (value.length() > 1) {
                value = value.replaceAll("\\pP", "");
            }
            value = value.toLowerCase();
            words.add(value);
        }
        return words;
    }

    private List<Component> getSentenceListFromComponent(Component component) {
        List<Component> paragraphList = component.getAll();
        List<Component> sentenceList = new ArrayList<>();
        for (Component paragraph : paragraphList) {
            List<Component> sentence = paragraph.getAll();
            sentenceList.addAll(sentence);
        }
        return sentenceList;

    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());

            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {

            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValueReverse(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());

            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {

            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}
