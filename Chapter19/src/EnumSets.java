/**
 * Created by TangBin on 24/10/2016.
 */
import java.util.*;
import enumerated.*;

public class EnumSets {
    public static void main(String[] args) {
        java.util.EnumSet<AlarmPoints> points = java.util.EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);
        points.addAll(java.util.EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
