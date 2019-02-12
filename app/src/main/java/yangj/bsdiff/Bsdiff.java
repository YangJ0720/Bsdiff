package yangj.bsdiff;

/**
 * @author YangJ
 * Created by YangJ on 2017/8/22.
 */
public class Bsdiff {

    static {
        System.loadLibrary("Bsdiff");
    }

    public static native void onBsdiff(String oldFilePath,
                                       String newFilePath,
                                       String patchFilePath);

}
