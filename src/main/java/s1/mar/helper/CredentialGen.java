package s1.mar.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CredentialGen {

    public static void main(String[] args){
        //Generate BCrypt passwords
        System.out.println(genBcryptPassword("bez3")); //For Simar
        System.out.println(genBcryptPassword("abcd123")); //For James
    }

    public static String genBcryptPassword(String passwordToEncrpyt){

         BCryptPasswordEncoder passEncoderBcrypt = new BCryptPasswordEncoder();
         return passEncoderBcrypt.encode(passwordToEncrpyt);

    }

}
