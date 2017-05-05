package String;

/**
 * KMP算法实现
 * 
 * **/
public class KMP {

	public static void getNext(char[] P, int[] next) {// P为需要查找的数组
		int c, k; // c为模板字符串的下标，k为最大度的长度
		int l = P.length; // 模板字符串的长度
		next[0] = 0; // 模板字符串的第一个字符的前后缀的度 为0
		for (c = 1, k = 0; c < l; c++) { // 从模板字符串的第二个长度开始，依次计算每个字符对应的next值
			while (k > 0 && P[c] != P[k]) {
				k = next[k - 1];
			}
			if (P[c] == P[k]) {
				k++;
			}
			next[c] = k;

		}
	}

	public static int kmp(char[] T, char[] P, int[] next) {
		// T匹配的长串 P匹配的短串
		int m, n; // m,需要搜索的字符串的长度，n需要进行在T中查找的T的字符串的长度
		int i, q; // q,需要搜索的字符串的下标，i是T的下标
		int count = 0; // 查找到的次数
		n = T.length;
		m = P.length;
		getNext(P, next);
		for (i = 0, q = 0; i < n; i++) {
			while (q > 0 && P[q] != T[i]) {
				/*
				 * 据此例：当第一次i==6时，q==6,此时T[i]为c,P[q]为D，并不相同，
				 * next【q-1】为当前匹配到字符的上一个字符的度
				 * 根据P[q]=='D'的上一个字符'B'的度next【q-1】==2可知P[q]为D的前面两个字符都相同， P移动的位数=
				 * 已匹配的字符数 - 对应的部分匹配值】 此时已匹配q==6个
				 * 计算得出字符串P应该移动的位数==q-next【q-1】=4,此时应该向后移动4为，移动4位之后，当前q的位置应该为2，
				 * 即 q = q-(q-next【p-1】),简化得：q=next[q-1] 只需要把当前P[q]
				 */

				q = next[q - 1];
			}
			if (P[q] == T[i]) {
				q++;
			}
			if (q == m) {
				count++;
				q = 0;
			}
		}
		return count;
	}

	public static void main(String args[]) {
		// String str="ABCDABc-BBC-ABCDAB-ABCDABCDABDE-ABCDABD";
		// String st="ABCDABD";
		// String
		// str="com.alibaba.fastjson.parser.deserializer,src/main/java/com/alibaba/fastjson/parser/deserializer/ArrayListTypeFieldDeserializer.java,"
		// +
		// "5,78,Found 'DD'-anomaly for variable 'paramIndex' (lines '78'-'83'),Controversial Rules,DataflowAnomalyAnalysis";
		// String
		// st="com.alibaba.fastjson.parser.deserializer,src/main/java/com/alibaba/fastjson/parser/deserializer/ArrayListTypeFieldDeserializer.java,"
		// +
		// "5,77,Found 'DD'-anomaly for variable 'paramIndex' (lines '77'-'82'),Controversial Rules,DataflowAnomalyAnalysis";

		String str = "com.alibaba.fastjson.parser.deserializer,src/main/java/com/alibaba/fastjson/parser/deserializer/ArrayListTypeFieldDeserializer.java,"
				+ "Found 'DD'-anomaly for variable 'paramIndex' (lines ),Controversial Rules,DataflowAnomalyAnalysis";
		String st = "com.alibaba.fastjson.parser.deserializer,src/main/java/com/alibaba/fastjson/parser/deserializer/ArrayListTypeFieldDeserializer.java,"
				+ "Found 'DD'-anomaly for variable 'paramIndex' (lines ),Controversial Rules,DataflowAnomalyAnalysis";
		char[] cstr = str.toCharArray();
		char[] cst = st.toCharArray();
		int[] next = new int[st.length()];
		// getNext(cst,next);

		// for(int i=0;i<cstr.length;i++){
		// System.out.print(cstr[i]+" ");
		// }
		int count = kmp(cstr, cst, next);
		System.out.println(count);

	}
}