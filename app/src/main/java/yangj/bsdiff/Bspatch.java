package yangj.bsdiff;

/**
 * @author YangJ
 * Created by YangJ on 2017/8/23.
 */
public class Bspatch {

    static {
        System.loadLibrary("Bspatch");
    }

    public static native void onBspatch(String oldFilePath,
                                       String newFilePath,
                                       String patchFilePath);

}
