package UTILS;

import static GL.GL.BOLD;
import static GL.GL.RESET;

import java.util.Base64;

public class AuthorInfo {
    public static final String AUTHOR_NAME;

    static {
        String encoded = "wqkgMjAyNSBJc2hhayBpU21haWwgRzAxIC0gTUlUIExpY2Vuc2U=";
        AUTHOR_NAME = new String(Base64.getDecoder().decode(encoded));
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println(BOLD + AUTHOR_NAME + RESET);
        System.out.println("++++++++++++++++++++++++++++++++++");

    }
}
