package s1.mar;

public class Manifest {

    public static final String ROUTE_MAIN = "/main";
    public static final String FILE_MAIN_HTML = "main.html";


    public enum Attr {
        username("username"),
        stocks("stocks"),
        authority("authority");
        String val;
        Attr(String val){
            this.val = val;
        }
        public final String  getVal(){
            return val;
        }
    }

    public enum Exception{
        badCredentials("Credentials not valid!"),
        userNameNotFoundExceptionMsg("Error encountered during authentication!");
        String val;
        Exception(String val){
            this.val = val;
        }
        public final String  getVal(){
            return val;
        }
    }

    public enum MessageStrings{
        permViewStock("Can only view available stock options"),
        permBuySellStock("Can Buy/Sell stock options");
        String val;
        MessageStrings(String val){
            this.val = val;
        }
        public final String  getVal(){
            return val;
        }

    }

    public enum Authority{
        CAN_VIEW("CAN_VIEW"),CAN_BUY_SELL("CAN_BUY_SELL");
        String val;
        Authority(String val){
            this.val = val;
        }
        public final String  getVal(){
            return val;
        }

    }

    public enum EncryptionAlgorithm {
        BCRYPT, SCRYPT
    }

    public enum Currency{
        USD,EUR,INR
    }
}
