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
     * @param   roman character
     * @return  Int
     */
    public static int convertRomanToArabicNumber(String roman){
        int previous = 0;
        int current;
        int sum = 0;
        for(int index = 0; index < roman.length(); index++){
            if(romanSymbols.containsKey(roman.charAt(index))){
                current = romanSymbols.get(roman.charAt(index));
                if(current <= previous){
                    sum += current;
                }else{
                    sum -= previous;
                    sum += (current - previous);
                }
                previous = current;
            }else{
                throw new IllegalArgumentException(String.format("Unexpected roman character %s", roman.charAt(index)));
            }

        }
        return sum;
    }
}
