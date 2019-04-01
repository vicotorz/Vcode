package WanMeiShijie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//2017/9/7 0:0:0
//2017/9/21 0:0:0
public class Main1 {
	// 计算时间中几个零点，几个星期四
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				Date d1 = sdf.parse(sc.nextLine());
				Date d2 = sdf.parse(sc.nextLine());
				long beginTime = d1.getTime();
				long endTime = d2.getTime();
				long betweenDays = (long) ((endTime - beginTime) / (1000 * 60 * 60 * 24) + 0.5);
				//System.out.println(d2.getHours());
				if (d1.getHours() == d2.getHours()) {
					betweenDays = betweenDays - 1;
				}
				int num4 = (int) (((betweenDays-1) / 7));
				System.out.println(betweenDays + "," + num4);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		sc.close();
	}
}
