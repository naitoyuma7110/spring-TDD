package rs.com.tm.siriusxi.tdd.roman;


import java.util.Hashtable;
import java.util.Map;

/**
 * ローマ数字とアラビア数字の変換を実行するクラス
 *
 * @author naito
 */
final class RomanConverter {
//  ローマ数字とアラビア数字のハッシュテーブル(Key:Valueのオブジェクト)を作成し数字ペアを管理
//  チェック：HashMap、Hashtableの違い
    private static final Map<Character, Integer> romanSymbols = new Hashtable<Character,Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    /**
     * private のコンストラクタを設置し、外部からのインスタンス化を禁止する事ができる
     * この場合、クラス内のメソッドを全てstaticにする必要がある
     * */
    private RomanConverter(){
    }

    /**
     * ローマ数字とアラビア数字の変換メソッド
     * @param   roman character
     * @return  Int
     */
    public static int convertRomanToArabicNumber(String roman){
        int previous = 0;
        int current;
        int sum = 0;
        for(int index = 0; index < roman.length(); index++){
            if(doesSymbolsContainsRomanCharacter(roman, index)){
                current = getSymbolValue(roman, index);
                if(current <= previous){
                    sum += current;
                }else{
                    sum -= previous;
                    sum += (current - previous);
                }
                previous = current;
            }else{
                throw new IllegalArgumentException(String.format("Unexpected roman character %s", getaCharValue(roman, index)));
            }
        }
        return sum;
    }

    private static char getaCharValue(String roman, int index) {
        return roman.charAt(index);
    }

    private static boolean doesSymbolsContainsRomanCharacter(String roman, int index) {
        return romanSymbols.containsKey(getaCharValue(roman, index));
    }

    private static Integer getSymbolValue(String roman, int index) {
        return romanSymbols.get(getaCharValue(roman, index));
    }
}
