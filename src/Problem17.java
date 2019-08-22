import java.util.*;

/**
 * 写一个算法，将数字转换为中文大写格式.
 */
public class Problem17 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;

        init();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
/*            StringBuilder inputBuilder = new StringBuilder();
            for (int i = line.length() - 1; i >= 0; i--) {
                inputBuilder.append(line.charAt(i));
            }
            line = inputBuilder.toString();*/

            // please write your code here
            LinkedList<Number> numbers = new LinkedList<>();
            StringBuilder text = new StringBuilder();

            for (int i = line.length() - 1; i >= 0; i--) {
                Number temp = new Number((line.charAt(i) - 48), line.length() - 1 - i);
                numbers.addLast(temp);
            }

            ListIterator<Number> iterator = (ListIterator<Number>) numbers.iterator();
            while (iterator.hasNext()) {
                Number number = iterator.next();
                if (number.value == 0 && number.index != 4 && number.index != 8) {
                    text.insert(0, getValueString(number.value));
                } else {
                    text.insert(0, getValueString(number.value).concat(getUnitString(number.index)));
                }
            }

            //delete the zero
            for (int i = 1; i < text.length(); ) {
                //1.有重复零数字时,删除.
                if (i + 1 < text.length() && getValueString(0).equals(String.valueOf(text.charAt(i))) &&
                        getValueString(0).equals(String.valueOf(text.charAt(i + 1)))) {
                    text.deleteCharAt(i);
                }
                //2.单位前的数字需要删除.
                else if (i < (text.length() - 1) && getValueString(0).equals(String.valueOf(text.charAt(i)))
                        && unitSet.contains(String.valueOf(text.charAt(i + 1)))) {
                    text.deleteCharAt(i);
                }
                //3.
                else if (getValueString(0).equals(String.valueOf(text.charAt(i)))
                        && i == text.length() - 1) {
                    text.deleteCharAt(i);
                } else {
                    i++;
                }
            }

            //delete the unused unit
            for (int i = 1; i < text.length();) {
                if (unitSet.contains(String.valueOf(text.charAt(i))) &&
                        unitSet.contains(String.valueOf(text.charAt(i - 1)))) {
                    text.deleteCharAt(i);
                }
                else{
                    i++;
                }
            }

            //append suffix
            text.append("元整");

            System.out.println(text.toString());
        }
    }

    private static String getValueString(int value) {
        return countMap.get(value);
    }

    private static String getUnitString(int unit) {
        return unitMap.get(unit);
    }

    private static void init() {
        //init unit map
        unitMap.put(0, "");
        unitMap.put(1, "拾");
        unitMap.put(2, "佰");
        unitMap.put(3, "仟");
        unitMap.put(4, "万");
        unitMap.put(5, "拾");
        unitMap.put(6, "佰");
        unitMap.put(7, "仟");
        unitMap.put(8, "亿");
        unitMap.put(9, "拾");
        unitMap.put(10, "佰");

        //init count map
        countMap.put(0, "零");
        countMap.put(1, "壹");
        countMap.put(2, "贰");
        countMap.put(3, "叁");
        countMap.put(4, "肆");
        countMap.put(5, "伍");
        countMap.put(6, "陆");
        countMap.put(7, "柒");
        countMap.put(8, "捌");
        countMap.put(9, "玖");

        //init hash set
        unitSet.add("万");
        unitSet.add("亿");
    }

    private static HashMap<Integer, String> unitMap = new HashMap<>();
    private static HashMap<Integer, String> countMap = new HashMap<>();
    private static HashSet<String> unitSet = new HashSet<>();

    static class Number {
        int value;//数字的值
        int index;//在整个数字序列中的位置

        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}
