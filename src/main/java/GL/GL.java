package GL;

import UTILS.AuthorInfo;

public class GL {
        public static final String RESET = "\u001B[0m";
        public static final String BLUE = "\u001B[34m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String CYAN = "\u001B[36m";
        public static final String RED = "\u001B[31m";
        public static final String BOLD = "\u001B[1m";
        public static final String MAGENTA = "\u001B[35m";

        public static void main(String[] args) {

                new AuthorInfo();
                TP1.Exec tp1_exec = new TP1.Exec();
                tp1_exec.run();

        }

        public static void clearScreen() {
                try {
                        if (System.getProperty("os.name").contains("Windows")) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } else {
                                new ProcessBuilder("clear").inheritIO().start().waitFor();
                        }
                } catch (Exception e) {
                        System.out.println("Error clearing the screen.");
                }
        }

}
