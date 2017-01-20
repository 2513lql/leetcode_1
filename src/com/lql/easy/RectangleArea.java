package com.lql.easy;

/**
 * Created by LQL on 2016/5/11.
 */
public class RectangleArea {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (E >= C || F >= D || H <= B || G <= A){
            return area;
        }
        int rightx = C < G ? C : G;
        int leftx = E > A ? E : A;
        int upy = H < D ? H : D;
        int downy = B > F ? B : F;
        int tmp = (rightx - leftx) * (upy - downy);
        return (area - tmp);
    }
}
