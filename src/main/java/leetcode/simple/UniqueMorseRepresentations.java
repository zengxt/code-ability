package leetcode.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ����Ħ��˹���붨��һ�ֱ�׼���뷽ʽ����ÿ����ĸ��Ӧ��һ����һϵ�е�Ͷ�����ɵ��ַ�����?����: "a" ��Ӧ ".-", "b" ��Ӧ "-...", "c" ��Ӧ "-.-.", �ȵȡ�
 * <p>
 * Ϊ�˷��㣬����26��Ӣ����ĸ��ӦĦ��˹��������£�
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * ����һ�������б�ÿ�����ʿ���д��ÿ����ĸ��ӦĦ��˹�������ϡ����磬"cab" ����д�� "-.-..--..."��(�� "-.-." + ".-" + "-..." �ַ����Ľ��)�����ǽ�����һ�����ӹ��̳������ʷ��롣
 * <p>
 * �������ǿ��Ի�����дʲ�ͬ���ʷ����������
 * <p>
 * ����:
 * ����: words = ["gin", "zen", "gig", "msg"]
 * ���: 2
 * ����:
 * �����ʷ�������:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * ���� 2 �ֲ�ͬ����, "--...-." �� "--...--.".
 */
public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        String[] morseCode = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> uniqueMorse = new HashSet<>();
        StringBuilder sb;
        for (String str : words) {
            sb = new StringBuilder();
            for (char ch : str.toCharArray()) {
                sb.append(morseCode[ch - 'a']);
            }
            uniqueMorse.add(sb.toString());
        }

        return uniqueMorse.size();
    }
}
