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
        }
    };


    /**
     * ローマ数字とアラビア数字の変換メソッド
     *
     * @params  String roman
     * @retrn   Int
     */
    public static int convertRomanToArabicNumber(String roman){
        int previous = 0;
        int current = 0;
        int sum = 0;
        for(char ch : roman.toCharArray()){
            if(romanSymbols.containsKey(ch)){
                current = romanSymbols.get(ch);
                if(current <= previous){
                    sum += current;
                }else{
                    sum -= previous;
                    sum += (current - previous);
                }
                previous = current;
            }else{
                throw new IllegalArgumentException(String.format("Unexpected roman character %s", ch));
            }

        }
        return sum;
    }
}
