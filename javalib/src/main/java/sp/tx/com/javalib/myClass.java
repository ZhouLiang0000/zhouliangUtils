package sp.tx.com.javalib;

public class myClass {
    public static void main(String[] args){


//        StringBuilder sb = getStringBuilder();

//        System.out.print(getString());
        new Test();
    }
    static class Base{
        static {
            System.out.print("3");
        }
        public Base(){
            System.out.print("4");
        }
    }
    static class Test extends Base{
        static {
            System.out.print("1");
        }
        public Test(){
            System.out.print("2");
        }
    }

    private static String getString(){
        String str = "公积金,人事,行政";
        String str1 = str.replace(",","/");
        return str1;
    }
    private static StringBuilder getStringBuilder() {
        String str = "公积金,人事,行政";
        String [] tags = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <tags.length ; i++) {
            sb.append(tags[i]);
            sb.append("/");
        }
        return sb;
    }
}
