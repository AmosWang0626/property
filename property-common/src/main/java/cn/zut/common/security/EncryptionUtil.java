package cn.zut.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5: MD5会产生一个128位的消息摘要/散列值；
 * SHA1: SHA1会产生一个160位的消息摘要；
 *
 * @author DaoyuanWang
 */
public class EncryptionUtil {
    /**
     * 加密方式
     */
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";

    /**
     * 加密
     *
     * @param sourceText 加密内容
     * @param type       加密类型
     * @return 加密后的内容
     */
    public static String encrypt(String sourceText, String type) {
        byte[] text = sourceText.getBytes();
        String encrypt;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(type);
            md.update(text);
            byte[] digest = md.digest();
            encrypt = HexString.bytes2HexStr(digest);
            return encrypt;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String cipherText) {
        return cipherText;
    }

    public static void main(String[] args) {
        String md5Encrypt = EncryptionUtil.encrypt("666666", MD5);
        String sha1Encrypt = EncryptionUtil.encrypt("666666", SHA1);
        System.out.println(md5Encrypt);
        System.out.println(sha1Encrypt);
    }
}