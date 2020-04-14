package src.leetcode.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LeetCode17 {
    public static void main(String[] args){
        letterCombinations("123456");
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length()<=0){
            return new ArrayList<>();
        }

        HashMap<Integer, List<Character>> map = new HashMap<>();
        for (int i = 2; i <= 6; i++) {
            ArrayList<Character> list = new ArrayList<>();
            list.add((char) ('a' + (i - 2) * 3));
            list.add((char) (('a' + (i - 2) * 3) + 1));
            list.add((char) (('a' + (i - 2) * 3) + 2));
            map.put(i, list);
        }

        //add map of key 7
        ArrayList<Character> list7 = new ArrayList<>();
        list7.add('p');
        list7.add('q');
        list7.add('r');
        list7.add('s');
        map.put(7,list7);

        //add map of key 8
        ArrayList<Character> list8 = new ArrayList<>();
        list8.add('t');
        list8.add('u');
        list8.add('v');
        map.put(8,list8);

        //add map of key 9
        ArrayList<Character> list9 = new ArrayList<>();
        list9.add('w');
        list9.add('x');
        list9.add('y');
        list9.add('z');
        map.put(9,list9);

        //map of key1 is empty
        map.put(1,new ArrayList<>());

        List<String> ansList = new ArrayList<>();

        recursiveSpell(ansList, digits, map);

        return ansList;
    }

    private static void recursiveSpell(List<String> ansList, String digits, HashMap<Integer,List<Character>> dictMap) {
        recursiveSpellInner(ansList,digits,dictMap,0,"");
    }

    private static void recursiveSpellInner(List<String> ansList, String digits, HashMap<Integer, List<Character>> dictMap,
                                     int index, String spellString) {
        if (index >= digits.length()) {
            ansList.add(spellString);
            return;
        }

        int curDigit = (int) digits.charAt(index) - '1' + 1;
        List<Character> chList = dictMap.get(curDigit);
        if (chList.size() > 0) {
            Iterator<Character> characterIterator = chList.iterator();
            while (characterIterator.hasNext()) {
                recursiveSpellInner(ansList, digits, dictMap, index + 1, spellString + characterIterator.next());
            }
        } else {
            recursiveSpellInner(ansList, digits, dictMap, index + 1, spellString);
        }
    }
}
