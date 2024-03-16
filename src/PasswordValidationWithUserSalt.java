import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordValidationWithUserSalt {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          // ادخل كلمة المرور الأساسية
          System.out.print("sign in ");
          String originalPassword = scanner.nextLine();

          // ادخل الملح من قبل المستخدم
          System.out.print("enter salt ");
          String userSalt = scanner.nextLine();

          // تشفير كلمة المرور الأساسية باستخدام الملح المدخل من قبل المستخدم
          String hashedPassword = hashPassword(originalPassword, userSalt);
         // ادخال كلمة المرور المدخلة من المستخدم
          System.out.print("log in ");
          String userInputPassword = scanner.nextLine();

          // قارن كلمة المرور المدخلة مع الكلمة المشفرة
          if (hashedPassword.equals(hashPassword(userInputPassword, userSalt))) {
              System.out.println("yes");
          } else {
              System.out.println("no");
          }
        System.out.println(hashedPassword);
      }
      private static String hashPassword(String password, String salt) {
          try {
              MessageDigest md = MessageDigest.getInstance("SHA-256");
              md.update(salt.getBytes());
              byte[] bytes = md.digest(password.getBytes());
              StringBuilder sb = new StringBuilder();
              for (byte b : bytes) {
                  sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
              }
              return sb.toString();
          } catch (NoSuchAlgorithmException e) {
              e.printStackTrace();
              return null;
   }
   }
   }

