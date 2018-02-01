package cn.zzgame.test.test;

public class Test1 {
	public static void main(String[] args) {
		/*String sql = "Insert into GameTableCfg values('1', '1', '1', '1', '1', 'Texas's Table(1)')";
		int serverID = 1;
		int gameID = 930329;
		int sceneID = 1;
		int roomID = 2;
		int start = 1;
		int end = 100;
		StringBuilder sb = new StringBuilder("Insert into GameTableCfg values ");
		for (int i = start; i <= end; i++) {
			sb.append("('"+serverID+"', '"+gameID+"', '"+sceneID+"', '"+roomID+"', '"+i+"', \"Texas's Table("+i+")\"), ");
		}
		if (sb.toString().endsWith(", ")) sb.delete(sb.length()-2, sb.length());
		sb.append(";");
		System.out.println(sb.toString());*/
		System.out.println((int)(System.currentTimeMillis()/1000));
//		System.out.println(System.currentTimeMillis());
	}
}
