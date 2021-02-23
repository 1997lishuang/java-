package 基础算法备考;
//一月 1对， 2月 1对，3月 2对，4月 3对，5月5对，6月8对，7月13对，8月 21只

//考点递归
public class 兔子繁衍 {

    public static void main(String[] args) {
        int n = 24;
        int i =0;
        int[] s = new int[24];
        s[0] = 1;
        s[1] = 1;
        s[2] = 2;

        for (int j = 2; j <n; j++) {
            s[j] = s[j-1]+s[j-2];
        }

        System.out.print(s[23]);
    }
}
