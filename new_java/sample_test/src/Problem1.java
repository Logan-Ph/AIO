public class Problem1 {
    public static boolean canFollowRule(double length, int n, double min){
        return (n - 1) * min <= length;
    }

    public static boolean isFollowingRule(double[] locations, double min){
        for (int i=1;i<locations.length;i++){
            if (locations[i] - locations[i-1] < min){
                return false;
            }
        }
        return true;
    }

    public static boolean isFollowingRealRule(double[] locations, boolean[] protected_, double min){
        int ptr1 = 0;
        int ptr2 = 1;

        while(ptr2< locations.length){
            if (protected_[ptr2]){
                ptr2++;
            } else if (locations[ptr2] - locations[ptr1] <min) {
                return false;
            }else {
                ptr1++;
                ptr2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isFollowingRealRule(new double[]{0.0, 1.5, 4.5, 10.0}, new boolean[]{false, true, false, false}, 2.0));
        System.out.println(isFollowingRealRule(new double[]{0.0, 1.5, 1.9, 10.0}, new boolean[]{false, true, false, false}, 2.0));
        System.out.println(isFollowingRealRule(new double[]{0.0, 0.5, 1.0, 1.5, 2.1}, new boolean[]{false, true, true, true, false}, 2.0));
    }
}
