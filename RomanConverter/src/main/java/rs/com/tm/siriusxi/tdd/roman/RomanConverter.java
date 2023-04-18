package rs.com.tm.siriusxi.tdd.roman;

/**
 * ローマ数字とアラビア数字の変換を実行するクラス
 *
 * @author naito
 */
final class RomanConverter {
    /**
     * ローマ数字とアラビア数字の変換メソッド
     *
     * @params  String roman
     * @retrn   Int
     */
    public static int convertRomanToArabicNumber(String roman){
        int sum = 0;
        for(char ch : roman.toCharArray()){
            if(ch == 'I') {
                sum += 1;
            } else if (ch == 'V') {
                sum +=5;
            }else{
                throw new IllegalArgumentException(
                        String.format("Unexpected roman character %s", ch)
                );
            }
        }
        return sum;
    }
}
