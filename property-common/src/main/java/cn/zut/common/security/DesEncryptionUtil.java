package cn.zut.common.security;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * DES加密，对称加密算法，知道秘钥可以解密密文；
 * 密钥至少为8位字符，56位的密钥以及附加的 8位奇偶校验位，每组的第8位作为奇偶校验位；
 *
 * @author DaoyuanWang
 */
public class DesEncryptionUtil {

    public static String encrypt(String sourceText, String keyString) {
        if (StringUtils.isBlank(sourceText) || StringUtils.isBlank(keyString)) {
            return null;
        }
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建一个DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(keyString.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 生成密钥
            SecretKey key = keyFactory.generateSecret(dks);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 使用密钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);

            byte[] data = sourceText.getBytes();
            // 加密
            byte[] encryptedData = cipher.doFinal(data);
            // 转成16进制串;
            return HexString.bytes2HexStr(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String cipherText, String keyString) {
        if (StringUtils.isBlank(cipherText) || StringUtils.isBlank(keyString)) {
            return null;
        }
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建一个DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(keyString.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 生成密钥
            SecretKey key = keyFactory.generateSecret(dks);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 使用密钥初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, key, sr);

            // 将十六进制串转成字节数组
            byte[] data = HexString.hex2Byte(cipherText);
            // 解密
            byte[] decryptedData = cipher.doFinal(data);

            return new String(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String encrypt = encrypt("666", "12345678abc123");
        System.out.println(encrypt);
        System.out.println(decrypt(encrypt, "12345678abc123"));
    }
}